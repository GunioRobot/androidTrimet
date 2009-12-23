package com.fixedd.AndroidTrimet.tasks;

import org.apache.http.client.methods.HttpUriRequest;

import android.os.AsyncTask;

import com.fixedd.AndroidTrimet.schemas.Arrivals.ResultSet;
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
	 * <p><b>WARNING:</b> This is not yet implemented and will return a RuntimeException if you try to use it!</p>
	 * @param caller Something that implements TripTaskCaller for the task to "call" back to.
	 */
	public TripTask(TripTaskCaller caller) {
		this.mCaller = caller;
	}
	
	/**
	 * Make and parse the API lookup on a background thread.
	 * @param request a pre-built request object that is to be run on the background thread. This should make an API call against something that returns a response as layed out in http://developer.trimet.org/schema/arrivals.xsd
	 * @return an Itinerary.ResponseType object on success or null on failure. 
	 */
	
	public ResponseType doInBackground(HttpUriRequest... request) {
		mCaller.handleError(new Exception("Not yet implemented."));
    	return null;
	}
	
	
    protected void onProgressUpdate(Integer... progress) {
    	mCaller.handleProgress(progress[0]);
    }

    protected void onPostExecute(ResultSet results) {
    	mCaller.handleResponse(results);
    }
    
    public interface TripTaskCaller {
    	void handleResponse(ResultSet results);
    	void handleProgress(Integer progress);
    	void handleError(Exception exception);
    }
}
