package br.com.maurireis.hexagonal.application.ports.in;

import br.com.maurireis.hexagonal.application.core.domain.Customer;

public interface CreateCustomerInputPort {

    Customer create(Customer customer, String zipCode);
}
