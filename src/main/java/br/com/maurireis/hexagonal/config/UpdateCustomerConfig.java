package br.com.maurireis.hexagonal.config;

import br.com.maurireis.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import br.com.maurireis.hexagonal.adapters.out.UpdateCustomerAdapter;
import br.com.maurireis.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import br.com.maurireis.hexagonal.application.core.usecase.UpdateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {

    @Bean
    public UpdateCustomerUseCase updateCustomerUseCase(
            FindCustomerByIdUseCase findCustomerByIdUseCase,
            UpdateCustomerAdapter updateCustomerAdapter,
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter
            ) {
        return new UpdateCustomerUseCase(findCustomerByIdUseCase, updateCustomerAdapter, findAddressByZipCodeAdapter);
    }
}
