package br.com.maurireis.hexagonal.application.ports.out;

import br.com.maurireis.hexagonal.application.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerByIdOutputPort {

    Optional<Customer> find(String id);
}
