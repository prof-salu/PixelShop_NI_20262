package com.pixelshop.modelo;

import java.util.Objects;

public abstract class Produto {
    private String nome;
    private double preco;
    private int quantidade;

    private static int totalProdutosCadastrados = 0;

    public Produto(String nome, double preco, int quantidade){
        this.nome = nome;

        if(preco < 0){
            this.preco = 0;
        }else{
            this.preco = preco;
        }

        //Operador ternário de atribuição (IGUAL A VALIDAÇÃO ACIMA)
        this.quantidade = quantidade < 0 ? 0 : quantidade;

        //Adiciona 1 ao criar uma nova instancia de produto
        totalProdutosCadastrados++;
    }
    //GETS e SETS
    public String getNome(){
        return this.nome;
    }

    public int getQuantidade(){
        return this.quantidade;
    }

    public double getPreco(){
        return this.preco;
    }

    public static int getTotalProdutosCadastrados(){return Produto.totalProdutosCadastrados;}

    public boolean setPreco(double preco){
        if(preco > 0){
            this.preco = preco;
            return true;
        }else{
            System.out.println("O preço deve ser positivo!");
            return false;
        }
    }

    public boolean setQuantidade(int quantidade){
        if(quantidade > 0){
            this.quantidade = quantidade;
            return true;
        }else{
            System.out.println("A quantidade deve ser positiva!");
            return false;
        }
    }

    public boolean adicionarEstoque(int quantidade){
        if(quantidade > 0){
            this.quantidade += quantidade;
            return true;
        }else{
            return false;
        }
    }

    public boolean removerEstoque(int quantidade){
        if(quantidade > 0){
            this.quantidade -= quantidade;
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                ", quantidade=" + quantidade;
    }

    @Override
    public boolean equals(Object o) {
        //Caso o objeto seja nulo ou de um tipo diferente de PRODUTO, retorna FALSE
        if (o == null || getClass() != o.getClass()) return false;
        //Garante que a instancia é do tipo Produto (CASTING)
        Produto produto = (Produto) o;
        //Compara a propriedade NOME
        return Objects.equals(nome, produto.nome);
    }
}
