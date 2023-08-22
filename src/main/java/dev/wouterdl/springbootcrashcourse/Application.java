package dev.wouterdl.springbootcrashcourse;

import dev.wouterdl.springbootcrashcourse.config.ContentCalendarProperties;
import dev.wouterdl.springbootcrashcourse.model.Content;
import dev.wouterdl.springbootcrashcourse.model.Status;
import dev.wouterdl.springbootcrashcourse.model.Type;
import dev.wouterdl.springbootcrashcourse.repository.ContentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.Arrays;

@EnableConfigurationProperties(ContentCalendarProperties.class)
@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

	}




}
