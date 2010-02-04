package com.fixedd.AndroidTrimet.util;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * This is to make a String implement Parcelable. It's just a wrapper since the lovely Java developers, in their infinite wisdom, decided to make String a final class.
 * @author Jeremy Logan
 */
public final class ParcelableString implements Parcelable {
	private String mString;
	
	/**
	 * Create a new wrapped string.
	 * @param s The String to wrap.
	 */
	public ParcelableString(String s) {
		mString = s;
	}
	
	/**
	 * Get the wrapped string.
	 * @return the wrapped String.
	 */
	public String getString() {
		return mString;
	}

	/**
	 * Set the wrapped String.
	 * @param s the string to wrap.
	 */
	public void setString(String s) {
		this.mString = s;
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
		dest.writeString(mString);
	}

	public static final Parcelable.Creator<ParcelableString> CREATOR = new Parcelable.Creator<ParcelableString>() {
		public ParcelableString createFromParcel(Parcel in) {
			return new ParcelableString(in);
		}

		public ParcelableString[] newArray(int size) {
			return new ParcelableString[size];
		}
	};
	
	private ParcelableString(Parcel dest) {
		mString = dest.readString();
	}
}
