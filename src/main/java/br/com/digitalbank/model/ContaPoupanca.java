package main.java.br.com.digitalbank.model;

public class ContaPoupanca extends Conta{

    public ContaPoupanca(Cliente cliente){
        super(cliente);
    }

    @Override
    public void imprimirExtrato(){
        System.out.println("=== Extrato Conta Poupança ===");
        System.out.println("Agência: " + super.getAgencia());
        System.out.println("Número: " + super.getNumero());
        System.out.println("Saldo: " + super.getSaldo());
    }
}
