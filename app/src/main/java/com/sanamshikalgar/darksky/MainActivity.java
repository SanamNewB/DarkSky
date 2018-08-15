/* this is MAIN ACTIVITY that shows working with Asynchronous Get () from the OkHttp Recipes */

package com.sanamshikalgar.darksky;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// STEP 1: declare URL of the API you will use to display weather of a particular location
        String apiKey = "8a713dd71a4848c8f429c84202dde31b"; // unique access to the website's api service when user signs up.
// hardcoded co-ordinates of Los Angeles, CA
        double latitude = 37.8267;
        double longitude = -122.4233;
// https://api.darksky.net/forecast/8a713dd71a4848c8f429c84202dde31b/37.8267,-122.4233
        String forecastURL = "https://api.darksky.net/forecast/"
                + apiKey + "/" + latitude + "," + longitude;

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
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                // The @param response object of type Response records the success of the
                // try-catch is checking response success. thus goes in here for Async method()
                try {
                    Log.v(TAG,response.body().string());
                    if (response.isSuccessful()){

                    }
                    else {
                        alertUserOnError();

                    }
                } catch (IOException e) {
                    Log.e(TAG,"IO Exception is caught", e);
                }
            }
        });
    }

    private void alertUserOnError() {

    }
}
