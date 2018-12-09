package com.trailapps.services.factoryservice;

import com.trailapps.services.factoryservice.model.Factory;
import com.trailapps.services.factoryservice.repository.FactoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.stream.Stream;

@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
@EnableFeignClients
public class FactoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FactoryServiceApplication.class, args);
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(new ApiInfoBuilder().version("1.0").title("Factory API").description("Documentation Factory API v1.0").build());
    }

    @Bean
    CommandLineRunner commandLineRunner(FactoryRepository factoryRepository) {
        return args -> {
            Stream.of(new Factory("H60A-LFM", "Duster Left Mirror ", 100, false),
                    new Factory("H60A-RM", "Duster Right Mirror ", 300, false),
                    new Factory("H60A-12", "Duster Radiator", 600, true),
                    new Factory("H60A-34", "Wiper", 2000, true),
                    new Factory("H60A-42", "16x Tyre", 1000, true),
                    new Factory("H60A-QW", "Beeding ", 10, false),
                    new Factory("H60A-ER", "Gearbox", 60, true),
                    new Factory("H60A-TM", "Bumper", 80, false))
                    .forEach(factoryRepository::save);
        };
    }
}
