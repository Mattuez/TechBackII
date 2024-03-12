package com.matheus.servicex.api.assembler.servico;

import com.matheus.servicex.api.model.categoria.CategoriaInputDto;
import com.matheus.servicex.api.model.servico.ServicoDto;
import com.matheus.servicex.api.model.servico.ServicoInputDto;
import com.matheus.servicex.domain.model.Categoria;
import com.matheus.servicex.domain.model.Servico;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ServicoDtoDisassembler {

    private ModelMapper modelMapper;

    public ServicoDtoDisassembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Servico toEntityObject(ServicoInputDto source) {
        return modelMapper.map(source, Servico.class);
    }

    public void copyToEntityObject(ServicoInputDto source, Servico destination) {
        modelMapper.map(source, destination);
    }
}
