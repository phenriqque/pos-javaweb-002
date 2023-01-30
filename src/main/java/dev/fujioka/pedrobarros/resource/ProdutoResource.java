package dev.fujioka.pedrobarros.resource;

import dev.fujioka.pedrobarros.dto.ProdutoDTO;
import dev.fujioka.pedrobarros.model.Produto;
import dev.fujioka.pedrobarros.repository.ProdutoRepository;
import dev.fujioka.pedrobarros.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoResource {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<ProdutoDTO> salvar(@RequestBody Produto produto){
        return ResponseEntity.ok(produtoService.salvar(produto));
    }

    @GetMapping
    public ResponseEntity<List<Produto>> getProdutos(){
        return ResponseEntity.ok(produtoService.listarProdutos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> consultaPorId(@PathVariable int id){
        return ResponseEntity.ok(produtoService.consultarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Produto> deletePorId(@PathVariable int id){
        produtoService.excluir(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Produto> alterar(@RequestBody Produto produto){
        return ResponseEntity.ok(produtoService.alterar(produto));
    }

    @GetMapping("/desclike/{descricao}")
    public ResponseEntity<List<Produto>> listarPorDescLike(@PathVariable String descricao){
        return ResponseEntity.ok(produtoService.buscarPorDescLike(descricao));
    }

    @GetMapping("/cor/{cor}")
    public ResponseEntity<List<Produto>> listarPorCor(@PathVariable String cor){
        return ResponseEntity.ok(produtoService.buscarPorCor(cor));
    }


}