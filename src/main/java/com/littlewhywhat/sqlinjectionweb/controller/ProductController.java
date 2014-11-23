package com.littlewhywhat.sqlinjectionweb.controller;

import com.littlewhywhat.sqlinjectionweb.repository.Product;
import com.littlewhywhat.sqlinjectionweb.repository.ProductRepository;

import java.util.concurrent.atomic.AtomicLong;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProductController {

    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private ProductRepository products;

    @RequestMapping(value = "/", method=RequestMethod.GET)
    public @ResponseBody List<Product> getProductList() {
        return products.findAll();
    }

    @RequestMapping(value="/add", 
                    method=RequestMethod.GET)
    public @ResponseBody boolean addProduct(
        @RequestParam("name") String name) {
        long id = counter.incrementAndGet();
        return products.add(id, name);
    } 
}