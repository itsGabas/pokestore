package br.com.first.crud.repository;

import br.com.first.crud.model.Categoria;
import br.com.first.crud.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findByCategoria(Categoria categoria);
    List<Produto> findByNomeContainingIgnoreCase(String nome);

}
