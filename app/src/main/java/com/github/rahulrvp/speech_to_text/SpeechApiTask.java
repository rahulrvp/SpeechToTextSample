package com.github.rahulrvp.speech_to_text;

import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;

import com.github.rahulrvp.speech_to_text.model.RecognitionRequest;
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

    private RecognitionRequest mRequest;
    private ConversionListener mListener;

    public SpeechApiTask(RecognitionRequest request) {
        mRequest = request;
    }

    public SpeechApiTask setListener(ConversionListener listener) {
        mListener = listener;

        return this;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected Response doInBackground(Void... voids) {
        String apiUrl = "https://speech.googleapis.com/v1beta1/speech:syncrecognize";
        String key = "?key=" + BuildConfig.API_KEY;

        HTTPManager httpManager = new HTTPManager(apiUrl + key);
        return httpManager.post(new Gson().toJson(mRequest));
    }

    @Override
    protected void onPostExecute(Response response) {
        if (response.getStatusCode() == 200) {
            if (mListener != null) {
                mListener.onSuccess(new Gson().fromJson(response.getResponseBody(), SyncRecognizeResponse.class));
            }
        } else {
            if (mListener != null) {
                mListener.onFailure(response.getStatusCode(), response.getResponseBody());
            }
        }
    }
}
