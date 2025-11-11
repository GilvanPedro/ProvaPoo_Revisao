package br.com.ValidacaoDeDominio;

import java.util.Scanner;

public class CadastroAluno {

    public static int parseIntSeguro(String valor) {
        try {
            return Integer.parseInt(valor);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Erro ao converter a idade para número inteiro.", e);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Digite o nome do aluno: ");
            String nome = sc.nextLine();

            System.out.print("Digite a idade: ");
            String idadeStr = sc.nextLine();

            int idade = parseIntSeguro(idadeStr);

            Aluno aluno = new Aluno(nome, idade);

            System.out.println("\nAluno cadastrado com sucesso!");
            System.out.println("Nome: " + aluno.getNome());
            System.out.println("Idade: " + aluno.getIdade());

        } catch (IllegalArgumentException e) {
            System.out.println("Erro de validação: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Erro inesperado: " + e.getMessage());
            if (e.getCause() != null) {
                System.out.println("Causa original: " + e.getCause());
            }
        } finally {
            System.out.println("Finalizando programa...");
            sc.close();
        }
    }
}
