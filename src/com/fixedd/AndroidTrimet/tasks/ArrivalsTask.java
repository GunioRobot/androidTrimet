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

import com.fixedd.AndroidTrimet.parsers.ArrivalHandler;
import com.fixedd.AndroidTrimet.schemas.Arrivals.ResultSet;

import android.os.AsyncTask;
import android.util.Log;

/**
 * A class for making Arrivals lookups and parsing the results asynchronously.
 * @author Jeremy Logan
 *
 */
public class ArrivalsTask extends AsyncTask<HttpUriRequest, Integer, ResultSet> {
	private ArrivalsTaskCaller mCaller;
	
	/**
	 * Class constructor
	 * @param caller Something that implements ArrivalsTaskCaller for the task to "call" back to.
	 */
	public ArrivalsTask(ArrivalsTaskCaller caller) {
		this.mCaller = caller;
	}
	
	/**
	 * Make and parse the API lookup on a background thread.
	 * @param request a pre-built request object that is to be run on the background thread. This should make an API call against something that returns a response as layed out in http://developer.trimet.org/schema/arrivals.xsd
	 * @return an Arrivals.ResultSet object on success or null on failure. 
	 */
	
	public ResultSet doInBackground(HttpUriRequest... request) {
		HttpResponse resp = null;
		
    	try {
    		//Log.i(getClass().getSimpleName(), "Starting HTTP Request");
    		HttpClient httpClient = new DefaultHttpClient();
    		resp = httpClient.execute(request[0]);
    		
    		//Log.i(getClass().getSimpleName(), "Starting XML parser");
    		SAXParserFactory saxFactory = SAXParserFactory.newInstance();
    		ArrivalHandler handler = new ArrivalHandler();
    		SAXParser parser = saxFactory.newSAXParser();
			parser.parse(resp.getEntity().getContent(), handler);
			
			return handler.getResultSet();
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

    protected void onPostExecute(ResultSet results) {
    	mCaller.handleResponse(results);
    }
    
    public interface ArrivalsTaskCaller {
    	void handleResponse(ResultSet results);
    	void handleProgress(Integer progress);
    	void handleError(Exception exception);
    }
}
