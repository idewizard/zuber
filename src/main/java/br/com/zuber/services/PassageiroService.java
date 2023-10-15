package br.com.zuber.services;

import br.com.zuber.models.Passageiro;
import br.com.zuber.repositories.PassageiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassageiroService {

    @Autowired
    private PassageiroRepository passageiroRepository;

    public Passageiro buscar(long id) {
        return passageiroRepository.findById(id).orElse(null);
    }

    public void cadastrar(Passageiro passageiro) {
        passageiroRepository.save(passageiro);
    }

    public void editar(Passageiro novosDadosPassageiro) {
        Passageiro passageiroEncontradoNoBanco = passageiroRepository.findById(novosDadosPassageiro.getId()).orElse(null);

        passageiroEncontradoNoBanco.setNome(novosDadosPassageiro.getNome());
        passageiroEncontradoNoBanco.setCpf(novosDadosPassageiro.getCpf());
        passageiroEncontradoNoBanco.setDataNascimento(novosDadosPassageiro.getDataNascimento());

        passageiroRepository.save(passageiroEncontradoNoBanco);
    }

    public void apagar(long id) {
        passageiroRepository.deleteById(id);
    }
}
