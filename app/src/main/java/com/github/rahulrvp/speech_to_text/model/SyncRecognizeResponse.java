package com.github.rahulrvp.speech_to_text.model;

/**
 * @author Rahul Raveendran V P
 *         Created on 30/12/16 @ 11:28 AM
 *         https://github.com/rahulrvp
 */


public class SyncRecognizeResponse {
    private SpeechRecognitionResult[] results;
    private SpeechRecognitionError error;

    public SpeechRecognitionResult[] getResults() {
        return results;
    }

    public SpeechRecognitionError getError() {
        return error;
    }
}
