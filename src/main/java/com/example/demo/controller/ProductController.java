package com.example.demo.controller;

import com.example.demo.entities.Product;
import com.example.demo.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.security.mscapi.CPublicKey;

import java.util.Arrays;
import java.util.List;

@Controller
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/showAllProducts")
    public String showAllProduct(Model uiModel) {
        List<Product> allProduct = productService.findAll();
        uiModel.addAttribute("productList", allProduct);
        return "allProducts";
    }

    @RequestMapping(value = "/maxValue")
    public String showMaxPrice(Model uiModel) {
        List<Product> productList = productService.getMaxVal();
        System.out.println(Arrays.toString(productList.toArray()));
        return Arrays.toString(productList.toArray());
    }

    @RequestMapping(path = "/showPriceBetweenMin&Max", method = RequestMethod.GET)
    @ResponseBody
    public String showMinMaxPrice(Model uiModel, @RequestParam int min, int max) {
        List<Product> productList = productService.getMaxValBetweenMinAndMax(min, max);
        return Arrays.toString(productList.toArray());
    }
}
