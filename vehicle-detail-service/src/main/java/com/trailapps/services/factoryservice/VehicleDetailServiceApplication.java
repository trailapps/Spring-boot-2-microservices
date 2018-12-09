package com.trailapps.services.factoryservice;

import com.trailapps.services.factoryservice.model.VehiclePart;
import com.trailapps.services.factoryservice.repository.VehiclePartRepository;
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
public class VehicleDetailServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(VehicleDetailServiceApplication.class, args);
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(new ApiInfoBuilder().version("1.0").title("Vehicle Detail API").description("Documentation Vehicle detail API v1.0").build());
    }

    @Bean
    CommandLineRunner commandLineRunner(VehiclePartRepository vehiclePartRepository) {
        return args -> {
            Stream.of(new VehiclePart("Duster", ""), new VehiclePart("Micro", ""),
                    new VehiclePart("Datsun Go", ""), new VehiclePart("Terrano", ""),
                    new VehiclePart("Clio", ""), new VehiclePart("Pulse", ""))
                    .forEach(vehiclePartRepository::save);
        };
    }
}
