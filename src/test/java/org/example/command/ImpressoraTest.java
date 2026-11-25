package org.example.command;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImpressoraTest {

    @Test
    void deveComecarComValoresPadrao() {
        Impressora impressora = new Impressora();

        assertEquals(25, impressora.getTemperaturaBico());
        assertEquals(100, impressora.getVelocidadePercentual());
        assertFalse(impressora.isVentoinhaLigada());
    }

    @Test
    void deveGuardarNovosValores() {
        Impressora impressora = new Impressora();

        impressora.setTemperaturaBico(210);
        impressora.setVelocidadePercentual(80);
        impressora.setVentoinhaLigada(true);

        assertEquals(210, impressora.getTemperaturaBico());
        assertEquals(80, impressora.getVelocidadePercentual());
        assertTrue(impressora.isVentoinhaLigada());
    }
}
