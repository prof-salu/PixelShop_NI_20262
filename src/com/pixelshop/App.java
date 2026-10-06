package com.pixelshop;

import com.pixelshop.modelo.Produto;

import java.util.Scanner;

public class App {
    static void main() {
        Scanner entrada = new Scanner(System.in);
        Produto p1 = new Produto("Processador I7", 1200, 30);
        Produto p2 = null;
        int opcao;

        System.out.println("***** Bem-vindo ao PIXEL SHOP *****");
        do{
            System.out.println("Escolha uma das opções a seguir: ");
            System.out.println("1- Cadastrar produto");
            System.out.println("2- Consultar produto");
            System.out.println("3- Adicionar produto no estoque");
            System.out.println("4- Remover produto no estoque");
            System.out.println("5- Alterar preço");
            System.out.println("6- Sair");

            System.out.print("\nOpção: ");
            opcao = Integer.parseInt(entrada.nextLine());

            switch(opcao){
                case 1 -> {
                    System.out.println("*** Cadastro de produto ***");
                    if(p2 == null){
                        System.out.print("Nome: ");
                        String nome = entrada.nextLine();
                        System.out.print("Preço: ");
                        double preco = Double.parseDouble(entrada.nextLine());
                        System.out.print("Quantidade: ");
                        int quantidade = Integer.parseInt(entrada.nextLine());
                        p2 = new Produto(nome, preco, quantidade);
                        System.out.println("Produto cadastrado com sucesso!");
                    }else{
                        System.out.println("O estoque da loja está lotada...");
                    }
                }
                case 2 -> {
                    System.out.println("*** Consulta produto ***");
                    System.out.print("Informe o nome do produto: ");
                    String busca = entrada.nextLine();
                    if(p1.getNome().equalsIgnoreCase(busca)){
                        System.out.println("Valor total: R$" +
                                        (p1.getQuantidade() * p1.getPreco()));
                    }else if(p2 != null && p2.getNome().equalsIgnoreCase(busca)){
                        System.out.println("Valor total: R$" +
                                (p1.getQuantidade() * p2.getPreco()));
                    }else{
                        System.out.println("Produto não encontrado");
                    }
                }
                case 3 -> {
                    System.out.println("*** Adicionar ao estoque ***");
                    System.out.print("Informe o nome do produto: ");
                    String busca = entrada.nextLine();
                    if(p1.getNome().equalsIgnoreCase(busca)){
                        System.out.print("Informe a quantidade: ");
                        int quantidade = Integer.parseInt(entrada.nextLine());
                        p1.adicionarEstoque(quantidade);
                        System.out.println("Produto adicionado ao estoque");
                        //Sempre verifique se o valor for nulo PRIMEIRO
                    }else if(p2 != null && p2.getNome().equalsIgnoreCase(busca)){
                        System.out.print("Informe a quantidade: ");
                        int quantidade = Integer.parseInt(entrada.nextLine());
                        p2.adicionarEstoque(quantidade);
                        System.out.println("Produto adicionado ao estoque");
                    }else{
                        System.out.println("Produto não encontrado");
                    }
                }
                case 4 -> {
                    System.out.println("*** Remover do estoque ***");
                    System.out.print("Informe o nome do produto: ");
                    String busca = entrada.nextLine();
                    if(p1.getNome().equalsIgnoreCase(busca)){
                        System.out.print("Informe a quantidade: ");
                        int quantidade = Integer.parseInt(entrada.nextLine());
                        p1.removerEstoque(quantidade);
                        System.out.println("Produto removido do estoque");
                        //Sempre verifique se o valor for nulo PRIMEIRO
                    }else if(p2 != null && p2.getNome().equalsIgnoreCase(busca)){
                        System.out.print("Informe a quantidade: ");
                        int quantidade = Integer.parseInt(entrada.nextLine());
                        p2.removerEstoque(quantidade);
                        System.out.println("Produto removido do estoque");
                    }else{
                        System.out.println("Produto não encontrado");
                    }
                }
                case 5 -> {System.out.println("*** Alterar preço ***");
                    System.out.print("Informe o nome do produto: ");
                    String busca = entrada.nextLine();
                    if(p1.getNome().equalsIgnoreCase(busca)){
                        System.out.print("Informe o novo preço: ");
                        double preco = Double.parseDouble(entrada.nextLine());
                        p1.setPreco(preco);
                        System.out.println("Produto alterado");
                        //Sempre verifique se o valor for nulo PRIMEIRO
                    }else if(p2 != null && p2.getNome().equalsIgnoreCase(busca)){
                        System.out.print("Informe o novo preço: ");
                        double preco = Double.parseDouble(entrada.nextLine());
                        p2.setPreco(preco);
                        System.out.println("Produto alterado");
                    }else{
                        System.out.println("Produto não encontrado");
                    }
                }
                case 6 -> System.out.println("Encerrando o sistema...");
                default -> System.out.println("Opção inválida. Tente Novamente");
            }
        }while(opcao != 6);
        //Encerrando o Scanner
        entrada.close();
    }
}
