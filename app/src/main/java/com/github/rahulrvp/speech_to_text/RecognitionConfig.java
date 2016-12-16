package com.github.rahulrvp.speech_to_text;

/**
 * @author Rahul Raveendran V P
 *         Created on 14/12/16 @ 1:28 PM
 *         https://github.com/rahulrvp
 */


public class RecognitionConfig {
    private String encoding;
    private long sampleRate;

    public RecognitionConfig() {
        // setting default values
        encoding = Encoding.AMR_WB.toString();
        sampleRate = 16000;
    }

    public enum Encoding {
        LINEAR16,
        FLAC,
        MULAW,
        AMR,
        AMR_WB
    }

}
