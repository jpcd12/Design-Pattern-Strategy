package br.padroes.strategy.app;

import br.padroes.strategy.model.Disciplina;
import br.padroes.strategy.strategy.Aritmetica;
import br.padroes.strategy.strategy.Geometrica;
import br.padroes.strategy.strategy.MediaStrategy;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Locale ptBr = Locale.forLanguageTag("pt-BR");

        System.out.println("=== MÉDIA ARITMÉTICA ===");
        testarEstrategia(new Aritmetica(), ptBr);

        System.out.println("\n=== MÉDIA GEOMÉTRICA ===");
        testarEstrategia(new Geometrica(), ptBr);
    }

    private static void testarEstrategia(MediaStrategy estrategia, Locale locale) {
        Disciplina d = new Disciplina(estrategia);
        d.setNome("Padrões de Desenvolvimento");
        d.setP1(10);
        d.setP2(5);
        d.calcularMedia();

        System.out.printf(locale, "P1: %.2f  P2: %.2f  Média: %.2f  Situação: %s%n",
                d.getP1(), d.getP2(), d.getMedia(), d.getSituacao());
    }
}