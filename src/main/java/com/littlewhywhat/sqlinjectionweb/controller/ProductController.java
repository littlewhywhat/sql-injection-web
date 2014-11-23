package sqlinjectionweb.controller;

import sqlinjectionweb.repository.Product;

import java.util.concurrent.atomic.AtomicLong;
import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private final List<Product> list = new ArrayList<Product>();
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/")
    public List<Product> product(@RequestParam(value="name", defaultValue="") String name) {
        if (name.length() != 0) {
            long id = counter.incrementAndGet();
            list.add(new Product(id, name));
        }
        return list;
    }
}