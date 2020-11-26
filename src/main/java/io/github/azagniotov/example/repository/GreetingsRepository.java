package io.github.azagniotov.example.repository;

import io.github.azagniotov.example.model.Greeting;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class GreetingsRepository {

    private final Map<Long, Greeting> greetings = new HashMap<Long, Greeting>() {{
        put(1L, new Greeting(1L, "Hello!"));
        put(2L, new Greeting(2L, "Konnichiwa!"));
        put(3L, new Greeting(3L, "Ni Hao!"));
    }};

    public List<Greeting> getAll() {
        return new ArrayList<>(greetings.values());
    }

    public Greeting get(final Long id) {
        return greetings.get(id);
    }

    public Long create(final String text) {
        final long currentSize = greetings.values().size();
        final long nextCandidateId = currentSize + 1;
        greetings.put(nextCandidateId, new Greeting(nextCandidateId, text));

        return nextCandidateId;
    }
}
