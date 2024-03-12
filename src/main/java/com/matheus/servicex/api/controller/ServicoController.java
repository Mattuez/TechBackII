package com.matheus.servicex.api.controller;

import com.matheus.servicex.domain.service.ServicoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/servicos")
public class ServicoController {

    private ServicoService servicoService;
}
