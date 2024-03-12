package com.matheus.servicex.api.exceptionHandler;

import com.matheus.servicex.domain.exception.CategoriaNaoEncontradaException;
import com.matheus.servicex.domain.exception.EntidadeNaoEncontradaException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@AllArgsConstructor
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        ApiErrorType errorType = ApiErrorType.RESOURCE_NOT_FOUND;
        String detail = "O recurso %s não é válido".formatted(ex.getRequestURL());

        ApiError error = createApiErrorBuilder(status, errorType, detail)
                .build();

        return handleExceptionInternal(ex, error, headers, status, request);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    private ResponseEntity<Object> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex,
                                                                             WebRequest request) {

        HttpStatusCode status = HttpStatusCode.valueOf(HttpStatus.BAD_REQUEST.value());
        ApiErrorType errorType = ApiErrorType.INVALID_URL_PARAMETER;
        String detail = String.format("O parâmetro de url '%s' recebeu um valor inválido de tipo '%s'. "+
                        "Substitua por um valor do tipo '%s'",
                ex.getPropertyName(), ex.getValue().getClass().getSimpleName(), ex.getRequiredType().getSimpleName());

        ApiError error = createApiErrorBuilder(status, errorType, detail)
                .build();

        return handleExceptionInternal(ex, error, new HttpHeaders(), status, request);
    }

    @ExceptionHandler(EntidadeNaoEncontradaException.class)
    private ResponseEntity<Object> handleEntidadeNaoEncontradaException(EntidadeNaoEncontradaException ex,
                                                                        WebRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ApiErrorType apiErrorType = ApiErrorType.RESOURCE_NOT_FOUND;
        String detail = ex.getMessage();

        ApiError error = createApiErrorBuilder(status, apiErrorType, detail)
                .build();

        return handleExceptionInternal(ex, error, new HttpHeaders(), status, request);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatusCode statusCode, WebRequest request) {
        return super.handleExceptionInternal(ex, body, headers, statusCode, request);
    }

    private ApiError.ApiErrorBuilder createApiErrorBuilder(HttpStatusCode statusCode, ApiErrorType errorType,
                                                           String detail) {
        return ApiError.builder()
                .status(statusCode.value())
                .type(errorType.getUri())
                .title(errorType.getTitle())
                .detail(detail);
    }
}
