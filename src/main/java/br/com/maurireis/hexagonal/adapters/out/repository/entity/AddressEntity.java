package br.com.maurireis.hexagonal.adapters.out.repository.entity;

import lombok.Data;

@Data
public class AddressEntity {

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
