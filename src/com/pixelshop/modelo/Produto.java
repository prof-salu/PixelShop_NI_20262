package com.pixelshop.modelo;

public class Produto {
    private String nome;
    private double preco;
    private int quantidade;

    public Produto(String nome, double preco, int quantidade){
        this.nome = nome;

        if(preco < 0){
            this.preco = 0;
        }else{
            this.preco = preco;
        }

        //Operador ternário de atribuição (IGUAL A VALIDAÇÃO ACIMA)
        this.quantidade = quantidade < 0 ? 0 : quantidade;
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
}
