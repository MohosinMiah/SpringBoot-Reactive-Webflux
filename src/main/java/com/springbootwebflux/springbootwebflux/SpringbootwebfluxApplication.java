package com.springbootwebflux.springbootwebflux;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableWebFlux

public class SpringbootwebfluxApplication {

	@Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

	public static void main(String[] args) {
		SpringApplication.run(SpringbootwebfluxApplication.class, args);
	}

}
