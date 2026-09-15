package com.pixelshop.testes;

import com.pixelshop.modelo.Produto;

public class TesteProduto {
    //Função main simplificada (desde o jdk 25)
    static void main() {
        Produto p1 = new Produto("Mouse RGB", 120, 300);
        //Erro [quantidade e preço negativo]
        Produto p2 = new Produto("Teclado Mecânico", -80, -120);

        //Exibindo os detalhes do produtos
        System.out.println("Nome: " + p1.getNome());
        System.out.println("Preço: " + p1.getPreco());
        System.out.println("Estoque: " + p1.getQuantidade());
        System.out.println();
        System.out.println("Nome: " + p2.getNome());
        System.out.println("Preço: " + p2.getPreco());
        System.out.println("Estoque: " + p2.getQuantidade());

        //Testando a alteração do estoque

        p1.setQuantidade(-1); //Erro [quantidade negativa]
        System.out.println("Estoque [mouse]: " + p1.getQuantidade());

        p2.adicionarEstoque(120);
        System.out.println("Estoque [teclado]: " + p2.getQuantidade());

        p1.removerEstoque(30);
        System.out.println("Estoque [mouse]: " + p1.getQuantidade());
    }
}
