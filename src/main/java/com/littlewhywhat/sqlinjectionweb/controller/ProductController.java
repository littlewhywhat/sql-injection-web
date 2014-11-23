package sqlinjectionweb.controller;

import sqlinjectionweb.repository.Product;

import java.util.concurrent.atomic.AtomicLong;
import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProductController {

    private final List<Product> list = new ArrayList<Product>();
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/", method=RequestMethod.GET)
    public @ResponseBody List<Product> getProductList() {
        return list;
    }

    @RequestMapping(value="/add", 
                    method=RequestMethod.GET)
    public @ResponseBody boolean addProduct(
        @RequestParam("name") String name) {
        long id = counter.incrementAndGet();
        return list.add(new Product(id, name));
    } 
}