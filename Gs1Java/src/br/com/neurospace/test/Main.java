package br.com.neurospace.test;

import br.com.neurospace.model.AnaliseFisica;
import br.com.neurospace.model.AnalisePsicologica;
import br.com.neurospace.model.Missao;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe principal do sistema NeuroSpace responsável por gerenciar o menu interativo via terminal.
 * Permite realizar operações de controle de missões espaciais integradas aos Objetivos de Desenvolvimento 
 * Sustentável (ODS), abrangendo o ciclo completo de cadastro, listagem, busca, atualização de status e 
 * análises comparativas de saúde e eficiência biológica dos astronautas antes e depois da órbita.
 * * @author Matheus Egea / RM:563490
 * @version 1.0
 */
public class Main {

    /**
     * Ponto de entrada padrão da aplicação Java (Método Main).
     * Gerencia a execução das opções do console, controlando o fluxo do switch-case e o armazenamento 
     * temporário das missões na lista em memória.
     * * @param args Argumentos passados por linha de comando (não utilizados nesta aplicação).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Missao> listaMissoes = new ArrayList<>();
        int opcao;

        do {
            System.out.println("\n===== NEUROSPACE =====");
            System.out.println("1 - Cadastrar missão");
            System.out.println("2 - Listar missões");
            System.out.println("3 - Buscar missão");
            System.out.println("4 - Alterar status");
            System.out.println("5 - Exibir variação percentual pós-viagem");
            System.out.println("6 - Exibir resumo final");
            System.out.println("0 - Sair");

            opcao = lerInteiro(scanner, "Escolha uma opção (número inteiro): ");

            switch (opcao) {
                case 1:
                    String nome = lerTexto(scanner, "Nome da missão (texto): ");
                    
                    // Validação para impedir a duplicidade de missões usando o mesmo nome
                    boolean nomeExiste = false;
                    for (Missao missao : listaMissoes) {
                        if (missao.getNomeMissao().equalsIgnoreCase(nome)) {
                            nomeExiste = true;
                            break;
                        }
                    }
                    
                    if (nomeExiste) {
                        System.out.println("\nERRO: Já existe uma missão cadastrada com o nome \"" + nome + "\". Cadastro cancelado.");
                        break; 
                    }

                    int tipoAnalise;
                    do {
                        System.out.println("\nTipo de análise:");
                        System.out.println("1 - Análise Física");
                        System.out.println("2 - Análise Psicológica");
                        tipoAnalise = lerInteiro(scanner, "Escolha o tipo de análise (número inteiro): ");
                        
                        if (tipoAnalise != 1 && tipoAnalise != 2) {
                            System.out.println("\nERRO: Escolha uma opção de análise válida (1 ou 2).");
                        }
                    } while (tipoAnalise != 1 && tipoAnalise != 2);

                    String area = lerTexto(scanner, "Área de impacto (texto): ");
                    String objetivo = lerTexto(scanner, "Objetivo da missão (texto): ");

                    System.out.println("\nODS disponíveis:");
                    System.out.println("1 - Erradicação da pobreza");
                    System.out.println("2 - Fome zero e agricultura sustentável");
                    System.out.println("3 - Saúde e bem-estar");
                    System.out.println("4 - Educação de qualidade");
                    System.out.println("9 - Indústria, inovação e infraestrutura");
                    System.out.println("13 - Ação contra a mudança global do clima");

                    int ods;
                    do {
                        ods = lerInteiro(scanner, "ODS relacionada (digite o número correspondente): ");
                        if (ods != 1 && ods != 2 && ods != 3 && ods != 4 && ods != 9 && ods != 13) {
                            System.out.println("\nERRO: Escolha uma ODS válida dentre as listadas (1, 2, 3, 4, 9, 13).");
                        }
                    } while (ods != 1 && ods != 2 && ods != 3 && ods != 4 && ods != 9 && ods != 13);

                    String tecnologia = lerTexto(scanner, "Tecnologia utilizada ou que será utilizada (texto): ");

                    int prioridade;
                    do {
                        prioridade = lerInteiro(scanner, "Prioridade (1 a 10): ");
                        if (prioridade < 1 || prioridade > 10) {
                            System.out.println("\nERRO: Digite um número entre 1 e 10.");
                        }
                    } while (prioridade < 1 || prioridade > 10);

                    String status;
                    System.out.println("\nStatus disponíveis: Planejada, Em andamento, Concluída, Cancelada");
                    do {
                        status = lerTexto(scanner, "Status inicial da missão: ");
                        if (!status.equalsIgnoreCase("planejada") && !status.equalsIgnoreCase("em andamento") && !status.equalsIgnoreCase("concluída") && !status.equalsIgnoreCase("concluida") && !status.equalsIgnoreCase("cancelada")) {
                            System.out.println("\nERRO: Digite um status válido.");
                        }
                    } while (!status.equalsIgnoreCase("planejada") && !status.equalsIgnoreCase("em andamento") && !status.equalsIgnoreCase("concluída") && !status.equalsIgnoreCase("concluida") && !status.equalsIgnoreCase("cancelada"));

                    // Tratamento e normalização baseados na Opção A (Foco em Eficiência Biológica Restante)
                    if (tipoAnalise == 1) {
                        System.out.println("\n--- Avaliação de Saúde Física do Astronauta (Na Terra) ---");
                        double sono = lerDouble(scanner, "Nota para Eficiência do Sono inicial (1-10): ");
                        double energia = lerDouble(scanner, "Nota para Eficiência Cognitiva inicial (1-10): ");
                        double massa = lerDouble(scanner, "Nota para Eficiência Muscular inicial (1-10): ");

                        AnaliseFisica analiseFisica = new AnaliseFisica(nome, area, objetivo, ods, tecnologia, prioridade, status, sono, energia, massa);
                        
                        if (status.equalsIgnoreCase("concluída") || status.equalsIgnoreCase("concluida") || status.equalsIgnoreCase("em andamento")) {
                            System.out.println("\n--- COLETANDO A EFICIÊNCIA DE SAÚDE EM ÓRBITA ---");
                            analiseFisica.setAlteracaoSonoPos(lerPorcentagem(scanner, "Eficiência atual do Sono no espaço (1-100%): "));
                            analiseFisica.setFadigaCognitivaPos(lerPorcentagem(scanner, "Eficiência atual Cognitiva no espaço (1-100%): "));
                            analiseFisica.setPerdaMuscularPos(lerPorcentagem(scanner, "Eficiência atual da Massa Muscular no espaço (1-100%): "));
                        }
                        
                        listaMissoes.add(analiseFisica);
                        System.out.println("\nAnálise física cadastrada com sucesso!");

                    } else if (tipoAnalise == 2) {
                        System.out.println("\n--- Avaliação de Saúde Psicológica do Astronauta (Na Terra) ---");
                        double estabilidade = lerDouble(scanner, "Nota para Estabilidade Emocional inicial (1-10): ");
                        double social = lerDouble(scanner, "Nota para Índice de Socialização de base (1-10): ");
                        double foco = lerDouble(scanner, "Nota para Foco Comportamental de base (1-10): ");

                        AnalisePsicologica analisePsicologica = new AnalisePsicologica(nome, area, objetivo, ods, tecnologia, prioridade, status, estabilidade, social, foco);
                        
                        if (status.equalsIgnoreCase("concluída") || status.equalsIgnoreCase("concluida") || status.equalsIgnoreCase("em andamento")) {
                            System.out.println("\n--- COLETANDO A EFICIÊNCIA DE SAÚDE EM ÓRBITA ---");
                            analisePsicologica.setEstresseEmocionalPos(lerPorcentagem(scanner, "Eficiência da Estabilidade Emocional no espaço (1-100%): "));
                            analisePsicologica.setIsolamentoPsicologicoPos(lerPorcentagem(scanner, "Eficiência da Socialização no espaço (1-100%): "));
                            analisePsicologica.setMudancasComportamentaisPos(lerPorcentagem(scanner, "Eficiência do Foco Comportamental no espaço (1-100%): "));
                        }

                        listaMissoes.add(analisePsicologica);
                        System.out.println("\nAnálise psicológica cadastrada com sucesso!");
                    }
                    break;

                case 2:
                    if (listaMissoes.isEmpty()) {
                        System.out.println("\nNenhuma missão cadastrada.");
                    } else {
                        System.out.println("\n===== MISSÕES CADASTRADAS =====");
                        for (Missao missao : listaMissoes) {
                            System.out.println(missao); 
                            System.out.println("\n------------------");
                        }
                    }
                    break;

                case 3:
                    System.out.println("\nBuscar por:");
                    System.out.println("1 - Nome");
                    System.out.println("2 - Área de impacto");
                    System.out.println("3 - Número do ODS");

                    int tipoBusca = lerInteiro(scanner, "Escolha a busca: ");
                    boolean encontrou = false;

                    if (tipoBusca == 1) {
                        String nomeBusca = lerTexto(scanner, "Digite o nome da missão: ");
                        for (Missao missao : listaMissoes) {
                            if (missao.getNomeMissao().equalsIgnoreCase(nomeBusca)) {
                                if (!encontrou) System.out.println("\n===== RESULTADO DA BUSCA =====");
                                System.out.println(missao);
                                encontrou = true;
                            }
                        }
                    } else if (tipoBusca == 2) {
                        String areaBusca = lerTexto(scanner, "Digite a área de impacto: ");
                        for (Missao missao : listaMissoes) {
                            if (missao.getAreaImpacto().equalsIgnoreCase(areaBusca)) {
                                if (!encontrou) System.out.println("\n===== RESULTADO DA BUSCA =====");
                                System.out.println(missao);
                                encontrou = true;
                            }
                        }
                    } else if (tipoBusca == 3) {
                        int odsBusca = lerInteiro(scanner, "Digite o número do ODS: ");
                        for (Missao missao : listaMissoes) {
                            if (missao.getOdsRelacionada() == odsBusca) {
                                if (!encontrou) System.out.println("\n===== RESULTADO DA BUSCA =====");
                                System.out.println(missao);
                                encontrou = true;
                            }
                        }
                    }
                    if (!encontrou) System.out.println("\nNenhuma missão encontrada.");
                    break;

                case 4:
                    String nomeAlterar = lerTexto(scanner, "Digite o nome da missão que deseja alterar: ");
                    boolean alterado = false;

                    for (Missao missao : listaMissoes) {
                        if (missao.getNomeMissao().equalsIgnoreCase(nomeAlterar)) {
                            String novoStatus;
                            System.out.println("\nStatus: Planejada, Em andamento, Concluída, Cancelada");

                            do {
                                novoStatus = lerTexto(scanner, "Novo status: ");
                            } while (!novoStatus.equalsIgnoreCase("planejada") && !novoStatus.equalsIgnoreCase("em andamento") && !novoStatus.equalsIgnoreCase("concluída") && !novoStatus.equalsIgnoreCase("concluida") && !novoStatus.equalsIgnoreCase("cancelada"));

                            missao.setStatus(novoStatus);

                            if (novoStatus.equalsIgnoreCase("concluída") || novoStatus.equalsIgnoreCase("concluida") || novoStatus.equalsIgnoreCase("em andamento")) {
                                System.out.println("\n--- COLETANDO DADOS DE EFICIÊNCIA DE SAÚDE EM ÓRBITA (1-100%) ---");
                                
                                if (missao instanceof AnaliseFisica) {
                                    AnaliseFisica af = (AnaliseFisica) missao;
                                    af.setAlteracaoSonoPos(lerPorcentagem(scanner, "Eficiência atual do Sono no espaço (1-100%): "));
                                    af.setFadigaCognitivaPos(lerPorcentagem(scanner, "Eficiência atual Cognitiva no espaço (1-100%): "));
                                    af.setPerdaMuscularPos(lerPorcentagem(scanner, "Eficiência atual da Massa Muscular no espaço (1-100%): "));
                                } else if (missao instanceof AnalisePsicologica) {
                                    AnalisePsicologica ap = (AnalisePsicologica) missao;
                                    ap.setEstresseEmocionalPos(lerPorcentagem(scanner, "Eficiência da Estabilidade Emocional no espaço (1-100%): "));
                                    ap.setIsolamentoPsicologicoPos(lerPorcentagem(scanner, "Eficiência da Socialização no espaço (1-100%): "));
                                    ap.setMudancasComportamentaisPos(lerPorcentagem(scanner, "Eficiência do Foco Comportamental no espaço (1-100%): "));
                                }
                            }

                            System.out.println("\nStatus atualizado com sucesso!");
                            alterado = true;
                        }
                    }
                    if (!alterado) System.out.println("\nMissão não encontrada.");
                    break;

                case 5:
                    boolean temDadosValidos = false;
                    System.out.println("\n===== RELATÓRIO ANALÍTICO DE IMPACTO BIOLÓGICO (VARIAÇÃO %) =====");
                    
                    for (Missao missao : listaMissoes) {
                        if (missao.getStatus().equalsIgnoreCase("concluída") || missao.getStatus().equalsIgnoreCase("concluida") || missao.getStatus().equalsIgnoreCase("em andamento")) {
                            temDadosValidos = true;
                            System.out.println("\nMissão: " + missao.getNomeMissao() + " [Status: " + missao.getStatus() + "]");
                            
                            if (missao instanceof AnaliseFisica) {
                                AnaliseFisica af = (AnaliseFisica) missao;
                                
                                double mediaTerraOriginal = (af.getQualidadeSono() + af.getEnergiaCognitiva() + af.getMassaMuscular()) / 3.0;
                                double mediaTerraPercentual = mediaTerraOriginal * 10.0; 
                                
                                double mediaEspacoPercentual = (af.getAlteracaoSonoPos() + af.getFadigaCognitivaPos() + af.getPerdaMuscularPos()) / 3.0;
                                
                                double variacao = ((mediaEspacoPercentual - mediaTerraPercentual) / mediaTerraPercentual) * 100;
                                
                                System.out.println("-> Eficiência Média da Saúde na Terra: " + String.format("%.2f", mediaTerraPercentual) + "%");
                                System.out.println("-> Eficiência Média da Saúde no Espaço: " + String.format("%.2f", mediaEspacoPercentual) + "%");
                                if (variacao < 0) {
                                    System.out.println("=> Variação da Saúde Corporal: " + String.format("%.2f", variacao) + "% (Houve perda/degradação da integridade física)");
                                } else {
                                    System.out.println("=> Variação da Saúde Corporal: +" + String.format("%.2f", variacao) + "% (A saúde corporal manteve-se estável ou expandida)");
                                }
                            
                            } else if (missao instanceof AnalisePsicologica) {
                                AnalisePsicologica ap = (AnalisePsicologica) missao;
                                
                                double mediaTerraOriginal = (ap.getEstabilidadeEmocional() + ap.getSocializacaoBase() + ap.getFocoComportamental()) / 3.0;
                                double mediaTerraPercentual = mediaTerraOriginal * 10.0;
                                
                                double mediaEspacoPercentual = (ap.getEstresseEmocionalPos() + ap.getIsolamentoPsicologicoPos() + ap.getMudancasComportamentaisPos()) / 3.0;
                                
                                double variacao = ((mediaEspacoPercentual - mediaTerraPercentual) / mediaTerraPercentual) * 100;
                                
                                System.out.println("-> Estabilidade Média Mental na Terra: " + String.format("%.2f", mediaTerraPercentual) + "%");
                                System.out.println("-> Estabilidade Média Mental no Espaço: " + String.format("%.2f", mediaEspacoPercentual) + "%");
                                if (variacao < 0) {
                                    System.out.println("=> Variação da Saúde Psicológica: " + String.format("%.2f", variacao) + "% (Houve regressão psicológica/estresse mental)");
                                } else {
                                    System.out.println("=> Variação da Saúde Psicológica: +" + String.format("%.2f", variacao) + "% (A saúde mental manteve-se resiliente ou adaptada)");
                                }
                            }
                            System.out.println("---------------------------------------------------------------");
                        }
                    }
                    if (!temDadosValidos) System.out.println("\nNenhuma missão ativa ou concluída com dados de órbita.");
                    break;

                case 6:
                    int planejada = 0; int andamento = 0; int concluida = 0; int cancelada = 0;
                    Missao maiorPrioridade = null;

                    for (Missao missao : listaMissoes) {
                        String statusAtual = missao.getStatus().toLowerCase();
                        if (statusAtual.equals("planejada")) planejada++;
                        else if (statusAtual.equals("em andamento")) andamento++;
                        else if (statusAtual.equals("concluída") || statusAtual.equals("concluida")) concluida++;
                        else if (statusAtual.equals("cancelada")) cancelada++;

                        if (maiorPrioridade == null || missao.getPrioridade() > maiorPrioridade.getPrioridade()) {
                            maiorPrioridade = missao;
                        }
                    }

                    System.out.println("\n===== RESUMO FINAL DO SISTEMA =====");
                    System.out.println("Total de missões: " + listaMissoes.size());
                    System.out.println("Planejada: " + planejada + " | Em andamento: " + andamento + " | Concluída: " + concluida + " | Cancelada: " + cancelada);
                    if (maiorPrioridade != null) {
                        System.out.println("Maior prioridade: " + maiorPrioridade.getNomeMissao() + " (Nota: " + maiorPrioridade.getPrioridade() + ")");
                    }
                    break;

                case 0:
                    System.out.println("\nSistema encerrado.");
                    break;

                default:
                    System.out.println("\nOpção inválida.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    /**
     * Lê um número inteiro a partir da entrada padrão do console, aplicando tratamento de 
     * exceção para evitar travamentos caso dados inválidos (letras ou símbolos) sejam informados.
     * * @param scanner O scanner ativo associado à entrada padrão.
     * @param mensagem A mensagem descritiva que orienta o usuário sobre o dado solicitado.
     * @return O número inteiro validado e convertido com sucesso.
     */
    public static int lerInteiro(Scanner scanner, String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("\nERRO: Digite apenas números inteiros.");
            }
        }
    }

    /**
     * Lê um número de precisão decimal dupla (double) do terminal, garantindo que caracteres não 
     * numéricos sejam capturados de forma preventiva pelo bloco de exceções sem interromper a execução.
     * * @param scanner O scanner ativo associado à entrada padrão.
     * @param mensagem A mensagem instrutiva que será exibida para o usuário.
     * @return O número decimal validado e retornado.
     */
    public static double lerDouble(Scanner scanner, String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("\nERRO: Digite apenas números decimais.");
            }
        }
    }

    /**
     * Captura e valida dados numéricos associados a taxas de porcentagem do ambiente em órbita,
     * aceitando unicamente valores contidos no intervalo de restrição entre 1 e 100.
     * * @param scanner O scanner ativo associado à entrada padrão.
     * @param mensagem O rótulo explicativo da métrica de eficiência a ser preenchida.
     * @return O valor decimal mapeado obrigatoriamente dentro do intervalo de 1 a 100.
     */
    public static double lerPorcentagem(Scanner scanner, String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                double valor = Double.parseDouble(scanner.nextLine());
                if (valor >= 1 && valor <= 100) return valor;
                System.out.println("\nERRO: Digite uma taxa percentual válida entre 1 e 100.");
            } catch (NumberFormatException e) {
                System.out.println("\nERRO: Digite apenas números decimais.");
            }
        }
    }

    /**
     * Lê sequências de texto do terminal via console, impedindo a submissão de campos em branco
     * ou compostos exclusivamente de espaços através da limpeza prévia com o método trim().
     * * @param scanner O scanner ativo associado à entrada padrão.
     * @param mensagem O contexto ou título do campo textual solicitado.
     * @return A String tratada contendo os caracteres preenchidos pelo usuário.
     */
    public static String lerTexto(Scanner scanner, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String texto = scanner.nextLine().trim();
            if (!texto.isEmpty()) return texto;
            System.out.println("\nERRO: Digite um texto válido.");
        }
    }
}