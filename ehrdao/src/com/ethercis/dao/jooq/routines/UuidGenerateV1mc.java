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
public class UuidGenerateV1mc extends org.jooq.impl.AbstractRoutine<java.util.UUID> {

	private static final long serialVersionUID = 1752621551;

	/**
	 * The parameter <code>ehr.uuid_generate_v1mc.RETURN_VALUE</code>.
	 */
	public static final org.jooq.Parameter<java.util.UUID> RETURN_VALUE = createParameter("RETURN_VALUE", org.jooq.impl.SQLDataType.UUID, false);

	/**
	 * Create a new routine call instance
	 */
	public UuidGenerateV1mc() {
		super("uuid_generate_v1mc", com.ethercis.dao.jooq.Ehr.EHR, org.jooq.impl.SQLDataType.UUID);

		setReturnParameter(RETURN_VALUE);
	}
}
