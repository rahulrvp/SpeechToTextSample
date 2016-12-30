package com.github.rahulrvp.speech_to_text;

import android.os.AsyncTask;
import android.util.Log;

import com.github.rahulrvp.speech_to_text.model.RecognitionRequest;
import com.github.rahulrvp.speech_to_text.model.SpeechRecognitionError;
import com.github.rahulrvp.speech_to_text.model.SpeechRecognitionResult;
import com.github.rahulrvp.speech_to_text.model.SyncRecognizeResponse;
import com.github.rahulrvp.speechapisample.BuildConfig;
import com.google.gson.Gson;

import in.fortelogic.httpmanager.HTTPManager;
import in.fortelogic.httpmanager.Response;

/**
 * @author Rahul Raveendran V P
 *         Created on 16/12/16 @ 6:58 PM
 *         https://github.com/rahulrvp
 */


public class SpeechApiTask extends AsyncTask<Void, Void, Response> {

    private static final String LOG_TAG = "SpeechApiTask";
    private RecognitionRequest mRequest;
    private ConversionListener mListener;

    public SpeechApiTask(RecognitionRequest request) {
        mRequest = request;
    }

    public SpeechApiTask setListener(ConversionListener listener) {
        mListener = listener;

        return this;
    }

    @Override
    protected Response doInBackground(Void... voids) {
        String apiUrl = "https://speech.googleapis.com/v1beta1/speech:syncrecognize";
        String key = "?key=" + BuildConfig.SPEECH_APIKEY;

        HTTPManager httpManager = new HTTPManager(apiUrl + key);
        return httpManager.post(new Gson().toJson(mRequest));
    }

    @Override
    protected void onPostExecute(Response response) {
        if (mListener != null) {
            SyncRecognizeResponse recognizeResponse = null;

            try {
                String json = response.getResponseBody();
                recognizeResponse = new Gson().fromJson(json, SyncRecognizeResponse.class);
            } catch (Exception e) {
                Log.e(LOG_TAG, e.getMessage());
            }

            if (response.getStatusCode() == 200) {
                SpeechRecognitionResult[] results = null;
                if (recognizeResponse != null) {
                    results = recognizeResponse.getResults();
                }

                mListener.onSuccess(results);
            } else {
                SpeechRecognitionError error = null;
                if (recognizeResponse != null) {
                    error = recognizeResponse.getError();
                }

                mListener.onFailure(error);
            }
        }
    }
}
