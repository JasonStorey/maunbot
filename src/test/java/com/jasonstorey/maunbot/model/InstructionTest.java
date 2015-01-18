package com.jasonstorey.maunbot.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InstructionTest {

    @Test
    public void parsesSpeakString_fromValidSpeakCommand() throws Exception {
        String expectedSpeakString = "Hello, world!";
        String validSpeakCommand = "@MaunHouse say, \"" + expectedSpeakString + "\"";

        Instruction instruction = new Instruction(validSpeakCommand);
        assertEquals(expectedSpeakString, instruction.getCommand());
    }
}