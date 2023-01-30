package dev.fujioka.pedrobarros.repository;

import dev.fujioka.pedrobarros.model.Vendas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VendasRepository extends JpaRepository<Vendas, Integer> {

    @Query("select a from Vendas a order by a.datavenda ASC")
    public List<Vendas> listarOrdernadoPordata();

    public List<Vendas> findAllByOrderByDatavendaAsc();

    @Query("select a from Vendas a where a.idcliente = :idcliente ")
    public List<Vendas> buscarVendasPorIDCliente(@Param("idcliente") String idcliente);

    @Query("select a from Vendas a where a.idproduto = :idproduto ")
    public List<Vendas> buscarVendaPorIdProduto(@Param("idproduto") String idproduto);


}
