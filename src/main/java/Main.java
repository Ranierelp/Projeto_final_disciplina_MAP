public class Main {
    public static void main(String[] args) {

        Barbearia barbearia = new Barbearia();

        InterfaceUsuario interfaceUsuario = new InterfaceUsuario(barbearia);

        interfaceUsuario.executar();
    }
}

