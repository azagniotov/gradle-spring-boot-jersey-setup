package io.github.azagniotov.example.controller.greetings;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

class GreetingHttpRequest {

    @JsonProperty
    private final String text;

    @JsonCreator
    GreetingHttpRequest(final String text) {
        this.text = text;
    }

    String getText() {
        return text;
    }
}
