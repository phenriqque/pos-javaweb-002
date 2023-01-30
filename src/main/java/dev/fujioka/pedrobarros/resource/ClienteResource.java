package dev.fujioka.pedrobarros.resource;

import dev.fujioka.pedrobarros.dto.ClienteDTO;
import dev.fujioka.pedrobarros.model.Cliente;
import dev.fujioka.pedrobarros.repository.ClienteRepository;
import dev.fujioka.pedrobarros.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteDTO> salvar(@RequestBody Cliente cliente){
        return ResponseEntity.ok(clienteService.salvar(cliente));
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> getClientes(){
        return ResponseEntity.ok(clienteService.listarClientes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> consultaPorId(@PathVariable int id){
        return ResponseEntity.ok(clienteService.consultarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> deletePorId(@PathVariable int id){
        clienteService.excluir(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Cliente> alterar(@RequestBody Cliente cliente){
        return ResponseEntity.ok(clienteService.alterar(cliente));
    }

    @GetMapping("/nomelike/{nome}")
    public ResponseEntity<List<Cliente>> listarNomePorLike(@PathVariable String nome){
        return ResponseEntity.ok(clienteService.buscarPorNomeLike(nome));
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<List<Cliente>> listarCPF(@PathVariable String cpf){
        return ResponseEntity.ok(clienteService.buscarCPF(cpf));
    }


}