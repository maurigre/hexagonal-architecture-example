package br.com.maurireis.hexagonal.adapters.out;

import br.com.maurireis.hexagonal.adapters.out.repository.CustomerRepository;
import br.com.maurireis.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import br.com.maurireis.hexagonal.application.core.domain.Customer;
import br.com.maurireis.hexagonal.application.ports.out.CreateCustomerOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateCustomerAdapter implements CreateCustomerOutputPort {

    private final CustomerRepository customerRepository;
    private final CustomerEntityMapper customerEntityMapper;

    @Override
    public Customer create(Customer customer) {
        final var customerEntity = customerEntityMapper.toCustomerEntity(customer);
        final var created = customerRepository.save(customerEntity);
        return customerEntityMapper.toCustomer(created);
    }
}
