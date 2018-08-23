/* this is MAIN ACTIVITY that shows working with Asynchronous Get () from the OkHttp Recipes */
/* MainActivity is the Controller*/

package com.sanamshikalgar.darksky.View;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;


import com.sanamshikalgar.darksky.Model.CurrentWeather;
import com.sanamshikalgar.darksky.Network.TestAsync;
import com.sanamshikalgar.darksky.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
// STEP 12: Using the CurrentWeather object
    private CurrentWeather currentWeather = new CurrentWeather(); // Set this only when network response is successful

    @BindViews({R.id.textView_temperature1,R.id.textViewHumidiValue1,
            R.id.textViewRainID1,R.id.textViewWindSpeedValue1,
            R.id.UVIndexValue1, R.id.OzoneValue1})
    List<TextView> temperature = new ArrayList<>();
    TestAsync testAsync = new TestAsync(this,this);
    @BindView(R.id.toolbarID1)
    Toolbar toolbar;

    //@BindView(R.id.textView_temperature)
    //TextView temperature;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitymainbutter);
      // final ActivitymainBinding activityMainBinding = DataBindingUtil.setContentView(MainActivity.this, R.layout.activitymain);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        //TextView darkSky = findViewById(R.id.creditTextView);
        //darkSky.setMovementMethod(LinkMovementMethod.getInstance());

// STEP 1: declare URL of the API you will use to display weather of a particular location
        String apiKey = "8a713dd71a4848c8f429c84202dde31b"; // unique access to the website's api service when user signs up.
        double latitude = 37.8267; // hardcoded co-ordinates of Los Angeles, CA
        //double latitude = 99999; // used this for testing the Alert Dialog Pop-up
        double longitude = -122.4233;

        String forecastURL = "https://api.darksky.net/forecast/" // https://api.darksky.net/forecast/8a713dd71a4848c8f429c84202dde31b/37.8267,-122.4233
                + apiKey + "/" + latitude + "," + longitude;



//// STEP 10: To Check if Network is available at all, make a boolean method isNetworkAvailable() and implement it using ConnectivityManager and NetworkInfo
//        if (isNetworkAvailable()) {
//
//// STEP 2: Use https://github.com/square/okhttp/wiki/Recipes to use Synchronous Get or Asynchronous Get ().
//// with Asynchronous Get () Download a file on a worker thread, and get called back when the response is readable.
//
//// STEP 3: Creating an OkHttp client object
//            OkHttpClient client = new OkHttpClient();
//
//// STEP 4: Build a request for the client to send to WeatherServiceProvider SERVER to get their weather data.
//// This is part of request-response cycle
//            Request request = new Request.Builder()
//                    .url(forecastURL)
//                    .build();
//
//// STEP 5: Passing in this request inside a call object
//            Call call = client.newCall(request);
//
//// STEP 6: To use Asynchronous method(), we use enqueue
//// @param is a new callback object.
//// An anonymous inner-class of type Callback.
//// It has 2 methods you need to override 'onFailure' and 'onResponse'
//            call.enqueue(new Callback() {
//                @Override
//                public void onFailure(Call call, IOException e) {
//                }
//
//                @Override
//                public void onResponse(Call call, Response response) throws IOException {
//                    // The @param response object of type Response records the success of the
//                    // try-catch is checking response success. thus goes in here for Async method()
//                    try {
//                        String jSON_Data = response.body().string();
//                        Log.v(TAG, jSON_Data);
//                        if (response.isSuccessful()) {
//                            // STEP 13: If response.isSuccessful ==true; set currentWeather to getCurrentDetails(JSON Data)
//                            // JSON Data == response.body().string()
//                            currentWeather = getCurrentDetails(jSON_Data);
//                            //String locationLabel, long time, String summary, String icon,
//                            //                          double temperature, double humidity, long pressure,
//                            //                          double windSpeed, int uvIndex, String timezone
//                            //setViews(currentWeather);
////                            CurrentWeather displayer = new CurrentWeather(
////                                    currentWeather.getLocationLabel(),
////                                    currentWeather.getTime(),
////                                    currentWeather.getSummary(),
////                                    currentWeather.getIcon(),
////                                    currentWeather.getTemperature(),
////                                    currentWeather.getHumidity(),
////                                    currentWeather.getOzone(),
////                                    currentWeather.getWindSpeed(),
////                                    currentWeather.getUvIndex(),
////                                    currentWeather.getTimezone(),
////                                    currentWeather.getPrecipProbability()
////                                    );
////                            activityMainBinding.setWeather(displayer);
//
//                        } else {
//// STEP 7: When an input URL isn't of right format, let user know something is gone wrong.
//                            alertUserOnError(); // Method to show an error dialog
//                        }
//                    } catch (IOException e) {
//                        Log.e(TAG, "IO Exception is caught", e);
//                    } catch (JSONException jsonException) { // STEP 15
//                        Log.e(TAG,"JSON exception caught", jsonException);
//                    }
//                }
//            });
        try {
            currentWeather = testAsync.execute().get();
        }
        catch (InterruptedException e){

        }
        catch (ExecutionException e){

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater menuInflater = getMenuInflater();
//        menuInflater.inflate(R.menu.menu,menu);
        getMenuInflater().inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.menu_id:
                SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
                SearchView searchView = (SearchView) item.getActionView();
                searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
                searchView.setIconifiedByDefault(false);
                searchView.setFocusable(true);
                searchView.requestFocusFromTouch();
        }

        return true;
    }

    public void setDisplay(CurrentWeather currentWeather1){
            temperature.get(0).setText(String.valueOf(Math.round(((currentWeather1.getTemperature())-32)*5/9)));
            temperature.get(1).setText(String.valueOf(currentWeather1.getHumidity()*100));
        }

