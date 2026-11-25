package org.example.command;

public class AlternarVentoinhaComando implements Comando {

    private final Impressora impressora;
    private boolean estavaLigada;

    public AlternarVentoinhaComando(Impressora impressora) {
        this.impressora = impressora;
    }

    @Override
    public String executar() {
        estavaLigada = impressora.isVentoinhaLigada();
        impressora.setVentoinhaLigada(!estavaLigada);
        return estavaLigada ? "Ventoinha desligada" : "Ventoinha ligada";
    }

    @Override
    public String desfazer() {
        impressora.setVentoinhaLigada(estavaLigada);
        return estavaLigada ? "Ventoinha restaurada: ligada" : "Ventoinha restaurada: desligada";
    }
}
