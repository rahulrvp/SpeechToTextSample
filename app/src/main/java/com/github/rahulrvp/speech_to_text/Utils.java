package com.github.rahulrvp.speech_to_text;

import android.util.Base64;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Rahul Raveendran V P
 *         Created on 30/12/16 @ 11:07 AM
 *         https://github.com/rahulrvp
 */


public class Utils {

    public static String getBase64String(File audioFile) {
        String result = null;

        if (audioFile != null && audioFile.exists()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(audioFile);
                byte[] bytes = new byte[(int) audioFile.length()];
                int len = fileInputStream.read(bytes);

                Log.d("RecognitionAudio", "File length read: " + len);

                result = new String(Base64.encode(bytes, Base64.NO_WRAP));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return result;
    }
}
