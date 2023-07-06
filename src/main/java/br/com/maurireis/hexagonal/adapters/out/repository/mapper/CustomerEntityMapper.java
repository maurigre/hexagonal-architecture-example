package br.com.maurireis.hexagonal.adapters.out.repository.mapper;

import br.com.maurireis.hexagonal.adapters.out.repository.entity.CustomerEntity;
import br.com.maurireis.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

    CustomerEntity toCustomerEntity(Customer customer);

    Customer toCustomer(CustomerEntity customerEntity);
}
