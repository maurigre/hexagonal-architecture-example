package br.com.maurireis.hexagonal.config;

import br.com.maurireis.hexagonal.adapters.out.DeleteCustomerByIdAdapter;
import br.com.maurireis.hexagonal.application.core.usecase.DeleteCustomerByIdUseCase;
import br.com.maurireis.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerByIdConfig {

    @Bean
    public DeleteCustomerByIdUseCase deleteCustomerByIdUseCase(
            FindCustomerByIdUseCase findCustomerByIdUseCase,
            DeleteCustomerByIdAdapter deleteCustomerByIdAdapter
    ) {
        return new DeleteCustomerByIdUseCase(findCustomerByIdUseCase, deleteCustomerByIdAdapter);
    }
}
