package br.com.neurospace.model;

/**
 * Representa uma análise física realizada durante a missão espacial.
 * Esta subclasse estende a classe abstrata Missao, adicionando parâmetros de 
 * monitoramento médico e de saúde física dos astronautas no ambiente de base 
 * terrestre e os dados de eficiência ou degradação coletados em órbita (pós-viagem).
 * * @author Matheus Egea / RM:563490
 * @version 1.0
 */
public class AnaliseFisica extends Missao {

    /** Dados de Saúde Inicial na Terra: Nota atribuída à qualidade e regularidade do sono. */
    private double qualidadeSono;
    
    /** Dados de Saúde Inicial na Terra: Nota atribuída à eficiência e tempos de reação cognitiva. */
    private double energiaCognitiva;
    
    /** Dados de Saúde Inicial na Terra: Nota atribuída à preservação e tônus da massa muscular. */
    private double massaMuscular;

    /** Dados de Pós-Viagem: Taxa percentual de eficiência ou alteração do sono registrada no espaço. */
    private double alteracaoSonoPos;
    
    /** Dados de Pós-Viagem: Taxa percentual de eficiência ou fadiga cognitiva registrada no espaço. */
    private double fadigaCognitivaPos;
    
    /** Dados de Pós-Viagem: Taxa percentual de eficiência ou perda biológica muscular registrada no espaço. */
    private double perdaMuscularPos;

    /**
     * Construtor completo da classe AnaliseFisica.
     * Invoca o construtor da superclasse para inicializar as propriedades comuns da missão 
     * e define os atributos específicos relacionados à saúde física inicial.
     * * @param nomeMissao O nome único identificador do projeto da missão.
     * @param areaImpacto A área social ou ambiental beneficiada pelo projeto.
     * @param objetivo A descrição da finalidade e metas da missão.
     * @param odsRelacionada O número identificador do ODS vinculado.
     * @param tecnologia A descrição tecnológica ou o aparato técnico empregado.
     * @param prioridade O grau de prioridade estabelecido no escopo (escala de 1 a 10).
     * @param status O estado operacional inicial do projeto no sistema.
     * @param qualidadeSono A nota para a qualidade de sono inicial medida na Terra.
     * @param energiaCognitiva A nota para a energia cognitiva inicial medida na Terra.
     * @param massaMuscular A nota para o volume/eficiência muscular inicial medido na Terra.
     */
    public AnaliseFisica(String nomeMissao, String areaImpacto, String objetivo, int odsRelacionada, String tecnologia, int prioridade, String status, double qualidadeSono, double energiaCognitiva, double massaMuscular) {
        super(nomeMissao, areaImpacto, objetivo, odsRelacionada, tecnologia, prioridade, status);
        this.qualidadeSono = qualidadeSono;
        this.energiaCognitiva = energiaCognitiva;
        this.massaMuscular = massaMuscular;
    }

    /**
     * Calcula o índice de risco ou perda de integridade com base no andamento do ciclo biológico.
     * Caso o projeto esteja com status Concluída ou Em andamento, o risco corresponde à média matemática 
     * das alterações físicas registradas em órbita. Se estiver em fase de Planejamento, estima o risco 
     * de forma inversamente proporcional à robustez da saúde inicial medida em ambiente terrestre.
     * * @return O valor numérico que representa o índice de risco calculado para a integridade do astronauta.
     */
    @Override
    public double calcularRisco() {
        if (this.getStatus().equalsIgnoreCase("concluída") || this.getStatus().equalsIgnoreCase("concluida")) {
            return (alteracaoSonoPos + fadigaCognitivaPos + perdaMuscularPos) / 3;
        }
        return (10 - qualidadeSono + (10 - energiaCognitiva) + (10 - massaMuscular)) / 3;
    }

