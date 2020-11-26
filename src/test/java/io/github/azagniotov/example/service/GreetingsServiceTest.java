package io.github.azagniotov.example.service;

import io.github.azagniotov.example.controller.ResourceNotFoundException;
import io.github.azagniotov.example.repository.GreetingsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GreetingsServiceTest {

    @Mock
    private GreetingsRepository greetingsRepository;

    @InjectMocks
    private GreetingsService greetingsService;

    @Test
    public void shouldThrowWhenCouldNotFindResource() throws Exception {

        when(greetingsRepository.get(anyLong())).thenReturn(null);

        assertThrows(ResourceNotFoundException.class, () -> {
            greetingsService.get(123L);
        });
    }
}