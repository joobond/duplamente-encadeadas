public class TestarLista {

    public static void main(String[] args) {

        Lista lista = new Lista();
        Lista teste = new Lista();
        teste.inserirFim(new No(0));
        teste.inserirFim(new No(1));
        teste.inserirFim(new No(8));

        lista.inserirInicio(new No(10));
        lista.inserirInicio(new No(12));
        lista.inserirFim(new No(8));
        lista.inserirFim(new No(7));
        lista.inserirFim(new No(6));
        lista.inserir(new No(9), 3);
        System.out.println("Lista: ");
        lista.imprimir();
        System.out.println("------");
        System.out.println("Elemento removido:" + lista.remover(3).getElemento());
        System.out.println("Lista: ");
        lista.imprimir();
        System.out.println("------");
        System.out.println("Extremidades Removidas!");
        //lista.removerExtremidades();
        System.out.println("Lista: ");
        lista.imprimir();
        System.out.println("------");
        System.out.println("Menor: "+lista.menor());
        System.out.println("Maior: "+lista.maior());
        System.out.println("Média: "+lista.media());
        System.out.println("Quantidade de pares: "+lista.pares());
        //lista = lista.trocarValor(lista, 8,10);
        System.out.println("------");
        System.out.println("Lista: ");
        lista.imprimir();
        System.out.println("Contém 10? "+lista.contem(10));
        lista = lista.eliminarRepetidos();
        System.out.println("Sem repetidos: ");
        System.out.println("------");
        lista.imprimir();
        System.out.println("Clonando na lista 'teste '");
        lista.clonarNaLista(teste);
        System.out.println("---TESTE---");
        teste.imprimir();
        System.out.println("--UNIAO----");
        Lista uniao = lista.uniao(teste);
        uniao.imprimir();
    }
}
