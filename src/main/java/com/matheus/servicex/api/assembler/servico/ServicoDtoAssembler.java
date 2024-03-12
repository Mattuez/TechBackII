package com.matheus.servicex.api.assembler.servico;

import com.matheus.servicex.api.model.servico.ServicoDto;
import com.matheus.servicex.domain.model.Servico;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ServicoDtoAssembler {

    private ModelMapper modelMapper;

    public ServicoDtoAssembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ServicoDto toDto(Servico source) {
        return modelMapper.map(source, ServicoDto.class);
    }

    public List<ServicoDto> toDtoCollection(List<Servico> source) {
        return source.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
