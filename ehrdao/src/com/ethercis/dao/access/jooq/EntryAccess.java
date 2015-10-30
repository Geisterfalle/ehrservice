/*
 * Copyright (c) 2015 Christian Chevalley
 * This file is part of Project Ethercis
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ethercis.dao.access.jooq;

import com.ethercis.dao.access.interfaces.*;
import com.ethercis.dao.access.support.DataAccess;
import com.ethercis.dao.jooq.enums.EntryType;
import com.ethercis.dao.jooq.tables.records.EntryHistoryRecord;
import com.ethercis.dao.jooq.tables.records.EntryRecord;
import com.ethercis.ehr.building.I_ContentBuilder;
import com.ethercis.ehr.building.I_RmBinding;
import com.ethercis.ehr.knowledge.I_KnowledgeCache;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.jooq.*;
import org.jooq.impl.DefaultDataType;
import org.jooq.impl.SQLDataType;
import org.jooq.tools.json.JSONObject;
import org.openehr.build.SystemValue;
import org.openehr.rm.composition.Composition;
import org.openehr.rm.composition.EventContext;
import org.openehr.rm.composition.content.entry.*;
import org.openehr.rm.composition.content.navigation.Section;
import org.openehr.rm.support.identification.ObjectVersionID;
import org.postgresql.util.PGobject;

import java.sql.*;
import java.util.*;

import static com.ethercis.dao.jooq.Tables.*;

/**
 * Created by Christian Chevalley on 4/9/2015.
 */
public class EntryAccess extends DataAccess implements I_EntryAccess {

    private static final Logger log = Logger.getLogger(EntryAccess.class);
    private static final String DEFAULT_VERSION = "1";

    private EntryRecord entryRecord;
    private PreparedStatement insertStatement;
    private PreparedStatement updateStatement;

    private Composition composition;
//    private boolean committed = false;

    public EntryAccess(DSLContext context, I_KnowledgeCache knowledge, String templateId, Integer sequence, UUID compositionId, Composition composition) throws Exception {
        super(context, knowledge);
//        this.connection = connection;
        setFields(templateId, sequence, compositionId, composition);
    }

    public EntryAccess(String templateId, Integer sequence, UUID compositionId, Composition composition) throws Exception {
        super(null, null);
//        this.connection = null;
        setFields(templateId, sequence, compositionId, composition);
    }

    public EntryAccess(){
        super(null, null);
//        this.connection = null;
    }

    public EntryAccess(DSLContext context, I_KnowledgeCache knowledge){
        super(context, knowledge);
//        this.connection = connectionHandler.getConnection();
    }

    public EntryAccess(I_DomainAccess domainAccess){
        super(domainAccess.getContext(), domainAccess.getKnowledgeManager());
    }

    /**
     * set the EntryRecord with fields from composition:<br>
     *     <ul>
     *         <li>category</li>
     *         <li>item type</li>
     *         <li>archetype node Id</li>
     *         <li>entry content (json)</li>
     *     </ul>
     * @param record
     * @param templateId
     * @param composition
     * @throws Exception
     */
    private void setCompositionFields(EntryRecord record, String templateId, Composition composition) throws Exception {
        I_ContentBuilder contentBuilder = I_ContentBuilder.getInstance(null, I_ContentBuilder.OET, knowledgeManager, templateId);

        Integer categoryId = Integer.parseInt(composition.getCategory().getCode());
        record.setCategory(I_ConceptAccess.fetchConcept(this, categoryId, "en"));

        Object node = composition.getContent().get(0);

        if (node instanceof Section)
            record.setItemType(EntryType.valueOf("section"));
        else if (node instanceof Evaluation || node instanceof Observation || node instanceof Instruction || node instanceof Action)
            record.setItemType(EntryType.valueOf("care_entry"));
        else if (node instanceof AdminEntry)
            record.setItemType(EntryType.valueOf("admin"));
        else
            ;

        record.setArchetypeId(composition.getArchetypeNodeId());

        //perform the transformation...
        //for the time being, we serialize to JSON all entries in a composition
        contentBuilder.setEntryData(composition);

        record.setEntry(contentBuilder.getEntry());
    }

