package com.matheus.servicex.domain.service;

import com.matheus.servicex.domain.exception.CategoriaNaoEncontradaException;
import com.matheus.servicex.domain.repository.CategoriaRepository;
import com.matheus.servicex.domain.model.Categoria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }

    public Categoria procurarCategoria(Integer id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new CategoriaNaoEncontradaException(id));
    }

    public Categoria salvarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public void deletarCategoria(Integer id) {
        Categoria categoria = procurarCategoria(id);

        categoriaRepository.delete(categoria);
    }
}
