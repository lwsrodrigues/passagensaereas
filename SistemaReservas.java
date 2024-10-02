import java.util.Scanner;

public class SistemaReservas {

    private int[][] valor = new int[30][10]; // Linhas e colunas
    private int total = 30;
    private int quantidade;

    public static void main(String[] args) {
        SistemaReservas sistema = new SistemaReservas();
        sistema.inicio();
    }

    private void inicio() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("PASSAGENS AÉREAS / RESERVAS");
            System.out.println("1. Cadastrar / Editar o total de poltronas da aeronave");
            System.out.println("2. Realizar reserva de poltrona");
            System.out.println("3. Visualizar as poltronas disponíveis");
            System.out.println("4. Visualizar poltronas reservadas");
            System.out.println("5. Consultar passageiro pelo nome");
            System.out.println("6. Total de poltronas reservadas e disponíveis");
            System.out.println("7. Sair do sistema");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastro(scanner);
                    break;
                case 2:
                    reserva(scanner);
                    break;
                case 3:
                    listarDisponiveis();
                    break;
                case 4:
                    listarReservadas();
                    break;
                case 5:
                    consultarNome();
                    break;
                case 6:
                    totalReservas();
                    break;
                case 7:
                    sair();
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 7);
        scanner.close();
    }

    private void cadastro(Scanner scanner) {
        System.out.print("Informe a quantidade de poltronas da aeronave: ");
        total = scanner.nextInt();
        for (int i = 0; i < valor.length; i++) {
            for (int j = 0; j < valor[i].length; j++) {
                valor[i][j] = 0; // Inicializa todas as poltronas como disponíveis
            }
        }
        System.out.println("Cadastro realizado!");
    }

    private void reserva(Scanner scanner) {
        System.out.print("Informe a poltrona desejada (linha): ");
        int linha = scanner.nextInt();

        System.out.print("Informe a coluna desejada: ");
        int coluna = scanner.nextInt();

        if (linha < 30 && coluna < 10) {
            if (valor[linha][coluna] == 0) {
                valor[linha][coluna] = 1; // Reserva a poltrona
                System.out.println("Reserva realizada com sucesso!");
            } else {
                System.out.println("A poltrona já está reservada!");
            }
        } else {
            System.out.println("Poltrona inválida!");
        }
    }

    private void listarDisponiveis() {
        StringBuilder disponiveis = new StringBuilder("Poltronas disponíveis:\n");
        for (int i = 0; i < valor.length; i++) {
            for (int j = 0; j < valor[i].length; j++) {
                if (valor[i][j] == 0) {
                    disponiveis.append("Linha ").append(i).append(", Coluna ").append(j).append("\n");
                }
            }
        }
        System.out.println(disponiveis.toString());
    }

    private void listarReservadas() {
        StringBuilder reservadas = new StringBuilder("Poltronas reservadas:\n");
        for (int i = 0; i < valor.length; i++) {
            for (int j = 0; j < valor[i].length; j++) {
                if (valor[i][j] == 1) {
                    reservadas.append("Linha ").append(i).append(", Coluna ").append(j).append("\n");
                }
            }
        }
        if (reservadas.length() > 0) {
            System.out.println(reservadas.toString());
        } else {
            System.out.println("Nenhuma reserva encontrada!");
        }
    }

    private void consultarNome() {
        // Implementar a lógica de consulta pelo nome do passageiro
        System.out.println("Funcionalidade ainda não implementada.");
    }

    private void totalReservas() {
        int totalReservadas = 0;
        for (int i = 0; i < valor.length; i++) {
            for (int j = 0; j < valor[i].length; j++) {
                if (valor[i][j] == 1) {
                    totalReservadas++;
                }
            }
        }
        String mensagem = "Total de poltronas disponíveis: " + (total * 10 - totalReservadas) + "\n" +
                          "Total de poltronas reservadas: " + totalReservadas;
        System.out.println(mensagem);
    }

    private void sair() {
        System.out.println("Programa finalizado com sucesso!");
    }
}
