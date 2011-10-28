package com.fixedd.AndroidTrimet.tasks;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.xml.sax.SAXException;
import android.os.AsyncTask;
import android.util.Log;
import com.fixedd.AndroidTrimet.parsers.ItineraryHandler;
import com.fixedd.AndroidTrimet.schemas.Itinerary.ResponseType;

/**
 * A class for making Plan Trip lookups and parsing the results asynchronously.
 * @author Jeremy Logan
 *
 */
public class TripTask extends AsyncTask<HttpUriRequest, Integer, ResponseType> {
	private TripTaskCaller mCaller;

	/**
	 * Class constructor
	 * @param caller Something that implements TripTaskCaller for the task to "call" back to.
	 */
	public TripTask(TripTaskCaller caller) {
		this.mCaller = caller;
	}

	/**
	 * Make and parse the API lookup on a background thread.
	 * @param request a pre-built request object that is to be run on the background thread. This should make an API call against something that returns a response as layed out in http://developer.trimet.org/ws_docs/tripplanner_ws.shtml
	 * @return an Itinerary.ResponseType object on success or null on failure.
	 */

	public ResponseType doInBackground(HttpUriRequest... request) {
		try {
    		Log.i(getClass().getSimpleName(), "Starting HTTP Request");
    		HttpClient httpClient = new DefaultHttpClient();
    		HttpResponse resp = httpClient.execute(request[0]);

    		Log.i(getClass().getSimpleName(), "Starting XML parser");
    		SAXParserFactory saxFactory = SAXParserFactory.newInstance();
    		ItineraryHandler handler = new ItineraryHandler();
    		SAXParser parser = saxFactory.newSAXParser();
			parser.parse(resp.getEntity().getContent(), handler);

			return handler.getResponse();
		} catch (ClientProtocolException e) {
			Log.e(getClass().getSimpleName(), "HTTP protocol error", e);
			mCaller.handleError(e);
		} catch (IOException e) {
			Log.e(getClass().getSimpleName(), "Communication error", e);
			mCaller.handleError(e);
		} catch (ParserConfigurationException e) {
			Log.e(getClass().getSimpleName(), "XML parser configuration error", e);
			mCaller.handleError(e);
		} catch (SAXException e) {
			Log.e(getClass().getSimpleName(), "General SAX error", e);
			mCaller.handleError(e);
		}

    	return null;
	}


    protected void onProgressUpdate(Integer... progress) {
    	mCaller.handleProgress(progress[0]);
    }

    protected void onPostExecute(ResponseType results) {
    	mCaller.handleResponse(results);
    }

    public interface TripTaskCaller {
    	void handleResponse(ResponseType results);
    	void handleProgress(Integer progress);
    	void handleError(Exception exception);
    }
}
