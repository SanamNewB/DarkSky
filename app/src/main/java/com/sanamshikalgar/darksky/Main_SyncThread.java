/* This Activity shows working with a Synchronous Get () request to make a network call with OkHttp
* This throws a NETWORK ON MAIN THREAD EXCEPTION each and every time
* indicating that networking is to be done on a separate thread. */

package com.sanamshikalgar.darksky;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Main_SyncThread extends AppCompatActivity {
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

// STEP 2: Use https://github.com/square/okhttp/wiki/Recipes to use Synchronous Get.
// With Synchronous Get, download a file, print its headers, and print its response body as a string.

// STEP 3: Creating an OkHttp client object
        OkHttpClient okHttpClient = new OkHttpClient();

// STEP 4: Build a request for the client to send to WeatherServiceProvider SERVER to get their weather data f.
// This is part of request-response cycle
        Request request = new Request.Builder()
                .url(forecastURL) // you want URL
                .build(); // asking to be build

// STEP 5: Passing in this request inside a call object
        Call call = okHttpClient.newCall(request);

// The 'Call' class has an execute() method that you can use on it's object 'call' to get the response.
        try {
            Response response = call.execute(); // needs a try-catch block compulsorily
            if (response.isSuccessful()) {
                Log.v(TAG,response.body().string());
            }
        } catch (IOException e) {
            Log.e(TAG,"IO Exception is caught", e);
        }
    }
}
