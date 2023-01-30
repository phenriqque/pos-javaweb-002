package dev.fujioka.pedrobarros.repository;

import dev.fujioka.pedrobarros.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Query("select a from Cliente a order by a.nome ASC")
    public List<Cliente> listarOrdernadoPorNome();
    public List<Cliente> findAllByOrderByNomeAsc();

    @Query("select a from Cliente a where a.nome like %:nome% ")
    public List<Cliente> buscarClientePorNomeLike(@Param("nome") String nome);

    @Query("select a from Cliente a where a.cpf = :cpf ")
    public List<Cliente> buscarClientePorCPF(@Param("cpf") String cpf);


}
