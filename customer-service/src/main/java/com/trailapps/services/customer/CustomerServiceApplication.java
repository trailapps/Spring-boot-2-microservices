package com.trailapps.services.customer;

import com.trailapps.services.customer.model.Customer;
import com.trailapps.services.customer.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(new ApiInfoBuilder().version("1.0").title("Customer API").description("Documentation Customer API v1.0").build());
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
        customerRepository.deleteAll();
        ;
        return args -> {
            Stream.of(new Customer(UUID.randomUUID(), "John", "addr", "Duster", new Date()),
                    new Customer(UUID.randomUUID(), "John", "addr", "Micro", new Date()),
                    new Customer(UUID.randomUUID(), "John", "addr", "Datsun Go", new Date()),
                    new Customer(UUID.randomUUID(), "John", "addr", "Terrano", new Date()),
                    new Customer(UUID.randomUUID(), "John", "addr", "Clio", new Date()),
                    new Customer(UUID.randomUUID(), "John", "addr", "Pulse", new Date())
            ).forEach(customerRepository::save);
        };

    }
}
