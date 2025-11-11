package br.com.ContaBancaria;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ContaBancaria {
    private String titular;
    private String cpf;
    private Usuario usuario;

    public ContaBancaria(String titular, String cpf, double saldoInicial) {
        this.titular = titular;
        this.cpf = cpf;
        this.usuario = new Usuario(saldoInicial, titular, cpf);
    }

    public void iniciar() {
        Scanner sc = new Scanner(System.in);
        int opc = 0;
        double quantia;

        try {
            while (true) {
                System.out.println("\n======== Conta Bancária ========");
                System.out.println("Titular: " + usuario.getNome());
                System.out.println("CPF: " + usuario.getCpf());
                System.out.printf("Saldo atual: R$ %.2f%n", usuario.getSaldo());
                System.out.println("1 - Sacar");
                System.out.println("2 - Depositar");
                System.out.println("3 - Sair");
                System.out.print("Escolha: ");

                opc = sc.nextInt();

                switch (opc) {
                    case 1:
                        System.out.print("Valor para saque: ");
                        quantia = sc.nextDouble();

                        if (quantia > usuario.getSaldo()) {
                            System.out.println("Saldo insuficiente!");
                        } else {
                            usuario.sacar(quantia);
                            System.out.println("Saque realizado com sucesso!");
                        }
                        break;

                    case 2:
                        System.out.print("Valor para depósito: ");
                        quantia = sc.nextDouble();
                        usuario.depositar(quantia);
                        System.out.println("Depósito realizado com sucesso!");
                        break;

                    case 3:
                        System.out.println("Encerrando...");
                        return;

                    default:
                        System.out.println("Opção inválida!");
                }
            }

        } catch (InputMismatchException e) {
            System.out.println("Erro: entrada inválida! Use apenas números.");
        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("======== Cadastro Inicial ========");
            System.out.print("Digite seu nome: ");
            String nome = sc.nextLine();
            System.out.print("Digite seu CPF: ");
            String cpf = sc.nextLine();

            ContaBancaria conta = new ContaBancaria(nome, cpf, 1000.0);
            conta.iniciar();

        } catch (Exception e) {
            System.out.println("Erro ao criar conta: " + e.getMessage());
        }
    }
}
