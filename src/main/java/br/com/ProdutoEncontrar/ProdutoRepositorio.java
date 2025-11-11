package br.com.ProdutoEncontrar;

public interface ProdutoRepositorio {
    Produto buscarPorId(String id) throws ProdutoNaoEncontradoException;
    void salvar(Produto p);
}