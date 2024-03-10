package com.matheus.servicex.api.exceptionHandler;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ApiError {

    private Integer status;
    private String type;
    private String title;
    private String detail;

}