// STEP 8: When you want to create a method, hover over the method you created, and alt+enter, select create method.
// Android Studio automatically creates that method with appropriate access modifier and return type.
// Of course you can change those later

    private void alertUserOnError () {

// AlertDialogFragment is a separate custom fragment class
// that I have specifically to created using Android's Dialog Manager
// See AlertDialogFragment.java for STEP 9

            AlertDialogFragment alertDialogFragment = new AlertDialogFragment();
            alertDialogFragment.show(getSupportFragmentManager(), "Error Dialog");
        }

//    private boolean isNetworkAvailable () {
//
//// ConnectivityManager.java is an Android class, that we can use to evaluate the Network Availability condition to true/false.
//// getSystemService is a method in the Activity Class that takes parameter in String format from the Activity it is being used in.
//// Hence, Context.CONNECTIVITY_SERVICE
//
//            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
//
//// Next instantiate a NetworkInfo object to returns a {@link Network} object corresponding to the currently active default data network.
//// NetworkInfo describes the status of a network interface.
//// getActiveNetworkInfo is also a method inside the ConnectivityManager.java
//
//            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo(); // Add android.permission.ACCESS_NETWORK_STATE in the Manifest
//
//            boolean isAvailable = false;
//// We check if network is available and change isAvailable to true. This depends on the what system answered when newtork was checked
//// in the if block, we are checking if the network is available and connected to Internet,
//            if(networkInfo != null && networkInfo.isConnected()) { // when both conditions are true
//                isAvailable = true; // change isAvailable to true
//            }
//            else
//                noNetworkFound();
//                //Toast.makeText(this, R.string.network_not_found_toast,Toast.LENGTH_LONG).show();
//        return isAvailable; // Return the status of isAvailable
//        }

// Because Airplane mode has been turned on, there is another Dialog Alert
//    private void noNetworkFound() {
//        NetworkIssueDialogFragment networkNotFoundDialogFragment = new NetworkIssueDialogFragment();
//        networkNotFoundDialogFragment.show(getSupportFragmentManager(), "No Network Found");
//    }

// STEP 14: Declare the getCurrentDetails() and create a new JSON object called weatherDetails.
// STEP 15: All exceptions should be Handled in the same place. just good practice.
// "throws JSONException" removes responsibility of handling exception in declaration of the method and moves it to where it's being called

//    private CurrentWeather getCurrentDetails(String jSON_Data) throws JSONException {
//// STEP 16: creating objects of JSONObject.
//
//
//        JSONObject weatherDetails = new JSONObject(jSON_Data);
//
//        String timezone = weatherDetails.getString("timezone"); // we pass the key rep. from JSON Response. getString bcuz timezone is returned in String
//        Log.i(TAG, "Receiving " + timezone + "from JSON");
//
//// STEP 17: Setting CurrentWeather from JSON; populating our data model object with the real weather data from the weather server.
//        JSONObject currently = weatherDetails.getJSONObject("currently"); // 'currently' corresponds to root object in the JSON Response
//        CurrentWeather currentWeather = new CurrentWeather();
//
//        currentWeather.setHumidity(currently.getDouble("humidity")); // setting values from the data model
//        currentWeather.setTime(currently.getLong("time"));
//        //currentWeather.setLocationLabel(currently.getString("timezone"));
//        currentWeather.setSummary(currently.getString("summary"));
//        currentWeather.setIcon(currently.getString("icon"));
//        currentWeather.setTemperature(currently.getDouble("temperature"));
//        currentWeather.setOzone(currently.getLong("ozone")); //The columnar density of total atmospheric ozone at the given time in Dobson units.
//        currentWeather.setUvIndex(currently.getInt("uvIndex"));
//        currentWeather.setWindSpeed(currently.getDouble("windSpeed"));
//        currentWeather.setPrecipProbability(currently.getDouble("precipProbability"));
//        currentWeather.setTimezone(timezone);
//
//
//        Log.v(TAG,currentWeather.getFormattedTime());
//
//        return currentWeather;
//// STEP 18: get formatted time in CurrentWeather.java
//    }


}

// extra notes:
// If you want to align a TextView to a specific spot in a layout but don't want to constrain it to another View or Widget,
// ConstraintLayout provides a helper object that can be used in this case called as "Guideline"
