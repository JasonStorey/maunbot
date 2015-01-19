package com.jasonstorey.maunbot;

import java.util.Observer;
import java.util.Observable;
import com.jasonstorey.maunbot.model.*;

public class Maunbot implements Observer {

	private String defaultMessage;
    private Voice voice;

    public Maunbot(Voice voice) {
        defaultMessage = "Maunbot lives.";
        this.voice = voice;
    }

    @Override
    public void update(Observable o, Object arg) {
        if(arg instanceof Instruction) {
            Instruction newInstruction = (Instruction) arg;
            Command newCommand = newInstruction.getCommand();
            String newArguments = newInstruction.getArguments();

            if(newCommand == null) {
                return;
            }

            switch (newCommand) {
                case SPEAK:
                    if(newArguments != null) {
                        speak(newInstruction.getArguments());
                    }
                    break;
                default:
                    break;
            }

        }
    }

    public void speak() {
        this.voice.speak(defaultMessage);
    }

    public void speak(String message) {
        this.voice.speak(message);
    }
}
