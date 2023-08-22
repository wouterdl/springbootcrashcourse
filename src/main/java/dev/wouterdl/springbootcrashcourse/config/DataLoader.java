package dev.wouterdl.springbootcrashcourse.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.wouterdl.springbootcrashcourse.model.Content;
import dev.wouterdl.springbootcrashcourse.repository.ContentRepository;
import org.springframework.asm.TypeReference;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final ContentRepository repository;
    private final ObjectMapper objectMapper;

    public DataLoader(ContentRepository repository, ObjectMapper objectMapper) {
        this.repository = repository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        try(InputStream inputStream = TypeReference.class.getResourceAsStream("/data/content.json")){
            repository.saveAll(objectMapper.readValue(inputStream, new com.fasterxml.jackson.core.type.TypeReference<List<Content>>(){}));
        }
    }
}
