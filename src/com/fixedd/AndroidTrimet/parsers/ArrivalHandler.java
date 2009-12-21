package com.fixedd.AndroidTrimet.parsers;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.fixedd.AndroidTrimet.schemas.Arrivals.ArrivalType;
import com.fixedd.AndroidTrimet.schemas.Arrivals.BlockPositionType;
import com.fixedd.AndroidTrimet.schemas.Arrivals.LayoverType;
import com.fixedd.AndroidTrimet.schemas.Arrivals.LocationType;
import com.fixedd.AndroidTrimet.schemas.Arrivals.ResultSet;
import com.fixedd.AndroidTrimet.schemas.Arrivals.RouteStatusType;
import com.fixedd.AndroidTrimet.schemas.Arrivals.TripType;

public class ArrivalHandler extends DefaultHandler {
	protected ResultSet        mResultSet            = null;
	private  LocationType      mCurrentLocation      = null;
	private  ArrivalType       mCurrentArrival       = null;
	private  BlockPositionType mCurrentBlockPosition = null;
	private  LayoverType       mCurrentLayover       = null;
	private  Boolean           mInError              = false;
	
	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String, java.lang.String, java.lang.String, org.xml.sax.Attributes)
	 */
	@Override
	public void startElement(String namespaceUri, String localName, String qualifiedName, Attributes attributes) throws SAXException {
		//super.startElement(namespaceUri, localName, qualifiedName, attributes);
		
		if (qualifiedName.equalsIgnoreCase("resultSet")) {
			mResultSet = new ResultSet();
			if (attributes.getValue("queryTime") != null)
				mResultSet.setQueryTime(Long.parseLong(attributes.getValue("queryTime")));
		} else if (qualifiedName.equalsIgnoreCase("location")) {
			mCurrentLocation = new LocationType();
			mCurrentLocation.setLocid(Integer.parseInt(attributes.getValue("locid")));
			mCurrentLocation.setDesc(attributes.getValue("desc"));
			mCurrentLocation.setDir(attributes.getValue("dir"));
			mCurrentLocation.setLat(Double.parseDouble(attributes.getValue("lat")));
			mCurrentLocation.setLng(Double.parseDouble(attributes.getValue("lng")));
		} else if (qualifiedName.equalsIgnoreCase("arrival")) {
			mCurrentArrival = new ArrivalType();
			// required
			mCurrentArrival.setRoute(Integer.parseInt(attributes.getValue("route")));
			mCurrentArrival.setLocid(Integer.parseInt(attributes.getValue("locid")));
			mCurrentArrival.setDir(Integer.parseInt(attributes.getValue("dir")));
			mCurrentArrival.setShortSign(attributes.getValue("shortSign"));
			mCurrentArrival.setFullSign(attributes.getValue("fullSign"));
			mCurrentArrival.setScheduled(Long.parseLong(attributes.getValue("scheduled")));
			mCurrentArrival.setBlock(Integer.parseInt(attributes.getValue("block")));
			mCurrentArrival.setPiece(attributes.getValue("piece"));
			mCurrentArrival.setDeparted(Boolean.parseBoolean(attributes.getValue("departed")));
			mCurrentArrival.setStatus(attributes.getValue("status"));
			// optional
			if (attributes.getValue("estimated") != null)
				mCurrentArrival.setEstimated(Long.parseLong(attributes.getValue("estimated")));
			if (attributes.getValue("detour") != null)
				mCurrentArrival.setDetour(Boolean.parseBoolean(attributes.getValue("detour")));			
		} else if (qualifiedName.equalsIgnoreCase("blockPosition")) {
			mCurrentBlockPosition = new BlockPositionType();
			// required
			mCurrentBlockPosition.setAt(Long.parseLong(attributes.getValue("at")));
			mCurrentBlockPosition.setFeet(Integer.parseInt(attributes.getValue("feet")));
			// optional
			mCurrentBlockPosition.setLat(Double.parseDouble(attributes.getValue("lat")));
			mCurrentBlockPosition.setLng(Double.parseDouble(attributes.getValue("lng")));
			mCurrentBlockPosition.setHeading(Integer.parseInt(attributes.getValue("heading")));
		} else if (qualifiedName.equalsIgnoreCase("layover")) {
			mCurrentLayover = new LayoverType();
			mCurrentLayover.setStart(Long.parseLong(attributes.getValue("start")));
			mCurrentLayover.setEnd(Long.parseLong(attributes.getValue("end")));
		} else if (qualifiedName.equalsIgnoreCase("trip")) {
			TripType trip = new TripType();
			trip.setProgress(Integer.parseInt(attributes.getValue("progress")));
			trip.setDestDist(Integer.parseInt(attributes.getValue("destDist")));
			trip.setRoute   (Integer.parseInt(attributes.getValue("route"   )));
			trip.setDir     (Integer.parseInt(attributes.getValue("dir"     )));
			trip.setTripNum (Integer.parseInt(attributes.getValue("tripNum" )));
			trip.setPattern (Integer.parseInt(attributes.getValue("pattern" )));
			trip.setDesc    (attributes.getValue("desc"));
			mCurrentBlockPosition.getTrip().add(trip);
		} else if (qualifiedName.equalsIgnoreCase("trip")) {
			RouteStatusType routeStatus = new RouteStatusType();
			routeStatus.setRoute(Integer.parseInt(attributes.getValue("route")));
			routeStatus.setStatus(attributes.getValue("status"));
			mResultSet.getRouteStatus().add(routeStatus);
		} else if (qualifiedName.equalsIgnoreCase("errorMessage")) {
			mInError = true;
		} else {
			System.out.println("There was an unknown XML element encountered: " + qualifiedName);
		}
		
	}
	
	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#endElement(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void endElement(String namespaceUri, String localName, String qualifiedName) throws SAXException {
		if (qualifiedName.equalsIgnoreCase("location")) {
			// a location can be inside a layover or the resultset
			if (mCurrentLayover != null)
				mCurrentLayover.setLocation(mCurrentLocation);
			else
				mResultSet.getLocation().add(mCurrentLocation);
			mCurrentLocation = null;
		} else if (qualifiedName.equalsIgnoreCase("arrival")) {
			mResultSet.getArrival().add(mCurrentArrival);
			mCurrentArrival = null;
		} else if (qualifiedName.equalsIgnoreCase("blockPosition")) {
			mCurrentArrival.getBlockPosition().add(mCurrentBlockPosition);
			mCurrentBlockPosition = null;
		} else if (qualifiedName.equalsIgnoreCase("layover")) {
			mCurrentBlockPosition.getLayover().add(mCurrentLayover);
			mCurrentLayover = null;
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
