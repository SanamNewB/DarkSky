package com.sanamshikalgar.darksky.View;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;

import com.sanamshikalgar.darksky.R;

public class NetworkIssueDialogFragment extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Context context  = getActivity();
        AlertDialog.Builder networkAlertDialogBuilder = new AlertDialog.Builder(context);

        networkAlertDialogBuilder.setTitle(R.string.network_error_title)
                .setMessage(R.string.network_error_message)
                .setPositiveButton(R.string.network_error_OK_button,null);

        return networkAlertDialogBuilder.create();
    }
}
