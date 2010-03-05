package com.fixedd.AndroidTrimet.schemas.TypeDefs;

import java.util.ArrayList;
import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;


/**
 * <p>Java class for RouteSummaryType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RouteSummaryType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="route" type="{http://maps.trimet.org/maps/model/xml}RouteIdType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class RouteSummaryType implements Parcelable {

	protected List<RouteIdType> mRoute;

	/**
	 * Create a new, empty copy of this object.
	 */
	public RouteSummaryType() {}

	/**
	 * Gets the value of the route property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list,
	 * not a snapshot. Therefore any modification you make to the
	 * returned list will be present inside the JAXB object.
	 * This is why there is not a <CODE>set</CODE> method for the route property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * <pre>
	 *    getRoute().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link RouteIdType }
	 * 
	 * 
	 */
	public List<RouteIdType> getRoute() {
		if (mRoute == null) {
			mRoute = new ArrayList<RouteIdType>();
		}
		return this.mRoute;
	}


	// **********************************************
	//  for implementing Parcelable
	// **********************************************


	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		if (mRoute != null && mRoute.size() > 0) {
			dest.writeInt(1);
			dest.writeTypedList(mRoute);
		} else
			dest.writeInt(0);
	}

	public static final Parcelable.Creator<RouteSummaryType> CREATOR = new Parcelable.Creator<RouteSummaryType>() {
		public RouteSummaryType createFromParcel(Parcel in) {
			return new RouteSummaryType(in);
		}

		public RouteSummaryType[] newArray(int size) {
			return new RouteSummaryType[size];
		}
	};

	private RouteSummaryType(Parcel dest) {
		if (dest.readInt() == 1) {
			mRoute = new ArrayList<RouteIdType>();
			dest.readTypedList(mRoute, RouteIdType.CREATOR);
		}
	}
}
