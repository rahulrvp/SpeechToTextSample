package com.github.rahulrvp.speech_to_text;

import java.io.File;

/**
 * @author Rahul Raveendran V P
 *         Created on 16/12/16 @ 6:12 PM
 *         https://github.com/rahulrvp
 */


public class SpeechApi {
    private File mFile;

    public SpeechApi(File audioFile) {
        mFile = audioFile;
    }

    public SpeechApi(String path) {
        mFile = new File(path);
    }

    public void convert(ConversionListener listener) {
        new SpeechApiTask(mFile).setListener(listener).execute();
    }
}
