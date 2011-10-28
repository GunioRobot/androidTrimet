package com.fixedd.AndroidTrimet.parsers;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import android.util.Log;
import com.fixedd.AndroidTrimet.schemas.Itinerary.ItinerariesType;
import com.fixedd.AndroidTrimet.schemas.Itinerary.LocationListType;
import com.fixedd.AndroidTrimet.schemas.Itinerary.ResponseType;
import com.fixedd.AndroidTrimet.schemas.Itinerary.WalkingDirectionsType;
import com.fixedd.AndroidTrimet.schemas.TypeDefs.AlertType;
import com.fixedd.AndroidTrimet.schemas.TypeDefs.ErrorType;
import com.fixedd.AndroidTrimet.schemas.TypeDefs.FareType;
import com.fixedd.AndroidTrimet.schemas.TypeDefs.GeoPointType;
import com.fixedd.AndroidTrimet.schemas.TypeDefs.GeoRouteType;
import com.fixedd.AndroidTrimet.schemas.TypeDefs.GeoURLType;
import com.fixedd.AndroidTrimet.schemas.TypeDefs.ItineraryType;
import com.fixedd.AndroidTrimet.schemas.TypeDefs.LegType;
import com.fixedd.AndroidTrimet.schemas.TypeDefs.OrderType;
import com.fixedd.AndroidTrimet.schemas.TypeDefs.OrderedStringsType;
import com.fixedd.AndroidTrimet.schemas.TypeDefs.PointType;
import com.fixedd.AndroidTrimet.schemas.TypeDefs.RequestType;
import com.fixedd.AndroidTrimet.schemas.TypeDefs.RouteIdType;
import com.fixedd.AndroidTrimet.schemas.TypeDefs.RouteSummaryType;
import com.fixedd.AndroidTrimet.schemas.TypeDefs.RouteType;
import com.fixedd.AndroidTrimet.schemas.TypeDefs.SpecialFareType;
import com.fixedd.AndroidTrimet.schemas.TypeDefs.StatusType;
import com.fixedd.AndroidTrimet.schemas.TypeDefs.StopPointType;
import com.fixedd.AndroidTrimet.schemas.TypeDefs.TimeDistanceType;
import com.fixedd.AndroidTrimet.schemas.TypeDefs.TransitLegType;
import com.fixedd.AndroidTrimet.schemas.TypeDefs.WalkingLegType;

/*
 * This is a god-awful mess that'll be impossible to maintain. It should be
 * rewritten to be clearer.
 */
public class ItineraryHandler extends DefaultHandler {
	private ResponseType		mResponse;
	// these are for keeping track of where we are while walking the XML tree
	private boolean				mInDate					= false;
	private boolean				mInTime					= false;
	private boolean				mInUrl					= false;
	private boolean				mInParam				= false;
	private boolean				mInX					= false;
	private boolean				mInY					= false;
	private boolean				mInLat					= false;
	private boolean				mInLon					= false;
	private boolean				mInDescription			= false;
	private boolean				mInLeg					= false;
	private boolean				mInStartTime			= false;
	private boolean				mInEndTime				= false;
	private boolean				mInDuration				= false;
	private boolean				mInDistance				= false;
	private boolean				mInNumberOfTransfers	= false;
	private boolean				mInNumberOfTripLegs		= false;
	private boolean				mInWalkingTime			= false;
	private boolean				mInTransitTime			= false;
	private boolean				mInWaitingTime			= false;
	private boolean				mInTimeDistance			= false;
	private boolean				mInRegular				= false;
	private boolean				mInSpecial				= false;
	private boolean				mInNumber				= false;
	private boolean				mInInternalNumber		= false;
	private boolean				mInDirection			= false;
	private boolean				mInName					= false;
	private boolean				mInKey					= false;
	private boolean				mInBlock				= false;
	private boolean				mInProvider				= false;
	private boolean				mInBegin				= false;
	private boolean				mInEnd					= false;
	private boolean				mInStatus				= false;
	private boolean				mInDomain				= false;
	private boolean				mInTypeName				= false;
	private boolean				mInOgcFilter			= false;
	private boolean				mInWfsUrl				= false;
	private boolean				mInWmsUrl				= false;
	private boolean				mInWalkingDirections	= false;
	private boolean				mInTransitLegRoute		= false;
	private boolean				mInQuery				= false;
	private boolean				mInTurn					= false;
	private boolean				mInMessage				= false;
	private boolean 			mInFrom = false;
	private boolean 			mInTo = false;
	//
	private RequestType.Param	mCurrentParam			= null;
	private PointType			mCurrentPointType		= null;
	private GeoPointType		mCurrentGeoPointType	= null;
	private ItineraryType		mCurrentItinerary		= null;
	private TimeDistanceType	mCurrentTimeDistance	= null;
	private SpecialFareType		mCurrentSpecialFareType	= null;
	private RouteIdType			mCurrentRouteId			= null;
	private LegType				mCurrentLeg				= null;
	private GeoRouteType		mCurrentGeoRoute		= null;
	private AlertType			mCurrentAlert			= null;
	private LocationListType	mCurrentLocationList	= null;
	private OrderedStringsType	mCurrentTurn			= null;

