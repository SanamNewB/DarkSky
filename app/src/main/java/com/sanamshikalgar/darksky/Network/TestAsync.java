package com.sanamshikalgar.darksky.Network;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;

import com.sanamshikalgar.darksky.Model.CurrentWeather;
import com.sanamshikalgar.darksky.View.MainActivity;
import com.sanamshikalgar.darksky.Util.CheckNetwork;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class TestAsync extends AsyncTask<Void,Void,CurrentWeather> {

    private Context context;
    private Activity activity;
    String apiKey = "8a713dd71a4848c8f429c84202dde31b"; // unique access to the website's api service when user signs up.
    double latitude = 37.8267; // hardcoded co-ordinates of Los Angeles, CA
    double longitude = -122.4233;
    String forecastURL = "https://api.darksky.net/forecast/" // https://api.darksky.net/forecast/8a713dd71a4848c8f429c84202dde31b/37.8267,-122.4233
            + apiKey + "/" + latitude + "," + longitude;

    CurrentWeather currentWeather = new CurrentWeather();

    public TestAsync(Context context, Activity activity) {
        this.context = context;
        this.activity = activity;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(CurrentWeather currentWeather) {
        super.onPostExecute(currentWeather);
        ((MainActivity) activity).setDisplay(this.currentWeather);
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected CurrentWeather doInBackground(Void... voids) {

        // STEP 10: To Check if Network is available at all, make a boolean method isNetworkAvailable() and implement it using ConnectivityManager and NetworkInfo
        if (new CheckNetwork(context).isNetworkAvailable()) {

// STEP 2: Use https://github.com/square/okhttp/wiki/Recipes to use Synchronous Get or Asynchronous Get ().
// with Asynchronous Get () Download a file on a worker thread, and get called back when the response is readable.

// STEP 3: Creating an OkHttp client object
            OkHttpClient client = new OkHttpClient();

// STEP 4: Build a request for the client to send to WeatherServiceProvider SERVER to get their weather data.
// This is part of request-response cycle
            Request request = new Request.Builder()
                    .url(forecastURL)
                    .build();

// STEP 5: Passing in this request inside a call object
            Call call = client.newCall(request);

// STEP 6: To use Asynchronous method(), we use enqueue
// @param is a new callback object.
// An anonymous inner-class of type Callback.
// It has 2 methods you need to override 'onFailure' and 'onResponse'
            try {
                String JSON_Data = call.execute().body().string();
                if (JSON_Data != null){
                    currentWeather = new SetAPIData().getCurrentDetails(JSON_Data);
                }
            } catch (IOException e) {
            }
            catch (JSONException j){
            }


            /*call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    try {
                        String jSON_Data = response.body().string();
                        //Log.v(TAG, jSON_Data);
                        if (response.isSuccessful()) {
                           currentWeather  = new SetAPIData().getCurrentDetails(jSON_Data);

                        } else {
// STEP 7: When an input URL isn't of right format, let user know something is gone wrong.
                           // alertUserOnError(); // Method to show an error dialog
                        }
                    } catch (IOException e) {
                        //Log.e(TAG, "IO Exception is caught", e);
                    } catch (JSONException jsonException) { // STEP 15
                       // Log.e(TAG,"JSON exception caught", jsonException);
                    }
                }
            });
    }*/
            //return currentWeather;
        }
        return null;
    }
}
