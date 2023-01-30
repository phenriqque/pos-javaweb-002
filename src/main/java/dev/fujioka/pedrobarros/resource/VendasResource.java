package dev.fujioka.pedrobarros.resource;

import dev.fujioka.pedrobarros.dto.VendasDTO;
import dev.fujioka.pedrobarros.model.Vendas;
import dev.fujioka.pedrobarros.repository.VendasRepository;
import dev.fujioka.pedrobarros.service.VendasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendas")
public class VendasResource {

    @Autowired
    private VendasService vendasService;

    @PostMapping
    public ResponseEntity<VendasDTO> salvar(@RequestBody Vendas vendas){
        return ResponseEntity.ok(vendasService.salvar(vendas));
    }

    @GetMapping
    public ResponseEntity<List<Vendas>> getVendas(){
        return ResponseEntity.ok(vendasService.listarVendas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vendas> consultaPorId(@PathVariable int id){
        return ResponseEntity.ok(vendasService.consultarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Vendas> deletePorId(@PathVariable int id){
        vendasService.excluir(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Vendas> alterar(@RequestBody Vendas vendas){
        return ResponseEntity.ok(vendasService.alterar(vendas));
    }

    @GetMapping("/idcliente/{idcliente}")
    public ResponseEntity<List<Vendas>> listarPorIdCLiente(@PathVariable String idcliente){
        return ResponseEntity.ok(vendasService.buscarPorIdCliente(idcliente));
    }

    @GetMapping("/idproduto/{idproduto}")
    public ResponseEntity<List<Vendas>> listarPorIdProduto(@PathVariable String idproduto){
        return ResponseEntity.ok(vendasService.buscarPorIdProduto(idproduto));
    }


}