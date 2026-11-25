package org.example.command;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlternarVentoinhaComandoTest {

    @Test
    void deveLigarQuandoEstavaDesligada() {
        Impressora impressora = new Impressora();
        Comando comando = new AlternarVentoinhaComando(impressora);

        assertEquals("Ventoinha ligada", comando.executar());
        assertTrue(impressora.isVentoinhaLigada());
    }

    @Test
    void deveDesligarQuandoEstavaLigada() {
        Impressora impressora = new Impressora();
        impressora.setVentoinhaLigada(true);
        Comando comando = new AlternarVentoinhaComando(impressora);

        assertEquals("Ventoinha desligada", comando.executar());
        assertFalse(impressora.isVentoinhaLigada());
    }

    @Test
    void deveDesfazerParaOEstadoAnterior() {
        Impressora impressora = new Impressora();
        Comando comando = new AlternarVentoinhaComando(impressora);
        comando.executar();

        assertEquals("Ventoinha restaurada: desligada", comando.desfazer());
        assertFalse(impressora.isVentoinhaLigada());
    }
}
