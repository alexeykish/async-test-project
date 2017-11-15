package by.kish.subscribtionmanager.service;

import by.kish.subscribtionmanager.client.ManoClient;
import by.kish.subscribtionmanager.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
public class ManoService {

    @Autowired
    public ManoClient manoClient;

    public Future<Response> assign(int delay) {
        return new AsyncResult<>(manoClient.createOrder(delay));
    }
}
