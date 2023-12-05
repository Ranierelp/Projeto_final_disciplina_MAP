import java.util.Scanner;

public class InterfaceUsuario {
    private Barbearia barbearia;

    public InterfaceUsuario(Barbearia barbearia) {
        this.barbearia = barbearia;
    }

    public void executar() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Bem-vindo a Barbearia!");
            System.out.println("1. Ver barbeiros e horários disponíveis");
            System.out.println("2. Agendar um horário");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");

            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    exibirBarbeirosEHorariosDisponiveis();
                    break;
                case 2:
                    agendarHorario(scanner);
                    break;
                case 3:
                    System.out.println("Obrigado por usar nosso sistema. Adeus!");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void exibirBarbeirosEHorariosDisponiveis() {
        System.out.println("Barbeiros disponíveis:");
        for (Barbeiro barbeiro : barbearia.getBarbeiros().values()) {
            System.out.println("- " + barbeiro.getNome());
            System.out.println("  Horários disponíveis:");
            for (String horario : barbeiro.getHorariosDisponiveis()) {
                System.out.print(horario + " ");
            }
            System.out.println();
        }
    }

    private void agendarHorario(Scanner scanner) {
        System.out.print("Digite seu nome: ");
        String nomeCliente = scanner.nextLine();

        System.out.println("Escolha um barbeiro:");
        for (String nomeBarbeiro : barbearia.getBarbeiros().keySet()) {
            System.out.println("- " + nomeBarbeiro);
        }
        System.out.print("Barbeiro escolhido: ");
        String barbeiroSelecionado = scanner.nextLine();

        Barbeiro barbeiro = barbearia.getBarbeiros().get(barbeiroSelecionado);
        if (barbeiro == null) {
            System.out.println("Barbeiro não encontrado. Tente novamente.");
            return;
        }

        System.out.println("Escolha um horário disponível:");
        for (String horario : barbeiro.getHorariosDisponiveis()) {
            System.out.print("- " + horario + " ");
        }
        System.out.println();
        System.out.print("Horário escolhido: ");
        String horarioSelecionado = scanner.nextLine();

        barbearia.agendarHorario(nomeCliente, barbeiroSelecionado, horarioSelecionado);
    }
}

