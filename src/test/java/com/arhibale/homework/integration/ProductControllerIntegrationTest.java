package com.arhibale.homework.integration;

import com.arhibale.homework.entity.ProductEntity;
import com.arhibale.homework.exception.ProductNotFoundException;
import com.arhibale.homework.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;
import java.util.Objects;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerIntegrationTest {

    private static final String BASE_URL = "/api/v1/product";
    private static final String PRODUCT_TITLE = "test";

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;

    @AfterEach
    public void deleteTestPerson() {
        productRepository.deleteByTitle(PRODUCT_TITLE);
    }

    @Test
    public void findPageProductsSuccess() throws Exception {
        int page = 2;
        int size = 5;

        List<ProductEntity> productEntityList = getPageProducts(page, size);

        mockMvc.perform(MockMvcRequestBuilders.get(BASE_URL + String.format("/?page=%s&size=%s", page, size)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(productEntityList)));
    }

    @Test
    public void findPageProductFail() throws Exception {
        int page = -1;

        mockMvc.perform(MockMvcRequestBuilders.get(BASE_URL + String.format("/?page=%s", page)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void findByIdSuccess() throws Exception {
        ProductEntity product = createTestProduct();

        mockMvc.perform(MockMvcRequestBuilders.get(BASE_URL + "/{id}", product.getId()))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(product.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value(product.getTitle()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.cost").value(product.getCost()));
    }

    @Test
    public void findByIdFail() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(BASE_URL + "/3301"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(mvcResult ->
                        Objects.requireNonNull(mvcResult.getResolvedException()).getClass().equals(ProductNotFoundException.class));
    }

    @Test
    public void deleteByIdSuccess() throws Exception {
        ProductEntity product = createTestProduct();

        mockMvc.perform(MockMvcRequestBuilders.delete(BASE_URL + "/" + product.getId()))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void saveSuccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post(BASE_URL)
                        .content(objectMapper.writeValueAsString(createTestProduct()))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    private List<ProductEntity> getPageProducts(int page, int size) {
        return productRepository.findAll(
                PageRequest.of(page, size)).stream().toList();
    }

    private ProductEntity createTestProduct() {
        ProductEntity product = new ProductEntity();
        product.setTitle(PRODUCT_TITLE);
        product.setCost(1);
        return productRepository.save(product);
    }
}
