package br.com.maurireis.hexagonal.application.core.usecase;

import br.com.maurireis.hexagonal.application.core.domain.Customer;
import br.com.maurireis.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import br.com.maurireis.hexagonal.application.ports.in.UpdateCustomerInputPort;
import br.com.maurireis.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import br.com.maurireis.hexagonal.application.ports.out.UpdateCustomerOutputPort;

public class UpdateCustomerUseCase implements UpdateCustomerInputPort {

    private final FindCustomerByIdInputPort findCustomerByIdInputPort;
    private final UpdateCustomerOutputPort updateCustomerOutputPort;
    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;

    public UpdateCustomerUseCase(FindCustomerByIdInputPort findCustomerByIdInputPort, UpdateCustomerOutputPort updateCustomerOutputPort, FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort) {
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.updateCustomerOutputPort = updateCustomerOutputPort;
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
    }

    @Override
    public Customer update(Customer customer, String zipCode) {
        findCustomerByIdInputPort.find(customer.getId());
        final var address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        return updateCustomerOutputPort.update(customer);
    }
}
