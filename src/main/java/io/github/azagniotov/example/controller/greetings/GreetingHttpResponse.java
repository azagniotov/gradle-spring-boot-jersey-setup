package io.github.azagniotov.example.controller.greetings;

import com.fasterxml.jackson.annotation.JsonProperty;

class GreetingHttpResponse {

    @JsonProperty
    private final Long id;

    @JsonProperty
    private final String text;

    GreetingHttpResponse(final Long id, final String text) {
        this.id = id;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    String getText() {
        return text;
    }
}
