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
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        Context context  = getActivity(); // because we're in a different class file
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

        //setting the title of the dialog
        alertDialogBuilder.setTitle("oops sorry")
                .setMessage("There was an error")
                .setPositiveButton("OK",null); //the dialog box with 2 buttons which only need to tap on OK

        //or  .setNegativeButton("OK",null);
        // or .setNeutralButton("OK",null);

        return alertDialogBuilder.create();
    }
}
