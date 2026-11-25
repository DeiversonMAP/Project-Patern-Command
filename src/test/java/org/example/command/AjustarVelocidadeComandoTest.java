package org.example.command;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AjustarVelocidadeComandoTest {

    @Test
    void deveAjustarAVelocidade() {
        Impressora impressora = new Impressora();
        Comando comando = new AjustarVelocidadeComando(impressora, 60);

        assertEquals("Velocidade: 100% -> 60%", comando.executar());
        assertEquals(60, impressora.getVelocidadePercentual());
    }

    @Test
    void deveDesfazerParaAVelocidadeAnterior() {
        Impressora impressora = new Impressora();
        Comando comando = new AjustarVelocidadeComando(impressora, 60);
        comando.executar();

        assertEquals("Velocidade restaurada para 100%", comando.desfazer());
        assertEquals(100, impressora.getVelocidadePercentual());
    }
}
