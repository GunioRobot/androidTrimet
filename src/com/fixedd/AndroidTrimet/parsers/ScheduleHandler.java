package com.fixedd.AndroidTrimet.parsers;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import android.util.Log;
import com.fixedd.AndroidTrimet.schemas.Schedule.*;

public class ScheduleHandler extends DefaultHandler {
	protected ResultSet          mResultSet        = null;
	private   RouteType          mCurrentRoute     = null;
	private   RouteDirectionType mCurrentDirection = null;
	private   DetourType         mCurrentDetour    = null;
	private   Boolean            mInError          = false;
	
	@Override
	public void startElement(String namespaceUri, String localName, String qualifiedName, Attributes attributes) throws SAXException {
		if ((qualifiedName.equalsIgnoreCase("resultSet")) || localName.equalsIgnoreCase("resultSet")) {
			mResultSet = new ResultSet();
		} else if ((qualifiedName.equalsIgnoreCase("route")) || localName.equalsIgnoreCase("route")) {
			mCurrentRoute = new RouteType();
			// required
			mCurrentRoute.setRouteNumber(Integer.parseInt(attributes.getValue("route")));
			mCurrentRoute.setDescription(attributes.getValue("desc"));
			mCurrentRoute.setType(attributes.getValue("type"));
			// optional
			if (attributes.getValue("detour") != null)
				mCurrentRoute.setDetour(Boolean.parseBoolean(attributes.getValue("detour")));
		} else if ((qualifiedName.equalsIgnoreCase("dir")) || localName.equalsIgnoreCase("dir")) {
			mCurrentDirection = new RouteDirectionType();
			mCurrentDirection.setDirection(Integer.parseInt(attributes.getValue("dir")));
			mCurrentDirection.setDescription(attributes.getValue("desc"));
		} else if ((qualifiedName.equalsIgnoreCase("stop")) || localName.equalsIgnoreCase("stop")) {
			StopType stop = new StopType();
			stop.setDescription(attributes.getValue("desc"));
			stop.setLocationId(Integer.parseInt    (attributes.getValue("locid")));
			stop.setLatitude(Double .parseDouble (attributes.getValue("lat"  )));
			stop.setLongitude(Double .parseDouble (attributes.getValue("lng"  )));
			stop.setSequence(Integer.parseInt    (attributes.getValue("seq"  )));
			stop.setTp(Boolean.parseBoolean(attributes.getValue("tp"   )));
			mCurrentDirection.getStops().add(stop);
		} else if ((qualifiedName.equalsIgnoreCase("detour")) || localName.equalsIgnoreCase("detour")) {
			mCurrentDetour = new DetourType();
			mCurrentDetour.setBeginTime(Long.parseLong(attributes.getValue("begin")));
			mCurrentDetour.setEndTime(Long.parseLong(attributes.getValue("end"  )));
			mCurrentDetour.setId(attributes.getValue("id"      ));
			mCurrentDetour.setDescription(attributes.getValue("desc"    ));
			mCurrentDetour.setPhonetic(attributes.getValue("phonetic"));
		} else if ((qualifiedName.equalsIgnoreCase("errorMessage")) || localName.equalsIgnoreCase("errorMessage")) {
			mInError = true;
		} else {
			Log.d(getClass().getSimpleName(), "There was an unknown XML element encountered: " + qualifiedName);
		}
	}
	
	@Override
	public void endElement(String namespaceUri, String localName, String qualifiedName) throws SAXException {
		if ((qualifiedName.equalsIgnoreCase("route")) || localName.equalsIgnoreCase("route")) {
			// a route can belong to a resultSet or a detour
			if (mCurrentDetour != null) 
				mCurrentDetour.getRoutes().add(mCurrentRoute);
			else
				mResultSet.getRoutes().add(mCurrentRoute);
			mCurrentRoute = null;
		} else if ((qualifiedName.equalsIgnoreCase("dir")) || localName.equalsIgnoreCase("dir")) {
			mCurrentRoute.getDirections().add(mCurrentDirection);
			mCurrentDirection = null;
		} else if ((qualifiedName.equalsIgnoreCase("detour")) || localName.equalsIgnoreCase("detour")) {
			mResultSet.getDetours().add(mCurrentDetour);
			mCurrentDetour = null;
		} else if ((qualifiedName.equalsIgnoreCase("errorMessage")) || localName.equalsIgnoreCase("errorMessage")) {
			mInError = false;
		}
	}

	@Override
	public void characters(char[] chars, int startIndex, int length) throws SAXException {
		String dataString = new String(chars, startIndex, length).trim();
		
		if (mInError) {
			mResultSet.setErrorMessage(dataString);
		} else {
			super.characters(chars, startIndex, length);
		}
	}
	
	/*
	 * 
	 */
	public ResultSet getResultSet() {
		return mResultSet;	
	}
}
