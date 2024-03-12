package com.matheus.servicex.api.model.categoria;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriaInputDto {

    @NotEmpty
    private String nome;
}
