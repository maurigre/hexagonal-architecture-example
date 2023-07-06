package br.com.maurireis.hexagonal.application.ports.in;

import br.com.maurireis.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerInputPort {

    Customer update(final Customer customer, final String zipCode);
}
