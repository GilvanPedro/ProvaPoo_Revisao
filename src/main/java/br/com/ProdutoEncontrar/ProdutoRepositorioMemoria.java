package br.com.ProdutoEncontrar;

import java.util.HashMap;
import java.util.Map;

public class ProdutoRepositorioMemoria implements ProdutoRepositorio {
    private final Map<String, Produto> banco = new HashMap<>();

    @Override
    public void salvar(Produto p) {
        banco.put(p.getId(), p);
    }

    @Override
    public Produto buscarPorId(String id) throws ProdutoNaoEncontradoException {
        Produto p = banco.get(id);
        if (p == null) {
            throw new ProdutoNaoEncontradoException("Produto '" + id + "' não encontrado.");
        }
        return p;
    }
}