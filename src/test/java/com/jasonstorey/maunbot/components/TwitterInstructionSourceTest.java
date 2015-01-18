package com.jasonstorey.maunbot.components;

import com.jasonstorey.maunbot.Maunbot;
import com.jasonstorey.maunbot.Voice;
import com.jasonstorey.maunbot.model.Instruction;
import org.junit.Before;
import org.junit.Test;
import twitter4j.Status;

import static org.mockito.Mockito.*;

public class TwitterInstructionSourceTest {

    TwitterInstructionSource twitterInstructionSource;
    Maunbot maunbot;
    Status status;

    @Before
    public void setUp() throws Exception {
        twitterInstructionSource = new TwitterInstructionSource();
        maunbot = new Maunbot(mock(Voice.class));
        status = mock(Status.class);
    }

    @Test
    public void onStatus_withValidInstruction_observerIsUpdated() {
        Maunbot maunbotSpy = spy(maunbot);
        String validInstruction = "@MaunHouse do stuff.";
        when(status.getText()).thenReturn(validInstruction);

        twitterInstructionSource.addObserver(maunbotSpy);
        twitterInstructionSource.onStatus(status);
        verify(maunbotSpy, times(1)).update(any(TwitterInstructionSource.class), any(Instruction.class));
    }

    @Test
    public void onStatus_withInvalidInstruction_observerIsNotUpdated() {
        Maunbot maunbotSpy = spy(maunbot);
        String invalidInstruction = "Yo, buddy... do stuff.";
        when(status.getText()).thenReturn(invalidInstruction);

        twitterInstructionSource.addObserver(maunbotSpy);
        twitterInstructionSource.onStatus(status);
        verify(maunbotSpy, times(0)).update(any(TwitterInstructionSource.class), any(Instruction.class));
    }
}