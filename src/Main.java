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
            System.out.println("3. Buscar Multas (por data ou placa)");
            System.out.println("4. Exibir Relatório de Multas");
            System.out.println("5. Sair");
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
}
