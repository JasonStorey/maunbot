package com.jasonstorey.maunbot;

import com.jasonstorey.maunbot.components.*;

public class App {
    public static void main( String[] args ) {

    	InstructionSource instructionSource = new TwitterInstructionSource();

    	Maunbot maunbot = new Maunbot();

    	instructionSource.addObserver(maunbot);

    	instructionSource.sendInstruction("Do the dishes");

        System.out.println(maunbot.speak());
    }
}
