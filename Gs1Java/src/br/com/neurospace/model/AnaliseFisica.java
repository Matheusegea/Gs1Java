package br.com.neurospace.model;

/**
 * Representa uma análise física realizada durante a missão.
 */
public class AnaliseFisica extends Missao {

    private double alteracaoSono;
    private double fadigaCognitiva;
    private double perdaMuscular;

    /**
     * Construtor completo.
     */
    public AnaliseFisica(String nomeMissao, String areaImpacto, String objetivo, int odsRelacionada, String tecnologia, int prioridade, String status, double alteracaoSono, double fadigaCognitiva, double perdaMuscular) {
        super(nomeMissao, areaImpacto, objetivo, odsRelacionada, tecnologia, prioridade, status);
        this.alteracaoSono = alteracaoSono;
        this.fadigaCognitiva = fadigaCognitiva;
        this.perdaMuscular = perdaMuscular;
    }

    @Override
    public double calcularRisco() {
        return (alteracaoSono + fadigaCognitiva + perdaMuscular) / 3;
    }

    @Override
    public String toString() {
        return super.toString() + "\nAlteração do sono: " + alteracaoSono + "\nFadiga cognitiva: " + fadigaCognitiva + "\nPerda muscular: " + perdaMuscular + "\nRisco médio: " + calcularRisco();
    }

    public double getAlteracaoSono() { return alteracaoSono; }
    public void setAlteracaoSono(double alteracaoSono) { this.alteracaoSono = alteracaoSono; }

    public double getFadigaCognitiva() { return fadigaCognitiva; }
    public void setFadigaCognitiva(double fadigaCognitiva) { this.fadigaCognitiva = fadigaCognitiva; }

    public double getPerdaMuscular() { return perdaMuscular; }
    public void setPerdaMuscular(double perdaMuscular) { this.perdaMuscular = perdaMuscular; }
}