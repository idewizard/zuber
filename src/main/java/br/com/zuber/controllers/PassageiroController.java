package br.com.zuber.controllers;

import br.com.zuber.controllers.response.PassageiroResponse;
import br.com.zuber.models.Motorista;
import br.com.zuber.models.Passageiro;
import br.com.zuber.services.PassageiroService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/passageiro")
public class PassageiroController {
    @Autowired
    private PassageiroService passageiroService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public PassageiroResponse buscarPassageiro(@RequestParam long id) {
        return modelMapper.map(passageiroService.buscar(id), PassageiroResponse.class);
    }

    @PostMapping
    public void cadastrarPassageiro(@RequestBody Passageiro passageiro) {
        passageiroService.cadastrar(passageiro);
    }

    @PutMapping
    public void editarPassageiro(@RequestBody Passageiro passageiro) {
        passageiroService.editar(passageiro);
    }

    @DeleteMapping
    public void apagarPassageiro(@RequestParam long id) {
        passageiroService.apagar(id);
    }
}
