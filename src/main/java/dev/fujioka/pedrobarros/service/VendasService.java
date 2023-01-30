package dev.fujioka.pedrobarros.service;
import dev.fujioka.pedrobarros.dto.ClienteDTO;
import dev.fujioka.pedrobarros.dto.VendasDTO;
import dev.fujioka.pedrobarros.model.Vendas;
import dev.fujioka.pedrobarros.repository.VendasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class VendasService {

    @Autowired
    private VendasRepository vendasRepository;
    @Autowired
    private JmsTemplate jmsTemplate;
    public VendasDTO salvar(Vendas vendas){
        vendas = vendasRepository.save(vendas);
        jmsTemplate.convertAndSend("Vendas_queue", vendas);
        return VendasDTO.builder()
                .datavenda(vendas.getDatavenda())
                .idproduto(vendas.getIdproduto())
                .build();
    }

    public List<Vendas> listarVendas(){
        return vendasRepository.findAll();
    }

    public Vendas consultarPorId(int id){
        return vendasRepository.findById(id).orElseThrow();
    }

    public void excluir(int id){
        vendasRepository.deleteById(id);
    }

    public Vendas alterar(Vendas vendas){
        if(Objects.isNull(vendas.getId())){
            throw new RuntimeException("ID não preenchido");
        }
        return vendasRepository.save(vendas);
    }

    public List<Vendas> buscarPorIdCliente(String idcliente){
        return vendasRepository.buscarVendasPorIDCliente(idcliente);
    }
    public List<Vendas> buscarPorIdProduto(String idproduto){
        return vendasRepository.buscarVendaPorIdProduto(idproduto);
    }

}