package io.github.azagniotov.example.controller;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;

// https://stackoverflow.com/questions/37209109/how-to-use-the-springboots-context-for-testing-by-jerseytest
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GreetingsControllerComponentTest {

    private static Client client;
    @Value("${local.server.port}")
    private int port;

    @BeforeClass
    public static void beforeClass() {
        client = ClientBuilder.newClient();
    }

    @Test
    public void shouldReturnGreetingById_whenCorrectRequest_thenResponseIsOkAndContainsGreeting() {
        WebTarget target = client.target("http://localhost:" + this.port);

        Response response = target.path("/api/v1/greetings/2").request().get();

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        assertEquals(MediaType.APPLICATION_JSON, response.getHeaderString(HttpHeaders.CONTENT_TYPE));

        String content = response.readEntity(String.class);
        assertEquals("{\"id\":2,\"text\":\"Konnichiwa!\"}", content);
    }

    @Test
    public void shouldReturn404_whenIncorrectResourceRequest_thenResponseIsNotFound() {
        WebTarget target = client.target("http://localhost:" + this.port);

        Response response = target.path("/api/v1/greetings/9999999").request().get();

        assertEquals(Response.Status.NOT_FOUND.getStatusCode(), response.getStatus());
        assertEquals(MediaType.APPLICATION_JSON, response.getHeaderString(HttpHeaders.CONTENT_TYPE));

        String content = response.readEntity(String.class);
        assertEquals("Resource not found", content);
    }
}
