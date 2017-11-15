package by.kish.mano.cache;

import by.kish.mano.entity.Order;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//@Component
public class CacheImpl implements Cache<String, Order> {

    private Map<Object, Object> map;

    private static CacheImpl sc = new CacheImpl();

    public static CacheImpl getInstance() {
        return sc;
    }

    private CacheImpl() {
        map = new ConcurrentHashMap<Object, Object>();
    }

    @Override
    public void put(String key, Order value) {
        System.out.println("Put: " + value);
        map.put(key, value);
    }

    @Override
    public Order get(String key) {
        return (Order) map.get(key);
    }

    public int size() {
        return map.size();
    }
}
