package by.kish.subscribtionmanager.client;

import by.kish.subscribtionmanager.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ManoClient {

    @Autowired
    RestTemplate restTemplate;

    @Async
    public Response createOrder(int delay) {
        System.out.println("Client in: " + delay);
        Response response = restTemplate.getForObject("http://localhost:8081/mano/order/" + delay, Response.class);
        System.out.println("Client out: " + response);
        return response;
    }
}
