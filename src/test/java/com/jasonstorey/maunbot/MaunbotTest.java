package com.jasonstorey.maunbot;

import com.jasonstorey.maunbot.model.Instruction;
import org.junit.Before;
import org.junit.Test;

import java.util.Observable;

import static org.mockito.Mockito.*;

public class MaunbotTest {

    Voice voice;
    Instruction instruction;

    private Maunbot maunbot;

    @Before
    public void setUp(){
        voice = mock(Voice.class);
        instruction = mock(Instruction.class);
        maunbot = new Maunbot(voice);
    }

    @Test
    public void speaksDefaultMessage_WhenSpeakCalledWithNoArgs() {
        String defaultMessage = "Maunbot lives.";
        maunbot.speak();
        verify(voice, times(1)).speak(defaultMessage);
    }

    @Test
    public void speaksMessage_WhenSpeakCalledWithArgs() {
        String message = "A new message!";
        maunbot.speak(message);
        verify(voice, times(1)).speak(message);
    }

    @Test
    public void speaksMessage_WhenUpdateIsCalled_WithSpeakCommand() {
        String speakArguments = "SPEAK: Hello, world.";

        when(instruction.getArguments()).thenReturn(speakArguments);

        maunbot.update(new Observable(), instruction);

        verify(voice, times(1)).speak(speakArguments);
    }
}