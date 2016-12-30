package com.github.rahulrvp.speech_to_text;


import com.github.rahulrvp.speech_to_text.model.SpeechRecognitionError;
import com.github.rahulrvp.speech_to_text.model.SpeechRecognitionResult;

/**
 * @author Rahul Raveendran V P
 *         Created on 16/12/16 @ 7:52 PM
 *         https://github.com/rahulrvp
 */


public interface ConversionListener {
    void onSuccess(SpeechRecognitionResult[] results);

    void onFailure(SpeechRecognitionError error);
}
