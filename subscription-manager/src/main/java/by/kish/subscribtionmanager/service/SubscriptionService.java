package by.kish.subscribtionmanager.service;

import by.kish.subscribtionmanager.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Service
public class SubscriptionService {

    @Autowired
    public ManoService manoService;

    public Response createOrder(int delay) throws ExecutionException, InterruptedException {
        Future<Response> future = manoService.assign(delay);
        while (!future.isDone()) {
            System.out.println("Request#" + delay + " is not ready");
            Thread.sleep(1000);
        }
        System.out.println("Request#" + delay + " READY");
        return future.get();
    }



}
