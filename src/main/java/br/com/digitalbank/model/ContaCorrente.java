package main.java.br.com.digitalbank.model;

public class ContaCorrente extends Conta{

    public ContaCorrente(Cliente cliente){
        super(cliente);
    }

    @Override
    public void imprimirExtrato(){
        System.out.println("=== Extrato Conta Corrente ===");
        System.out.println("Agência: " + super.getAgencia());
        System.out.println("Número: " + super.getNumero());
        System.out.println("Saldo: " + super.getSaldo());
    }
}
