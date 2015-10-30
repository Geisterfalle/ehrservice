/**
 * This class is generated by jOOQ
 */
package com.ethercis.dao.jooq.tables.records;

/**
 * ISO 639-1 language codeset
 */
@javax.annotation.Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.5.3"
	},
	comments = "This class is generated by jOOQ"
)
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class LanguageRecord extends org.jooq.impl.UpdatableRecordImpl<com.ethercis.dao.jooq.tables.records.LanguageRecord> implements org.jooq.Record2<java.lang.String, java.lang.String> {

	private static final long serialVersionUID = -764306089;

	/**
	 * Setter for <code>ehr.language.code</code>.
	 */
	public void setCode(java.lang.String value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>ehr.language.code</code>.
	 */
	public java.lang.String getCode() {
		return (java.lang.String) getValue(0);
	}

	/**
	 * Setter for <code>ehr.language.description</code>.
	 */
	public void setDescription(java.lang.String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>ehr.language.description</code>.
	 */
	public java.lang.String getDescription() {
		return (java.lang.String) getValue(1);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Record1<java.lang.String> key() {
		return (org.jooq.Record1) super.key();
	}

	// -------------------------------------------------------------------------
	// Record2 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row2<java.lang.String, java.lang.String> fieldsRow() {
		return (org.jooq.Row2) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row2<java.lang.String, java.lang.String> valuesRow() {
		return (org.jooq.Row2) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field1() {
		return com.ethercis.dao.jooq.tables.Language.LANGUAGE.CODE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field2() {
		return com.ethercis.dao.jooq.tables.Language.LANGUAGE.DESCRIPTION;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value1() {
		return getCode();
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
	public LanguageRecord value1(java.lang.String value) {
		setCode(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LanguageRecord value2(java.lang.String value) {
		setDescription(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LanguageRecord values(java.lang.String value1, java.lang.String value2) {
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached LanguageRecord
	 */
	public LanguageRecord() {
		super(com.ethercis.dao.jooq.tables.Language.LANGUAGE);
	}

	/**
	 * Create a detached, initialised LanguageRecord
	 */
	public LanguageRecord(java.lang.String code, java.lang.String description) {
		super(com.ethercis.dao.jooq.tables.Language.LANGUAGE);

		setValue(0, code);
		setValue(1, description);
	}
}
