package org.example.command;

import java.util.ArrayDeque;
import java.util.Deque;

public class PainelControle {

    private final Deque<Comando> historico = new ArrayDeque<>();

    public String executar(Comando comando) {
        String resultado = comando.executar();
        historico.push(comando);
        return resultado;
    }

    public String desfazerUltimo() {
        if (historico.isEmpty()) {
            throw new IllegalStateException("Nada para desfazer");
        }
        return historico.pop().desfazer();
    }

    public int tamanhoHistorico() {
        return historico.size();
    }
}
