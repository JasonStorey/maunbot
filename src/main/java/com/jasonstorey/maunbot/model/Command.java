package com.jasonstorey.maunbot.model;

import java.util.regex.Pattern;

public enum Command {
    SPEAK("say", Pattern.compile("\"([^\"]*)\""));

    private final String text;
    private final Pattern argumentsPattern;

    private Command(final String text, final Pattern argumentsPattern) {
        this.text = text;
        this.argumentsPattern = argumentsPattern;
    }

    public String getText(){
        return this.text;
    }

    public Pattern getArgumentsPattern(){
        return this.argumentsPattern;
    }
}
