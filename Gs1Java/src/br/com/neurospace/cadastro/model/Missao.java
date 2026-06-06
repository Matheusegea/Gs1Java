package br.com.neurospace.cadastro.model;

/**
 * Classe abstrata que representa a estrutura fundamental de uma missão espacial.
 * Serve como superclasse para os tipos específicos de análises biomédicas e 
 * operacionais da tripulação, fornecendo o gerenciamento centralizado de metadados, 
 * níveis de priorização dinâmica e vinculação com os Objetivos de Desenvolvimento Sustentável (ODS).
 * * @author Matheus Egea / RM: 563490
 * @version 1.0
 */
public abstract class Missao {

    /** O nome único ou identificador do projeto da missão espacial. */
    private String nomeMissao;
    
    /** A área social, científica ou ambiental diretamente beneficiada pela missão. */
    private String areaImpacto;
    
    /** A descrição detalhada da finalidade, escopo e metas da missão. */
    private String objetivo;
    
    /** O número identificador da ODS (Organização das Nações Unidas) vinculada ao projeto. */
    private int odsRelacionada;
    
    /** A descrição tecnológica ou o aparato técnico-científico empregado em órbita. */
    private String tecnologia;
    
    /** O grau de prioridade operacional atual estabelecido no ecossistema (escala de 1 a 10 ou 0 se inativo). */
    private int prioridade;
    
    /** O registro histórico da prioridade antes de uma eventual conclusão ou cancelamento do projeto. */
    private int prioridadeAnterior;
    
    /** O estado operacional contemporâneo da missão (Ex: Planejada, Em andamento, Concluída, Cancelada). */
    private String status;

    /**
     * Construtor padrão e sem argumentos da classe Missao.
     * Permite a sobrecarga de construtores e instanciação flexível pelas subclasses ou frameworks de persistência.
     */
    public Missao() {
    }

    /**
     * Construtor parcial da classe Missao (Sobrecarga).
     * Inicializa uma instância da missão definindo exclusivamente o seu identificador nominal de projeto.
     * * @param nomeMissao O nome único identificador do projeto da missão.
     */
    public Missao(String nomeMissao) {
        this.nomeMissao = nomeMissao;
    }

    /**
     * Construtor completo da classe abstrata Missao.
     * Consolida e inicializa todas as propriedades estruturais essenciais da missão espacial, 
     * replicando a prioridade original na trilha histórica e aplicando as regras automáticas de status.
     * * @param nomeMissao O nome único identificador do projeto da missão.
     * @param areaImpacto A área social ou ambiental beneficiada pelo projeto.
     * @param objetivo A descrição da finalidade e metas da missão.
     * @param odsRelacionada O número identificador do ODS vinculado.
     * @param tecnologia A descrição tecnológica ou o aparato técnico empregado.
     * @param prioridade O grau de prioridade estabelecido no escopo (escala de 1 a 10).
     * @param status O estado operacional inicial do projeto no sistema.
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
     * Método abstrato responsável por estipular as diretrizes de cálculo do risco ou impacto.
     * Deve ser implementado obrigatoriamente pelas subclasses específicas de análise biológica, 
     * considerando os parâmetros operacionais e médicos de cada domínio.
     * * @return O valor numérico em ponto flutuante representando o índice de risco calculado.
     */
    public abstract double calcularRisco();

    /**
     * Resolve e retorna a nomenclatura oficial do Objetivo de Desenvolvimento Sustentável (ODS) 
     * com base no índice numérico atualmente cadastrado para a missão.
     * * @return Uma String contendo o código e a descrição da ODS, ou mensagem de não cadastrada.
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

    /**
     * Recupera o nome identificador do projeto da missão.
     * @return O nome da missão.
     */
    public String getNomeMissao() { return nomeMissao; }
    
    /**
     * Define ou atualiza o nome identificador da missão.
     * @param nomeMissao O novo nome a ser atribuído à missão.
     */
    public void setNomeMissao(String nomeMissao) { this.nomeMissao = nomeMissao; }

