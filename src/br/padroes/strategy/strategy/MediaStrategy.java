package br.padroes.strategy.strategy;

/**
 * Interface que define o contrato para estratégias de cálculo de média
 */
public interface MediaStrategy {
    /**
     * Calcula a média baseada nas notas P1 e P2
     * @param p1 nota da primeira avaliação
     * @param p2 nota da segunda avaliação
     * @return média calculada
     */
    double calcularMedia(double p1, double p2);
    
    /**
     * Verifica a situação do aluno baseada na média
     * @param media média calculada
     * @return "Aprovado" ou "Reprovado"
     */
    String verificarSituacao(double media);
}