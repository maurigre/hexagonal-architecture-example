package br.com.maurireis.hexagonal.application.ports.out;

import br.com.maurireis.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerOutputPort {

    Customer update(Customer customer);
}
