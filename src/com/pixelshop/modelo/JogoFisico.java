package com.pixelshop.modelo;

public class JogoFisico extends Produto{
    private String plataforma;
    private boolean manualImpresso;

    public JogoFisico(String nome, double preco, int quantidade,
                      String plataforma, boolean manualImpresso) {
        super(nome, preco, quantidade);
        this.plataforma = plataforma;
        this.manualImpresso = manualImpresso;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public boolean getManualImpresso() {
        return manualImpresso;
    }

    public void setManualImpresso(boolean manualImpresso) {
        this.manualImpresso = manualImpresso;
    }

    @Override
    public String toString() {
        return "JogoFisico" + super.toString() + ", plataforma='" + plataforma + '\'' +
                ", manualImpresso=" + manualImpresso +
                "}";
    }
}
