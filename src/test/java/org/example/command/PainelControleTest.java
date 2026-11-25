package org.example.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PainelControleTest {

    private Impressora impressora;
    private PainelControle painel;

    @BeforeEach
    void montarPainel() {
        impressora = new Impressora();
        painel = new PainelControle();
    }

    @Test
    void deveExecutarEGuardarNoHistorico() {
        String resultado = painel.executar(new AjustarTemperaturaComando(impressora, 200));

        assertEquals("Bico: 25 -> 200", resultado);
        assertEquals(1, painel.tamanhoHistorico());
    }

    @Test
    void deveDesfazerSempreOUltimoComando() {
        painel.executar(new AjustarTemperaturaComando(impressora, 200));
        painel.executar(new AjustarVelocidadeComando(impressora, 70));

        assertEquals("Velocidade restaurada para 100%", painel.desfazerUltimo());
        assertEquals(100, impressora.getVelocidadePercentual());
        assertEquals(200, impressora.getTemperaturaBico());

        assertEquals("Bico restaurado para 25", painel.desfazerUltimo());
        assertEquals(25, impressora.getTemperaturaBico());
        assertEquals(0, painel.tamanhoHistorico());
    }

    @Test
    void deveDesfazerUmaMacroInteira() {
        painel.executar(new MacroComando("Pre-aquecer", java.util.Arrays.asList(
                new AjustarTemperaturaComando(impressora, 210),
                new AlternarVentoinhaComando(impressora)
        )));

        painel.desfazerUltimo();

        assertEquals(25, impressora.getTemperaturaBico());
        assertFalse(impressora.isVentoinhaLigada());
    }

    @Test
    void deveLancarExcecaoQuandoNaoHaNadaParaDesfazer() {
        IllegalStateException excecao = assertThrows(
                IllegalStateException.class,
                painel::desfazerUltimo
        );
        assertEquals("Nada para desfazer", excecao.getMessage());
    }
}
