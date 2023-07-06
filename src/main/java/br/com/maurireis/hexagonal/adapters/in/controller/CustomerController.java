package br.com.maurireis.hexagonal.adapters.in.controller;

import br.com.maurireis.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import br.com.maurireis.hexagonal.adapters.in.controller.request.CustomerRequest;
import br.com.maurireis.hexagonal.adapters.in.controller.response.CustomerResponse;
import br.com.maurireis.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import br.com.maurireis.hexagonal.application.ports.in.InsertCustomerInputPort;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final InsertCustomerInputPort insertCustomerInputPort;
    private final FindCustomerByIdInputPort findCustomerByIdInputPort;
    private final CustomerMapper customerMapper;

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody @Valid CustomerRequest customerRequest) {
        final var customer = customerMapper.toCustomer(customerRequest);
        insertCustomerInputPort.insert(customer, customerRequest.getZipCode());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable @Valid @NotBlank final String id) {
        final var customer = findCustomerByIdInputPort.find(id);
        final var customerResponse = customerMapper.toCustomerResponse(customer);
        return ResponseEntity.ok(customerResponse);
    }

}