    private void setFields(String templateId, Integer sequence, UUID compositionId, Composition composition) throws Exception {

        entryRecord = context.newRecord(ENTRY);

        entryRecord.setTemplateId(templateId);
        entryRecord.setSequence(sequence);
        entryRecord.setCompositionId(compositionId);

        setCompositionFields(entryRecord, templateId, composition);

        this.composition = composition;

        //setup a prepared statement to store json object
//        Configuration configuration = context.configuration();
//
//        Connection connection1 = configuration.connectionProvider().acquire();

        String sql = "INSERT INTO ehr.entry (sequence, composition_id, template_id, item_type, archetype_id, category, entry, sys_transaction) " +
                "VALUES (?, ?, ?, CAST(? AS ehr.entry_type), ?, ?, ?::jsonb, ?)" +
                " RETURNING id";

        Connection connection = context.configuration().connectionProvider().acquire();
        insertStatement = connection.prepareStatement(sql);
        insertStatement.setInt(1, getSequence());
        insertStatement.setObject(2, getCompositionId());
        insertStatement.setObject(3, getTemplateId());
        insertStatement.setObject(4, getItemType());
        insertStatement.setObject(5, getArchetypeId());
        insertStatement.setObject(6, getCategory());
        insertStatement.setObject(7, getEntryJson());
        insertStatement.setObject(8, new Timestamp(DateTime.now().getMillis())); //default value, changed by commit!
    }

    @Override
    public Composition getComposition() {
        return composition;
    }

    @Override
    public UUID commit(Timestamp transactionTime) throws Exception {

        //patch insertStatement with the actual transaction time
        insertStatement.setObject(8, transactionTime);

        ResultSet resultSet = insertStatement.executeQuery();

        String retval  = null;

        if (resultSet != null && resultSet.next()){
            retval = resultSet.getString(1);
        }

        if (retval != null)
            return UUID.fromString(retval);

        return entryRecord.getId();

    }

    @Override
    public UUID commit() throws Exception {
        throw new IllegalArgumentException("INTERNAL: commit without transaction time is not legal");
    }

    public static I_EntryAccess retrieveInstance(I_DomainAccess domainAccess, UUID entryId) throws Exception {
        EntryRecord entrySelectedRecord = domainAccess.getContext().selectFrom(ENTRY).where(ENTRY.ID.eq(entryId)).fetchOne();

        if (entrySelectedRecord == null){
            log.warn("Could not retrieveInstanceByNamedSubject record with id:"+entryId);
            return null;
        }

        I_ContentBuilder contentBuilder = I_ContentBuilder.getInstance(null, domainAccess.getKnowledgeManager(), entrySelectedRecord.getTemplateId());
        EntryAccess entryAccess = new EntryAccess(domainAccess);
        entryAccess.entryRecord = entrySelectedRecord;
        entryAccess.composition = contentBuilder.buildCompositionFromJson(((PGobject) entrySelectedRecord.getEntry()).getValue());

        return entryAccess;
    }

    public static List<I_EntryAccess> retrieveInstanceInComposition(I_DomainAccess domainAccess, I_CompositionAccess compositionAccess) throws Exception {

        Result<EntryRecord> entryRecords = domainAccess.getContext().selectFrom(ENTRY).where(ENTRY.COMPOSITION_ID.eq(compositionAccess.getId())).fetch();

        //build the list of parameters to recreate the composition
        Map<SystemValue, Object> values = new HashMap<>();
        values.put(SystemValue.COMPOSER, I_PartyIdentifiedAccess.retrievePartyIdentified(domainAccess, compositionAccess.getComposerId()));
        I_ContextAccess contextAccess = I_ContextAccess.retrieveInstance(domainAccess, compositionAccess.getContextId());
        values.put(SystemValue.CONTEXT, contextAccess.mapRmEventContext());
        values.put(SystemValue.LANGUAGE, I_RmBinding.makeLanguageCodePhrase(compositionAccess.getLanguageCode()));
        String territory2letters = domainAccess.getContext().fetchOne(TERRITORY, TERRITORY.CODE.eq(compositionAccess.getTerritoryCode())).getTwoletter();
        values.put(SystemValue.TERRITORY, I_RmBinding.makeTerritoryCodePhrase(territory2letters));

        List<I_EntryAccess> content = new ArrayList<>();

        try {
            EntryAccess entryAccess = new EntryAccess(domainAccess);

            for (EntryRecord record: entryRecords){
                //set the record UID in the composition
                values.put(SystemValue.UID, new ObjectVersionID(record.getId().toString(), domainAccess.getServerNodeId(), DEFAULT_VERSION));
                I_ContentBuilder contentBuilder = I_ContentBuilder.getInstance(values, domainAccess.getKnowledgeManager(), record.getTemplateId());
//                EntryAccess entry = new EntryAccess();
                entryAccess.entryRecord = record;
                entryAccess.composition = contentBuilder.buildCompositionFromJson(((PGobject) record.getEntry()).getValue());

                if (contextAccess.getOtherContextJson() != null)
                    contentBuilder.bindOtherContextFromJson(entryAccess.composition, contextAccess.getOtherContextJson());

                content.add(entryAccess);
//                entry.committed = true;
            }
        }
        catch (Exception e){
            log.error("DB inconsistency:"+e);
            throw new IllegalArgumentException("DB inconsistency:"+e);
        }
        return content;
    }

