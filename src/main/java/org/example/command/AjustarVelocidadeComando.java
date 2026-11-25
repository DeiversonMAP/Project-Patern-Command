package org.example.command;

public class AjustarVelocidadeComando implements Comando {

    private final Impressora impressora;
    private final int novaVelocidade;
    private int velocidadeAnterior;

    public AjustarVelocidadeComando(Impressora impressora, int novaVelocidade) {
        this.impressora = impressora;
        this.novaVelocidade = novaVelocidade;
    }

    @Override
    public String executar() {
        velocidadeAnterior = impressora.getVelocidadePercentual();
        impressora.setVelocidadePercentual(novaVelocidade);
        return "Velocidade: " + velocidadeAnterior + "% -> " + novaVelocidade + "%";
    }

    @Override
    public String desfazer() {
        impressora.setVelocidadePercentual(velocidadeAnterior);
        return "Velocidade restaurada para " + velocidadeAnterior + "%";
    }
}
