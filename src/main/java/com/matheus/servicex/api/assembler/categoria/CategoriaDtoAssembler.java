package com.matheus.servicex.api.assembler.categoria;

import com.matheus.servicex.api.model.categoria.CategoriaDto;
import com.matheus.servicex.domain.model.Categoria;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoriaDtoAssembler {

    private ModelMapper modelMapper;

    public CategoriaDtoAssembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public CategoriaDto toDto(Categoria source) {
        return modelMapper.map(source, CategoriaDto.class);
    }

    public List<CategoriaDto> toDtoCollection(List<Categoria> source) {
        return source.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
