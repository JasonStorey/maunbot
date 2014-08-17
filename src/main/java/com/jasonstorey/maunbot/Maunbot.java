package com.jasonstorey.maunbot;

public class Maunbot {

	private String currentMessage;

    public Maunbot() {
        currentMessage = "Hello, world.";
    }

    public String speak() {
		return currentMessage;
    }
}
