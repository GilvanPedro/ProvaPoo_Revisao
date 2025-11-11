package br.com.ProdutoEncontrar;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        ProdutoRepositorio repo = new ProdutoRepositorioMemoria();
        String buscar;

        Scanner sc = new Scanner(System.in);

        repo.salvar(new Produto("P1", "Caneta", 2.5));
        repo.salvar(new Produto("P2", "Caderno", 15.0));
        repo.salvar(new Produto("P3", "Borracha", 2.5));
        repo.salvar(new Produto("P4", "Água Mineral", 3.25));
        repo.salvar(new Produto("P5", "Fichário", 50.99));
        repo.salvar(new Produto("P6", "Mochila do Mário", 113.30));

        try {
            System.out.println("Digite o id do produto (EX.: P1)");
            buscar = sc.nextLine();
            Produto p = repo.buscarPorId(buscar);
            System.out.println("Encontrado: " + p);
        } catch (ProdutoNaoEncontradoException e) {
            System.out.println("Erro de negócio: " + e.getMessage());
        } finally {
            System.out.println("Encerrando busca de produto...");
        }
    }
}
