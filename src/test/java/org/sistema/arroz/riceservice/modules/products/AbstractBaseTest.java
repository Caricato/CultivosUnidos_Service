package org.sistema.arroz.riceservice.modules.products;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.amazonaws.util.json.Jackson.getObjectMapper;

public abstract class AbstractBaseTest {
    public static String readJSON(String path) throws URISyntaxException, IOException {
        return new String(Files.readAllBytes(Paths.get(AbstractBaseTest.class.getResource(path).toURI())));
    }

    public static <T> T fromJson(String message, Class<T> clazz) throws JsonProcessingException {
        ObjectMapper objectMapper = getObjectMapper();
        return objectMapper.readValue(message, clazz);
    }

    public static <T> T convertTo(String path, Class<T> clazz) throws IOException, URISyntaxException {
        String jsonRequest = readJSON(path);

        return getObjectMapper().readValue(jsonRequest, clazz);
    }
}
