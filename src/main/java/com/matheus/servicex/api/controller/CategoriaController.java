package com.matheus.servicex.api.controller;

import com.matheus.servicex.api.assembler.categoria.CategoriaDtoAssembler;
import com.matheus.servicex.api.assembler.categoria.CategoriaDtoDisassembler;
import com.matheus.servicex.api.model.categoria.CategoriaDto;
import com.matheus.servicex.api.model.categoria.CategoriaInputDto;
import com.matheus.servicex.domain.model.Categoria;
import com.matheus.servicex.domain.service.CategoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private CategoriaService categoriaService;
    private CategoriaDtoAssembler categoriaDtoAssembler;
    private CategoriaDtoDisassembler categoriaDtoDisassembler;

    public CategoriaController(CategoriaService categoriaService, CategoriaDtoAssembler categoriaDtoAssembler,
                               CategoriaDtoDisassembler categoriaDtoDisassembler) {
        this.categoriaService = categoriaService;
        this.categoriaDtoAssembler = categoriaDtoAssembler;
        this.categoriaDtoDisassembler = categoriaDtoDisassembler;
    }

    @GetMapping
    public List<CategoriaDto> listarCategorias() {
        return categoriaDtoAssembler.toDtoCollection(categoriaService.listarCategorias());
    }

    @GetMapping("/{categoriaId}")
    public CategoriaDto buscarCategoria(@PathVariable("categoriaId") Integer categoriaId) {
        return categoriaDtoAssembler.toDto(categoriaService.procurarCategoria(categoriaId));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoriaDto criarCategoria(@RequestBody CategoriaInputDto categoriaInputDto) {
        Categoria categoria = categoriaDtoDisassembler.toEntityObject(categoriaInputDto);

        return categoriaDtoAssembler.toDto(categoriaService.salvarCategoria(categoria));
    }

    @PutMapping("/{categoriaId}")
    public CategoriaDto atualizarCategoria(@PathVariable("categoriaId") Integer categoriaId,
                                           @RequestBody CategoriaInputDto categoriaInputDto) {
        Categoria categoriaExistente = categoriaService.procurarCategoria(categoriaId);

        categoriaDtoDisassembler.copyToEntityObject(categoriaInputDto, categoriaExistente);

        return categoriaDtoAssembler.toDto(categoriaService.salvarCategoria(categoriaExistente));
    }

    @DeleteMapping("categoriaId")
    public void excluirCategoria(@PathVariable("categoriaId") Integer categoriaId) {
        categoriaService.deletarCategoria(categoriaId);
    }
}
