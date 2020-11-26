package io.github.azagniotov.example.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class GreetingTest {

    @Test
    public void shouldCreateNewExpectedGreeting() throws Exception {
        final Greeting greeting = new Greeting(1L, "Hello!");

        assertEquals(1, greeting.getId().longValue());
        assertEquals("Hello!", greeting.getText());
    }

    @Test
    public void shouldVerifyEquality() throws Exception {
        final Greeting greetingOne = new Greeting(1L, "Hello!");
        final Greeting greetingTwo = new Greeting(1L, "Hello!");

        assertSame(greetingOne, greetingOne);
        assertEquals(greetingOne, greetingTwo);
    }
}