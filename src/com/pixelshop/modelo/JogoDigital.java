package com.pixelshop.modelo;

public class JogoDigital extends Produto implements Promovivel{
    private int tamanhoArquivoGB;

    public JogoDigital(String nome, double preco, int quantidade, int tamanhoArquivoGB) {
        super(nome, preco, quantidade);
        this.tamanhoArquivoGB = tamanhoArquivoGB;
    }

    public int getTamanhoArquivoGB() {
        return tamanhoArquivoGB;
    }

    public void setTamanhoArquivoGB(int tamanhoArquivoGB) {
        this.tamanhoArquivoGB = tamanhoArquivoGB;
    }

    @Override
    public String toString() {
        return "JogoDigital" + super.toString() + ", tamanhoArquivoGB=" + tamanhoArquivoGB +
                "}";
    }

    @Override
    public void aplicarDesconto(double desconto) {
        setPreco(getPreco() - (getPreco() * desconto) / 100);
    }
}
