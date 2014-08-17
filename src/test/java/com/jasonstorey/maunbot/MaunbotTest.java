package com.jasonstorey.maunbot;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaunbotTest {

    @Test
    public void speakReturnsCurrentMessage() {
        Maunbot maunbot = new Maunbot();
        assertThat(maunbot.speak(), is("Hello, world."));
    }
}