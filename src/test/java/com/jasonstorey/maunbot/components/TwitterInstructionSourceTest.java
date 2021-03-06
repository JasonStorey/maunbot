package com.jasonstorey.maunbot.components;

import com.jasonstorey.maunbot.Maunbot;
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
        maunbot = mock(Maunbot.class);
        status = mock(Status.class);
    }

    @Test
    public void onStatus_withValidInstruction_observerIsUpdated() {
        String validInstruction = "@MaunHouse do stuff.";
        when(status.getText()).thenReturn(validInstruction);

        twitterInstructionSource.addObserver(maunbot);
        twitterInstructionSource.onStatus(status);
        verify(maunbot, times(1)).update(any(TwitterInstructionSource.class), any(Instruction.class));
    }

    @Test
    public void onStatus_withInvalidInstruction_observerIsNotUpdated() {
        String invalidInstruction = "Yo, buddy... do stuff.";
        when(status.getText()).thenReturn(invalidInstruction);

        twitterInstructionSource.addObserver(maunbot);
        twitterInstructionSource.onStatus(status);
        verify(maunbot, times(0)).update(any(TwitterInstructionSource.class), any(Instruction.class));
    }
}