package br.com.maurireis.hexagonal.application.ports.out;

public interface DeleteCustomerByIdOutputPort {

    void delete(final String id);
}
