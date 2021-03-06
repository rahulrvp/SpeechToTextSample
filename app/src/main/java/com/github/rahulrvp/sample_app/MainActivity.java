package com.github.rahulrvp.sample_app;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.github.rahulrvp.speech_to_text.ConversionListener;
import com.github.rahulrvp.speech_to_text.Encoding;
import com.github.rahulrvp.speech_to_text.SpeechApi;
import com.github.rahulrvp.speech_to_text.Utils;
import com.github.rahulrvp.speech_to_text.model.RecognitionAudio;
import com.github.rahulrvp.speech_to_text.model.RecognitionConfig;
import com.github.rahulrvp.speech_to_text.model.RecognitionRequest;
import com.github.rahulrvp.speech_to_text.model.SpeechRecognitionAlternative;
import com.github.rahulrvp.speech_to_text.model.SpeechRecognitionError;
import com.github.rahulrvp.speech_to_text.model.SpeechRecognitionResult;
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
        RecognitionConfig config = new RecognitionConfig();
        config.setEncoding(Encoding.AMR_WB);
        config.setLanguageCode("en-US");
        config.setSampleRate(16000);

        String base64 = Utils.getBase64String(new File(getSampleAudioPath()));
        RecognitionAudio audio = new RecognitionAudio();
        audio.setContent(base64);

        RecognitionRequest request = new RecognitionRequest(config, audio);

        new SpeechApi(request)
                .convert(new ConversionListener() {
                    @Override
                    public void onSuccess(SpeechRecognitionResult[] results) {
                        if (results != null && results.length > 0) {
                            SpeechRecognitionResult result = results[0];
                            if (result != null) {
                                SpeechRecognitionAlternative[] alternatives = result.getAlternatives();
                                if (alternatives != null && alternatives.length > 0) {
                                    SpeechRecognitionAlternative alternative = alternatives[0];
                                    if (alternative != null) {
                                        showToast(alternative.getTranscript());
                                    }
                                }
                            }
                        }
                    }

                    @Override
                    public void onFailure(SpeechRecognitionError error) {
                        if (error != null) {
                            showToast(error.getCode() + ", " + error.getStatus());
                        }
                    }
                });
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
