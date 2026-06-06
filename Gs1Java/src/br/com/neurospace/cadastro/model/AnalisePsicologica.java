package br.com.neurospace.cadastro.model;

/**
 * Representa uma análise psicológica realizada durante a missão espacial.
 * Esta subclasse estende a classe abstrata Missao, adicionando parâmetros de 
 * monitoramento mental, comportamental e de socialização dos astronautas no 
 * ambiente de base terrestre e os dados de eficiência coletados em órbita (pós-viagem).
 * * @author Matheus Egea / RM:563490
 * @version 1.0
 */
public class AnalisePsicologica extends Missao {

    /** Dados de Saúde Inicial na Terra: Nota atribuída à estabilidade emocional do astronauta. */
    private double estabilidadeEmocional;
    
    /** Dados de Saúde Inicial na Terra: Nota atribuída ao índice de socialização de base. */
    private double socializacaoBase;
    
    /** Dados de Saúde Inicial na Terra: Nota atribuída ao foco comportamental de base. */
    private double focoComportamental;

    /** Dados de Pós-Viagem: Taxa percentual de eficiência da estabilidade emocional registrada no espaço. */
    private double estresseEmocionalPos;
    
    /** Dados de Pós-Viagem: Taxa percentual de eficiência da socialização registrada no espaço. */
    private double isolamentoPsicologicoPos;
    
    /** Dados de Pós-Viagem: Taxa percentual de eficiência do foco comportamental registrada no espaço. */
    private double mudancasComportamentaisPos;

    /**
     * Construtor completo da classe AnalisePsicologica.
     * Invoca o construtor da superclasse para inicializar as propriedades comuns da missão 
     * e define os atributos específicos relacionados à saúde mental e comportamental inicial.
     * * @param nomeMissao O nome único identificador do projeto da missão.
     * @param areaImpacto A área social ou ambiental beneficiada pelo projeto.
     * @param objetivo A descrição da finalidade e metas da missão.
     * @param odsRelacionada O número identificador do ODS vinculado.
     * @param tecnologia A descrição tecnológica ou o aparato técnico empregado.
     * @param prioridade O grau de prioridade estabelecido no escopo (escala de 1 a 10).
     * @param status O estado operacional inicial do projeto no sistema.
     * @param estabilidadeEmocional A nota para a estabilidade emocional inicial medida na Terra.
     * @param socializacaoBase A nota para o índice de socialização de base medido na Terra.
     * @param focoComportamental A nota para o foco comportamental de base medido na Terra.
     */
    public AnalisePsicologica(String nomeMissao, String areaImpacto, String objetivo, int odsRelacionada, String tecnologia, int prioridade, String status, double estabilidadeEmocional, double socializacaoBase, double focoComportamental) {
        super(nomeMissao, areaImpacto, objetivo, odsRelacionada, tecnologia, prioridade, status);
        this.estabilidadeEmocional = estabilidadeEmocional;
        this.socializacaoBase = socializacaoBase;
        this.focoComportamental = focoComportamental;
    }

    /**
     * Calculates the risk index or loss of psychological integrity based on flight progress.
     * Caso o projeto esteja com status Concluída ou Em andamento, o risco corresponde à média matemática 
     * das alterações mentais registradas em órbita. Se estiver em fase de Planejamento, estima o risco 
     * de forma inversamente proporcional à robustez da saúde psicológica inicial medida em ambiente terrestre.
     * * @return O valor numérico que representa o índice de risco calculado para a integridade mental do astronauta.
     */
    @Override
    public double calcularRisco() {
        if (this.getStatus().equalsIgnoreCase("concluída") || this.getStatus().equalsIgnoreCase("concluida")) {
            return (estresseEmocionalPos + isolamentoPsicologicoPos + mudancasComportamentaisPos) / 3;
        }
        return (10 - estabilidadeEmocional + (10 - socializacaoBase) + (10 - focoComportamental)) / 3;
    }

