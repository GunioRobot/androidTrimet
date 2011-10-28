package com.fixedd.AndroidTrimet.schemas.TypeDefs;


/**
 * <p>Java class for KeyType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="KeyType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="Weekday"/>
 *     &lt;enumeration value="Saturday"/>
 *     &lt;enumeration value="Sunday"/>
 *     &lt;enumeration value="Holiday"/>
 *     &lt;enumeration value="Other"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 *
 */
public enum KeyType {

	WEEKDAY("Weekday"),
	SATURDAY("Saturday"),
	SUNDAY("Sunday"),
	HOLIDAY("Holiday"),
	OTHER("Other");

	private final String mValue;

	KeyType(String v) {
		mValue = v;
	}

	public String value() {
		return mValue;
	}

	public static KeyType fromValue(String v) {
		for (KeyType c: KeyType.values()) {
			if (c.mValue.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}
}
