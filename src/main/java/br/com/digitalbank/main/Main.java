package main.java.br.com.digitalbank.main;

import main.java.br.com.digitalbank.model.Cliente;
import main.java.br.com.digitalbank.model.Conta;
import main.java.br.com.digitalbank.model.ContaCorrente;
import main.java.br.com.digitalbank.model.ContaPoupanca;
import main.java.br.com.digitalbank.service.BancoService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BancoService bancoService = new BancoService();
        Conta contaCorrente = null;
        Conta contaPoupanca = null;

        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite seu CPF: ");
        String cpf = scanner.nextLine();

        Cliente cliente = new Cliente(nome, cpf);

        while (true) {
            System.out.println("\n=== Banco Digital ===");
            System.out.println("1. Criar Conta Corrente");
            System.out.println("2. Criar Conta Poupança");
            System.out.println("3. Consultar Saldo");
            System.out.println("4. Depositar");
            System.out.println("5. Sacar");
            System.out.println("6. Transferir");
            System.out.println("7. Imprimir Extrato");
            System.out.println("8. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    contaCorrente = bancoService.criarContaCorrente(cliente);
                    System.out.println("Conta Corrente criada com sucesso!");
                    break;
                case 2:
                    contaPoupanca = bancoService.criarContaPoupanca(cliente);
                    System.out.println("Conta Poupança criada com sucesso!");
                    break;
                case 3:
                    if (contaCorrente != null) {
                        System.out.println("Saldo Conta Corrente: " + contaCorrente.getSaldo());
                    } else if (contaPoupanca != null) {
                        System.out.println("Saldo Conta Poupança: " + contaPoupanca.getSaldo());
                    } else {
                        System.out.println("Nenhuma conta criada.");
                    }
                    break;
                case 4:
                    System.out.println("Digite o valor para Depositar: ");
                    double valorDeposito = scanner.nextDouble();
                    if (contaCorrente != null) {
                        bancoService.depositar(contaCorrente, valorDeposito);
                        System.out.println("Depósito realizado com sucesso na Conta Corrente.");
                    } else if (contaPoupanca != null) {
                        bancoService.depositar(contaPoupanca, valorDeposito);
                        System.out.println("Depósito realizado com sucesso na Conta Poupança");
                    } else {
                        System.out.println("Nenhuma conta criada.");
                    }
                    break;
                case 5:
                    System.out.println("Digite o valor para sacar: ");
                    double valorSaque = scanner.nextDouble();
                    if (contaCorrente != null) {
                        bancoService.sacar(contaCorrente, valorSaque);
                        System.out.println("Saque realizado com sucesso na Conta Corrente.");
                    } else if (contaPoupanca != null) {
                        bancoService.sacar(contaPoupanca, valorSaque);
                        System.out.println("Saque relizado com sucesso na Conta Poupança");
                    } else {
                        System.out.println("Nenhuma conta criada.");
                    }
                    break;
                case 6:
                    System.out.println("Digite o valor para transferir: ");
                    double valorTransferencia = scanner.nextDouble();
                    if (contaCorrente != null & contaPoupanca != null) {
                        bancoService.transferir(contaCorrente, contaPoupanca, valorTransferencia);
                        System.out.println("Transferência realizada com sucesso da Conta Corrente para a Conta Poupança");
                    } else {
                        System.out.println("Ambas as contas precisam ser criadas.");
                    }
                    break;
                case 7:
                    if (contaCorrente != null) {
                        bancoService.imprimirExtrato(contaCorrente);
                    } else if (contaPoupanca != null) {
                        bancoService.imprimirExtrato(contaPoupanca);
                    } else {
                        System.out.println("Nenhuma conta criada.");
                    }
                case 8:
                    System.out.println("Saindo do aplicativo...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

        }
    }
}