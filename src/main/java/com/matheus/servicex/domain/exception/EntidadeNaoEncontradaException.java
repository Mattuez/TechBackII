package com.matheus.servicex.domain.exception;

public class EntidadeNaoEncontradaException extends RegraDeNegocioException {
    public EntidadeNaoEncontradaException(String message) {
        super(message);
    }
}
