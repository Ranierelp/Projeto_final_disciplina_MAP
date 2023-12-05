import java.util.ArrayList;
import java.util.List;

class Barbeiro extends Sujeito {
    private String nome;
    private List<String> horariosDisponiveis;

    public Barbeiro(String nome) {
        this.nome = nome;
        this.horariosDisponiveis = new ArrayList<>();
        inicializarHorariosDisponiveis();
    }

    private void inicializarHorariosDisponiveis() {
        horariosDisponiveis.add("09:00");
        horariosDisponiveis.add("11:00");
        horariosDisponiveis.add("13:00");
        horariosDisponiveis.add("15:00");
    }

    public String getNome() {
        return nome;
    }

    public List<String> getHorariosDisponiveis() {
        return horariosDisponiveis;
    }

    public void adicionarHorarioDisponivel(String horario) {
        horariosDisponiveis.add(horario);
        notificarObservadores("Horário adicionado: " + horario);
    }

    public void removerHorarioDisponivel(String horario) {
        horariosDisponiveis.remove(horario);
        notificarObservadores("Horário removido: " + horario);
    }
}
