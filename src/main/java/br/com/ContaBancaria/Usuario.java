package br.com.ContaBancaria;

public class Usuario {
    private double saldo;
    private String nome;
    private String cpf;

    public Usuario(double saldo, String nome, String cpf) {
        this.saldo = saldo;
        this.nome = nome;
        this.cpf = cpf;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void sacar(double quantidade) {
        this.saldo -= quantidade;
    }

    public void depositar(double quantidade) {
        this.saldo += quantidade;
    }
}
