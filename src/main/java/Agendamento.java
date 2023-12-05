class Agendamento {
    private String nomeCliente;
    private String nomeBarbeiro;
    private String horarioAgendado;

    public Agendamento(String nomeCliente, String nomeBarbeiro, String horarioAgendado) {
        this.nomeCliente = nomeCliente;
        this.nomeBarbeiro = nomeBarbeiro;
        this.horarioAgendado = horarioAgendado;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getNomeBarbeiro() {
        return nomeBarbeiro;
    }

    public String getHorarioAgendado() {
        return horarioAgendado;
    }
}