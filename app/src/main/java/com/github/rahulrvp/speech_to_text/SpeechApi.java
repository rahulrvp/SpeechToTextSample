package com.github.rahulrvp.speech_to_text;

import com.github.rahulrvp.speech_to_text.model.RecognitionRequest;

/**
 * @author Rahul Raveendran V P
 *         Created on 16/12/16 @ 6:12 PM
 *         https://github.com/rahulrvp
 */


public class SpeechApi {
    private RecognitionRequest request;

    public SpeechApi(RecognitionRequest request) {
        this.request = request;
    }

    public void convert(ConversionListener listener) {
        new SpeechApiTask(request).setListener(listener).execute();
    }
}
