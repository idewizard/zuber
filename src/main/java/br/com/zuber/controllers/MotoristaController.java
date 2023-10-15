package br.com.zuber.controllers;

import br.com.zuber.controllers.response.MotoristaResponse;
import br.com.zuber.models.Motorista;
import br.com.zuber.services.MotoristaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/motorista")
public class MotoristaController {
    /*
     * Esta é a controller, ela é a porta de entrada da nossa API, outros serviços e aplicações
     * vão chamar ela para acessar as funcionalidades da nossa API.
     * */

    //A controller NÃo deve conter lógicas complexas e nem regras de negócio
    //Portanto vamos usar uma service para se encarregar disso
    @Autowired
    private MotoristaService motoristaService;

    @Autowired
    private ModelMapper modelMapper;

    //Esse método da controle é onde vamos chamar a criação de um novo motorista
    @PostMapping
    public void cadastrarMotorista(@RequestBody Motorista motorista) {
        motoristaService.cadastrar(motorista);
    }

    //Esse método da controle é onde vamos BUSCAR um motorista que já exista
    @GetMapping
    public MotoristaResponse buscarMotorista(@RequestParam long id) {
        return modelMapper.map(motoristaService.buscar(id), MotoristaResponse.class);
    }

    //Esse método da controle é onde vamos ALTERAR um motorista
    @PutMapping
    public void editarMotorista(@RequestBody Motorista motorista) {
        motoristaService.editar(motorista);
    }

    //Esse método da controle é onde vamos APAGAR um motorista
    @DeleteMapping
    public void apagarMotorista(@RequestParam long id) {
        motoristaService.apagar(id);
    }
}
