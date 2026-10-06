package com.pixelshop.testes;

import com.pixelshop.modelo.JogoDigital;
import com.pixelshop.modelo.JogoFisico;
import com.pixelshop.modelo.Produto;

public class TesteProduto {
    //Função main simplificada (desde o jdk 25)
    static void main() {
        Produto p1 = new JogoDigital("GTA VI", 380, 300, 150);
        //Erro [quantidade e preço negativo]
        Produto p2 = new JogoFisico("Tekken 8", 300, 120, "PS5", true);

        //Exibindo os detalhes do produtos
        System.out.println(p1);
        System.out.println(p2);

        //Testando a alteração do estoque
        p1.setQuantidade(-1); //Erro [quantidade negativa]
        System.out.println("Estoque [GTA VI]: " + p1.getQuantidade());

        p2.adicionarEstoque(120);
        System.out.println("Estoque [Tekken 8]: " + p2.getQuantidade());

        p1.removerEstoque(30);
        System.out.println("Estoque [GTA VI]: " + p1.getQuantidade());
    }
}
