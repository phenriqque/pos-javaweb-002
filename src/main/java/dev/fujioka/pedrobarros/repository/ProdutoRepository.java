package dev.fujioka.pedrobarros.repository;

import dev.fujioka.pedrobarros.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    @Query("select a from Produto a order by a.descricao ASC")
    public List<Produto> listarOrdernadoPorDesc();

    public List<Produto> findAllByOrderByDescricaoAsc();

    @Query("select a from Produto a where a.descricao like %:descricao% ")
    public List<Produto> buscarProdutoPorDescLike(@Param("descricao") String descricao);

    @Query("select a from Produto a where a.cor = :cor ")
    public List<Produto> buscarProdutoPorCor(@Param("cor") String cor);


}
