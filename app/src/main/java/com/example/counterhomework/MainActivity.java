package com.example.counterhomework;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = MainActivity.class.getSimpleName();

    private TextView mCountView;
    private int mCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCountView = (TextView) findViewById(R.id.countValue);
        Log.d(LOG_TAG, "found the view item");

        // this next line is causing the app to crash
        // need to convert Int to String
        // mCountView.setText(Integer.toString(mCount));
        // no need to set teh text here, as already initialised by the view xml

        if (savedInstanceState != null) {
            // retrieve the state
            String mCountString = savedInstanceState.getString("save_count");
            // restore teh state
            mCountView.setText(mCountString);

            // restore the count variable
            mCount = Integer.parseInt(mCountString);

        }

    }

    public void increment_count(View view) {
        mCount++;
        // update teh view with the incremented counter
        mCountView.setText(Integer.toString(mCount));
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("save_count", Integer.toString(mCount));
        // log to confirm that state is saved
        Log.d(LOG_TAG, "saved state");

    }
}