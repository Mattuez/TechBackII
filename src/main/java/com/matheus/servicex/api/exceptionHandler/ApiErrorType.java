package com.matheus.servicex.api.exceptionHandler;

import lombok.Getter;

@Getter
public enum ApiErrorType {

    RESOURCE_NOT_FOUND("/resource-not-found", "Recurso não encontrado."),
    INVALID_URL_PARAMETER("/invalid-url-parameter", "Parâmetro de url inválido.");

    private final String uri;
    private final String title;

    ApiErrorType(String path, String title) {
        this.uri = "https://autumnflix.com.br" + path;
        this.title = title;
    }
}
