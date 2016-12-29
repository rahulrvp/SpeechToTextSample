package com.github.rahulrvp.speech_to_text;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;

import java.io.File;
import java.io.IOException;

/**
 * @author Rahul Raveendran V P
 *         Created on 14/12/16 @ 1:28 PM
 *         https://github.com/rahulrvp
 */


public class RecognitionConfig {
    private String encoding;
    private String languageCode;
    private long sampleRate;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public RecognitionConfig(File audioFile) {
        // setting default values
        languageCode = "en-US";

        MediaExtractor mediaExtractor = new MediaExtractor();
        try {
            mediaExtractor.setDataSource(audioFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        MediaFormat mediaFormat = mediaExtractor.getTrackFormat(0);
        encoding = Encoding.AMR_WB.toString();
        sampleRate = mediaFormat.getInteger(MediaFormat.KEY_SAMPLE_RATE);

    }

    private enum Encoding {
        LINEAR16,
        FLAC,
        MULAW,
        AMR,
        AMR_WB
    }
}
