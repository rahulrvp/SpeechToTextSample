package com.github.rahulrvp.speech_to_text;

import com.github.rahulrvp.speech_to_text.model.SyncRecognizeResponse;

/**
 * @author Rahul Raveendran V P
 *         Created on 16/12/16 @ 7:52 PM
 *         https://github.com/rahulrvp
 */


public interface ConversionListener {
    void onSuccess(SyncRecognizeResponse response);

    void onFailure(int code, String message);
}
