package br.com.maurireis.hexagonal.config;

import br.com.maurireis.hexagonal.adapters.out.CreateCustomerAdapter;
import br.com.maurireis.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import br.com.maurireis.hexagonal.application.core.usecase.CreateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreateCustomerConfig {

    @Bean
    public CreateCustomerUseCase createCustomerUseCase(
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            CreateCustomerAdapter createCustomerAdapter
    ){
        return new CreateCustomerUseCase(findAddressByZipCodeAdapter, createCustomerAdapter);
    }
}
