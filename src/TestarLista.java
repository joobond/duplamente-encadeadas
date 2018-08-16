public class TestarLista {

    public static void main(String[] args) {

        Lista lista = new Lista();

        lista.inserirInicio(new No(10));
        lista.inserirInicio(new No(12));
        lista.inserirFim(new No(8));
        lista.inserirFim(new No(7));
        lista.inserirFim(new No(6));
        lista.inserir(new No(9), 3);

        lista.imprimir();
    }
}
