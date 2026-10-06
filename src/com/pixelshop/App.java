package com.pixelshop;

import com.pixelshop.modelo.JogoDigital;
import com.pixelshop.modelo.JogoFisico;
import com.pixelshop.modelo.Produto;
import com.pixelshop.modelo.Promovivel;

import java.util.Scanner;

public class App {
    static void main() {
        Scanner entrada = new Scanner(System.in);
        Produto p1 = new JogoDigital("Rainbow Six", 19.90, 1000, 100);
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
            System.out.println("6- Aplicar descontos");
            System.out.println("7- Total de jogos cadastrados");
            System.out.println("8- Sair");

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

                        System.out.println("Jogo digital? [S, N]");
                        String digital = entrada.nextLine();

                        if(digital.equalsIgnoreCase("S")){
                            System.out.println("Tamanho do jogo em GBs: ");
                            int tamanho = Integer.parseInt(entrada.nextLine());

                            p2 = new JogoDigital(nome, preco, quantidade, tamanho);
                            if(!p1.equals(p2)){
                                System.out.println("Produto cadastrado com sucesso!");
                            }else{
                                p2 = null;
                                System.out.println("Jogo já cadastrado");
                            }

                        }else if(digital.equalsIgnoreCase("N")){
                            System.out.print("Plataforma: ");
                            String plataforma = entrada.nextLine();
                            System.out.println("Tem manual? [S, N]");
                            String manual = entrada.nextLine();
                            p2 = new JogoFisico(nome, preco, quantidade, plataforma, manual.equalsIgnoreCase("S"));
                            if(!p1.equals(p2)){

                            }else{
                                System.out.println("Produto cadastrado com sucesso!");
                            }
                                p2 = null;
                                System.out.println("Jogo já cadastrado");
                        }else{
                            System.out.println("Opção inválida, tente novamente.");
                        }
                    }else{
                        System.out.println("O estoque da loja está lotada...");
                    }
                }
                case 2 -> {
                    System.out.println("*** Consulta produto ***");
                    System.out.print("Informe o nome do produto: ");
                    String busca = entrada.nextLine();
                    if(p1.getNome().equalsIgnoreCase(busca)){
                        System.out.println(p1);
                    }else if(p2 != null && p2.getNome().equalsIgnoreCase(busca)){
                        System.out.println(p2);
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
                case 6 -> {
                    System.out.println("*** Aplicar descontos ***");
                    if(p2 != null && p2 instanceof Promovivel){
                        ((JogoDigital) p2).aplicarDesconto(5);
                        System.out.println("Desconto aplicado com sucesso.");
                    }else{
                        System.out.println("Nenhum produto elegivel.");
                    }
                }

                case 7 -> System.out.println("Jogos cadastrados no sistema: " + Produto.getTotalProdutosCadastrados());
                case 8 -> System.out.println("Encerrando o sistema...");
                default -> System.out.println("Opção inválida. Tente Novamente");
            }
        }while(opcao != 8);
        //Encerrando o Scanner
        entrada.close();
    }
}
