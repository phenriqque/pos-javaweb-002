package dev.fujioka.pedrobarros.service;
import dev.fujioka.pedrobarros.dto.ClienteDTO;

import dev.fujioka.pedrobarros.model.Cliente;
import dev.fujioka.pedrobarros.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private JmsTemplate jmsTemplate;

    public ClienteDTO salvar(Cliente cliente){
        cliente = clienteRepository.save(cliente);
        jmsTemplate.convertAndSend("Cliente_queue", cliente);
        return ClienteDTO.builder()
                .nome(cliente.getNome())
                .cpf(cliente.getCpf())
                .build();
    }


    public List<Cliente> listarClientes(){
        return clienteRepository.findAll();
    }

    public Cliente consultarPorId(int id){
        return clienteRepository.findById(id).orElseThrow();
    }

    public void excluir(int id){
        clienteRepository.deleteById(id);
    }

    public Cliente alterar(Cliente cliente){
        if(Objects.isNull(cliente.getId())){
            throw new RuntimeException("ID não preenchido");
        }
        return clienteRepository.save(cliente);
    }

    public List<Cliente> buscarPorNomeLike(String nome){
        return clienteRepository.buscarClientePorNomeLike(nome);
    }
    public List<Cliente> buscarCPF(String cpf){
        return clienteRepository.buscarClientePorCPF(cpf);
    }

}