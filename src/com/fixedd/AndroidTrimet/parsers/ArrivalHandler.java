package com.fixedd.AndroidTrimet.parsers;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import com.fixedd.AndroidTrimet.schemas.Arrivals.*;

public class ArrivalHandler extends DefaultHandler {
	protected ResultSet        mResultSet            = null;
	private  LocationType      mCurrentLocation      = null;
	private  ArrivalType       mCurrentArrival       = null;
	private  BlockPositionType mCurrentBlockPosition = null;
	private  LayoverType       mCurrentLayover       = null;
	private  Boolean           mInError              = false;
	
	@Override
	public void startElement(String namespaceUri, String localName, String qualifiedName, Attributes attributes) throws SAXException {		
		if ((qualifiedName.equalsIgnoreCase("resultSet")) || (localName.equalsIgnoreCase("resultSet"))) {
			mResultSet = new ResultSet();
			if (attributes.getValue("queryTime") != null)
				mResultSet.setQueryTime(Long.parseLong(attributes.getValue("queryTime")));
		} else if ((qualifiedName.equalsIgnoreCase("location")) || (localName.equalsIgnoreCase("location"))) {
			mCurrentLocation = new LocationType();
			mCurrentLocation.setLocationId(Integer.parseInt(attributes.getValue("locid")));
			mCurrentLocation.setDescription(attributes.getValue("desc"));
			mCurrentLocation.setDirection(attributes.getValue("dir"));
			mCurrentLocation.setLatitude(Double.parseDouble(attributes.getValue("lat")));
			mCurrentLocation.setLongitude(Double.parseDouble(attributes.getValue("lng")));
		} else if ((qualifiedName.equalsIgnoreCase("arrival")) || (localName.equalsIgnoreCase("arrival"))) {
			mCurrentArrival = new ArrivalType();
			// required
			mCurrentArrival.setRouteNumber(Integer.parseInt(attributes.getValue("route")));
			mCurrentArrival.setLocationId(Integer.parseInt(attributes.getValue("locid")));
			mCurrentArrival.setDirection(Integer.parseInt(attributes.getValue("dir")));
			mCurrentArrival.setShortSign(attributes.getValue("shortSign"));
			mCurrentArrival.setFullSign(attributes.getValue("fullSign"));
			mCurrentArrival.setScheduledTime(Long.parseLong(attributes.getValue("scheduled")));
			mCurrentArrival.setBlock(Integer.parseInt(attributes.getValue("block")));
			mCurrentArrival.setPiece(attributes.getValue("piece"));
			mCurrentArrival.setDeparted(Boolean.parseBoolean(attributes.getValue("departed")));
			mCurrentArrival.setStatus(attributes.getValue("status"));
			// optional
			if (attributes.getValue("estimated") != null)
				mCurrentArrival.setEstimatedTime(Long.parseLong(attributes.getValue("estimated")));
			if (attributes.getValue("detour") != null)
				mCurrentArrival.setDetour(Boolean.parseBoolean(attributes.getValue("detour")));			
		} else if ((qualifiedName.equalsIgnoreCase("blockPosition")) || (localName.equalsIgnoreCase("blockPosition"))) {
			mCurrentBlockPosition = new BlockPositionType();
			// required
			mCurrentBlockPosition.setAt(Long.parseLong(attributes.getValue("at")));
			mCurrentBlockPosition.setFeet(Integer.parseInt(attributes.getValue("feet")));
			// optional
			mCurrentBlockPosition.setLatitude(Double.parseDouble(attributes.getValue("lat")));
			mCurrentBlockPosition.setLongitude(Double.parseDouble(attributes.getValue("lng")));
			mCurrentBlockPosition.setHeading(Integer.parseInt(attributes.getValue("heading")));
		} else if ((qualifiedName.equalsIgnoreCase("layover")) || (localName.equalsIgnoreCase("layover"))) {
			mCurrentLayover = new LayoverType();
			mCurrentLayover.setStartTime(Long.parseLong(attributes.getValue("start")));
			mCurrentLayover.setEndTime(Long.parseLong(attributes.getValue("end")));
		} else if ((qualifiedName.equalsIgnoreCase("trip")) || (localName.equalsIgnoreCase("trip"))) {
			TripType trip = new TripType();
			trip.setProgress           (Integer.parseInt(attributes.getValue("progress")));
			trip.setDestinationDistance(Integer.parseInt(attributes.getValue("destDist")));
			trip.setRouteNumber        (Integer.parseInt(attributes.getValue("route"   )));
			trip.setDirection          (Integer.parseInt(attributes.getValue("dir"     )));
			trip.setTripNum            (Integer.parseInt(attributes.getValue("tripNum" )));
			trip.setPattern            (Integer.parseInt(attributes.getValue("pattern" )));
			trip.setDesc               (attributes.getValue("desc"));
			mCurrentBlockPosition.getTrips().add(trip);
		} else if ((qualifiedName.equalsIgnoreCase("routeStatus")) || (localName.equalsIgnoreCase("routeStatus"))) {
			RouteStatusType routeStatus = new RouteStatusType();
			routeStatus.setRouteNumber(Integer.parseInt(attributes.getValue("route")));
			routeStatus.setStatus(attributes.getValue("status"));
			mResultSet.getRouteStatuses().add(routeStatus);
		} else if ((qualifiedName.equalsIgnoreCase("errorMessage")) || (localName.equalsIgnoreCase("errorMessage"))) {
			mInError = true;
		} else {
			System.out.println("There was an unknown XML element encountered.");
			System.out.println("    qualifiedName: " + qualifiedName);
			System.out.println("    localName:     " + localName);
			System.out.println("    namespaceUri:  " + namespaceUri);
		}
		
	}
	
	@Override
	public void endElement(String namespaceUri, String localName, String qualifiedName) throws SAXException {
		if ((qualifiedName.equalsIgnoreCase("location")) || (localName.equalsIgnoreCase("location"))) {
			// a location can be inside a layover or the resultset
			if (mCurrentLayover != null)
				mCurrentLayover.setLocation(mCurrentLocation);
			else
				mResultSet.getLocations().add(mCurrentLocation);
			mCurrentLocation = null;
		} else if ((qualifiedName.equalsIgnoreCase("arrival"))  || (localName.equalsIgnoreCase("arrival"))) {
			mResultSet.getArrivals().add(mCurrentArrival);
			mCurrentArrival = null;
		} else if ((qualifiedName.equalsIgnoreCase("blockPosition")) || (localName.equalsIgnoreCase("blockPosition"))) {
			mCurrentArrival.getBlockPositions().add(mCurrentBlockPosition);
			mCurrentBlockPosition = null;
		} else if ((qualifiedName.equalsIgnoreCase("layover")) || (localName.equalsIgnoreCase("layover"))) {
			mCurrentBlockPosition.getLayovers().add(mCurrentLayover);
			mCurrentLayover = null;
		} else if ((qualifiedName.equalsIgnoreCase("errorMessage")) || (localName.equalsIgnoreCase("errorMessage"))) {
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
