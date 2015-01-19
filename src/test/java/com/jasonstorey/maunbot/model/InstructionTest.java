package com.jasonstorey.maunbot.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class InstructionTest {

    @Test
    public void parsesSpeakCommandAndArgs_fromValidSpeakString() throws Exception {
        Command expectedCommand = Command.SPEAK;
        String expectedSpeakString = "Hello, world!";
        String validSpeakCommand = "@MaunHouse say, \"" + expectedSpeakString + "\"";

        Instruction instruction = new Instruction(validSpeakCommand);
        assertEquals(expectedCommand, instruction.getCommand());
        assertEquals(expectedSpeakString, instruction.getArguments());
    }

    @Test
    public void parsesSpeakCommandAndArgs_fromInvalidSpeakString() throws Exception {
        Command expectedCommand = Command.SPEAK;
        String invalidSpeakCommand = "@MaunHouse say, invalid";

        Instruction instruction = new Instruction(invalidSpeakCommand);
        assertEquals(expectedCommand, instruction.getCommand());
        assertEquals(null, instruction.getArguments());
    }
}