    public static List<I_EntryAccess> retrieveInstanceInCompositionVersion(I_DomainAccess domainAccess, I_CompositionAccess compositionHistoryAccess) throws Exception {

        Result<EntryHistoryRecord> entryHistoryRecords = domainAccess.getContext().
                selectFrom(ENTRY_HISTORY)
                .where(ENTRY_HISTORY.COMPOSITION_ID.eq(compositionHistoryAccess.getId()))
                .and(ENTRY_HISTORY.SYS_TRANSACTION.eq(compositionHistoryAccess.getSysTransaction()))
                .fetch();

        //build the list of parameters to recreate the composition
        Map<SystemValue, Object> values = new HashMap<>();
        values.put(SystemValue.COMPOSER, I_PartyIdentifiedAccess.retrievePartyIdentified(domainAccess, compositionHistoryAccess.getComposerId()));

        EventContext context = I_ContextAccess.retrieveHistoricalEventContext(domainAccess, compositionHistoryAccess.getId(), compositionHistoryAccess.getSysTransaction());
        if (context == null) {//unchanged context use the current one!
            I_ContextAccess contextAccess = I_ContextAccess.retrieveInstance(domainAccess, compositionHistoryAccess.getContextId());
            context = contextAccess.mapRmEventContext();
        }
        values.put(SystemValue.CONTEXT, context);

        values.put(SystemValue.LANGUAGE, I_RmBinding.makeLanguageCodePhrase(compositionHistoryAccess.getLanguageCode()));
        String territory2letters = domainAccess.getContext().fetchOne(TERRITORY, TERRITORY.CODE.eq(compositionHistoryAccess.getTerritoryCode())).getTwoletter();
        values.put(SystemValue.TERRITORY, I_RmBinding.makeTerritoryCodePhrase(territory2letters));

        List<I_EntryAccess> content = new ArrayList<>();

        try {
            EntryAccess entryAccess = new EntryAccess(domainAccess);

            for (EntryHistoryRecord record: entryHistoryRecords){
                //set the record UID in the composition
                values.put(SystemValue.UID, new ObjectVersionID(record.getId().toString(), domainAccess.getServerNodeId(), DEFAULT_VERSION));
                I_ContentBuilder contentBuilder = I_ContentBuilder.getInstance(values, domainAccess.getKnowledgeManager(), record.getTemplateId());
//                EntryAccess entry = new EntryAccess();
                entryAccess.entryRecord = null;
                entryAccess.composition = contentBuilder.buildCompositionFromJson(((PGobject) record.getEntry()).getValue());
                content.add(entryAccess);
//                entry.committed = true;
            }
        }
        catch (Exception e){
            log.error("DB inconsistency:"+e);
            throw new IllegalArgumentException("DB inconsistency:"+e);
        }
        return content;
    }


    //TODO: use JSON type as described in https://github.com/jOOQ/jOOQ/issues/2788
//    @Override
    public Boolean updatePROGRESS() throws SQLException {

        if (!(entryRecord.changed()))
            return false;

        //ignore the temporal field since it is maintained by an external trigger!
        entryRecord.changed(ENTRY.SYS_PERIOD, false);

        DataType<Object> json = new DefaultDataType<Object>(SQLDialect.POSTGRES, SQLDataType.OTHER, "json");
        JSONObject jsonObject = new JSONObject();

         int entryResult = context.update(ENTRY)
                .set(ENTRY.SEQUENCE, getSequence())
                .set(ENTRY.COMPOSITION_ID, getCompositionId())
                .set(ENTRY.TEMPLATE_ID, getTemplateId())
                .set(ENTRY.ITEM_TYPE, EntryType.valueOf(getItemType()))
                .set(ENTRY.ARCHETYPE_ID, getTemplateId())
                .set(ENTRY.CATEGORY, getCategory())
                 .set(ENTRY.ENTRY_, getEntryJson()) //requires casting to json!!!
                .execute();


        return entryResult > 0;
    }

