package br.com.maurireis.hexagonal.adapters.in.controller;

import br.com.maurireis.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import br.com.maurireis.hexagonal.adapters.in.controller.request.CustomerRequest;
import br.com.maurireis.hexagonal.adapters.in.controller.response.CustomerResponse;
import br.com.maurireis.hexagonal.application.ports.in.DeleteCustomerByIdInputPort;
import br.com.maurireis.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import br.com.maurireis.hexagonal.application.ports.in.CreateCustomerInputPort;
import br.com.maurireis.hexagonal.application.ports.in.UpdateCustomerInputPort;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(CustomerController.PATH)
@RequiredArgsConstructor
public class CustomerController {

    static final String VERSION = "/v1";
    static final String PATH = VERSION + "/customers";

    private final CreateCustomerInputPort createCustomerInputPort;
    private final FindCustomerByIdInputPort findCustomerByIdInputPort;
    private final UpdateCustomerInputPort updateCustomerInputPort;
    private final DeleteCustomerByIdInputPort deleteCustomerByIdInputPort;
    private final CustomerMapper customerMapper;

    @PostMapping
    public ResponseEntity<CustomerResponse> create(@RequestBody @Valid CustomerRequest customerRequest, UriComponentsBuilder uriComponentsBuilder) {
        final var customer = customerMapper.toCustomer(customerRequest);
        final var created = createCustomerInputPort.create(customer, customerRequest.getZipCode());
        final var customerResponse = customerMapper.toCustomerResponse(created);
        final var uriCustomer = uriComponentsBuilder.path(PATH + "/{id}").buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriCustomer)
                .body(customerResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable @Valid @NotBlank final String id) {
        final var customer = findCustomerByIdInputPort.find(id);
        final var customerResponse = customerMapper.toCustomerResponse(customer);
        return ResponseEntity.ok(customerResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponse> update(@PathVariable @NotBlank final String id, @RequestBody @Valid CustomerRequest customerRequest) {
        final var customer = customerMapper.toCustomer(customerRequest);
        customer.setId(id);
        final var  update = updateCustomerInputPort.update(customer, customerRequest.getZipCode());
        final var customerResponse = customerMapper.toCustomerResponse(update);
        return ResponseEntity.ok(customerResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final String id){
        deleteCustomerByIdInputPort.delete(id);
        return ResponseEntity.noContent()
                .build();
    }

}
