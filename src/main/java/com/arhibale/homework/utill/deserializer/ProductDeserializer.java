package com.arhibale.homework.utill.deserializer;

import com.arhibale.homework.model.Product;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;

@Log4j2
public class ProductDeserializer extends StdDeserializer<Product> {

    public ProductDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Product deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        try {
            JsonNode jsonNode = jsonParser.getCodec().readTree(jsonParser);

            long id = jsonNode.get("id").asLong();
            String title = jsonNode.get("product code").asText().split("-")[0].trim();
            String company = jsonNode.get("product code").asText().split("-")[1].trim();
            int cost = jsonNode.get("cost").asInt();

            log.info("Product: {}, {}, {}, {}", id, title, company, cost);

            return new Product(id, title, company, cost);
        } catch (JsonParseException e) {
            return null;
        }
    }
}