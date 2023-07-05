package com.contabanco;

import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        System.out.println("Por favor, digite o número da conta!");
        int numero = Integer.parseInt(scanner.nextLine());

        System.out.println("Por favor, digite a agência!");
        String agencia = scanner.nextLine();

        System.out.println("Por favor, digite o nome do titular!");
        String nomeCliente = scanner.nextLine();

        System.out.println("Por favor, digite o saldo da conta!");
        double saldo = Double.parseDouble(scanner.nextLine());

        exibeMensagemSucesso(nomeCliente, agencia, numero, saldo);
    }

    public static void exibeMensagemSucesso(String nomeCliente, String agencia,
                                            int numeroConta, double saldo) {
        var mensagem = "Olá ".concat(nomeCliente)
                .concat(", obrigado por criar uma conta em nosso banco, ")
                .concat("sua agência é ").concat(agencia)
                .concat(", conta " + numeroConta)
                .concat(" e seu saldo " + saldo)
                .concat(" já está disponível para saque");
        System.out.println(mensagem);
    }
}