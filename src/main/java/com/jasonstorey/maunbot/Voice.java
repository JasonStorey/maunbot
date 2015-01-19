package com.jasonstorey.maunbot;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class Voice {

    private String url;
    private String charset;
    private String params;

    public Voice() {
        url = "http://translate.google.com/translate_tts?tl=en&q=";
        charset = java.nio.charset.StandardCharsets.UTF_8.name();
    }

    public void speak(String msg) {
        try {
            params = URLEncoder.encode(msg, charset);
            requestAudio(url + params);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(msg);
    }

    private void requestAudio(String url) throws IOException, JavaLayerException {
        URLConnection connection = new URL(url).openConnection();
        connection.setRequestProperty("User-Agent", "Agent");
        connection.setRequestProperty("Accept-Charset", charset);
        InputStream response = connection.getInputStream();
        Player player = new Player(response);
        player.play();
    }
}
