package com.example.demo.repo;

import com.example.demo.entities.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class ProductDao {
    public SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Product.class)
            .buildSessionFactory();

    public List<Product> findMaxPrice() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        List<Product> productList = session.createQuery("select max(price) from Product ", Product.class).getResultList();
        System.out.println(Arrays.toString(productList.toArray()));
        return productList;
    }
}
