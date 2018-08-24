// Creating the data Model objects to hold the data we are getting from the Dark Sky Web service.
// STEP 10: Add a java class to main project
// This is a class file to define all setters and getter methods on each variable defined
package com.sanamshikalgar.darksky.Model;

import com.sanamshikalgar.darksky.R;

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
    private long ozone;
    private double windSpeed;
    private int uvIndex;
    private String timezone;
    private double precipProbability;

    // C1
    public CurrentWeather() {
    }

    // C2
    public CurrentWeather(String locationLabel, long time, String summary, String icon,
                          double temperature, double humidity, long ozone,
                          double windSpeed, int uvIndex, String timezone, double precipProbability) {
        this.locationLabel = locationLabel;
        this.time = time;
        this.summary = summary;
        this.icon = icon;
        this.temperature = temperature;
        this.humidity = humidity;
        this.ozone = ozone;
        this.windSpeed = windSpeed;
        this.uvIndex = uvIndex;
        this.timezone = timezone;
        this.precipProbability = precipProbability;
    }


    // STEP 11: Use Generate option to select getter and setter to get the list of getter and setter methods for each of the variables

    public long getTime() {
        return time;
    }

    public String getFormattedTime() { // STEP 18
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("h:mm a"); // building a simpleDateFormat object . a= am/pm
        simpleDateFormat.setTimeZone(java.util.TimeZone.getTimeZone(timezone)); // getting the time from the location specified . so to set time we consider timezone

        Date date = new Date(time * 1000); // // the date object is takes in time in ms as its parameter; 1s = 1000ms
        return simpleDateFormat.format(date); //format() takes in a date object.
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

    public void getIconID() { // To display Icons which are in String format from JSON data to relevant images for user
        //possible string values in the API are:
        // clear-day, clear-night, rain, snow, sleet, wind, fog,
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

    public long getOzone() {
        return ozone;
    }

    public void setOzone(long ozone) {
        this.ozone = ozone;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public double getPrecipProbability() {
        return precipProbability;
    }

    public void setPrecipProbability(double precipProbability) {
        this.precipProbability = precipProbability;
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
