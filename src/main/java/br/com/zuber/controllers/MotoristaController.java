package br.com.zuber.controllers;

import br.com.zuber.models.Motorista;
import br.com.zuber.services.MotoristaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MotoristaController {

    @Autowired
    private MotoristaService motoristaService;

    @PostMapping
    public void cadastrarMotorista(@RequestBody Motorista motorista){
        motoristaService.cadastrar(motorista);
    }

    @GetMapping
    public Motorista buscarMotorista(@RequestParam long id){
        return motoristaService.buscar(id);
    }

}
