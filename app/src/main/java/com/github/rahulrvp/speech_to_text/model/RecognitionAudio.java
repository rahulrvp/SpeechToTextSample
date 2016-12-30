package com.github.rahulrvp.speech_to_text.model;

/**
 * @author Rahul Raveendran V P
 *         Created on 14/12/16 @ 1:23 PM
 *         https://github.com/rahulrvp
 */


public class RecognitionAudio {
    private String content;
    private String uri;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
