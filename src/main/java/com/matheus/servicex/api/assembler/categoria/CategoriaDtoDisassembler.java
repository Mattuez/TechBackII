package com.matheus.servicex.api.assembler.categoria;

import com.matheus.servicex.api.model.categoria.CategoriaInputDto;
import com.matheus.servicex.domain.model.Categoria;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CategoriaDtoDisassembler {

    private ModelMapper modelMapper;

    public CategoriaDtoDisassembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Categoria toEntityObject(CategoriaInputDto source) {
        return modelMapper.map(source, Categoria.class);
    }

    public void copyToEntityObject(CategoriaInputDto source, Categoria destination) {
        modelMapper.map(source, destination);
    }
}
