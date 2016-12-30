package com.github.rahulrvp.speech_to_text.model;

/**
 * @author Rahul Raveendran V P
 *         Created on 30/12/16 @ 12:06 PM
 *         https://github.com/rahulrvp
 */


public class SpeechRecognitionError {
    private int code;
    private String message;
    private String status;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }
}
