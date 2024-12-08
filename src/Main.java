import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BaseDeDados baseDeDados = new BaseDeDados();
        baseDeDados.inicializarRegras(); // aqui inicializa as regras

        boolean sair = false;

        while (!sair) {
            System.out.println("\n==== DETRAN - Sistema de Gerenciamento de Multas ====");
            System.out.println("1. Cadastrar Ocorrência");
            System.out.println("2. Processar Ocorrências");
            System.out.println("3. Buscar Multas (data/placa)");
            System.out.println("4. Exibir Relatório de Multas");
            System.out.println("5. Cadastrar Regras");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarOcorrencia(scanner, baseDeDados); //aqui cadastra a ocorrencia
                    break;

                case 2:
                    baseDeDados.processar(); //processa as multas
                    System.out.println("Ocorrências processadas com sucesso!");
                    break;

                case 3:
                    System.out.println("Buscando multas pendentes...\n");
                    buscarMultas(scanner, baseDeDados); //aqui busca e mostra todas as multas pendentes
                    break;

                case 4:
                    System.out.println("Gerando relatorio das multas...\n");
                    baseDeDados.exibirRelatorioMultas(); // aqui mostra os relatorios das multas
                    break;

                case 5:
                    cadastrarRegras(scanner, baseDeDados);
                    break;
                    
                case 6:
                    sair = true;
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        scanner.close();
        System.out.println("Sistema encerrado.");
    }

    private static void cadastrarOcorrencia(Scanner scanner, BaseDeDados baseDeDados) {
        try {
            System.out.print("Digite a placa do veículo: ");
            String placa = scanner.nextLine();

            System.out.print("Digite a data da ocorrência (dd/MM/yyyy): ");
            String dataTexto = scanner.nextLine();
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); //converte para formato de data padrão Brasileiro
            Date data = formato.parse(dataTexto);

            System.out.print("Digite o nome do logradouro: ");
            String logradouro = scanner.nextLine();

            System.out.print("Digite a velocidade registrada (em km/h): ");
            int velocidade = scanner.nextInt();

            System.out.print("Digite o tipo de veículo (0 - Veículo leve, 1 - Caminhão): ");
            int tipoVeiculo = scanner.nextInt();
            scanner.nextLine();

            Ocorrencia ocorrencia = new Ocorrencia(placa, data, logradouro, velocidade, tipoVeiculo);
            baseDeDados.adicionarOcorrencia(ocorrencia);
            System.out.println("Ocorrência cadastrada com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar ocorrência. Verifique os dados inseridos.");
        }
    }

    private static void buscarMultas(Scanner scanner, BaseDeDados baseDeDados) {
        System.out.println("Escolha o critério de busca:");
        System.out.println("1. Buscar por data");
        System.out.println("2. Buscar por placa");
        int criterio = scanner.nextInt();
        scanner.nextLine(); // Consome a quebra de linha

        switch (criterio) {
            case 1:
                System.out.print("Digite a data (dd/MM/yyyy): ");
                String dataTexto = scanner.nextLine();
                try {
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    Date data = formato.parse(dataTexto);

                    System.out.println("Multas na data " + dataTexto + ":");
                    for (Multa multa : baseDeDados.getMultas()) {
                        if (multa.getData().equals(data)) {
                            System.out.println(multa);
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Erro ao buscar multas por data. Verifique o formato da data.");
                }
                break;

            case 2:
                System.out.print("Digite a placa do veículo: ");
                String placa = scanner.nextLine();

                System.out.println("Multas para a placa " + placa + ":");
                for (Multa multa : baseDeDados.getMultas()) {
                    if (multa.getPlaca().equalsIgnoreCase(placa)) {
                        System.out.println(multa);
                    }
                }
                break;

            default:
                System.out.println("Critério inválido.");
        }
    }

    private static void cadastrarRegras(Scanner scanner, BaseDeDados baseDeDados) {
      System.out.println("\n==== Cadastro de Regras ====");
      System.out.println("Escolha o tipo de regra:");
      System.out.println("1. Regra de Velocidade");
      System.out.println("2. Regra de Rodízio");
      System.out.println("3. Regra de Corredor de Ônibus");
      System.out.print("Digite sua opção: ");
  
      int tipo = scanner.nextInt();
      scanner.nextLine(); // Consome quebra de linha
  
      switch (tipo) {
          case 1:
              // Cadastro de RegraVelocidade
              System.out.print("Digite o nome do logradouro: ");
              String logradouroVel = scanner.nextLine();
  
              System.out.print("Digite a velocidade limite (km/h): ");
              int velocidadeLimite = scanner.nextInt();
              scanner.nextLine();
  
              if (velocidadeLimite > 0) {
                  RegraVelocidade regraVel = new RegraVelocidade(velocidadeLimite, logradouroVel);
                  baseDeDados.getRegras().add(regraVel);
                  System.out.println("Regra de Velocidade cadastrada com sucesso!");
              } else {
                  System.out.println("Erro: Velocidade limite deve ser positiva.");
              }
              break;
  
          case 2:
              // Cadastro de RegraRodizio
              System.out.print("Digite o final da placa afetado (0 a 9): ");
              int finalPlaca = scanner.nextInt();
              scanner.nextLine();
  
              if (finalPlaca < 0 || finalPlaca > 9) {
                  System.out.println("Erro: Final de placa inválido.");
                  return;
              }
  
              System.out.print("Digite o(s) logradouro(s) afetado(s), separados por vírgula: ");
              String logradouros = scanner.nextLine();
              String[] logradourosAfetados = logradouros.split(",");
  
              System.out.print("Digite o dia da semana afetado (1 = Domingo, 7 = Sábado): ");
              int diaDaSemana = scanner.nextInt();
              scanner.nextLine();
  
              if (diaDaSemana < 1 || diaDaSemana > 7) {
                  System.out.println("Erro: Dia da semana inválido.");
                  return;
              }
  
              System.out.print("Digite o tipo de veículo (0 - Veículo leve, 1 - Caminhão): ");
              int tipoVeiculo = scanner.nextInt();
              scanner.nextLine();
  
              RegraRodizio regraRod = new RegraRodizio(finalPlaca, logradourosAfetados, diaDaSemana, tipoVeiculo);
              baseDeDados.getRegras().add(regraRod);
              System.out.println("Regra de Rodízio cadastrada com sucesso!");
              break;
  
          case 3:
              // Cadastro de RegraCorredorOnibus
              System.out.print("Digite o nome do logradouro: ");
              String logradouroOnibus = scanner.nextLine();
  
              System.out.print("Digite a hora inicial (0 a 23): ");
              int horaInicial = scanner.nextInt();
  
              System.out.print("Digite a hora final (0 a 23): ");
              int horaFinal = scanner.nextInt();
              scanner.nextLine();
  
              if (horaInicial < 0 || horaInicial > 23 || horaFinal < 0 || horaFinal > 23 || horaInicial >= horaFinal) {
                  System.out.println("Erro: Horário inválido.");
                  return;
              }
  
              RegraCorredorOnibus regraOnibus = new RegraCorredorOnibus(horaInicial, horaFinal, logradouroOnibus);
              baseDeDados.getRegras().add(regraOnibus);
              System.out.println("Regra de Corredor de Ônibus cadastrada com sucesso!");
              break;
  
          default:
              System.out.println("Opção inválida.");
      }
  }
  
}
