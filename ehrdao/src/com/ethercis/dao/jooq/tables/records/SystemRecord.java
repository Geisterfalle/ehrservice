/**
 * This class is generated by jOOQ
 */
package com.ethercis.dao.jooq.tables.records;

/**
 * system table for reference
 */
@javax.annotation.Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.5.3"
	},
	comments = "This class is generated by jOOQ"
)
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SystemRecord extends org.jooq.impl.UpdatableRecordImpl<com.ethercis.dao.jooq.tables.records.SystemRecord> implements org.jooq.Record3<java.util.UUID, java.lang.String, java.lang.String> {

	private static final long serialVersionUID = -1733546954;

	/**
	 * Setter for <code>ehr.system.id</code>.
	 */
	public void setId(java.util.UUID value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>ehr.system.id</code>.
	 */
	public java.util.UUID getId() {
		return (java.util.UUID) getValue(0);
	}

	/**
	 * Setter for <code>ehr.system.description</code>.
	 */
	public void setDescription(java.lang.String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>ehr.system.description</code>.
	 */
	public java.lang.String getDescription() {
		return (java.lang.String) getValue(1);
	}

	/**
	 * Setter for <code>ehr.system.settings</code>.
	 */
	public void setSettings(java.lang.String value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>ehr.system.settings</code>.
	 */
	public java.lang.String getSettings() {
		return (java.lang.String) getValue(2);
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
	// Record3 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row3<java.util.UUID, java.lang.String, java.lang.String> fieldsRow() {
		return (org.jooq.Row3) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row3<java.util.UUID, java.lang.String, java.lang.String> valuesRow() {
		return (org.jooq.Row3) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.util.UUID> field1() {
		return com.ethercis.dao.jooq.tables.System.SYSTEM.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field2() {
		return com.ethercis.dao.jooq.tables.System.SYSTEM.DESCRIPTION;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field3() {
		return com.ethercis.dao.jooq.tables.System.SYSTEM.SETTINGS;
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
	public java.lang.String value2() {
		return getDescription();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value3() {
		return getSettings();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SystemRecord value1(java.util.UUID value) {
		setId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SystemRecord value2(java.lang.String value) {
		setDescription(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SystemRecord value3(java.lang.String value) {
		setSettings(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SystemRecord values(java.util.UUID value1, java.lang.String value2, java.lang.String value3) {
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached SystemRecord
	 */
	public SystemRecord() {
		super(com.ethercis.dao.jooq.tables.System.SYSTEM);
	}

	/**
	 * Create a detached, initialised SystemRecord
	 */
	public SystemRecord(java.util.UUID id, java.lang.String description, java.lang.String settings) {
		super(com.ethercis.dao.jooq.tables.System.SYSTEM);

		setValue(0, id);
		setValue(1, description);
		setValue(2, settings);
	}
}