	@Override
	public void startElement(String uri, String localName, String qualifiedName, Attributes attributes) throws SAXException {
		// ResponseType
		if (qualifiedName.equalsIgnoreCase("response") || localName.equalsIgnoreCase("response")) {
			mResponse = new ResponseType();
			mResponse.setSuccess(Boolean.parseBoolean(attributes.getValue("success")));
		} else if (qualifiedName.equalsIgnoreCase("date") || localName.equalsIgnoreCase("date")) {
			mInDate = true;
		} else if (qualifiedName.equalsIgnoreCase("time") || localName.equalsIgnoreCase("time")) {
			mInTime = true;


		} else if (qualifiedName.equalsIgnoreCase("request") || localName.equalsIgnoreCase("request")) {
			mResponse.setRequest(new RequestType());
		} else if (qualifiedName.equalsIgnoreCase("url") || localName.equalsIgnoreCase("url")) {
			mInUrl = true;
		} else if (qualifiedName.equalsIgnoreCase("param") || localName.equalsIgnoreCase("param")) {
			mInParam = true;
			mCurrentParam = new RequestType.Param();
			mCurrentParam.setName(attributes.getValue("name"));


		} else if (qualifiedName.equalsIgnoreCase("from") || localName.equalsIgnoreCase("from")) {
			mInFrom = true;

			// TODO: HACK! I can't seem to figure out how to just request the
			// "xsi:type" attribute without looping over the attribute list
			// looking for it. This needs more research.
			String val = null;
			for (int i=0; i < attributes.getLength(); i++) {
				if (attributes.getQName(i).equalsIgnoreCase("type") || attributes.getLocalName(i).equalsIgnoreCase("type")) {
					val = attributes.getValue(i);
					break;
				}
			}
			if (val == null)
				mCurrentPointType = new PointType();
			else if (val.equalsIgnoreCase("ns:GeoPointType")) {	// xsi:type
				mCurrentPointType = new GeoPointType();
			} else if (val.equalsIgnoreCase("ns:StopPointType")) {
				mCurrentPointType = new StopPointType();
			} else {
				mCurrentPointType = new PointType();
			}

			if (attributes.getValue("areaKey") != null)
				mCurrentPointType.setAreaKey(attributes.getValue("areaKey"));
			if (attributes.getValue("areaValue") != null)
				mCurrentPointType.setAreaValue(attributes.getValue("areaValue"));
			if (attributes.getValue("id") != null)
				mCurrentPointType.setAreaKey(attributes.getValue("id"));
		} else if (qualifiedName.equalsIgnoreCase("pos") || localName.equalsIgnoreCase("pos")) {
			mCurrentGeoPointType = new GeoPointType();
			if (attributes.getValue("srsName") != null)
				mCurrentGeoPointType.setSrsName(attributes.getValue("srsName"));
			if (attributes.getValue("id") != null)
				mCurrentGeoPointType.setId(attributes.getValue("id"));
		} else if (qualifiedName.equalsIgnoreCase("x") || localName.equalsIgnoreCase("x")) {
			mInX = true;
		} else if (qualifiedName.equalsIgnoreCase("y") || localName.equalsIgnoreCase("y")) {
			mInY = true;
		} else if (qualifiedName.equalsIgnoreCase("lat") || localName.equalsIgnoreCase("lat")) {
			mInLat = true;
		} else if (qualifiedName.equalsIgnoreCase("lon") || localName.equalsIgnoreCase("lon")) {
			mInLon = true;
		} else if (qualifiedName.equalsIgnoreCase("description") || localName.equalsIgnoreCase("description")) {
			mInDescription = true;


		} else if (qualifiedName.equalsIgnoreCase("to") || localName.equalsIgnoreCase("to")) {
			mInTo = true;

			// TODO: HACK! I can't seem to figure out how to just request the
			// "xsi:type" attribute without looping over the attribute list
			// looking for it. This needs more research.
			String val = null;
			for (int i=0; i < attributes.getLength(); i++) {
				if (attributes.getQName(i).equalsIgnoreCase("type") || attributes.getLocalName(i).equalsIgnoreCase("type")) {
					val = attributes.getValue(i);
					break;
				}
			}
			if (val == null)
				mCurrentPointType = new PointType();
			else if (val.equalsIgnoreCase("ns:GeoPointType")) {	// xsi:type
				mCurrentPointType = new GeoPointType();
			} else if (val.equalsIgnoreCase("ns:StopPointType")) {
				mCurrentPointType = new StopPointType();
			} else {
				mCurrentPointType = new PointType();
			}

			if (attributes.getValue("areaKey") != null)
				mCurrentPointType.setAreaKey(attributes.getValue("areaKey"));
			if (attributes.getValue("areaValue") != null)
				mCurrentPointType.setAreaValue(attributes.getValue("areaValue"));
			if (attributes.getValue("id") != null)
				mCurrentPointType.setAreaKey(attributes.getValue("id"));
		} else if (qualifiedName.equalsIgnoreCase("itineraries") || localName.equalsIgnoreCase("itineraries")) {
			mResponse.setItineraries(new ItinerariesType());
			mResponse.getItineraries().setCount(Integer.parseInt(attributes.getValue("count")));
		} else if (qualifiedName.equalsIgnoreCase("itinerary") || localName.equalsIgnoreCase("itinerary")) {
			mCurrentItinerary = new ItineraryType();
			mCurrentItinerary.setId(attributes.getValue("id"));
			mCurrentItinerary.setViaRoute(attributes.getValue("viaRoute"));
		} else if (qualifiedName.equalsIgnoreCase("time-distance") || localName.equalsIgnoreCase("time-distance")) {
			mInTimeDistance = true;
			mCurrentTimeDistance = new TimeDistanceType();
		} else if (qualifiedName.equalsIgnoreCase("startTime") || localName.equalsIgnoreCase("startTime")) {
			mInStartTime = true;
		} else if (qualifiedName.equalsIgnoreCase("endTime") || localName.equalsIgnoreCase("endTime")) {
			mInEndTime = true;
		} else if (qualifiedName.equalsIgnoreCase("duration") || localName.equalsIgnoreCase("duration")) {
			mInDuration = true;
		} else if (qualifiedName.equalsIgnoreCase("distance") || localName.equalsIgnoreCase("distance")) {
			mInDistance = true;
		} else if (qualifiedName.equalsIgnoreCase("numberOfTransfers") || localName.equalsIgnoreCase("numberOfTransfers")) {
			mInNumberOfTransfers = true;
		} else if (qualifiedName.equalsIgnoreCase("numberOfTripLegs") || localName.equalsIgnoreCase("numberOfTripLegs")) {
			mInNumberOfTripLegs = true;
		} else if (qualifiedName.equalsIgnoreCase("walkingTime") || localName.equalsIgnoreCase("walkingTime")) {
			mInWalkingTime = true;
		} else if (qualifiedName.equalsIgnoreCase("transitTime") || localName.equalsIgnoreCase("transitTime")) {
			mInTransitTime = true;
		} else if (qualifiedName.equalsIgnoreCase("waitingTime") || localName.equalsIgnoreCase("waitingTime")) {
			mInWaitingTime = true;


		} else if (qualifiedName.equalsIgnoreCase("fare") || localName.equalsIgnoreCase("fare")) {
			if (mInLeg) {
				((TransitLegType)mCurrentLeg).setFare(new FareType());
				((TransitLegType)mCurrentLeg).getFare().setProvider(attributes.getValue("provider"));
			} else {
				mCurrentItinerary.setFare(new FareType());
				mCurrentItinerary.getFare().setProvider(attributes.getValue("provider"));
			}
		} else if (qualifiedName.equalsIgnoreCase("regular") || localName.equalsIgnoreCase("regular")) {
			mInRegular = true;
		} else if (qualifiedName.equalsIgnoreCase("special") || localName.equalsIgnoreCase("special")) {
			mInSpecial = true;
			mCurrentSpecialFareType = new SpecialFareType();
			mCurrentSpecialFareType.setId(attributes.getValue("id"));


		} else if (qualifiedName.equalsIgnoreCase("routes") || localName.equalsIgnoreCase("routes")) {
			mCurrentItinerary.setRoutes(new RouteSummaryType());
		} else if (qualifiedName.equalsIgnoreCase("route") || localName.equalsIgnoreCase("route")) {
			if (mInLeg) {
				mInTransitLegRoute = true;
				((TransitLegType)mCurrentLeg).setRoute(new RouteType());
			} else
				mCurrentRouteId = new RouteIdType();
		} else if (qualifiedName.equalsIgnoreCase("number") || localName.equalsIgnoreCase("number")) {
			mInNumber = true;
		} else if (qualifiedName.equalsIgnoreCase("internalNumber") || localName.equalsIgnoreCase("internalNumber")) {
			mInInternalNumber = true;
		} else if (qualifiedName.equalsIgnoreCase("direction") || localName.equalsIgnoreCase("direction")) {
			mInDirection = true;

		} else if (qualifiedName.equalsIgnoreCase("name") || localName.equalsIgnoreCase("name")) {
			mInName = true;
		} else if (qualifiedName.equalsIgnoreCase("key") || localName.equalsIgnoreCase("key")) {
			mInKey = true;
		} else if (qualifiedName.equalsIgnoreCase("block") || localName.equalsIgnoreCase("block")) {
			mInBlock = true;
		} else if (qualifiedName.equalsIgnoreCase("provider") || localName.equalsIgnoreCase("provider")) {
			mInProvider = true;
		} else if (qualifiedName.equalsIgnoreCase("alert") || localName.equalsIgnoreCase("alert")) {
			mCurrentAlert = new AlertType();
		} else if (qualifiedName.equalsIgnoreCase("begin") || localName.equalsIgnoreCase("begin")) {
			mInBegin = true;
		} else if (qualifiedName.equalsIgnoreCase("end") || localName.equalsIgnoreCase("end")) {
			mInEnd = true;
		} else if (qualifiedName.equalsIgnoreCase("status") || localName.equalsIgnoreCase("status")) {
			mInStatus = true;

		} else if (qualifiedName.equalsIgnoreCase("leg") || localName.equalsIgnoreCase("leg")) {
			mInLeg = true;

			// TODO: HACK! I can't seem to figure out how to just request the
			// "xsi:type" attribute without looping over the attribute list
			// looking for it. This needs more research.
			String val = null;
			for (int i=0; i < attributes.getLength(); i++) {
				if (attributes.getQName(i).equalsIgnoreCase("type") || attributes.getLocalName(i).equalsIgnoreCase("type")) {
					val = attributes.getValue(i);
					break;
				}
			}
			if (val == null)
				throw new RuntimeException("can't find xsi:type");


			if (val.equalsIgnoreCase("ns:TransitLegType")) {	// xsi:type
					mCurrentLeg = new TransitLegType();
			} else if (val.equalsIgnoreCase("ns:WalkingLegType")) {
				mCurrentLeg = new WalkingLegType();
			} else {
				throw new RuntimeException("Unknown LegType: " + val);
			}
			if (attributes.getValue("id") != null)
				mCurrentLeg.setId(attributes.getValue("id"));
			mCurrentLeg.setMode(attributes.getValue("mode"));
			if (attributes.getValue("order") != null)
				mCurrentLeg.setOrder(OrderType.fromValue(attributes.getValue("order")));
		} else if (qualifiedName.equalsIgnoreCase("lineURL") || localName.equalsIgnoreCase("lineURL")) {
			mCurrentLeg.setLineURL(new GeoURLType());
			mCurrentLeg.getLineURL().setParam(attributes.getValue("param"));


		} else if (qualifiedName.equalsIgnoreCase("geo") || localName.equalsIgnoreCase("geo")) {
			mCurrentGeoRoute = new GeoRouteType();
		} else if (qualifiedName.equalsIgnoreCase("domain") || localName.equalsIgnoreCase("domain")) {
			mInDomain = true;
		} else if (qualifiedName.equalsIgnoreCase("typeName") || localName.equalsIgnoreCase("typeName")) {
			mInTypeName = true;
		} else if (qualifiedName.equalsIgnoreCase("ogcFilter") || localName.equalsIgnoreCase("ogcFilter")) {
			mInOgcFilter = true;
		} else if (qualifiedName.equalsIgnoreCase("wfsUrl") || localName.equalsIgnoreCase("wfsUrl")) {
			mInWfsUrl = true;
		} else if (qualifiedName.equalsIgnoreCase("wmsUrl") || localName.equalsIgnoreCase("wmsUrl")) {
			mInWmsUrl = true;




		} else if (
			qualifiedName.equalsIgnoreCase("locations") || localName.equalsIgnoreCase("locations") ||
			qualifiedName.equalsIgnoreCase("fromList" ) || localName.equalsIgnoreCase("fromList" ) ||
			qualifiedName.equalsIgnoreCase("toList"   ) || localName.equalsIgnoreCase("toList"   )
		) {
			mCurrentLocationList = new LocationListType();
			if (attributes.getValue("count") != null)
				mCurrentLocationList.setCount(Integer.parseInt(attributes.getValue("count")));
		} else if (qualifiedName.equalsIgnoreCase("query") || localName.equalsIgnoreCase("query")) {
			mInQuery = true;
		} else if (qualifiedName.equalsIgnoreCase("location") || localName.equalsIgnoreCase("location")) {
			mCurrentPointType = new PointType();
			if (attributes.getValue("areaKey") != null)
				mCurrentPointType.setAreaKey(attributes.getValue("areaKey"));
			if (attributes.getValue("areaValue") != null)
				mCurrentPointType.setAreaValue(attributes.getValue("areaValue"));
			if (attributes.getValue("id") != null)
				mCurrentPointType.setAreaKey(attributes.getValue("id"));



		} else if (qualifiedName.equalsIgnoreCase("walkingDirections") || localName.equalsIgnoreCase("walkingDirections")) {
			mInWalkingDirections = true;
			mResponse.setWalkingDirections(new WalkingDirectionsType());
			mResponse.getWalkingDirections().setCount(Integer.parseInt(attributes.getValue("count")));
		} else if (qualifiedName.equalsIgnoreCase("turn") || localName.equalsIgnoreCase("turn")) {
			mInTurn = true;
			mCurrentTurn = new OrderedStringsType();
			mCurrentTurn.setId(Integer.parseInt(attributes.getValue("id")));


		} else if (qualifiedName.equalsIgnoreCase("error") || localName.equalsIgnoreCase("error")) {
			mResponse.setError(new ErrorType());
			mResponse.getError().setCode(attributes.getValue("code"));
		} else if (qualifiedName.equalsIgnoreCase("message") || localName.equalsIgnoreCase("message")) {
			mInMessage = true;
		} else {
			Log.i(getClass().getSimpleName(), "Unknown start element: " + qualifiedName + "/" + localName);
		}
	}



