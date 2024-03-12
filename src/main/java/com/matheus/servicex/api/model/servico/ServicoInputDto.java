package com.matheus.servicex.api.model.servico;

import com.matheus.servicex.api.model.categoria.CategoriaIdDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServicoInputDto {

    private String nome;
    private Double valor;
    private CategoriaIdDto categoria;
}
