package com.matheus.servicex.domain.service;

import com.matheus.servicex.domain.exception.ServicoNaoEncontradoException;
import com.matheus.servicex.domain.model.Categoria;
import com.matheus.servicex.domain.model.Servico;
import com.matheus.servicex.domain.repository.ServicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoService {

    private CategoriaService categoriaService;
    private ServicoRepository servicoRepository;

    public ServicoService(CategoriaService categoriaService, ServicoRepository servicoRepository) {
        this.categoriaService = categoriaService;
        this.servicoRepository = servicoRepository;
    }

    private List<Servico> listarServicos() {
        return servicoRepository.findAll();
    }

    private Servico procurarServico(Integer servicoId) {
        return servicoRepository.findById(servicoId)
                .orElseThrow(() -> new ServicoNaoEncontradoException(servicoId));
    }

    private Servico salvarServico(Servico servico) {
        Categoria categoria = categoriaService.procurarCategoria(servico.getCategoria().getId());
        servico.setCategoria(categoria);

        return servicoRepository.save(servico);
    }

    private void deletarServico(Integer categoriaId) {
        Servico servico = procurarServico(categoriaId);

        servicoRepository.delete(servico);
    }
}
