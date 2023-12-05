import java.util.*;

public class Barbearia implements Observador {
    private Map<String, Barbeiro> barbeiros = new HashMap<>();
    private List<Agendamento> agendamentos = new ArrayList<>();

    public Barbearia() {
        inicializarBarbeiros();
    }

    private void inicializarBarbeiros() {
        barbeiros.put("Arthur", new Barbeiro("Arthur"));
        barbeiros.put("Raniere", new Barbeiro("Raniere"));
    }

    public void exibirBarbeirosEHorariosDisponiveis() {
        System.out.println("Barbeiros disponíveis:");
        for (Barbeiro barbeiro : barbeiros.values()) {
            System.out.println("- " + barbeiro.getNome());
            System.out.println("  Horários disponíveis:");
            for (String horario : barbeiro.getHorariosDisponiveis()) {
                System.out.print(horario + " ");
            }
            System.out.println();
        }
    }

    public void agendarHorario(String nomeCliente, String nomeBarbeiro, String horario) {
        Barbeiro barbeiro = barbeiros.get(nomeBarbeiro);
        if (barbeiro == null) {
            System.out.println("Barbeiro não encontrado. Tente novamente.");
            return;
        }

        if (barbeiro.getHorariosDisponiveis().contains(horario)) {
            agendamentos.add(new Agendamento(nomeCliente, nomeBarbeiro, horario));
            barbeiro.removerHorarioDisponivel(horario);
            System.out.println("Agendamento realizado com sucesso!");
        } else {
            System.out.println("Horário indisponível. Tente novamente.");
        }
    }

    @Override
    public void atualizar(String mensagem) {
        System.out.println("Notificação: " + mensagem);
    }

    public Map<String, Barbeiro> getBarbeiros() {
        return barbeiros;
    }

}