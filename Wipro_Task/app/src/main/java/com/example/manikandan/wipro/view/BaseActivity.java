package com.example.manikandan.wipro.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Toast;

import timber.log.Timber;

public class BaseActivity extends AppCompatActivity {

    ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setCancelable(false);

        } catch (Exception e) {
            Timber.e(e, e.getMessage());
        }
    }


    public void showProcess(@Nullable String msg) {
        try {
            if (TextUtils.isEmpty(msg)) {
                msg = "Loading...";
            }
            mProgressDialog.setMessage(msg);
            mProgressDialog.show();

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void hideProcess() {
        try {
            if (mProgressDialog != null) {
                if (mProgressDialog.isShowing()) {
                    mProgressDialog.dismiss();
                }
            }

        } catch (Exception e) {
            Timber.e(e, e.getMessage());
        }
    }

}
