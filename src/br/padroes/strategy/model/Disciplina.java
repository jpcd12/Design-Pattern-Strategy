package br.padroes.strategy.model;

import br.padroes.strategy.strategy.MediaStrategy;

public class Disciplina {
    private String nome;
    private double p1;
    private double p2;
    private double media;
    private String situacao;
    private MediaStrategy estrategia;

    public Disciplina(MediaStrategy estrategia) {
        if (estrategia == null) {
            throw new IllegalArgumentException("Estratégia não pode ser nula");
        }
        this.estrategia = estrategia;
    }

    public void calcularMedia() {
        this.media = this.estrategia.calcularMedia(this.p1, this.p2);
        this.situacao = this.estrategia.verificarSituacao(this.media);
    }

    // Getters e setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getP1() {
        return p1;
    }

    public void setP1(double p1) {
        validarNota(p1);
        this.p1 = p1;
    }

    public double getP2() {
        return p2;
    }

    public void setP2(double p2) {
        validarNota(p2);
        this.p2 = p2;
    }

    public double getMedia() {
        return media;
    }

    public String getSituacao() {
        return situacao;
    }

    // estratégia pode ser alterada em tempo de execução
    public MediaStrategy getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(MediaStrategy estrategia) {
        if (estrategia == null) {
            throw new IllegalArgumentException("Estratégia não pode ser nula");
        }
        this.estrategia = estrategia;
    }

    private void validarNota(double nota) {
        if (nota < 0.0 || nota > 10.0) {
            throw new IllegalArgumentException("Nota deve estar entre 0 e 10");
        }
    }
}