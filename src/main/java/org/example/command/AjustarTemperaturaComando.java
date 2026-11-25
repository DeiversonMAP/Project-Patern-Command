package org.example.command;

public class AjustarTemperaturaComando implements Comando {

    private final Impressora impressora;
    private final int novaTemperatura;
    private int temperaturaAnterior;

    public AjustarTemperaturaComando(Impressora impressora, int novaTemperatura) {
        this.impressora = impressora;
        this.novaTemperatura = novaTemperatura;
    }

    @Override
    public String executar() {
        temperaturaAnterior = impressora.getTemperaturaBico();
        impressora.setTemperaturaBico(novaTemperatura);
        return "Bico: " + temperaturaAnterior + " -> " + novaTemperatura;
    }

    @Override
    public String desfazer() {
        impressora.setTemperaturaBico(temperaturaAnterior);
        return "Bico restaurado para " + temperaturaAnterior;
    }
}
