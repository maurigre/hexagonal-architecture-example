package br.com.maurireis.hexagonal.adapters.out;

import br.com.maurireis.hexagonal.adapters.out.repository.CustomerRepository;
import br.com.maurireis.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import br.com.maurireis.hexagonal.application.core.domain.Customer;
import br.com.maurireis.hexagonal.application.ports.out.UpdateCustomerOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateCustomerAdapter implements UpdateCustomerOutputPort {

    private final CustomerRepository customerRepository;
    private final CustomerEntityMapper customerEntityMapper;

    @Override
    public Customer update(Customer customer) {
        final var customerEntity = customerEntityMapper.toCustomerEntity(customer);
        final var customerEntitySave = customerRepository.save(customerEntity);
        return customerEntityMapper.toCustomer(customerEntitySave);
    }
}
