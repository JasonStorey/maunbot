package com.jasonstorey.maunbot.components;

public class TwitterInstructionSource extends InstructionSource {

    public TwitterInstructionSource() {
    	
    }

    public void sendInstruction(String instruction) {
    	setChanged();
    	notifyObservers(instruction);
    }
}
