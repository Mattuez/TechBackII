package com.matheus.servicex.api.model.categoria;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriaIdDto {

    @NotNull
    private Integer id;
}
