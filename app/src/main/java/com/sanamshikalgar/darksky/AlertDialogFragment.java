// STEP 9: Creating the AlertDialogFragment

package com.sanamshikalgar.darksky;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;

public class AlertDialogFragment extends DialogFragment {

    @NonNull
    @Override // overriding the onCreateDialog()
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        Context context  = getActivity(); // because we're in a different class file

// Builder is an inner class inside AlertDialog.java that creates a builder for an alert dialog that uses the default alert dialog theme.
        AlertDialog.Builder urlAlertDialogBuilder = new AlertDialog.Builder(context);

//setting the title of the dialog when URL error is encountered.
        urlAlertDialogBuilder.setTitle(R.string.url_error_title)
                .setMessage(R.string.url_error_message)
                .setPositiveButton(R.string.url_error_OK_button,null); //the dialog box with 2 buttons which only need to tap on OK
        // listener can be a regular button behavior to take some action about the dialog.
        // Like take you to 'settings' page, etc. Other values that can be set on the builder are
        // .setNegativeButton("OK",null) or .setNeutralButton("OK",null);

        return urlAlertDialogBuilder.create();
    }
}

// if URL is incorrect, return URLalertDialogBuilder.create() pop-up;
// if NETWORK issue, return networkAlertDialogBuilder.create() pop-up;