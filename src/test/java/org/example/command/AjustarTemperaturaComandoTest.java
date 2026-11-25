package org.example.command;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AjustarTemperaturaComandoTest {

    @Test
    void deveAjustarATemperaturaDoBico() {
        Impressora impressora = new Impressora();
        Comando comando = new AjustarTemperaturaComando(impressora, 210);

        assertEquals("Bico: 25 -> 210", comando.executar());
        assertEquals(210, impressora.getTemperaturaBico());
    }

    @Test
    void deveDesfazerParaATemperaturaAnterior() {
        Impressora impressora = new Impressora();
        impressora.setTemperaturaBico(180);
        Comando comando = new AjustarTemperaturaComando(impressora, 210);
        comando.executar();

        assertEquals("Bico restaurado para 180", comando.desfazer());
        assertEquals(180, impressora.getTemperaturaBico());
    }
}
