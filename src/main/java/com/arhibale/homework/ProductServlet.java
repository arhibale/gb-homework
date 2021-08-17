package com.arhibale.homework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductServlet", urlPatterns = {"/product"})
public class ProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write("<h2>Product:</h2>");

        for (int i = 0; i < 10; i++) {
            Product product = new Product(randomNumber(1000), randomString(), randomNumber(100));
            resp.getWriter().write(
                    String.format("<ul>" +
                                    "<li>Id: %s</li>" +
                                    "<li>Title: %s</li>" +
                                    "<li>Cost: %s</li>" +
                                    "</ul>",
                            product.getId(), product.getTitle(), product.getCost())
            );
        }
    }

    private String randomString() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};
        return words[randomNumber(words.length)];
    }

    private int randomNumber(int i) {
        return (int) (Math.random() * i);
    }
}
