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
            Instruction instuction = (Instruction) arg;
            System.out.println(instuction.getCommand());
        }
    }

    public String speak() {
		return currentMessage;
    }
}
