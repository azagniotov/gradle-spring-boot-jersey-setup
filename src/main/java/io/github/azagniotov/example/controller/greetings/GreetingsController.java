package io.github.azagniotov.example.controller.greetings;

import io.github.azagniotov.example.model.Greeting;
import io.github.azagniotov.example.service.GreetingsService;
import org.glassfish.jersey.internal.guava.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Path("/v1/greetings")
public class GreetingsController {

    private final GreetingsService greetingsService;

    @Autowired
    GreetingsController(final GreetingsService greetingsService) {
        this.greetingsService = greetingsService;
    }

    @GET
    @ResponseStatus(HttpStatus.OK)
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public List<GreetingHttpResponse> getAll() {
        return greetingsService.getAll()
                .stream()
                .map(greeting -> new GreetingHttpResponse(greeting.getId(), greeting.getText()))
                .collect(Collectors.toList());
    }

    @GET
    @Path("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public GreetingHttpResponse get(@PathParam("id") Long id) {
        final Greeting greeting = greetingsService.get(id);

        return new GreetingHttpResponse(greeting.getId(), greeting.getText());
    }

    @POST
    @ResponseStatus(HttpStatus.CREATED)
    @Consumes(MediaType.APPLICATION_JSON_VALUE)
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public Long create(@RequestBody GreetingHttpRequest request) {
        Preconditions.checkNotNull(request);

        return greetingsService.create(request.getText());
    }
}


