package main.java.br.com.digitalbank.service;

import main.java.br.com.digitalbank.model.Cliente;
import main.java.br.com.digitalbank.model.Conta;
import main.java.br.com.digitalbank.model.ContaCorrente;
import main.java.br.com.digitalbank.model.ContaPoupanca;

public class BancoService {

    public Conta criarContaCorrente(Cliente cliente){
        return new ContaCorrente(cliente);
    }

    public Conta criarContaPoupanca(Cliente cliente){
        return new ContaPoupanca(cliente);
    }

    public void depositar(Conta conta, double valor){
        conta.depositar(valor);
    }

    public void sacar(Conta conta, double valor){
        conta.sacar(valor);
    }

    public void transferir(Conta contaOrigem, Conta contaDestino, double valor){
        contaOrigem.transferir(valor, contaDestino);
    }

    public void imprimirExtrato(Conta conta){
        conta.imprimirExtrato();
    }
}
