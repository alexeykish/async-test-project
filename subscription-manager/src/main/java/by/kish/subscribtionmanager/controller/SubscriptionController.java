package by.kish.subscribtionmanager.controller;

import by.kish.subscribtionmanager.entity.Response;
import by.kish.subscribtionmanager.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
@RequestMapping("/subscription")
public class SubscriptionController {

    @Autowired
    public SubscriptionService subscriptionService;

    @GetMapping("/")
    public Response assignLicense() throws ExecutionException, InterruptedException {
        int random = new Random().nextInt(20);
        System.out.println("Controller in: " + random);
        Response response = subscriptionService.createOrder(random);
        System.out.println("Controller out: " + response);
        return response;
    }
}
