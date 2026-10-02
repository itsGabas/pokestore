package br.com.first.crud.service;

import br.com.first.crud.model.Produto;
import br.com.first.crud.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository repository;

    public List<Produto> listar(){
        return repository.findAll(Sort.by("id"));
    }

    public Produto buscarPorId(Long id){
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado: " + id));
    }

    public Produto criar(Produto produto){
        produto.setId(null);
        return repository.save(produto);

    }

    public Produto atualizar(Long id, Produto dados){
        Produto existente = buscarPorId(id);
        existente.setNome(dados.getNome());
        existente.setDescricao(dados.getDescricao());
        existente.setCategoria(dados.getCategoria());
        existente.setPreco(dados.getPreco());
        existente.setQuantidade(dados.getQuantidade());
        return repository.save(existente);
    }

    public void deletar(Long id){
        buscarPorId(id);
        repository.deleteById(id);
    }
}
