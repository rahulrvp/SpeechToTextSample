package com.github.rahulrvp.speech_to_text.model;

/**
 * @author Rahul Raveendran V P
 *         Created on 30/12/16 @ 11:34 AM
 *         https://github.com/rahulrvp
 */


public class SpeechRecognitionAlternative {
    private String transcript;
    private float confidence;

    public String getTranscript() {
        return transcript;
    }

    public float getConfidence() {
        return confidence;
    }
}
