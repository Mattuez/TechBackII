package com.matheus.servicex.api.controller;

import com.matheus.servicex.api.assembler.servico.ServicoDtoAssembler;
import com.matheus.servicex.api.assembler.servico.ServicoDtoDisassembler;
import com.matheus.servicex.api.model.servico.ServicoDto;
import com.matheus.servicex.api.model.servico.ServicoInputDto;
import com.matheus.servicex.domain.model.Servico;
import com.matheus.servicex.domain.service.ServicoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicos")
public class ServicoController {

    private ServicoService servicoService;
    private ServicoDtoAssembler servicoDtoAssembler;
    private ServicoDtoDisassembler servicoDtoDisassembler;

    public ServicoController(ServicoService servicoService, ServicoDtoAssembler servicoDtoAssembler,
                             ServicoDtoDisassembler servicoDtoDisassembler) {
        this.servicoService = servicoService;
        this.servicoDtoAssembler = servicoDtoAssembler;
        this.servicoDtoDisassembler = servicoDtoDisassembler;
    }

    @GetMapping
    public List<ServicoDto> listarServicos() {
        return servicoDtoAssembler.toDtoCollection(servicoService.listarServicos());
    }

    @GetMapping("/{servicoId}")
    public ServicoDto buscarServico(@PathVariable("servicoId") Integer servicoId) {
        return servicoDtoAssembler.toDto(servicoService.procurarServico(servicoId));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ServicoDto criarServico(@RequestBody ServicoInputDto servicoInput) {
        Servico servico = servicoDtoDisassembler.toEntityObject(servicoInput);

        return servicoDtoAssembler.toDto(servicoService.salvarServico(servico));
    }

    @PutMapping("/{servicoId}")
    public ServicoDto atualizarServico(@PathVariable("servicoId") Integer servicoId,
                                       @RequestBody ServicoInputDto servicoInput) {
        Servico servico = servicoService.procurarServico(servicoId);

        servicoDtoDisassembler.copyToEntityObject(servicoInput, servico);

        return servicoDtoAssembler.toDto(servicoService.salvarServico(servico));
    }

    @DeleteMapping("/{servicoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirServico(@PathVariable("servicoId") Integer servicoId) {
        servicoService.deletarServico(servicoId);
    }
}
