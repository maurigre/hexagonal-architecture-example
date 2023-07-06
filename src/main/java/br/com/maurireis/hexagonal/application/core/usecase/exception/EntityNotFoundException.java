package br.com.maurireis.hexagonal.application.core.usecase.exception;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String message) {
        super(message);
    }
}
