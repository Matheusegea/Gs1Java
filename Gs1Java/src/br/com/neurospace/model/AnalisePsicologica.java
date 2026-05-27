package br.com.neurospace.model;

/**
 * Representa uma análise psicológica realizada durante a missão.
 */
public class AnalisePsicologica extends Missao {

    private double estresseEmocional;
    private double isolamentoPsicologico;
    private double mudancasComportamentais;

    /**
     * Construtor completo.
     */
    public AnalisePsicologica(String nomeMissao, String areaImpacto, String objetivo, int odsRelacionada, String tecnologia, int prioridade, String status, double estresseEmocional, double isolamentoPsicologico, double mudancasComportamentais) {
        super(nomeMissao, areaImpacto, objetivo, odsRelacionada, tecnologia, prioridade, status);
        this.estresseEmocional = estresseEmocional;
        this.isolamentoPsicologico = isolamentoPsicologico;
        this.mudancasComportamentais = mudancasComportamentais;
    }

    @Override
    public double calcularRisco() {
        return (estresseEmocional + isolamentoPsicologico + mudancasComportamentais) / 3;
    }

    @Override
    public String toString() {
        return super.toString() + "\nEstresse emocional: " + estresseEmocional + "\nIsolamento psicológico: " + isolamentoPsicologico + "\nMudanças comportamentais: " + mudancasComportamentais + "\nRisco médio: " + calcularRisco();
    }

    public double getEstresseEmocional() { return estresseEmocional; }
    public void setEstresseEmocional(double estresseEmocional) { this.estresseEmocional = estresseEmocional; }

    public double getIsolamentoPsicologico() { return isolamentoPsicologico; }
    public void setIsolamentoPsicologico(double isolamentoPsicologico) { this.isolamentoPsicologico = isolamentoPsicologico; }

    public double getMudancasComportamentais() { return mudancasComportamentais; }
    public void setMudancasComportamentais(double mudancasComportamentais) { this.mudancasComportamentais = mudancasComportamentais; }
}