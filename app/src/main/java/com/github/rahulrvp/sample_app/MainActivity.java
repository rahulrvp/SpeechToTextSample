package com.github.rahulrvp.sample_app;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.github.rahulrvp.speech_to_text.ConversionListener;
import com.github.rahulrvp.speech_to_text.SpeechApi;
import com.github.rahulrvp.speechapisample.R;

import java.io.File;


public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = "G-Cloud-Speech";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private String getSampleAudioPath() {
        String filePath = null;

        File audioFile = new File(Environment.getExternalStorageDirectory(), "sample.3gp");
        if (audioFile.exists()) {
            filePath = audioFile.getPath();
        }

        return filePath;
    }

    public void onUploadClick(View view) {
        new SpeechApi(getSampleAudioPath())
                .convert(new ConversionListener() {
                    @Override
                    public void onSuccess(String convertedText) {
                        Log.d(LOG_TAG, "Converted text: " + convertedText);
                    }

                    @Override
                    public void onFailure(int code, String message) {
                        Log.d(LOG_TAG, "Error code: " + code);
                        Log.d(LOG_TAG, "Error message: " + message);
                    }
                });

    }
}
