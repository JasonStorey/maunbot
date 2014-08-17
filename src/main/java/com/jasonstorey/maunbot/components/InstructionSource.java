package com.jasonstorey.maunbot.components;

import java.util.Observable;

public abstract class InstructionSource extends Observable {

	public abstract void sendInstruction(String instruction);
}