    /**
     * Sobrescreve o método de representação textual, consolidando as propriedades estruturais da 
     * missão espacial contidas na superclasse e anexando os blocos informativos de saúde mental 
     * inicial, os dados dinâmicos pós-viagem e o índice final de risco.
     * * @return Uma String formatada contendo todos os dados e métricas psicológicas associados à missão.
     */
    @Override
    public String toString() {
        String resultado = super.toString() + 
               "\n--- SAÚDE PSICOLÓGICA INICIAL (NA TERRA) ---" +
               "\nEstabilidade emocional: " + estabilidadeEmocional + 
               "\nÍndice de socialização: " + socializacaoBase + 
               "\nFoco comportamental: " + focoComportamental;

        if (this.getStatus().equalsIgnoreCase("concluída") || this.getStatus().equalsIgnoreCase("concluida")) {
            resultado += "\n--- ALTERAÇÃO DE SAÚDE PSICOLÓGICA (PÓS-VIAGEM) ---" +
                         "\nEstresse emocional medido: " + estresseEmocionalPos + 
                         "\nIsolamento psicológico medido: " + isolamentoPsicologicoPos + 
                         "\nMudanças comportamentais medidos: " + mudancasComportamentaisPos;
        }

        resultado += "\nÍndice de Risco Calculado: " + String.format("%.2f", calcularRisco());
        return resultado;
    }

    /**
     * Recupera a nota inicial de estabilidade emocional do astronauta na Terra.
     * @return O valor decimal da estabilidade emocional original.
     */
    public double getEstabilidadeEmocional() { return estabilidadeEmocional; }
    
    /**
     * Define ou atualiza a nota inicial de estabilidade emocional medida na Terra.
     * @param estabilidadeEmocional A nova nota a ser atribuída à estabilidade emocional.
     */
    public void setEstabilidadeEmocional(double estabilidadeEmocional) { this.estabilidadeEmocional = estabilidadeEmocional; }

    /**
     * Recupera a nota de referência para o índice de socialização inicial medida na Terra.
     * @return O valor decimal do índice de socialização de base.
     */
    public double getSocializacaoBase() { return socializacaoBase; }
    
    /**
     * Define ou atualiza a nota de referência para o índice de socialização.
     * @param socializacaoBase A nova nota a ser atribuída à socialização de base.
     */
    public void setSocializacaoBase(double socializacaoBase) { this.socializacaoBase = socializacaoBase; }

    /**
     * Recupera a nota inicial associada ao foco comportamental medido na Terra.
     * @return O valor decimal do foco comportamental original.
     */
    public double getFocoComportamental() { return focoComportamental; }
    
    /**
     * Define ou atualiza a nota inicial do foco comportamental do astronauta.
     * @param focoComportamental A nova nota a ser atribuída ao foco de base.
     */
    public void setFocoComportamental(double focoComportamental) { this.focoComportamental = focoComportamental; }

    /**
     * Recupera a taxa percentual de eficiência da estabilidade emocional capturada no espaço.
     * @return O valor percentual medido pós-viagem.
     */
    public double getEstresseEmocionalPos() { return estresseEmocionalPos; }
    
    /**
     * Define ou atualiza a taxa percentual de eficiência da estabilidade emocional em órbita.
     * @param estresseEmocionalPos O valor percentual medido em órbita.
     */
    public void setEstresseEmocionalPos(double estresseEmocionalPos) { this.estresseEmocionalPos = estresseEmocionalPos; }

    /**
     * Recupera a taxa percentual de eficiência da socialização capturada no espaço.
     * @return O valor percentual medido pós-viagem.
     */
    public double getIsolamentoPsicologicoPos() { return isolamentoPsicologicoPos; }
    
    /**
     * Define ou atualiza a taxa percentual de eficiência da socialização monitorada no espaço.
     * @param isolamentoPsicologicoPos O valor percentual medido em órbita.
     */
    public void setIsolamentoPsicologicoPos(double isolamentoPsicologicoPos) { this.isolamentoPsicologicoPos = isolamentoPsicologicoPos; }

    /**
     * Recupera a taxa percentual de eficiência do foco comportamental capturada no espaço.
     * @return O valor percentual medido pós-viagem.
     */
    public double getMudancasComportamentaisPos() { return mudancasComportamentaisPos; }
    
    /**
     * Define ou atualiza a taxa percentual de eficiência do foco comportamental em órbita.
     * @param mudancasComportamentaisPos O valor percentual medido em órbita.
     */
    public void setMudancasComportamentaisPos(double mudancasComportamentaisPos) { this.mudancasComportamentaisPos = mudancasComportamentaisPos; }
}