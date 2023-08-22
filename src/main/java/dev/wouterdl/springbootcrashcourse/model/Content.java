package dev.wouterdl.springbootcrashcourse.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Null;
import org.springframework.cglib.core.Local;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record Content(
        @Id
        Integer id,
        @NotBlank
        String title,
        @Column(value = "description")
        String desc,
        Status status,
        Type contentType,
        LocalDateTime dateCreated,
        LocalDateTime dateUpdated,
        String url
        ) {

}
