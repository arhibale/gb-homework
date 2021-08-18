package com.arhibale.client;

import com.arhibale.service.Cart;
import com.arhibale.service.ProductRepository;
import com.arhibale.service.impl.SimpleCart;
import com.arhibale.service.config.AppConfig;
import com.arhibale.service.impl.SimpleProductRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ProductRepository productRepository = context.getBean(ProductRepository.class);
        Cart cart = context.getBean("simpleCart", Cart.class);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hi! Here is the assortment for today:\n" + productRepository.getProductList());
        System.out.println("Commands: ADD, REMOVE, NEW_CART, LOOK_CART, LOOK_PRODUCT, EXIT");
        while (true) {
            System.out.println("Cart: " + cart.getCart());
            String str = scanner.nextLine();

            switch (str) {
                case "EXIT":
                    return;
                case "ADD": {
                    System.out.println("Enter the product ID");
                    int id = scanner.nextInt();
                    cart.add(productRepository.getProduct(id));
                    break;
                }
                case "REMOVE": {
                    System.out.println("Enter the product ID");
                    int id = scanner.nextInt();
                    cart.remove(id);
                    break;
                }
                case "NEW_CART":
                    cart = context.getBean("simpleCart", Cart.class);
                    break;
                case "LOOK_CART":
                    System.out.println(cart.getCart());
                    break;
                case "LOOK_PRODUCT":
                    System.out.println(productRepository.getProductList());
            }
        }
    }
}