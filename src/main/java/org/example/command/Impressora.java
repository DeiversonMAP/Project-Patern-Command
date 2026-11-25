package org.example.command;

public class Impressora {

    private static final int TEMPERATURA_AMBIENTE = 25;
    private static final int VELOCIDADE_PADRAO = 100;

    private int temperaturaBico = TEMPERATURA_AMBIENTE;
    private int velocidadePercentual = VELOCIDADE_PADRAO;
    private boolean ventoinhaLigada;

    public int getTemperaturaBico() {
        return temperaturaBico;
    }

    public void setTemperaturaBico(int temperaturaBico) {
        this.temperaturaBico = temperaturaBico;
    }

    public int getVelocidadePercentual() {
        return velocidadePercentual;
    }

    public void setVelocidadePercentual(int velocidadePercentual) {
        this.velocidadePercentual = velocidadePercentual;
    }

    public boolean isVentoinhaLigada() {
        return ventoinhaLigada;
    }

    public void setVentoinhaLigada(boolean ventoinhaLigada) {
        this.ventoinhaLigada = ventoinhaLigada;
    }
}
