/**
 * This class is generated by jOOQ
 */
package com.ethercis.dao.jooq.tables.records;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.5.3"
	},
	comments = "This class is generated by jOOQ"
)
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class StatusHistoryRecord extends org.jooq.impl.TableRecordImpl<com.ethercis.dao.jooq.tables.records.StatusHistoryRecord> implements org.jooq.Record7<java.util.UUID, java.util.UUID, java.lang.Boolean, java.lang.Boolean, java.util.UUID, java.sql.Timestamp, java.lang.Object> {

	private static final long serialVersionUID = -1913131309;

	/**
	 * Setter for <code>ehr.status_history.id</code>.
	 */
	public void setId(java.util.UUID value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>ehr.status_history.id</code>.
	 */
	public java.util.UUID getId() {
		return (java.util.UUID) getValue(0);
	}

	/**
	 * Setter for <code>ehr.status_history.ehr_id</code>.
	 */
	public void setEhrId(java.util.UUID value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>ehr.status_history.ehr_id</code>.
	 */
	public java.util.UUID getEhrId() {
		return (java.util.UUID) getValue(1);
	}

	/**
	 * Setter for <code>ehr.status_history.is_queryable</code>.
	 */
	public void setIsQueryable(java.lang.Boolean value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>ehr.status_history.is_queryable</code>.
	 */
	public java.lang.Boolean getIsQueryable() {
		return (java.lang.Boolean) getValue(2);
	}

	/**
	 * Setter for <code>ehr.status_history.is_modifiable</code>.
	 */
	public void setIsModifiable(java.lang.Boolean value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>ehr.status_history.is_modifiable</code>.
	 */
	public java.lang.Boolean getIsModifiable() {
		return (java.lang.Boolean) getValue(3);
	}

	/**
	 * Setter for <code>ehr.status_history.party</code>.
	 */
	public void setParty(java.util.UUID value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>ehr.status_history.party</code>.
	 */
	public java.util.UUID getParty() {
		return (java.util.UUID) getValue(4);
	}

	/**
	 * Setter for <code>ehr.status_history.sys_transaction</code>.
	 */
	public void setSysTransaction(java.sql.Timestamp value) {
		setValue(5, value);
	}

	/**
	 * Getter for <code>ehr.status_history.sys_transaction</code>.
	 */
	public java.sql.Timestamp getSysTransaction() {
		return (java.sql.Timestamp) getValue(5);
	}

	/**
	 * Setter for <code>ehr.status_history.sys_period</code>.
	 */
	public void setSysPeriod(java.lang.Object value) {
		setValue(6, value);
	}

	/**
	 * Getter for <code>ehr.status_history.sys_period</code>.
	 */
	public java.lang.Object getSysPeriod() {
		return (java.lang.Object) getValue(6);
	}

	// -------------------------------------------------------------------------
	// Record7 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row7<java.util.UUID, java.util.UUID, java.lang.Boolean, java.lang.Boolean, java.util.UUID, java.sql.Timestamp, java.lang.Object> fieldsRow() {
		return (org.jooq.Row7) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row7<java.util.UUID, java.util.UUID, java.lang.Boolean, java.lang.Boolean, java.util.UUID, java.sql.Timestamp, java.lang.Object> valuesRow() {
		return (org.jooq.Row7) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.util.UUID> field1() {
		return com.ethercis.dao.jooq.tables.StatusHistory.STATUS_HISTORY.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.util.UUID> field2() {
		return com.ethercis.dao.jooq.tables.StatusHistory.STATUS_HISTORY.EHR_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Boolean> field3() {
		return com.ethercis.dao.jooq.tables.StatusHistory.STATUS_HISTORY.IS_QUERYABLE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Boolean> field4() {
		return com.ethercis.dao.jooq.tables.StatusHistory.STATUS_HISTORY.IS_MODIFIABLE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.util.UUID> field5() {
		return com.ethercis.dao.jooq.tables.StatusHistory.STATUS_HISTORY.PARTY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.sql.Timestamp> field6() {
		return com.ethercis.dao.jooq.tables.StatusHistory.STATUS_HISTORY.SYS_TRANSACTION;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Object> field7() {
		return com.ethercis.dao.jooq.tables.StatusHistory.STATUS_HISTORY.SYS_PERIOD;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.UUID value1() {
		return getId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.UUID value2() {
		return getEhrId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Boolean value3() {
		return getIsQueryable();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Boolean value4() {
		return getIsModifiable();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.UUID value5() {
		return getParty();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.sql.Timestamp value6() {
		return getSysTransaction();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Object value7() {
		return getSysPeriod();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public StatusHistoryRecord value1(java.util.UUID value) {
		setId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public StatusHistoryRecord value2(java.util.UUID value) {
		setEhrId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public StatusHistoryRecord value3(java.lang.Boolean value) {
		setIsQueryable(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public StatusHistoryRecord value4(java.lang.Boolean value) {
		setIsModifiable(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public StatusHistoryRecord value5(java.util.UUID value) {
		setParty(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public StatusHistoryRecord value6(java.sql.Timestamp value) {
		setSysTransaction(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public StatusHistoryRecord value7(java.lang.Object value) {
		setSysPeriod(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public StatusHistoryRecord values(java.util.UUID value1, java.util.UUID value2, java.lang.Boolean value3, java.lang.Boolean value4, java.util.UUID value5, java.sql.Timestamp value6, java.lang.Object value7) {
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached StatusHistoryRecord
	 */
	public StatusHistoryRecord() {
		super(com.ethercis.dao.jooq.tables.StatusHistory.STATUS_HISTORY);
	}

	/**
	 * Create a detached, initialised StatusHistoryRecord
	 */
	public StatusHistoryRecord(java.util.UUID id, java.util.UUID ehrId, java.lang.Boolean isQueryable, java.lang.Boolean isModifiable, java.util.UUID party, java.sql.Timestamp sysTransaction, java.lang.Object sysPeriod) {
		super(com.ethercis.dao.jooq.tables.StatusHistory.STATUS_HISTORY);

		setValue(0, id);
		setValue(1, ehrId);
		setValue(2, isQueryable);
		setValue(3, isModifiable);
		setValue(4, party);
		setValue(5, sysTransaction);
		setValue(6, sysPeriod);
	}
}
