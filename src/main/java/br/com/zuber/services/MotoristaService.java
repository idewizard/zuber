package br.com.zuber.services;

import br.com.zuber.models.Motorista;
import br.com.zuber.repositories.MotoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MotoristaService {

    @Autowired
    private MotoristaRepository motoristaRepository;

    public void cadastrar(Motorista motorista) {
        motoristaRepository.save(motorista);
    }

    public Motorista buscar(long id) {
        return motoristaRepository.findById(id).orElse(null);
    }

}
