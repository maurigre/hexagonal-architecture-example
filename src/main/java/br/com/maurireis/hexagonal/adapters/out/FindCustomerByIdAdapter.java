package br.com.maurireis.hexagonal.adapters.out;

import br.com.maurireis.hexagonal.adapters.out.repository.CustomerRepository;
import br.com.maurireis.hexagonal.adapters.out.repository.entity.CustomerEntity;
import br.com.maurireis.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import br.com.maurireis.hexagonal.application.core.domain.Customer;
import br.com.maurireis.hexagonal.application.ports.out.FindCustomerByIdOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindCustomerByIdAdapter implements FindCustomerByIdOutputPort {

    private final CustomerRepository customerRepository;
    private final CustomerEntityMapper customerEntityMapper;

    @Override
    public Optional<Customer> find(String id) {
        final var customerEntity = customerRepository.findById(id);
        return customerEntity.map(customerEntityMapper::toCustomer);
    }
}
