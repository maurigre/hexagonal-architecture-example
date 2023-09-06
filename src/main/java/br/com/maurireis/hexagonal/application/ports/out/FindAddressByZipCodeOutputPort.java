package br.com.maurireis.hexagonal.application.ports.out;

import br.com.maurireis.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {

    Address find(String zipCode);
}