    /**
     * Sobrescreve o método de representação textual, consolidando as propriedades estruturais da 
     * missão espacial contidas na superclasse e anexando os blocos informativos de saúde biológica 
     * inicial, os dados dinâmicos pós-viagem e o índice final de risco.
     * * @return Uma String formatada contendo todos os dados e métricas físicas associados à missão.
     */
    @Override
    public String toString() {
        String resultado = super.toString() + 
               "\n--- SAÚDE FÍSICA INICIAL (NA TERRA) ---" +
               "\nQualidade do sono: " + qualidadeSono + 
               "\nEnergia cognitiva: " + energiaCognitiva + 
               "\nMassa muscular: " + massaMuscular;

        if (this.getStatus().equalsIgnoreCase("concluída") || this.getStatus().equalsIgnoreCase("concluida")) {
            resultado += "\n--- ALTERAÇÃO DE SAÚDE FÍSICA (PÓS-VIAGEM) ---" +
                         "\nAlteração do sono medida: " + alteracaoSonoPos + 
                         "\nFadiga cognitiva medida: " + fadigaCognitivaPos + 
                         "\nPerda muscular medida: " + perdaMuscularPos;
        }

        resultado += "\nÍndice de Risco Calculado: " + String.format("%.2f", calcularRisco());
        return resultado;
    }

    /**
     * Recupera a nota inicial referente à qualidade do sono do astronauta na Terra.
     * @return O valor decimal da qualidade de sono original.
     */
    public double getQualidadeSono() { return qualidadeSono; }
    
    /**
     * Define ou atualiza a nota inicial da qualidade do sono medida na Terra.
     * @param qualidadeSono A nova nota a ser atribuída à qualidade do sono.
     */
    public void setQualidadeSono(double qualidadeSono) { this.qualidadeSono = qualidadeSono; }

    /**
     * Recupera a nota inicial referente à eficiência e energia cognitiva medida na Terra.
     * @return O valor decimal da energia cognitiva original.
     */
    public double getEnergiaCognitiva() { return energiaCognitiva; }
    
    /**
     * Define ou atualiza a nota inicial de eficiência cognitiva do astronauta.
     * @param energiaCognitiva A nova nota a ser atribuída à energia cognitiva de base.
     */
    public void setEnergiaCognitiva(double energiaCognitiva) { this.energiaCognitiva = energiaCognitiva; }

    /**
     * Recupera a nota inicial associada à eficiência e tônus da massa muscular.
     * @return O valor decimal de referência da massa muscular.
     */
    public double getMassaMuscular() { return massaMuscular; }
    
    /**
     * Define ou atualiza a nota inicial de eficiência ou tônus muscular do astronauta.
     * @param massaMuscular A nova nota a ser atribuída à massa muscular de base.
     */
    public void setMassaMuscular(double massaMuscular) { this.massaMuscular = massaMuscular; }

    /**
     * Recupera a taxa percentual de eficiência do sono capturada durante o período em órbita.
     * @return O valor percentual de eficiência pós-viagem.
     */
    public double getAlteracaoSonoPos() { return alteracaoSonoPos; }
    
    /**
     * Define ou atualiza a taxa percentual de eficiência do sono monitorada no espaço.
     * @param alteracaoSonoPos O valor percentual medido em órbita.
     */
    public void setAlteracaoSonoPos(double alteracaoSonoPos) { this.alteracaoSonoPos = alteracaoSonoPos; }

    /**
     * Recupera a taxa percentual de eficiência cognitiva registrada no ambiente espacial.
     * @return O valor percentual de eficiência cognitiva pós-viagem.
     */
    public double getFadigaCognitivaPos() { return fadigaCognitivaPos; }
    
    /**
     * Define ou atualiza a taxa percentual de eficiência cognitiva monitorada no espaço.
     * @param fadigaCognitivaPos O valor percentual medido em órbita.
     */
    public void setFadigaCognitivaPos(double fadigaCognitivaPos) { this.fadigaCognitivaPos = fadigaCognitivaPos; }

    /**
     * Recupera a taxa percentual de eficiência ou preservação muscular registrada no espaço.
     * @return O valor percentual de eficiência muscular pós-viagem.
     */
    public double getPerdaMuscularPos() { return perdaMuscularPos; }
    
    /**
     * Define ou atualiza a taxa percentual de eficiência ou preservação muscular monitorada no espaço.
     * @param perdaMuscularPos O valor percentual medido em órbita.
     */
    public void setPerdaMuscularPos(double perdaMuscularPos) { this.perdaMuscularPos = perdaMuscularPos; }
}