package org.example.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MacroComandoTest {

    private Impressora impressora;
    private MacroComando preAquecer;

    @BeforeEach
    void montarMacro() {
        impressora = new Impressora();
        preAquecer = new MacroComando("Pre-aquecer", Arrays.asList(
                new AjustarTemperaturaComando(impressora, 210),
                new AjustarVelocidadeComando(impressora, 50),
                new AlternarVentoinhaComando(impressora)
        ));
    }

    @Test
    void deveGuardarONome() {
        assertEquals("Pre-aquecer", preAquecer.getNome());
    }

    @Test
    void deveExecutarTodosOsComandosNaOrdem() {
        String resultado = preAquecer.executar();

        assertEquals("Bico: 25 -> 210; Velocidade: 100% -> 50%; Ventoinha ligada", resultado);
        assertEquals(210, impressora.getTemperaturaBico());
        assertEquals(50, impressora.getVelocidadePercentual());
        assertTrue(impressora.isVentoinhaLigada());
    }

    @Test
    void deveDesfazerEmOrdemInversa() {
        preAquecer.executar();

        String resultado = preAquecer.desfazer();

        assertEquals(
                "Ventoinha restaurada: desligada; Velocidade restaurada para 100%; Bico restaurado para 25",
                resultado
        );
        assertEquals(25, impressora.getTemperaturaBico());
        assertEquals(100, impressora.getVelocidadePercentual());
        assertFalse(impressora.isVentoinhaLigada());
    }

    @Test
    void macroVaziaNaoDeveFazerNada() {
        MacroComando vazia = new MacroComando("Vazia", Arrays.asList());

        assertEquals("", vazia.executar());
        assertEquals("", vazia.desfazer());
    }
}
