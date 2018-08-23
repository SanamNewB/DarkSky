package com.sanamshikalgar.darksky.Network;

import android.util.Log;

import com.sanamshikalgar.darksky.Model.CurrentWeather;
import com.sanamshikalgar.darksky.Model.CurrentWeather;

import org.json.JSONException;
import org.json.JSONObject;

public class SetAPIData {

    public CurrentWeather getCurrentDetails(String jSON_Data) throws JSONException {
// STEP 16: creating objects of JSONObject.


        JSONObject weatherDetails = new JSONObject(jSON_Data);

        String timezone = weatherDetails.getString("timezone"); // we pass the key rep. from JSON Response. getString bcuz timezone is returned in String
        //Log.i(TAG, "Receiving " + timezone + "from JSON");

// STEP 17: Setting CurrentWeather from JSON; populating our data model object with the real weather data from the weather server.
        JSONObject currently = weatherDetails.getJSONObject("currently"); // 'currently' corresponds to root object in the JSON Response
        CurrentWeather currentWeather = new CurrentWeather();

        currentWeather.setHumidity(currently.getDouble("humidity")); // setting values from the data model
        currentWeather.setTime(currently.getLong("time"));
        //currentWeather.setLocationLabel(currently.getString("timezone"));
        currentWeather.setSummary(currently.getString("summary"));
        currentWeather.setIcon(currently.getString("icon"));
        currentWeather.setTemperature(currently.getDouble("temperature"));
        currentWeather.setOzone(currently.getLong("ozone")); //The columnar density of total atmospheric ozone at the given time in Dobson units.
        currentWeather.setUvIndex(currently.getInt("uvIndex"));
        currentWeather.setWindSpeed(currently.getDouble("windSpeed"));
        currentWeather.setPrecipProbability(currently.getDouble("precipProbability"));
        currentWeather.setTimezone(timezone);


        //Log.v(TAG,currentWeather.getFormattedTime());

        return currentWeather;
// STEP 18: get formatted time in CurrentWeather.java
    }
}
