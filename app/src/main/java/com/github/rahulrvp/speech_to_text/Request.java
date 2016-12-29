package com.github.rahulrvp.speech_to_text;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.io.File;

/**
 * @author Rahul Raveendran V P
 *         Created on 14/12/16 @ 1:21 PM
 *         https://github.com/rahulrvp
 */

public class Request {
    private RecognitionConfig config;
    private RecognitionAudio audio;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public Request(File file) {
        config = new RecognitionConfig(file);
    }

    public void setAudio(RecognitionAudio audio) {
        this.audio = audio;
    }
}
