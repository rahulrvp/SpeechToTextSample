package com.github.rahulrvp.speech_to_text.model;

/**
 * @author Rahul Raveendran V P
 *         Created on 14/12/16 @ 1:21 PM
 *         https://github.com/rahulrvp
 */

public class RecognitionRequest {
    private RecognitionConfig config;
    private RecognitionAudio audio;

    public RecognitionRequest(RecognitionConfig config, RecognitionAudio audio) {
        this.config = config;
        this.audio = audio;
    }
}
