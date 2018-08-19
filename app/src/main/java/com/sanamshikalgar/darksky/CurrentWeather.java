// Creating the Model objects to hold the data we are getting from the Dark Sky Web service.
// STEP 10: Add a java class to main project
// This is a class file to define all setters and getter methods on each variable defined
package com.sanamshikalgar.darksky;

import android.icu.util.TimeZone;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentWeather {
    // See the JSON response and add all the keys in respective data types you'd like to display
    // Eg. In "time": 1534644250 ; time will be a variable of 'long' data type
    // Eg. In "dewPoint": 48.72 ; dewPoint will be a variable of 'double' data type

    private String locationLabel;
    private long time;
    private String summary;
    private String icon;
    private double temperature;
    private double humidity;
    private long pressure;
    private double windSpeed;
    private int uvIndex;
    private String timezone;

// STEP 11: Use Generate option to select getter and setter to get the list of getter and setter methods for each of the variables
    public String getLocationLabel() {
        return locationLabel;
    }

    public void setLocationLabel(String locationLabel) {
        this.locationLabel = locationLabel;
    }

    public long getTime() {
        return time;
    }

    public String getFormattedTime() { // STEP 18
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("h:mm a");
        simpleDateFormat.setTimeZone(java.util.TimeZone.getTimeZone(timezone));

        Date date = new Date(time * 1000);
        return simpleDateFormat.format(date);
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void getIconID() {
        //clear-day, clear-night, rain, snow, sleet, wind, fog,
        // cloudy, partly-cloudy-day, or partly-cloudy-night

        int iconID = R.drawable.clear_day;
        switch (icon) {
            case "clear-day":
                iconID = R.drawable.clear_day;
                break;
            case "clear-night" :
                iconID = R.drawable.clear_night;
                break;
            case "rain":
                iconID = R.drawable.rain;
                break;
            case "snow":
                iconID = R.drawable.snow;
                break;
            case "sleet":
                iconID = R.drawable.sleet;
                break;
            case "wind":
                iconID = R.drawable.wind;
                break;
            case "fog":
                iconID = R.drawable.fog;
                break;
            case "cloudy":
                iconID = R.drawable.cloudy;
                break;
            case "partly-cloudy-day":
                iconID = R.drawable.partly_cloudy;
                break;
            case "partly-cloudy-night":
                iconID = R.drawable.cloudy_night;
                break;
        }
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public long getPressure() {
        return pressure;
    }

    public void setPressure(long pressure) {
        this.pressure = pressure;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public int getUvIndex() {
        return uvIndex;
    }

    public void setUvIndex(int uvIndex) {
        this.uvIndex = uvIndex;
    }

    // STEP 12: use the CurrentWeather object in the main Activity


    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

}