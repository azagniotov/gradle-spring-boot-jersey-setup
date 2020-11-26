package io.github.azagniotov.example.service;

import io.github.azagniotov.example.controller.ResourceNotFoundException;
import io.github.azagniotov.example.model.Greeting;
import io.github.azagniotov.example.repository.GreetingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class GreetingsService {

    private final GreetingsRepository greetingsRepository;

    @Autowired
    public GreetingsService(final GreetingsRepository greetingsRepository) {
        this.greetingsRepository = greetingsRepository;
    }

    public List<Greeting> getAll() {
        return greetingsRepository.getAll();
    }

    public Greeting get(final Long id) {
        return Optional.ofNullable(greetingsRepository.get(id)).orElseThrow(ResourceNotFoundException::new);
    }

    public Long create(final String text) {
        return greetingsRepository.create(text);
    }
}
