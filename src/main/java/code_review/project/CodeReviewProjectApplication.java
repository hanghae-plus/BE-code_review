package code_review.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class CodeReviewProjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(CodeReviewProjectApplication.class, args);
    }
}