package io.github.azagniotov.example.model;

import java.util.Objects;

public class Greeting {

    private final Long id;
    private final String text;

    public Greeting(final Long id, final String text) {
        this.id = id;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Greeting greeting = (Greeting) o;
        return Objects.equals(getId(), greeting.getId()) &&
                Objects.equals(getText(), greeting.getText());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getText());
    }
}
