/**
 * This class is generated by jOOQ
 */
package com.ethercis.dao.jooq.tables.records;

/**
 * openEHR identified terminology provider
 */
@javax.annotation.Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.5.3"
	},
	comments = "This class is generated by jOOQ"
)
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TerminologyProviderRecord extends org.jooq.impl.UpdatableRecordImpl<com.ethercis.dao.jooq.tables.records.TerminologyProviderRecord> implements org.jooq.Record3<java.lang.String, java.lang.String, java.lang.String> {

	private static final long serialVersionUID = 1172677317;

	/**
	 * Setter for <code>ehr.terminology_provider.code</code>.
	 */
	public void setCode(java.lang.String value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>ehr.terminology_provider.code</code>.
	 */
	public java.lang.String getCode() {
		return (java.lang.String) getValue(0);
	}

	/**
	 * Setter for <code>ehr.terminology_provider.source</code>.
	 */
	public void setSource(java.lang.String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>ehr.terminology_provider.source</code>.
	 */
	public java.lang.String getSource() {
		return (java.lang.String) getValue(1);
	}

	/**
	 * Setter for <code>ehr.terminology_provider.authority</code>.
	 */
	public void setAuthority(java.lang.String value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>ehr.terminology_provider.authority</code>.
	 */
	public java.lang.String getAuthority() {
		return (java.lang.String) getValue(2);
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
	// Record3 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row3<java.lang.String, java.lang.String, java.lang.String> fieldsRow() {
		return (org.jooq.Row3) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row3<java.lang.String, java.lang.String, java.lang.String> valuesRow() {
		return (org.jooq.Row3) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field1() {
		return com.ethercis.dao.jooq.tables.TerminologyProvider.TERMINOLOGY_PROVIDER.CODE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field2() {
		return com.ethercis.dao.jooq.tables.TerminologyProvider.TERMINOLOGY_PROVIDER.SOURCE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field3() {
		return com.ethercis.dao.jooq.tables.TerminologyProvider.TERMINOLOGY_PROVIDER.AUTHORITY;
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
		return getSource();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value3() {
		return getAuthority();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TerminologyProviderRecord value1(java.lang.String value) {
		setCode(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TerminologyProviderRecord value2(java.lang.String value) {
		setSource(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TerminologyProviderRecord value3(java.lang.String value) {
		setAuthority(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TerminologyProviderRecord values(java.lang.String value1, java.lang.String value2, java.lang.String value3) {
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached TerminologyProviderRecord
	 */
	public TerminologyProviderRecord() {
		super(com.ethercis.dao.jooq.tables.TerminologyProvider.TERMINOLOGY_PROVIDER);
	}

	/**
	 * Create a detached, initialised TerminologyProviderRecord
	 */
	public TerminologyProviderRecord(java.lang.String code, java.lang.String source, java.lang.String authority) {
		super(com.ethercis.dao.jooq.tables.TerminologyProvider.TERMINOLOGY_PROVIDER);

		setValue(0, code);
		setValue(1, source);
		setValue(2, authority);
	}
}
