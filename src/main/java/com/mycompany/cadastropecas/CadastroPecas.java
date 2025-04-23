/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.cadastropecas;

/**
 *
 * @author CaioBraz
 */
import java.util.ArrayList;
import java.util.Scanner;

class Peca {
    int id;
    int quantidade;

    Peca(int id, int quantidade) {
        this.id = id;
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Quantidade: " + quantidade;
    }
}

public class CadastroPecas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Peca> aprovadas = new ArrayList<>();
        ArrayList<Peca> ajustar = new ArrayList<>();
        ArrayList<Peca> sucata = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            System.out.println("\nCadastro da peça " + (i + 1));
            Peca peca = cadastrarPeca(scanner);
            int acao = solicitarAcao(scanner);
            armazenarPeca(peca, acao, aprovadas, ajustar, sucata);
        }

        exibirLista("Peças Aprovadas", aprovadas);
        exibirLista("Peças a Ajustar", ajustar);
        exibirLista("Peças Sucatadas", sucata);

        scanner.close();
    }

    public static Peca cadastrarPeca(Scanner scanner) {
        int id = solicitarInteiro(scanner, "Digite o identificador da peça (inteiro positivo): ", 1, Integer.MAX_VALUE);
        int qtd = solicitarInteiro(scanner, "Digite a quantidade produzida (0 a 100): ", 0, 100);
        return new Peca(id, qtd);
    }

    public static int solicitarAcao(Scanner scanner) {
        System.out.println("Ação futura da peça:");
        System.out.println("1 — Aprovar");
        System.out.println("2 — Ajustar");
        System.out.println("3 — Sucatar");
        return solicitarInteiro(scanner, "Escolha a opção (1, 2 ou 3): ", 1, 3);
    }

    public static int solicitarInteiro(Scanner scanner, String mensagem, int minimo, int maximo) {
        int valor;
        while (true) {
            System.out.print(mensagem);
            if (scanner.hasNextInt()) {
                valor = scanner.nextInt();
                if (valor >= minimo && valor <= maximo) {
                    return valor;
                } else {
                    System.out.println("Valor fora do intervalo permitido.");
                }
            } else {
                System.out.println("Entrada inválida. Digite um número inteiro.");
                scanner.next();
            }
        }
    }

    public static void armazenarPeca(Peca peca, int acao, ArrayList<Peca> aprovadas, ArrayList<Peca> ajustar, ArrayList<Peca> sucata) {
        switch (acao) {
            case 1 -> aprovadas.add(peca);
            case 2 -> ajustar.add(peca);
            case 3 -> sucata.add(peca);
        }
    }

    public static void exibirLista(String titulo, ArrayList<Peca> lista) {
        System.out.println("\n--- " + titulo + " ---");
        if (lista.isEmpty()) {
            System.out.println("Nenhuma peça.");
        } else {
            for (Peca p : lista) {
                System.out.println(p);
            }
        }
    }
}
