package by.kish.mano.controller;

import by.kish.mano.cache.Cache;
import by.kish.mano.cache.CacheImpl;
import by.kish.mano.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mano")
public class ManoController {

    private CacheImpl cache = CacheImpl.getInstance();

    @GetMapping("/order/{delay}")
    public ResponseEntity<Order> processOrder(@PathVariable Integer delay) {
        System.out.println("Mano in: " + delay);
        Order order = createResponse(delay);
        int cacheSize = cache.size();
        cache.put("Order#0" + cacheSize + delay, order);
        System.out.println("Mano out: " + order);
        return new ResponseEntity<Order>(order, HttpStatus.OK);
    }

    @GetMapping("/order/check/{id}")
    public ResponseEntity<String> checkStatus(@PathVariable String id) {
        System.out.println("Check if status OK for order#" + id);
        Order order = cache.get(id);
        if (order.getStatus().endsWith("PENDING")) {
            return new ResponseEntity<>("Not ready", HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Ready", HttpStatus.OK);
        }
    }

    private Order createResponse(Integer delay) {
        Order order = new Order();
        order.setName("Order#0" + delay);
        order.setStatus("PENDING");
        order.setIncrement(0);
        return order;
    }


}
