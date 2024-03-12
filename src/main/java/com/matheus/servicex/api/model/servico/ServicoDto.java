package com.matheus.servicex.api.model.servico;

import com.matheus.servicex.api.model.categoria.CategoriaDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServicoDto {

    private Integer id;
    private String nome;
    private Double valor;
    private CategoriaDto categoria;
}
