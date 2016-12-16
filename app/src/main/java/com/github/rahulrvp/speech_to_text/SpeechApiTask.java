package com.github.rahulrvp.speech_to_text;

import android.os.AsyncTask;

import com.google.gson.Gson;

import java.io.File;

import in.fortelogic.httpmanager.HTTPManager;
import in.fortelogic.httpmanager.Response;

/**
 * @author Rahul Raveendran V P
 *         Created on 16/12/16 @ 6:58 PM
 *         https://github.com/rahulrvp
 */


public class SpeechApiTask extends AsyncTask<Void, Void, Response> {

    private File mFile;
    private ConversionListener mListener;

    public SpeechApiTask(File audioFile) {
        mFile = audioFile;
    }

    public SpeechApiTask setListener(ConversionListener listener) {
        mListener = listener;

        return this;
    }

    @Override
    protected Response doInBackground(Void... voids) {
        // TODO: 16/12/16 Do authentication with G Cloud before this

        RecognitionAudio audio = new RecognitionAudio();
        audio.setContent(mFile);

        Request request = new Request();
        request.setAudio(audio);

        HTTPManager httpManager = new HTTPManager("https://speech.googleapis.com/v1beta1/speech:syncrecognize");
        return httpManager.post(new Gson().toJson(request));
    }

    @Override
    protected void onPostExecute(Response response) {
        // TODO: 16/12/16 Fix this response reading when Api is working

        if (response.getStatusCode() == 200) {
            if (mListener != null) {
                mListener.onSuccess(response.getResponseBody());
            }
        } else {
            if (mListener != null) {
                mListener.onFailure(response.getStatusCode(), response.getResponseBody());
            }
        }
    }
}
