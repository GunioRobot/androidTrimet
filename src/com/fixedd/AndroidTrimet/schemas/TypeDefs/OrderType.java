package com.fixedd.AndroidTrimet.schemas.TypeDefs;


/**
 * <p>Java class for OrderType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="OrderType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="start"/>
 *     &lt;enumeration value="transfer"/>
 *     &lt;enumeration value="thru-route"/>
 *     &lt;enumeration value="end"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
public enum OrderType {

	START("start"),
	TRANSFER("transfer"),
	THRU_ROUTE("thru-route"),
	END("end");

	private final String mValue;

	OrderType(String v) {
		mValue = v;
	}

	public String value() {
		return mValue;
	}

	public static OrderType fromValue(String v) {
		for (OrderType c: OrderType.values()) {
			if (c.mValue.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}
}
