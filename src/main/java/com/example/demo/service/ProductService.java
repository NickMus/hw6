package com.example.demo.service;

import com.example.demo.entities.Product;
import com.example.demo.repo.ProductDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.example.demo.repo.ProductRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private ProductDao productDao;

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        List<Product> productList = productRepository.findAll();
        System.out.println(Arrays.toString(productList.toArray()));
        return productList;
    }
//    public List<Product> findAll() {
//        Page<Product> productList = productRepository.findAll(PageRequest.of(1,5));
//        System.out.println(productList);
//        return productList.stream().collect(Collectors.toList());
//    }

    public List<Product> getMaxVal() {
        return productDao.findMaxPrice();
    }

    public List<Product> getMaxValBetweenMinAndMax(int min, int max) {
        return productRepository.findAllByPriceBetween(min,max);
    }
}
