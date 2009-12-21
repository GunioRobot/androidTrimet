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
	
	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String, java.lang.String, java.lang.String, org.xml.sax.Attributes)
	 */
	@Override
	public void startElement(String namespaceUri, String localName, String qualifiedName, Attributes attributes) throws SAXException {
		if (qualifiedName.equalsIgnoreCase("resultSet")) {
			mResultSet = new ResultSet();
		} else if (qualifiedName.equalsIgnoreCase("route")) {
			mCurrentRoute = new RouteType();
			// required
			mCurrentRoute.setRoute(Integer.parseInt(attributes.getValue("route")));
			mCurrentRoute.setDesc(attributes.getValue("desc"));
			mCurrentRoute.setType(attributes.getValue("type"));
			// optional
			if (attributes.getValue("detour") != null)
				mCurrentRoute.setDetour(Boolean.parseBoolean(attributes.getValue("detour")));
		} else if (qualifiedName.equalsIgnoreCase("dir")) {
			mCurrentDirection = new RouteDirectionType();
			mCurrentDirection.setDir(Integer.parseInt(attributes.getValue("dir")));
			mCurrentDirection.setDesc(attributes.getValue("desc"));
		} else if (qualifiedName.equalsIgnoreCase("stop")) {
			StopType stop = new StopType();
			stop.setDesc (attributes.getValue("desc"));
			stop.setLocid(Integer.parseInt    (attributes.getValue("locid")));
			stop.setLat  (Double .parseDouble (attributes.getValue("lat"  )));
			stop.setLng  (Double .parseDouble (attributes.getValue("lng"  )));
			stop.setSeq  (Integer.parseInt    (attributes.getValue("seq"  )));
			stop.setTp   (Boolean.parseBoolean(attributes.getValue("tp"   )));
			mCurrentDirection.getStop().add(stop);
		} else if (qualifiedName.equalsIgnoreCase("detour")) {
			mCurrentDetour = new DetourType();
			mCurrentDetour.setBegin(Long.parseLong(attributes.getValue("begin")));
			mCurrentDetour.setEnd  (Long.parseLong(attributes.getValue("end"  )));
			mCurrentDetour.setId      (attributes.getValue("id"      ));
			mCurrentDetour.setDesc    (attributes.getValue("desc"    ));
			mCurrentDetour.setPhonetic(attributes.getValue("phonetic"));
		} else if (qualifiedName.equalsIgnoreCase("errorMessage")) {
			mInError = true;
		} else {
			Log.d(getClass().getSimpleName(), "There was an unknown XML element encountered: " + qualifiedName);
		}
	}
	
	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#endElement(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void endElement(String namespaceUri, String localName, String qualifiedName) throws SAXException {
		if (qualifiedName.equalsIgnoreCase("route")) {
			// a route can belong to a resultSet or a detour
			if (mCurrentDetour != null) 
				mCurrentDetour.getRoute().add(mCurrentRoute);
			else
				mResultSet.getRoute().add(mCurrentRoute);
			mCurrentRoute = null;
		} else if (qualifiedName.equalsIgnoreCase("dir")) {
			mCurrentRoute.getDir().add(mCurrentDirection);
			mCurrentDirection = null;
		} else if (qualifiedName.equalsIgnoreCase("detour")) {
			mResultSet.getDetour().add(mCurrentDetour);
			mCurrentDetour = null;
		} else if (qualifiedName.equalsIgnoreCase("errorMessage")) {
			mInError = false;
		}
	}

	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#characters(char[], int, int)
	 */
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
