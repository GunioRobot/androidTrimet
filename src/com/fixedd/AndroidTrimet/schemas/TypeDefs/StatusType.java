package com.fixedd.AndroidTrimet.schemas.TypeDefs;


/**
 * <p>Java class for StatusType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="StatusType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="Detour"/>
 *     &lt;enumeration value="Route Status"/>
 *     &lt;enumeration value="Loss of Service"/>
 *     &lt;enumeration value="Announcement"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 *
 */
public enum StatusType {
	DETOUR("Detour"),
	ROUTE_STATUS("Route Status"),
	LOSS_OF_SERVICE("Loss of Service"),
	ANNOUNCEMENT("Announcement");

	private final String mValue;

	StatusType(String v) {
		mValue = v;
	}

	public String value() {
		return mValue;
	}

	public static StatusType fromValue(String v) {
		for (StatusType c: StatusType.values()) {
			if (c.mValue.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}
}
