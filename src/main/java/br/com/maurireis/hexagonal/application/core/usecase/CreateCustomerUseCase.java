package br.com.maurireis.hexagonal.application.core.usecase;

import br.com.maurireis.hexagonal.application.core.domain.Customer;
import br.com.maurireis.hexagonal.application.ports.in.CreateCustomerInputPort;
import br.com.maurireis.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import br.com.maurireis.hexagonal.application.ports.out.CreateCustomerOutputPort;

public class CreateCustomerUseCase implements CreateCustomerInputPort {

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
    private final CreateCustomerOutputPort createCustomerOutputPort;

    public CreateCustomerUseCase(FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort, CreateCustomerOutputPort createCustomerOutputPort) {
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.createCustomerOutputPort = createCustomerOutputPort;
    }

    @Override
    public Customer create(Customer customer, String zipCode){
        var address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        return createCustomerOutputPort.create(customer);
    }
}
