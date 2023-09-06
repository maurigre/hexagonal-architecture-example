package br.com.maurireis.hexagonal.adapters.out.client.response;

import lombok.Data;

@Data
public class AddressResponse {

    private String zipcode;
    private String street;
    private String number;
    private String district;
    private String city;
    private String state;
    private String reference;
    private String complement;
    private String country;
    private String ibgeCode;
}