	@Override
	public void characters(char[] chars, int startIndex, int length) throws SAXException {
		String dataString = new String(chars, startIndex, length);

		if (mInDate) {
			if (mInTimeDistance) {
				mCurrentTimeDistance.setDate(dataString);
			} else {
				mResponse.setDate(dataString);
			}
		} else if (mInTime) {
			mResponse.setTime(dataString);
		} else if (mInUrl) {
			if (mInLeg) {
				mCurrentLeg.getLineURL().setUrl(dataString);
			} else {
				mResponse.getRequest().setUrl(dataString);
			}
		} else if (mInParam) {
			mCurrentParam.setValue(dataString);
		} else if (mInX) {
			mCurrentGeoPointType.setX(dataString);
		} else if (mInY) {
			mCurrentGeoPointType.setY(dataString);
		} else if (mInLat) {
			mCurrentGeoPointType.setLat(dataString);
		} else if (mInLon) {
			mCurrentGeoPointType.setLon(dataString);
		} else if (mInDescription) {
			if (mInLeg && !mInFrom && !mInTo)
				mCurrentAlert.setDescription(dataString);
			else
				mCurrentPointType.appendDescription(dataString);

		} else if (mInStartTime) {
			mCurrentTimeDistance.setStartTime(dataString);
		} else if (mInEndTime) {
			mCurrentTimeDistance.setEndTime(dataString);
		} else if (mInDuration) {
			mCurrentTimeDistance.setDuration(Integer.parseInt(dataString));
		} else if (mInDistance) {
			if (mInWalkingDirections) {
				mResponse.getWalkingDirections().setDistance(Double.parseDouble(dataString));
			} else {
				mCurrentTimeDistance.setDistance(Double.parseDouble(dataString));
			}
		} else if (mInNumberOfTransfers) {
			mCurrentTimeDistance.setNumberOfTransfers(Integer.parseInt(dataString));
		} else if (mInNumberOfTripLegs) {
			mCurrentTimeDistance.setNumberOfTripLegs(Integer.parseInt(dataString));
		} else if (mInWalkingTime) {
			mCurrentTimeDistance.setWalkingTime(Integer.parseInt(dataString));
		} else if (mInTransitTime) {
			mCurrentTimeDistance.setTransitTime(Integer.parseInt(dataString));
		} else if (mInWaitingTime) {
			mCurrentTimeDistance.setWaitingTime(Integer.parseInt(dataString));

		} else if (mInRegular) {
			if (mInLeg)
				((TransitLegType)mCurrentLeg).getFare().setRegular(dataString);
			else
				mCurrentItinerary.getFare().setRegular(dataString);
		} else if (mInSpecial) {
			mCurrentSpecialFareType.setValue(dataString);


		} else if (mInNumber) {
			if (mInLeg)
				((TransitLegType)mCurrentLeg).getRoute().setNumber(dataString);
			else
				mCurrentRouteId.setNumber(dataString);
		} else if (mInInternalNumber) {
			if (mInLeg)
				((TransitLegType)mCurrentLeg).getRoute().setInternalNumber(dataString);
			else
				mCurrentRouteId.setInternalNumber(dataString);
		} else if (mInDirection) {
			if (mInLeg) {
				if (mInTransitLegRoute)
					((TransitLegType)mCurrentLeg).getRoute().setDirection(dataString);
				else
					((WalkingLegType)mCurrentLeg).setDirection(dataString);
			} else
				mCurrentRouteId.setDirection(dataString);
		} else if (mInName) {
			((TransitLegType)mCurrentLeg).getRoute().setName(dataString);
		} else if (mInKey) {
			((TransitLegType)mCurrentLeg).getRoute().setKey(dataString);
		} else if (mInBlock) {
			((TransitLegType)mCurrentLeg).getRoute().setBlock(dataString);
		} else if (mInProvider) {
			((TransitLegType)mCurrentLeg).getRoute().setProvider(dataString);
		} else if (mInBegin) {
			mCurrentAlert.setBegin(dataString);
		} else if (mInEnd) {
			mCurrentAlert.setEnd(dataString);
		} else if (mInStatus) {
			mCurrentAlert.setStatus(StatusType.fromValue(dataString));


		} else if (mInDomain) {
			mCurrentGeoRoute.setDomain(dataString);
		} else if (mInTypeName) {
			mCurrentGeoRoute.setTypeName(dataString);
		} else if (mInOgcFilter) {
			mCurrentGeoRoute.setOgcFilter(dataString);
		} else if (mInWfsUrl) {
			mCurrentGeoRoute.setWfsUrl(dataString);
		} else if (mInWmsUrl) {
			mCurrentGeoRoute.setWmsUrl(dataString);


		} else if (mInQuery) {
			mCurrentLocationList.setQuery(dataString);


		} else if (mInTurn) {
			mCurrentTurn.setValue(dataString);

		} else if  (mInMessage) {
			mResponse.getError().setMessage(dataString);

		} else {
			super.characters(chars, startIndex, length);
		}
	}

