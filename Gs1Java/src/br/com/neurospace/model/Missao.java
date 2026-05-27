package br.com.neurospace.model;

/**
 * Classe abstrata que representa uma missão espacial.
 */
public abstract class Missao {

    private String nomeMissao;
    private String areaImpacto;
    private String objetivo;
    private int odsRelacionada;
    private String tecnologia;
    private int prioridade;
    private int prioridadeAnterior;
    private String status;

    /**
     * Construtor vazio (sobrecarga).
     */
    public Missao() {
    }

    /**
     * Construtor parcial (sobrecarga).
     *
     * @param nomeMissao Nome da missão.
     */
    public Missao(String nomeMissao) {
        this.nomeMissao = nomeMissao;
    }

    /**
     * Construtor completo.
     */
    public Missao(String nomeMissao, String areaImpacto, String objetivo, int odsRelacionada, String tecnologia, int prioridade, String status) {
        this.nomeMissao = nomeMissao;
        this.areaImpacto = areaImpacto;
        this.objetivo = objetivo;
        this.odsRelacionada = odsRelacionada;
        this.tecnologia = tecnologia;
        this.prioridade = prioridade;
        this.prioridadeAnterior = prioridade;
        setStatus(status);
    }

    /**
     * Método abstrato para cálculo do risco.
     *
     * @return risco calculado
     */
    public abstract double calcularRisco();

    /**
     * Retorna o nome da ODS baseado no número informado.
     *
     * @return nome da ODS
     */
    public String obterNomeOds() {
        switch (odsRelacionada) {
            case 1: return "ODS 1 - Erradicação da pobreza";
            case 2: return "ODS 2 - Fome zero";
            case 3: return "ODS 3 - Saúde e bem-estar";
            case 4: return "ODS 4 - Educação de qualidade";
            case 9: return "ODS 9 - Indústria, inovação e infraestrutura";
            case 13: return "ODS 13 - Ação contra mudança do clima";
            default: return "ODS não cadastrada";
        }
    }

    public String getNomeMissao() { return nomeMissao; }
    public void setNomeMissao(String nomeMissao) { this.nomeMissao = nomeMissao; }

    public String getAreaImpacto() { return areaImpacto; }
    public void setAreaImpacto(String areaImpacto) { this.areaImpacto = areaImpacto; }

    public String getObjetivo() { return objetivo; }
    public void setObjetivo(String objetivo) { this.objetivo = objetivo; }

    public int getOdsRelacionada() { return odsRelacionada; }
    public void setOdsRelacionada(int odsRelacionada) { this.odsRelacionada = odsRelacionada; }

    public String getTecnologia() { return tecnologia; }
    public void setTecnologia(String tecnologia) { this.tecnologia = tecnologia; }

    public int getPrioridade() { return prioridade; }
    public void setPrioridade(int prioridade) { this.prioridade = prioridade; }

    public int getPrioridadeAnterior() { return prioridadeAnterior; }
    public void setPrioridadeAnterior(int prioridadeAnterior) { this.prioridadeAnterior = prioridadeAnterior; }

    public String getStatus() { return status; }

    public void setStatus(String status) {
        this.status = status;
        if (status.equalsIgnoreCase("concluída") || status.equalsIgnoreCase("concluida") || status.equalsIgnoreCase("cancelada")) {
            if (this.prioridade > 0) {
                this.prioridadeAnterior = this.prioridade;
            }
            this.prioridade = 0;
        } else if (status.equalsIgnoreCase("planejada") || status.equalsIgnoreCase("em andamento")) {
            if (this.prioridade == 0) {
                this.prioridade = this.prioridadeAnterior;
            }
        }
    }

    @Override
    public String toString() {
        return "\nNome da missão: " + nomeMissao + "\nÁrea de impacto: " + areaImpacto + "\nObjetivo: " + objetivo + "\nODS: " + obterNomeOds() + "\nTecnologia: " + tecnologia + "\nPrioridade: " + prioridade + "\nStatus: " + status;
    }
}