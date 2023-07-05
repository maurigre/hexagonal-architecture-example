package br.com.maurireis.hexagonal.adapters.in.controller.mapper;

import br.com.maurireis.hexagonal.adapters.in.controller.request.CustomerRequest;
import br.com.maurireis.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "string")
public interface CustomerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "isValidCpf", ignore = true)
    Customer toCustomer(CustomerRequest customerRequest);
}
