package br.com.maurireis.hexagonal.application.ports.in;

import br.com.maurireis.hexagonal.application.core.domain.Customer;

public interface InsertCustomerInputPort {

    void insert(Customer customer, String zipCode);
}
