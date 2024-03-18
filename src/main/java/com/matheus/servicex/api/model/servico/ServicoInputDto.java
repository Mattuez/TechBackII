package com.matheus.servicex.api.model.servico;

import com.matheus.servicex.api.model.categoria.CategoriaIdDto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServicoInputDto {

    @NotEmpty
    private String nome;

    @NotNull
    private Double valor;

    @NotNull
    private CategoriaIdDto categoria;
}