    /**
     * Recupera a descrição da área social ou ambiental impactada pela missão.
     * @return A área de impacto descritiva.
     */
    public String getAreaImpacto() { return areaImpacto; }
    
    /**
     * Define ou atualiza a descrição da área de impacto da missão.
     * @param areaImpacto A nova área de impacto a ser atribuída.
     */
    public void setAreaImpacto(String areaImpacto) { this.areaImpacto = areaImpacto; }

    /**
     * Recupera a descrição dos objetivos e metas estabelecidos.
     * @return O objetivo textual da missão.
     */
    public String getObjetivo() { return objetivo; }
    
    /**
     * Define ou atualiza a descrição da finalidade e objetivos da missão.
     * @param objetivo O novo objetivo a ser atribuído.
     */
    public void setObjetivo(String objetivo) { this.objetivo = objetivo; }

    /**
     * Recupera o número identificador do ODS associado à missão.
     * @return O número da ODS relacionada.
     */
    public int getOdsRelacionada() { return odsRelacionada; }
    
    /**
     * Define ou atualiza o código do ODS relacionado à missão.
     * @param odsRelacionada O novo número da ODS a ser vinculada.
     */
    public void setOdsRelacionada(int odsRelacionada) { this.odsRelacionada = odsRelacionada; }

    /**
     * Recupera a descrição do aparato tecnológico ou científico empregado na missão.
     * @return A descrição da tecnologia utilizada.
     */
    public String getTecnologia() { return tecnologia; }
    
    /**
     * Define ou atualiza a descrição tecnológica do aparato da missão.
     * @param tecnologia A nova descrição tecnológica a ser atribuída.
     */
    public void setTecnologia(String tecnologia) { this.tecnologia = tecnologia; }

    /**
     * Recupera o nível de prioridade atual da missão.
     * @return O valor inteiro da prioridade (0 se inativo, 1 a 10 se ativo).
     */
    public int getPrioridade() { return prioridade; }
    
    /**
     * Define ou atualiza diretamente o nível de prioridade da missão.
     * @param prioridade O novo valor inteiro de prioridade.
     */
    public void setPrioridade(int prioridade) { this.prioridade = prioridade; }

    /**
     * Recupera o histórico do nível de prioridade anterior da missão.
     * @return O valor inteiro da prioridade de backup antes de encerramentos.
     */
    public int getPrioridadeAnterior() { return prioridadeAnterior; }
    
    /**
     * Define ou atualiza o backup do histórico de prioridade anterior.
     * @param prioridadeAnterior O novo valor inteiro histórico de prioridade.
     */
    public void setPrioridadeAnterior(int prioridadeAnterior) { this.prioridadeAnterior = prioridadeAnterior; }

    /**
     * Recupera o estado operacional ou status atual da missão.
     * @return O texto correspondente ao status.
     */
    public String getStatus() { return status; }

    /**
     * Define o estado operacional da missão, aplicando regras de negócio automáticas de priorização.
     * Caso o status seja definido para Concluída ou Cancelada, a prioridade atual é zerada e guardada 
     * no histórico. Se o status retornar para Planejada ou Em andamento, a prioridade original é restaurada.
     * * @param status O novo texto representativo do status (Ex: "planejada", "em andamento", "concluida", "cancelada").
     */
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

    /**
     * Retorna a representação textual formatada de uma missão espacial, consolidando 
     * os metadados primários e chamando internamente o método de mapeamento nominal de ODS.
     * * @return Uma String estruturada contendo todos os atributos públicos informativos da missão.
     */
    @Override
    public String toString() {
        return "\nNome da missão: " + nomeMissao + 
               "\nÁrea de impacto: " + areaImpacto + 
               "\nObjetivo: " + objetivo + 
               "\nODS: " + obterNomeOds() + 
               "\nTecnologia: " + tecnologia + 
               "\nPrioridade: " + prioridade + 
               "\nStatus: " + status;
    }
}