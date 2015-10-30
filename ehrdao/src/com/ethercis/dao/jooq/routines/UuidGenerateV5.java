/**
 * This class is generated by jOOQ
 */
package com.ethercis.dao.jooq.routines;

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
public class UuidGenerateV5 extends org.jooq.impl.AbstractRoutine<java.util.UUID> {

	private static final long serialVersionUID = -2026560322;

	/**
	 * The parameter <code>ehr.uuid_generate_v5.RETURN_VALUE</code>.
	 */
	public static final org.jooq.Parameter<java.util.UUID> RETURN_VALUE = createParameter("RETURN_VALUE", org.jooq.impl.SQLDataType.UUID, false);

	/**
	 * The parameter <code>ehr.uuid_generate_v5.namespace</code>.
	 */
	public static final org.jooq.Parameter<java.util.UUID> NAMESPACE = createParameter("namespace", org.jooq.impl.SQLDataType.UUID, false);

	/**
	 * The parameter <code>ehr.uuid_generate_v5.name</code>.
	 */
	public static final org.jooq.Parameter<java.lang.String> NAME = createParameter("name", org.jooq.impl.SQLDataType.CLOB, false);

	/**
	 * Create a new routine call instance
	 */
	public UuidGenerateV5() {
		super("uuid_generate_v5", com.ethercis.dao.jooq.Ehr.EHR, org.jooq.impl.SQLDataType.UUID);

		setReturnParameter(RETURN_VALUE);
		addInParameter(NAMESPACE);
		addInParameter(NAME);
	}

	/**
	 * Set the <code>namespace</code> parameter IN value to the routine
	 */
	public void setNamespace(java.util.UUID value) {
		setValue(com.ethercis.dao.jooq.routines.UuidGenerateV5.NAMESPACE, value);
	}

	/**
	 * Set the <code>namespace</code> parameter to the function to be used with a {@link org.jooq.Select} statement
	 */
	public void setNamespace(org.jooq.Field<java.util.UUID> field) {
		setField(NAMESPACE, field);
	}

	/**
	 * Set the <code>name</code> parameter IN value to the routine
	 */
	public void setName_(java.lang.String value) {
		setValue(com.ethercis.dao.jooq.routines.UuidGenerateV5.NAME, value);
	}

	/**
	 * Set the <code>name</code> parameter to the function to be used with a {@link org.jooq.Select} statement
	 */
	public void setName_(org.jooq.Field<java.lang.String> field) {
		setField(NAME, field);
	}
}
