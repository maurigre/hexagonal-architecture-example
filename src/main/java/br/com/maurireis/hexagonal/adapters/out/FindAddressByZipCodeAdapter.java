package br.com.maurireis.hexagonal.adapters.out;

import br.com.maurireis.hexagonal.adapters.out.client.FindAddressByZipCodeClinet;
import br.com.maurireis.hexagonal.adapters.out.client.mapper.AddressResponseMapper;
import br.com.maurireis.hexagonal.application.core.domain.Address;
import br.com.maurireis.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutputPort {

    private final FindAddressByZipCodeClinet findAddressByZipCodeClinet;
    private final AddressResponseMapper addressResponseMapper;

    @Override
    public Address find(String zipCode) {
        var addressResponse = findAddressByZipCodeClinet.find(zipCode);
        return addressResponseMapper.toAddress(addressResponse);
    }
}
