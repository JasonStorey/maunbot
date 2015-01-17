package com.jasonstorey.maunbot;

import java.util.Observer;
import java.util.Observable;
import com.jasonstorey.maunbot.model.*;

public class Maunbot implements Observer {

	private String currentMessage;

    public Maunbot() {
        currentMessage = "Maunbot lives.";
    }

    @Override
    public void update(Observable o, Object arg) {
        if(arg instanceof Instruction) {
            Instruction instruction = (Instruction) arg;
            System.out.println(instruction.getCommand());
        }
    }

    public String speak() {
		return currentMessage;
    }
}
