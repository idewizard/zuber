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

    public void editar(Motorista novosDadosMotorista) {
        //Para fazer a alteração de um motorista no banco, primeiro precisamos buscar esse motorista
        Motorista motoristaEncontradoNoBanco = motoristaRepository.findById(novosDadosMotorista.getId()).orElse(null);

        //Após pegar o motorista do banco, vamos alterar os dados do motorista com os dados novos
        motoristaEncontradoNoBanco.setCnh(novosDadosMotorista.getCnh());
        motoristaEncontradoNoBanco.setNome(novosDadosMotorista.getNome());
        motoristaEncontradoNoBanco.setVeiculo(novosDadosMotorista.getVeiculo());

        //Vamos salvar no banco esse motorista que alteramos os dados
        motoristaRepository.save(motoristaEncontradoNoBanco);
    }

    public void apagar(long id) {
        motoristaRepository.deleteById(id);
    }
}
