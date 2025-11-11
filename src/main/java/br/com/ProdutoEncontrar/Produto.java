package br.com.ProdutoEncontrar;

public class Produto {
    private final String id;
    private final String nome;
    private final double preco;

    public Produto(String id, String nome, double preco) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Id obrigatório.");
        }
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome obrigatório.");
        }
        if (preco < 0) {
            throw new IllegalArgumentException("Preço inválido.");
        }

        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return id + " - " + nome + " (R$ " + preco + ")";
    }
}
