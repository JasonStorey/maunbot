package com.jasonstorey.maunbot;

import java.util.Observer;
import java.util.Observable;

public class Maunbot implements Observer {

	private String currentMessage;

    public Maunbot() {
        currentMessage = "Maunbot lives.";
    }

    public void update(Observable o, Object arg) {
    	System.out.println(arg);
    }

    public String speak() {
		return currentMessage;
    }
}
