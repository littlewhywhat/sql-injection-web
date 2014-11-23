package sqlinjectionweb.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private List<String> list = new ArrayList<String>();

    @RequestMapping("/")
    public List<String> product(@RequestParam(value="product", defaultValue="") String product) {
        if (product.length() != 0)
            list.add(product);
        return list;
    }
}