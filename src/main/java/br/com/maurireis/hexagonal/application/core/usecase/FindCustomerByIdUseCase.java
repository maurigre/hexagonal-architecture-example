package br.com.maurireis.hexagonal.application.core.usecase;

import br.com.maurireis.hexagonal.application.core.domain.Customer;
import br.com.maurireis.hexagonal.application.core.usecase.exception.EntityNotFoundException;
import br.com.maurireis.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import br.com.maurireis.hexagonal.application.ports.out.FindCustomerByIdOutputPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FindCustomerByIdUseCase implements FindCustomerByIdInputPort {

    private final FindCustomerByIdOutputPort findCustomerByIdOutputPort;

    @Override
    public Customer find(String id) {
        return findCustomerByIdOutputPort.find(id)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found"));
    }
}
