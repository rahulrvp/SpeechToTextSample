package com.github.rahulrvp.speech_to_text;

/**
 * @author Rahul Raveendran V P
 *         Created on 14/12/16 @ 1:21 PM
 *         https://github.com/rahulrvp
 */

public class Request {
    private RecognitionConfig config;
    private RecognitionAudio audio;

    public Request() {
        config = new RecognitionConfig();
    }

    public void setAudio(RecognitionAudio audio) {
        this.audio = audio;
    }
}
