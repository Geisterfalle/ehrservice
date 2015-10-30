/**
 * This class is generated by jOOQ
 */
package com.ethercis.dao.jooq.tables;

/**
 * define a participating party for an event f.ex.
 */
@javax.annotation.Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.5.3"
	},
	comments = "This class is generated by jOOQ"
)
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Participation extends org.jooq.impl.TableImpl<com.ethercis.dao.jooq.tables.records.ParticipationRecord> {

	private static final long serialVersionUID = 978952897;

	/**
	 * The reference instance of <code>ehr.participation</code>
	 */
	public static final com.ethercis.dao.jooq.tables.Participation PARTICIPATION = new com.ethercis.dao.jooq.tables.Participation();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<com.ethercis.dao.jooq.tables.records.ParticipationRecord> getRecordType() {
		return com.ethercis.dao.jooq.tables.records.ParticipationRecord.class;
	}

	/**
	 * The column <code>ehr.participation.id</code>.
	 */
	public final org.jooq.TableField<com.ethercis.dao.jooq.tables.records.ParticipationRecord, java.util.UUID> ID = createField("id", org.jooq.impl.SQLDataType.UUID.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>ehr.participation.event_context</code>.
	 */
	public final org.jooq.TableField<com.ethercis.dao.jooq.tables.records.ParticipationRecord, java.util.UUID> EVENT_CONTEXT = createField("event_context", org.jooq.impl.SQLDataType.UUID.nullable(false), this, "");

	/**
	 * The column <code>ehr.participation.performer</code>.
	 */
	public final org.jooq.TableField<com.ethercis.dao.jooq.tables.records.ParticipationRecord, java.util.UUID> PERFORMER = createField("performer", org.jooq.impl.SQLDataType.UUID, this, "");

	/**
	 * The column <code>ehr.participation.function</code>.
	 */
	public final org.jooq.TableField<com.ethercis.dao.jooq.tables.records.ParticipationRecord, java.lang.String> FUNCTION = createField("function", org.jooq.impl.SQLDataType.VARCHAR.length(50), this, "");

	/**
	 * The column <code>ehr.participation.mode</code>.
	 */
	public final org.jooq.TableField<com.ethercis.dao.jooq.tables.records.ParticipationRecord, java.lang.String> MODE = createField("mode", org.jooq.impl.SQLDataType.VARCHAR.length(50), this, "");

	/**
	 * The column <code>ehr.participation.start_time</code>.
	 */
	public final org.jooq.TableField<com.ethercis.dao.jooq.tables.records.ParticipationRecord, java.sql.Timestamp> START_TIME = createField("start_time", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

	/**
	 * The column <code>ehr.participation.sys_transaction</code>.
	 */
	public final org.jooq.TableField<com.ethercis.dao.jooq.tables.records.ParticipationRecord, java.sql.Timestamp> SYS_TRANSACTION = createField("sys_transaction", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

	/**
	 * The column <code>ehr.participation.sys_period</code>.
	 */
	public final org.jooq.TableField<com.ethercis.dao.jooq.tables.records.ParticipationRecord, java.lang.Object> SYS_PERIOD = createField("sys_period", org.jooq.impl.DefaultDataType.getDefaultDataType("tstzrange"), this, "");

	/**
	 * Create a <code>ehr.participation</code> table reference
	 */
	public Participation() {
		this("participation", null);
	}

	/**
	 * Create an aliased <code>ehr.participation</code> table reference
	 */
	public Participation(java.lang.String alias) {
		this(alias, com.ethercis.dao.jooq.tables.Participation.PARTICIPATION);
	}

	private Participation(java.lang.String alias, org.jooq.Table<com.ethercis.dao.jooq.tables.records.ParticipationRecord> aliased) {
		this(alias, aliased, null);
	}

	private Participation(java.lang.String alias, org.jooq.Table<com.ethercis.dao.jooq.tables.records.ParticipationRecord> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, com.ethercis.dao.jooq.Ehr.EHR, aliased, parameters, "define a participating party for an event f.ex.");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<com.ethercis.dao.jooq.tables.records.ParticipationRecord> getPrimaryKey() {
		return com.ethercis.dao.jooq.Keys.PARTICIPATION_PKEY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<com.ethercis.dao.jooq.tables.records.ParticipationRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<com.ethercis.dao.jooq.tables.records.ParticipationRecord>>asList(com.ethercis.dao.jooq.Keys.PARTICIPATION_PKEY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.ForeignKey<com.ethercis.dao.jooq.tables.records.ParticipationRecord, ?>> getReferences() {
		return java.util.Arrays.<org.jooq.ForeignKey<com.ethercis.dao.jooq.tables.records.ParticipationRecord, ?>>asList(com.ethercis.dao.jooq.Keys.PARTICIPATION__PARTICIPATION_EVENT_CONTEXT_FKEY, com.ethercis.dao.jooq.Keys.PARTICIPATION__PARTICIPATION_PERFORMER_FKEY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public com.ethercis.dao.jooq.tables.Participation as(java.lang.String alias) {
		return new com.ethercis.dao.jooq.tables.Participation(alias, this);
	}

	/**
	 * Rename this table
	 */
	public com.ethercis.dao.jooq.tables.Participation rename(java.lang.String name) {
		return new com.ethercis.dao.jooq.tables.Participation(name, null);
	}
}
