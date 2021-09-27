package com.arhibale.homework.service;

import com.arhibale.homework.component.Cart;
import com.arhibale.homework.dto.CartDto;
import com.arhibale.homework.dto.CartItemDto;
import com.arhibale.homework.dto.ProductDto;
import com.arhibale.homework.exceptions.ProductNotFountException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CartService {

    private final Cart cart;
    private final ProductService productService;

    public CartDto findAll() {
        CartDto result = new CartDto();
        List<CartItemDto> items = cart.findAll().entrySet().stream()
                .map(entry -> {
                    ProductDto productDto = productService.findById(entry.getKey())
                            .orElseThrow(() -> new ProductNotFountException("product not found: id = " + entry.getKey()));
                    CartItemDto cartItemDto = new CartItemDto();
                    cartItemDto.setProductTitle(productDto.getTitle());
                    cartItemDto.setPricePerProduct(productDto.getPrice());
                    cartItemDto.setQuantity(entry.getValue());
                    cartItemDto.setPrice(entry.getValue() * productDto.getPrice());
                    return cartItemDto;
                }).collect(Collectors.toList());
        result.setItems(items);
        result.setTotalPrice(items.stream()
                .map(CartItemDto::getPrice)
                .reduce(Integer::sum)
                .orElse(0));
        return result;
    }

    public void add(Long id) {
        cart.addProduct(id);
    }

    public void deleteAll() {
        cart.deleteAll();
    }
}