	@Override
	public void endElement(String uri, String localName, String qualifiedName) throws SAXException {
		if (qualifiedName.equalsIgnoreCase("date") || localName.equalsIgnoreCase("date")) {
			mInDate = false;
		} else if (qualifiedName.equalsIgnoreCase("time") || localName.equalsIgnoreCase("time")) {
			mInTime = false;
		} else if (qualifiedName.equalsIgnoreCase("url") || localName.equalsIgnoreCase("url")) {
			mInUrl = false;
		} else if (qualifiedName.equalsIgnoreCase("param") || localName.equalsIgnoreCase("param")) {
			mInParam = false;
			mResponse.getRequest().getParam().add(mCurrentParam);
		} else if (qualifiedName.equalsIgnoreCase("from") || localName.equalsIgnoreCase("from")) {
			mInFrom = false;
			if (mInLeg) {
				mCurrentLeg.setFrom(mCurrentPointType);
			} else {
				mResponse.setFrom(mCurrentPointType);
			}
		} else if (qualifiedName.equalsIgnoreCase("pos") || localName.equalsIgnoreCase("pos")) {
			mCurrentPointType.setPos(mCurrentGeoPointType);
		} else if (qualifiedName.equalsIgnoreCase("x") || localName.equalsIgnoreCase("x")) {
			mInX = false;
		} else if (qualifiedName.equalsIgnoreCase("y") || localName.equalsIgnoreCase("y")) {
			mInY = false;
		} else if (qualifiedName.equalsIgnoreCase("lat") || localName.equalsIgnoreCase("lat")) {
			mInLat = false;
		} else if (qualifiedName.equalsIgnoreCase("lon") || localName.equalsIgnoreCase("lon")) {
			mInLon = false;
		} else if (qualifiedName.equalsIgnoreCase("description") || localName.equalsIgnoreCase("description")) {
			mInDescription = false;
		} else if (qualifiedName.equalsIgnoreCase("to") || localName.equalsIgnoreCase("to")) {
			mInTo = false;
			if (mInLeg) {
				mCurrentLeg.setTo(mCurrentPointType);
			} else {
				mResponse.setTo(mCurrentPointType);
			}
		} else if (qualifiedName.equalsIgnoreCase("itinerary") || localName.equalsIgnoreCase("itinerary")) {
			mResponse.getItineraries().getItinerary().add(mCurrentItinerary);
		} else if (qualifiedName.equalsIgnoreCase("time-distance") || localName.equalsIgnoreCase("time-distance")) {
			mInTimeDistance = false;
			if (mInLeg) {
				mCurrentLeg.setTimeDistance(mCurrentTimeDistance);
			} else {
				mCurrentItinerary.setTimeDistance(mCurrentTimeDistance);
			}

		} else if (qualifiedName.equalsIgnoreCase("startTime") || localName.equalsIgnoreCase("startTime")) {
			mInStartTime = false;
		} else if (qualifiedName.equalsIgnoreCase("endTime") || localName.equalsIgnoreCase("endTime")) {
			mInEndTime = false;
		} else if (qualifiedName.equalsIgnoreCase("duration") || localName.equalsIgnoreCase("duration")) {
			mInDuration = false;
		} else if (qualifiedName.equalsIgnoreCase("distance") || localName.equalsIgnoreCase("distance")) {
			mInDistance = false;
		} else if (qualifiedName.equalsIgnoreCase("numberOfTransfers") || localName.equalsIgnoreCase("numberOfTransfers")) {
			mInNumberOfTransfers = false;
		} else if (qualifiedName.equalsIgnoreCase("numberOfTripLegs") || localName.equalsIgnoreCase("numberOfTripLegs")) {
			mInNumberOfTripLegs = false;
		} else if (qualifiedName.equalsIgnoreCase("walkingTime") || localName.equalsIgnoreCase("walkingTime")) {
			mInWalkingTime = false;
		} else if (qualifiedName.equalsIgnoreCase("transitTime") || localName.equalsIgnoreCase("transitTime")) {
			mInTransitTime = false;

		} else if (qualifiedName.equalsIgnoreCase("waitingTime") || localName.equalsIgnoreCase("waitingTime")) {
			mInWaitingTime = false;
		} else if (qualifiedName.equalsIgnoreCase("regular") || localName.equalsIgnoreCase("regular")) {
			mInRegular = false;
		} else if (qualifiedName.equalsIgnoreCase("special") || localName.equalsIgnoreCase("special")) {
			mInSpecial = false;

			if (mInLeg)
				((TransitLegType)mCurrentLeg).getFare().getSpecial().add(mCurrentSpecialFareType);
			else
				mCurrentItinerary.getFare().getSpecial().add(mCurrentSpecialFareType);
		} else if (qualifiedName.equalsIgnoreCase("route") || localName.equalsIgnoreCase("route")) {
			if (!mInLeg)
				mCurrentItinerary.getRoutes().getRoute().add(mCurrentRouteId);
			else
				mInTransitLegRoute = false;


		} else if (qualifiedName.equalsIgnoreCase("alert") || localName.equalsIgnoreCase("alert")) {
			((TransitLegType)mCurrentLeg).getRoute().getAlert().add(mCurrentAlert);
		} else if (qualifiedName.equalsIgnoreCase("number") || localName.equalsIgnoreCase("number")) {
			mInNumber = false;
		} else if (qualifiedName.equalsIgnoreCase("internalNumber") || localName.equalsIgnoreCase("internalNumber")) {
			mInInternalNumber = false;
		} else if (qualifiedName.equalsIgnoreCase("direction") || localName.equalsIgnoreCase("direction")) {
			mInDirection = false;
		} else if (qualifiedName.equalsIgnoreCase("name") || localName.equalsIgnoreCase("name")) {
			mInName = false;
		} else if (qualifiedName.equalsIgnoreCase("key") || localName.equalsIgnoreCase("key")) {
			mInKey = false;
		} else if (qualifiedName.equalsIgnoreCase("block") || localName.equalsIgnoreCase("block")) {
			mInBlock = false;
		} else if (qualifiedName.equalsIgnoreCase("provider") || localName.equalsIgnoreCase("provider")) {
			mInProvider = false;

		} else if (qualifiedName.equalsIgnoreCase("leg") || localName.equalsIgnoreCase("leg")) {
			mInLeg = false;
			mCurrentItinerary.getLeg().add(mCurrentLeg);
		} else if (qualifiedName.equalsIgnoreCase("geo") || localName.equalsIgnoreCase("geo")) {
			mCurrentItinerary.getGeo().add(mCurrentGeoRoute);
		} else if (qualifiedName.equalsIgnoreCase("domain") || localName.equalsIgnoreCase("domain")) {
			mInDomain = false;
		} else if (qualifiedName.equalsIgnoreCase("typeName") || localName.equalsIgnoreCase("typeName")) {
			mInTypeName = false;
		} else if (qualifiedName.equalsIgnoreCase("ogcFilter") || localName.equalsIgnoreCase("ogcFilter")) {
			mInOgcFilter = false;
		} else if (qualifiedName.equalsIgnoreCase("wfsUrl") || localName.equalsIgnoreCase("wfsUrl")) {
			mInWfsUrl = false;
		} else if (qualifiedName.equalsIgnoreCase("wmsUrl") || localName.equalsIgnoreCase("wmsUrl")) {
			mInWmsUrl = false;

		} else if (qualifiedName.equalsIgnoreCase("begin") || localName.equalsIgnoreCase("begin")) {
			mInBegin = false;
		} else if (qualifiedName.equalsIgnoreCase("end") || localName.equalsIgnoreCase("end")) {
			mInEnd = false;
		} else if (qualifiedName.equalsIgnoreCase("status") || localName.equalsIgnoreCase("status")) {
			mInStatus = false;


		} else if (qualifiedName.equalsIgnoreCase("locations") || localName.equalsIgnoreCase("locations")) {
			mResponse.setLocations(mCurrentLocationList);
		} else if (qualifiedName.equalsIgnoreCase("fromList") || localName.equalsIgnoreCase("fromList")) {
			mResponse.setFromList(mCurrentLocationList);
		} else if (qualifiedName.equalsIgnoreCase("toList") || localName.equalsIgnoreCase("toList")) {
			mResponse.setToList(mCurrentLocationList);
		} else if (qualifiedName.equalsIgnoreCase("query") || localName.equalsIgnoreCase("query")) {
			mInQuery = false;
		} else if (qualifiedName.equalsIgnoreCase("location") || localName.equalsIgnoreCase("location")) {
			mCurrentLocationList.getLocation().add(mCurrentPointType);


		} else if (qualifiedName.equalsIgnoreCase("walkingDirections") || localName.equalsIgnoreCase("walkingDirections")) {
			mInWalkingDirections = false;
		} else if (qualifiedName.equalsIgnoreCase("turn") || localName.equalsIgnoreCase("turn")) {
			mInTurn = false;
			mResponse.getWalkingDirections().getTurn().add(mCurrentTurn);


		} else if (qualifiedName.equalsIgnoreCase("message") || localName.equalsIgnoreCase("message")) {
			mInMessage = false;
		} else {
			Log.i(getClass().getSimpleName(), "Unknown end element: " + qualifiedName + "/" + localName);
		}
	}


	/*
	 *
	 */
	public ResponseType getResponse() {
		return mResponse;
	}
}
