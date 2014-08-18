package com.jasonstorey.maunbot;

import com.jasonstorey.maunbot.components.*;

public class App {

	public static void startMaunbot() {
		Maunbot maunbot = new Maunbot();
		System.out.println(maunbot.speak());

    	InstructionSource instructionSource = new TwitterInstructionSource();
    	    instructionSource.addObserver(maunbot);
    	    instructionSource.fetchInstructions();
	}

    public static void main(String[] args) {
    	startMaunbot();
    }
}
