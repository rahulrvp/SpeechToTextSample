package com.github.rahulrvp.speech_to_text;

/**
 * @author Rahul Raveendran V P
 *         Created on 16/12/16 @ 7:52 PM
 *         https://github.com/rahulrvp
 */


public interface ConversionListener {
    void onSuccess(String convertedText);

    void onFailure(int code, String message);
}
