package br.com.maurireis.hexagonal.application.core.domain;

import java.util.Objects;

public class Customer {

    public Customer() {
        this.isValidCpf = false;
    }

    public Customer(String id, String name, Address address, String cpf, Boolean isValidCpf) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.cpf = cpf;
        this.isValidCpf = isValidCpf;
    }

    private String id;

    private String name;

    private Address address;

    private String cpf;

    private Boolean isValidCpf;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Boolean getValidCpf() {
        return isValidCpf;
    }

    public void setValidCpf(Boolean validCpf) {
        isValidCpf = validCpf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer customer)) return false;
        return getId().equals(customer.getId()) && Objects.equals(getName(), customer.getName()) && Objects.equals(getAddress(), customer.getAddress()) && Objects.equals(getCpf(), customer.getCpf());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getAddress(), getCpf());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", cpf='" + cpf + '\'' +
                ", isValidCpf=" + isValidCpf +
                '}';
    }
}
