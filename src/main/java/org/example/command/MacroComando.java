package org.example.command;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MacroComando implements Comando {

    private static final String SEPARADOR = "; ";

    private final String nome;
    private final List<Comando> comandos;

    public MacroComando(String nome, List<Comando> comandos) {
        this.nome = nome;
        this.comandos = new ArrayList<>(comandos);
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String executar() {
        List<String> resultados = new ArrayList<>();
        for (Comando comando : comandos) {
            resultados.add(comando.executar());
        }
        return String.join(SEPARADOR, resultados);
    }

    @Override
    public String desfazer() {
        List<Comando> invertidos = new ArrayList<>(comandos);
        Collections.reverse(invertidos);
        List<String> resultados = new ArrayList<>();
        for (Comando comando : invertidos) {
            resultados.add(comando.desfazer());
        }
        return String.join(SEPARADOR, resultados);
    }
}
