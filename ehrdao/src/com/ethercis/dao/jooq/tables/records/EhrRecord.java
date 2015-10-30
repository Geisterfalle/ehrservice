/**
 * This class is generated by jOOQ
 */
package com.ethercis.dao.jooq.tables.records;

/**
 * EHR itself
 */
@javax.annotation.Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.5.3"
	},
	comments = "This class is generated by jOOQ"
)
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class EhrRecord extends org.jooq.impl.UpdatableRecordImpl<com.ethercis.dao.jooq.tables.records.EhrRecord> implements org.jooq.Record5<java.util.UUID, java.sql.Timestamp, java.util.UUID, java.util.UUID, java.util.UUID> {

	private static final long serialVersionUID = 333164841;

	/**
	 * Setter for <code>ehr.ehr.id</code>.
	 */
	public void setId(java.util.UUID value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>ehr.ehr.id</code>.
	 */
	public java.util.UUID getId() {
		return (java.util.UUID) getValue(0);
	}

	/**
	 * Setter for <code>ehr.ehr.date_created</code>.
	 */
	public void setDateCreated(java.sql.Timestamp value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>ehr.ehr.date_created</code>.
	 */
	public java.sql.Timestamp getDateCreated() {
		return (java.sql.Timestamp) getValue(1);
	}

	/**
	 * Setter for <code>ehr.ehr.access</code>.
	 */
	public void setAccess(java.util.UUID value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>ehr.ehr.access</code>.
	 */
	public java.util.UUID getAccess() {
		return (java.util.UUID) getValue(2);
	}

	/**
	 * Setter for <code>ehr.ehr.system_id</code>.
	 */
	public void setSystemId(java.util.UUID value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>ehr.ehr.system_id</code>.
	 */
	public java.util.UUID getSystemId() {
		return (java.util.UUID) getValue(3);
	}

	/**
	 * Setter for <code>ehr.ehr.directory</code>.
	 */
	public void setDirectory(java.util.UUID value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>ehr.ehr.directory</code>.
	 */
	public java.util.UUID getDirectory() {
		return (java.util.UUID) getValue(4);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Record1<java.util.UUID> key() {
		return (org.jooq.Record1) super.key();
	}

	// -------------------------------------------------------------------------
	// Record5 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row5<java.util.UUID, java.sql.Timestamp, java.util.UUID, java.util.UUID, java.util.UUID> fieldsRow() {
		return (org.jooq.Row5) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row5<java.util.UUID, java.sql.Timestamp, java.util.UUID, java.util.UUID, java.util.UUID> valuesRow() {
		return (org.jooq.Row5) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.util.UUID> field1() {
		return com.ethercis.dao.jooq.tables.Ehr.EHR.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.sql.Timestamp> field2() {
		return com.ethercis.dao.jooq.tables.Ehr.EHR.DATE_CREATED;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.util.UUID> field3() {
		return com.ethercis.dao.jooq.tables.Ehr.EHR.ACCESS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.util.UUID> field4() {
		return com.ethercis.dao.jooq.tables.Ehr.EHR.SYSTEM_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.util.UUID> field5() {
		return com.ethercis.dao.jooq.tables.Ehr.EHR.DIRECTORY;
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
	public java.sql.Timestamp value2() {
		return getDateCreated();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.UUID value3() {
		return getAccess();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.UUID value4() {
		return getSystemId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.UUID value5() {
		return getDirectory();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EhrRecord value1(java.util.UUID value) {
		setId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EhrRecord value2(java.sql.Timestamp value) {
		setDateCreated(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EhrRecord value3(java.util.UUID value) {
		setAccess(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EhrRecord value4(java.util.UUID value) {
		setSystemId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EhrRecord value5(java.util.UUID value) {
		setDirectory(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EhrRecord values(java.util.UUID value1, java.sql.Timestamp value2, java.util.UUID value3, java.util.UUID value4, java.util.UUID value5) {
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached EhrRecord
	 */
	public EhrRecord() {
		super(com.ethercis.dao.jooq.tables.Ehr.EHR);
	}

	/**
	 * Create a detached, initialised EhrRecord
	 */
	public EhrRecord(java.util.UUID id, java.sql.Timestamp dateCreated, java.util.UUID access, java.util.UUID systemId, java.util.UUID directory) {
		super(com.ethercis.dao.jooq.tables.Ehr.EHR);

		setValue(0, id);
		setValue(1, dateCreated);
		setValue(2, access);
		setValue(3, systemId);
		setValue(4, directory);
	}
}
