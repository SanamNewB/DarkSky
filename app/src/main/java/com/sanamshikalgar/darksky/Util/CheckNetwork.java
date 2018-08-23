package com.sanamshikalgar.darksky.Util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.sanamshikalgar.darksky.View.NetworkIssueDialogFragment;

public class CheckNetwork {
    private Context context;

    public CheckNetwork(Context context) {
        this.context = context;
    }

    public boolean isNetworkAvailable () {

// ConnectivityManager.java is an Android class, that we can use to evaluate the Network Availability condition to true/false.
// getSystemService is a method in the Activity Class that takes parameter in String format from the Activity it is being used in.
// Hence, Context.CONNECTIVITY_SERVICE

        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

// Next instantiate a NetworkInfo object to returns a {@link Network} object corresponding to the currently active default data network.
// NetworkInfo describes the status of a network interface.
// getActiveNetworkInfo is also a method inside the ConnectivityManager.java

        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo(); // Add android.permission.ACCESS_NETWORK_STATE in the Manifest

        boolean isAvailable = false;
// We check if network is available and change isAvailable to true. This depends on the what system answered when newtork was checked
// in the if block, we are checking if the network is available and connected to Internet,
        if(networkInfo != null && networkInfo.isConnected()) { // when both conditions are true
            isAvailable = true; // change isAvailable to true
        }
        else
            noNetworkFound();
        //Toast.makeText(this, R.string.network_not_found_toast,Toast.LENGTH_LONG).show();
        return isAvailable; // Return the status of isAvailable
    }

    private void noNetworkFound() {
        NetworkIssueDialogFragment networkNotFoundDialogFragment = new NetworkIssueDialogFragment();
        //networkNotFoundDialogFragment.show(getSupportFragmentManager(), "No Network Found");
    }

}
