/**
 * This class is generated by jOOQ
 */
package com.ethercis.dao.jooq.tables;

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
public class PartyIdentified extends org.jooq.impl.TableImpl<com.ethercis.dao.jooq.tables.records.PartyIdentifiedRecord> {

	private static final long serialVersionUID = -670983745;

	/**
	 * The reference instance of <code>ehr.party_identified</code>
	 */
	public static final com.ethercis.dao.jooq.tables.PartyIdentified PARTY_IDENTIFIED = new com.ethercis.dao.jooq.tables.PartyIdentified();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<com.ethercis.dao.jooq.tables.records.PartyIdentifiedRecord> getRecordType() {
		return com.ethercis.dao.jooq.tables.records.PartyIdentifiedRecord.class;
	}

	/**
	 * The column <code>ehr.party_identified.id</code>.
	 */
	public final org.jooq.TableField<com.ethercis.dao.jooq.tables.records.PartyIdentifiedRecord, java.util.UUID> ID = createField("id", org.jooq.impl.SQLDataType.UUID.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>ehr.party_identified.name</code>.
	 */
	public final org.jooq.TableField<com.ethercis.dao.jooq.tables.records.PartyIdentifiedRecord, java.lang.String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR.length(50), this, "");

	/**
	 * The column <code>ehr.party_identified.party_ref_value</code>.
	 */
	public final org.jooq.TableField<com.ethercis.dao.jooq.tables.records.PartyIdentifiedRecord, java.lang.String> PARTY_REF_VALUE = createField("party_ref_value", org.jooq.impl.SQLDataType.VARCHAR.length(50), this, "");

	/**
	 * The column <code>ehr.party_identified.party_ref_scheme</code>.
	 */
	public final org.jooq.TableField<com.ethercis.dao.jooq.tables.records.PartyIdentifiedRecord, java.lang.String> PARTY_REF_SCHEME = createField("party_ref_scheme", org.jooq.impl.SQLDataType.VARCHAR.length(100), this, "");

	/**
	 * The column <code>ehr.party_identified.party_ref_namespace</code>.
	 */
	public final org.jooq.TableField<com.ethercis.dao.jooq.tables.records.PartyIdentifiedRecord, java.lang.String> PARTY_REF_NAMESPACE = createField("party_ref_namespace", org.jooq.impl.SQLDataType.VARCHAR.length(50), this, "");

	/**
	 * The column <code>ehr.party_identified.party_ref_type</code>.
	 */
	public final org.jooq.TableField<com.ethercis.dao.jooq.tables.records.PartyIdentifiedRecord, java.lang.String> PARTY_REF_TYPE = createField("party_ref_type", org.jooq.impl.SQLDataType.VARCHAR.length(50), this, "");

	/**
	 * Create a <code>ehr.party_identified</code> table reference
	 */
	public PartyIdentified() {
		this("party_identified", null);
	}

	/**
	 * Create an aliased <code>ehr.party_identified</code> table reference
	 */
	public PartyIdentified(java.lang.String alias) {
		this(alias, com.ethercis.dao.jooq.tables.PartyIdentified.PARTY_IDENTIFIED);
	}

	private PartyIdentified(java.lang.String alias, org.jooq.Table<com.ethercis.dao.jooq.tables.records.PartyIdentifiedRecord> aliased) {
		this(alias, aliased, null);
	}

	private PartyIdentified(java.lang.String alias, org.jooq.Table<com.ethercis.dao.jooq.tables.records.PartyIdentifiedRecord> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, com.ethercis.dao.jooq.Ehr.EHR, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<com.ethercis.dao.jooq.tables.records.PartyIdentifiedRecord> getPrimaryKey() {
		return com.ethercis.dao.jooq.Keys.PARTY_IDENTIFIED_PKEY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<com.ethercis.dao.jooq.tables.records.PartyIdentifiedRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<com.ethercis.dao.jooq.tables.records.PartyIdentifiedRecord>>asList(com.ethercis.dao.jooq.Keys.PARTY_IDENTIFIED_PKEY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public com.ethercis.dao.jooq.tables.PartyIdentified as(java.lang.String alias) {
		return new com.ethercis.dao.jooq.tables.PartyIdentified(alias, this);
	}

	/**
	 * Rename this table
	 */
	public com.ethercis.dao.jooq.tables.PartyIdentified rename(java.lang.String name) {
		return new com.ethercis.dao.jooq.tables.PartyIdentified(name, null);
	}
}
