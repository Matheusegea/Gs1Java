package br.com.neurospace.test;

import br.com.neurospace.model.AnaliseFisica;
import br.com.neurospace.model.AnalisePsicologica;
import br.com.neurospace.model.Missao;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe principal do sistema NeuroSpace.
 */
public class Main {

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
            System.out.println("5 - Exibir resumo final");
            System.out.println("0 - Sair");

            opcao = lerInteiro(scanner, "Escolha uma opção (número inteiro): ");

            switch (opcao) {
                case 1:
                    System.out.println("\nTipo de análise:");
                    System.out.println("1 - Análise Física");
                    System.out.println("2 - Análise Psicológica");

                    int tipoAnalise = lerInteiro(scanner, "Escolha o tipo de análise (número inteiro): ");
                    String nome = lerTexto(scanner, "Nome da missão (texto): ");
                    String area = lerTexto(scanner, "Área de impacto (texto): ");
                    String objetivo = lerTexto(scanner, "Objetivo da missão (texto): ");

                    System.out.println("\nODS disponíveis:");
                    System.out.println("1 - Erradicação da pobreza");
                    System.out.println("2 - Fome zero");
                    System.out.println("3 - Saúde e bem-estar");
                    System.out.println("4 - Educação de qualidade");
                    System.out.println("9 - Indústria, inovação e infraestrutura");
                    System.out.println("13 - Ação contra mudança do clima");

                    int ods;
                    do {
                        ods = lerInteiro(scanner, "ODS relacionada (digite o número): ");
                        if (ods != 1 && ods != 2 && ods != 3 && ods != 4 && ods != 9 && ods != 13) {
                            System.out.println("\nERRO: Escolha uma ODS válida.");
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
                    System.out.println("\nStatus disponíveis:");
                    System.out.println("Planejada");
                    System.out.println("Em andamento");
                    System.out.println("Concluída");
                    System.out.println("Cancelada");

                    do {
                        status = lerTexto(scanner, "Status da missão: ");
                        if (!status.equalsIgnoreCase("planejada") && !status.equalsIgnoreCase("em andamento") && !status.equalsIgnoreCase("concluída") && !status.equalsIgnoreCase("concluida") && !status.equalsIgnoreCase("cancelada")) {
                            System.out.println("\nERRO: Digite um status válido.");
                            System.out.println("Opções: Planejada, Em andamento, Concluída, Cancelada");
                        }
                    } while (!status.equalsIgnoreCase("planejada") && !status.equalsIgnoreCase("em andamento") && !status.equalsIgnoreCase("concluída") && !status.equalsIgnoreCase("concluida") && !status.equalsIgnoreCase("cancelada"));

                    if (tipoAnalise == 1) {
                        double sono = lerDouble(scanner, "Alteração do sono (decimal): ");
                        double fadiga = lerDouble(scanner, "Fadiga cognitiva (decimal): ");
                        double perda = lerDouble(scanner, "Perda muscular (decimal): ");

                        AnaliseFisica analiseFisica = new AnaliseFisica(nome, area, objetivo, ods, tecnologia, prioridade, status, sono, fadiga, perda);
                        listaMissoes.add(analiseFisica);
                        System.out.println("\nAnálise física cadastrada!");

                    } else if (tipoAnalise == 2) {
                        double estresse = lerDouble(scanner, "Estresse emocional (1-10): ");
                        double isolamento = lerDouble(scanner, "Isolamento psicológico (1-10): ");
                        double mudancas = lerDouble(scanner, "Mudanças comportamentais (1-10): ");

                        AnalisePsicologica analisePsicologica = new AnalisePsicologica(nome, area, objetivo, ods, tecnologia, prioridade, status, estresse, isolamento, mudancas);
                        listaMissoes.add(analisePsicologica);
                        System.out.println("\nAnálise psicológica cadastrada!");
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

                    int tipoBusca = lerInteiro(scanner, "Escolha a busca (número inteiro): ");
                    boolean encontrou = false;

                    if (tipoBusca == 1) {
                        String nomeBusca = lerTexto(scanner, "Digite o nome da missão (texto): ");
                        for (Missao missao : listaMissoes) {
                            if (missao.getNomeMissao().equalsIgnoreCase(nomeBusca)) {
                                System.out.println(missao);
                                encontrou = true;
                            }
                        }
                    } else if (tipoBusca == 2) {
                        String areaBusca = lerTexto(scanner, "Digite a área de impacto (texto): ");
                        for (Missao missao : listaMissoes) {
                            if (missao.getAreaImpacto().equalsIgnoreCase(areaBusca)) {
                                System.out.println(missao);
                                encontrou = true;
                            }
                        }
                    }

                    if (!encontrou) {
                        System.out.println("\nMissão não encontrada.");
                    }
                    break;

                case 4:
                    String nomeAlterar = lerTexto(scanner, "Digite o nome da missão (texto): ");
                    boolean alterado = false;

                    for (Missao missao : listaMissoes) {
                        if (missao.getNomeMissao().equalsIgnoreCase(nomeAlterar)) {
                            String novoStatus;
                            System.out.println("\nStatus disponíveis:");
                            System.out.println("Planejada");
                            System.out.println("Em andamento");
                            System.out.println("Concluída");
                            System.out.println("Cancelada");

                            do {
                                novoStatus = lerTexto(scanner, "Novo status da missão: ");
                                if (!novoStatus.equalsIgnoreCase("planejada") && !novoStatus.equalsIgnoreCase("em andamento") && !novoStatus.equalsIgnoreCase("concluída") && !novoStatus.equalsIgnoreCase("concluida") && !novoStatus.equalsIgnoreCase("cancelada")) {
                                    System.out.println("\nERRO: Digite um status válido.");
                                    System.out.println("Opções: Planejada, Em andamento, Concluída, Cancelada");
                                }
                            } while (!novoStatus.equalsIgnoreCase("planejada") && !novoStatus.equalsIgnoreCase("em andamento") && !novoStatus.equalsIgnoreCase("concluída") && !novoStatus.equalsIgnoreCase("concluida") && !novoStatus.equalsIgnoreCase("cancelada"));

                            missao.setStatus(novoStatus);
                            System.out.println("\nStatus atualizado!");
                            alterado = true;
                        }
                    }

                    if (!alterado) {
                        System.out.println("\nMissão não encontrada.");
                    }
                    break;

                case 5:
                    int planejada = 0;
                    int andamento = 0;
                    int concluida = 0;
                    int cancelada = 0;
                    Missao maiorPrioridade = null;

                    for (Missao missao : listaMissoes) {
                        String statusAtual = missao.getStatus().toLowerCase();

                        if (statusAtual.equals("planejada")) {
                            planejada++;
                        } else if (statusAtual.equals("em andamento")) {
                            andamento++;
                        } else if (statusAtual.equals("concluída") || statusAtual.equals("concluida")) {
                            concluida++;
                        } else if (statusAtual.equals("cancelada")) {
                            cancelada++;
                        }

                        if (maiorPrioridade == null || missao.getPrioridade() > maiorPrioridade.getPrioridade()) {
                            maiorPrioridade = missao;
                        }
                    }

                    System.out.println("\n===== RESUMO FINAL =====");
                    System.out.println("Total de missões: " + listaMissoes.size());
                    System.out.println("\nQuantidade por status:");
                    System.out.println("Planejada: " + planejada);
                    System.out.println("Em andamento: " + andamento);
                    System.out.println("Concluída: " + concluida);
                    System.out.println("Cancelada: " + cancelada);

                    if (maiorPrioridade != null) {
                        System.out.println("\nMissão com maior prioridade:");
                        System.out.println(maiorPrioridade.getNomeMissao());
                        System.out.println("Prioridade: " + maiorPrioridade.getPrioridade());
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

    public static String lerTexto(Scanner scanner, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String texto = scanner.nextLine().trim();
            if (!texto.isEmpty()) {
                return texto;
            }
            System.out.println("\nERRO: Digite um texto válido.");
        }
    }
}