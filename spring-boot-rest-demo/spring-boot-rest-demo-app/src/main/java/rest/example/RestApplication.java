package rest.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
@EnableJpaRepositories(basePackages={"rest.example"})
@ComponentScan(basePackages={"rest.example"})
public class RestApplication {

	public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }
}
