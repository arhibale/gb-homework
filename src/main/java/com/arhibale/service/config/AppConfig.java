package com.arhibale.service.config;

import com.arhibale.service.Cart;
import com.arhibale.service.ProductRepository;
import com.arhibale.service.impl.SimpleCart;
import com.arhibale.service.impl.SimpleProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.arhibale")
public class AppConfig {

    @Bean
    public ProductRepository productRepository() {
        return new SimpleProductRepository();
    }

    @Bean
    public Cart cart() {
        return new SimpleCart();
    }
}