    @Override
    public Boolean update(Timestamp transactionTime) throws Exception {
        return update(transactionTime, false);
    }

    @Override
    public Boolean update(Timestamp transactionTime, boolean force) throws Exception {

        log.debug("updating entry with force flag:"+force+" and changed flag:"+entryRecord.changed());
        if (!(force || entryRecord.changed())) {
            log.debug("No updateComposition took place, returning...");
            return false;
        }

        //ignore the temporal field since it is maintained by an external trigger!
        entryRecord.changed(ENTRY.SYS_PERIOD, false);

        //for the time being use a straight SQL with typecast...
        String sql = "UPDATE ehr.entry SET sequence = ?, " +
                "composition_id = ?, " +
                "template_id = ?, " +
                "item_type = CAST(? AS ehr.entry_type), " +
                "archetype_id = ?, " +
                "category = ?, " +
                "entry = ?::jsonb, " +
                "sys_transaction = ? " +
                "WHERE id = ? ";

        Connection connection = context.configuration().connectionProvider().acquire();
        updateStatement = connection.prepareStatement(sql);
        updateStatement.setInt(1, getSequence());
        updateStatement.setObject(2, getCompositionId());
        updateStatement.setObject(3, getTemplateId());
        updateStatement.setObject(4, getItemType());
        updateStatement.setObject(5, getArchetypeId());
        updateStatement.setObject(6, getCategory());
        updateStatement.setObject(7, getEntryJson());
        updateStatement.setObject(8, transactionTime);
        updateStatement.setObject(9, getId());

        log.debug("Update done...");

        return updateStatement.execute();
    }

    @Override
    public Boolean update() throws Exception {
        throw new IllegalArgumentException("INTERNAL: Invalid updateComposition call to updateComposition without Transaction time and/or force flag arguments");
    }

    @Override
    public Boolean update(Boolean force) throws Exception {
        throw new IllegalArgumentException("INTERNAL: Invalid updateComposition call to updateComposition without Transaction time and/or force flag arguments");
    }

    @Override
    public Integer delete(){

        if (entryRecord != null)
            return entryRecord.delete();

        return 0;
    }

//    @Override
//    public I_EntryAccess retrieve(UUID id) throws Exception {
//        return retrieveInstance(this, id);
//    }

    @Override
    public UUID getId(){
        return entryRecord.getId();
    }

    @Override
    public String getEntryJson() {
        if (entryRecord.getEntry() instanceof String)
            return (String)entryRecord.getEntry();

        PGobject entryPGobject = (PGobject)entryRecord.getEntry();
        return entryPGobject.getValue();
    }

    @Override
    public UUID getCategory() {
        return entryRecord.getCategory();
    }

    @Override
    public UUID getCompositionId() {
        return entryRecord.getCompositionId();
    }

    @Override
    public String getTemplateId() {
        return entryRecord.getTemplateId();
    }

    @Override
    public Integer getSequence() {
        return entryRecord.getSequence();
    }

    @Override
    public String getArchetypeId() {
        return entryRecord.getArchetypeId();
    }

    @Override
    public String getItemType() {
        return entryRecord.getItemType().getLiteral();
    }

    @Override
    public void setCompositionData(String templateId, Composition composition) throws Exception {
        setCompositionFields(entryRecord, templateId, composition);
   }

    @Override
    public void setCompositionId(UUID compositionId) {
        entryRecord.setCompositionId(compositionId);
    }

    @Override
    public void setTemplateId(String templateId) {
        entryRecord.setTemplateId(templateId);
    }

    @Override
    public void setSequence(Integer sequence) {
        entryRecord.setSequence(sequence);
    }

    public static Map<String, Object> queryJSON(I_DomainAccess domainAccess, String queryString) throws Exception {
        Result<Record> records = domainAccess.getContext().fetch(queryString);
        Map<String, Object> resultMap = new HashMap<>();

        resultMap.put("executedSQL", queryString);

        List<Map> resultList = new ArrayList<>();

        for (Record record: records) {
            Map<String, Object> fieldMap = new HashMap<>();
            for (Field field : records.fields()) {
                fieldMap.put(field.getName(), record.getValue(field));
            }

            resultList.add(fieldMap);
        }

        resultMap.put("resultSet", resultList);

        return resultMap;
    }

}
