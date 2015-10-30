/**
 * This class is generated by jOOQ
 */
package com.ethercis.dao.jooq.tables;

/**
 * defines the context of an event (time, who, where... see openEHR IM 5.2
 */
@javax.annotation.Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.5.3"
	},
	comments = "This class is generated by jOOQ"
)
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class EventContext extends org.jooq.impl.TableImpl<com.ethercis.dao.jooq.tables.records.EventContextRecord> {

	private static final long serialVersionUID = 1646900900;

	/**
	 * The reference instance of <code>ehr.event_context</code>
	 */
	public static final com.ethercis.dao.jooq.tables.EventContext EVENT_CONTEXT = new com.ethercis.dao.jooq.tables.EventContext();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<com.ethercis.dao.jooq.tables.records.EventContextRecord> getRecordType() {
		return com.ethercis.dao.jooq.tables.records.EventContextRecord.class;
	}

	/**
	 * The column <code>ehr.event_context.id</code>.
	 */
	public final org.jooq.TableField<com.ethercis.dao.jooq.tables.records.EventContextRecord, java.util.UUID> ID = createField("id", org.jooq.impl.SQLDataType.UUID.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>ehr.event_context.composition_id</code>.
	 */
	public final org.jooq.TableField<com.ethercis.dao.jooq.tables.records.EventContextRecord, java.util.UUID> COMPOSITION_ID = createField("composition_id", org.jooq.impl.SQLDataType.UUID, this, "");

	/**
	 * The column <code>ehr.event_context.start_time</code>.
	 */
	public final org.jooq.TableField<com.ethercis.dao.jooq.tables.records.EventContextRecord, java.sql.Timestamp> START_TIME = createField("start_time", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

	/**
	 * The column <code>ehr.event_context.end_time</code>.
	 */
	public final org.jooq.TableField<com.ethercis.dao.jooq.tables.records.EventContextRecord, java.sql.Timestamp> END_TIME = createField("end_time", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

	/**
	 * The column <code>ehr.event_context.facility</code>.
	 */
	public final org.jooq.TableField<com.ethercis.dao.jooq.tables.records.EventContextRecord, java.util.UUID> FACILITY = createField("facility", org.jooq.impl.SQLDataType.UUID, this, "");

	/**
	 * The column <code>ehr.event_context.location</code>.
	 */
	public final org.jooq.TableField<com.ethercis.dao.jooq.tables.records.EventContextRecord, java.lang.String> LOCATION = createField("location", org.jooq.impl.SQLDataType.VARCHAR.length(50), this, "");

	/**
	 * The column <code>ehr.event_context.other_context</code>.
	 */
	public final org.jooq.TableField<com.ethercis.dao.jooq.tables.records.EventContextRecord, java.lang.Object> OTHER_CONTEXT = createField("other_context", org.jooq.impl.DefaultDataType.getDefaultDataType("jsonb"), this, "");

	/**
	 * The column <code>ehr.event_context.setting</code>.
	 */
	public final org.jooq.TableField<com.ethercis.dao.jooq.tables.records.EventContextRecord, java.util.UUID> SETTING = createField("setting", org.jooq.impl.SQLDataType.UUID, this, "");

	/**
	 * The column <code>ehr.event_context.sys_transaction</code>.
	 */
	public final org.jooq.TableField<com.ethercis.dao.jooq.tables.records.EventContextRecord, java.sql.Timestamp> SYS_TRANSACTION = createField("sys_transaction", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

	/**
	 * The column <code>ehr.event_context.sys_period</code>.
	 */
	public final org.jooq.TableField<com.ethercis.dao.jooq.tables.records.EventContextRecord, java.lang.Object> SYS_PERIOD = createField("sys_period", org.jooq.impl.DefaultDataType.getDefaultDataType("tstzrange"), this, "");

	/**
	 * Create a <code>ehr.event_context</code> table reference
	 */
	public EventContext() {
		this("event_context", null);
	}

	/**
	 * Create an aliased <code>ehr.event_context</code> table reference
	 */
	public EventContext(java.lang.String alias) {
		this(alias, com.ethercis.dao.jooq.tables.EventContext.EVENT_CONTEXT);
	}

	private EventContext(java.lang.String alias, org.jooq.Table<com.ethercis.dao.jooq.tables.records.EventContextRecord> aliased) {
		this(alias, aliased, null);
	}

	private EventContext(java.lang.String alias, org.jooq.Table<com.ethercis.dao.jooq.tables.records.EventContextRecord> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, com.ethercis.dao.jooq.Ehr.EHR, aliased, parameters, "defines the context of an event (time, who, where... see openEHR IM 5.2");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<com.ethercis.dao.jooq.tables.records.EventContextRecord> getPrimaryKey() {
		return com.ethercis.dao.jooq.Keys.EVENT_CONTEXT_PKEY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<com.ethercis.dao.jooq.tables.records.EventContextRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<com.ethercis.dao.jooq.tables.records.EventContextRecord>>asList(com.ethercis.dao.jooq.Keys.EVENT_CONTEXT_PKEY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.ForeignKey<com.ethercis.dao.jooq.tables.records.EventContextRecord, ?>> getReferences() {
		return java.util.Arrays.<org.jooq.ForeignKey<com.ethercis.dao.jooq.tables.records.EventContextRecord, ?>>asList(com.ethercis.dao.jooq.Keys.EVENT_CONTEXT__EVENT_CONTEXT_COMPOSITION_ID_FKEY, com.ethercis.dao.jooq.Keys.EVENT_CONTEXT__EVENT_CONTEXT_FACILITY_FKEY, com.ethercis.dao.jooq.Keys.EVENT_CONTEXT__EVENT_CONTEXT_SETTING_FKEY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public com.ethercis.dao.jooq.tables.EventContext as(java.lang.String alias) {
		return new com.ethercis.dao.jooq.tables.EventContext(alias, this);
	}

	/**
	 * Rename this table
	 */
	public com.ethercis.dao.jooq.tables.EventContext rename(java.lang.String name) {
		return new com.ethercis.dao.jooq.tables.EventContext(name, null);
	}
}
