package com.github.rahulrvp.speech_to_text.model;

/**
 * @author Rahul Raveendran V P
 *         Created on 14/12/16 @ 1:28 PM
 *         https://github.com/rahulrvp
 */


public class RecognitionConfig {
    private String encoding;
    private String languageCode;
    private long sampleRate;

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public long getSampleRate() {
        return sampleRate;
    }

    public void setSampleRate(long sampleRate) {
        this.sampleRate = sampleRate;
    }
}
