//Feitos:
//Não feitos: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
public class Lista {

    private No inicio;
    private No fim;
    private int quantidade;

    public Lista() {
        this.quantidade = 0;
        inicio = fim = null;
    }

    public boolean isVazia() {
        return this.inicio == null;
    }

    public void inserirInicio(No no) {
        if (isVazia()) {
            inicio = no;
            fim = no;
        } else {
            no.setProximo(this.inicio);
            inicio.setProximo(no);
            this.inicio = no;
        }
        quantidade++;
    }


    public void inserirFim(No no) {
        if (isVazia()) {
            inserirInicio(no);
        } else {
            no.setAnterior(this.fim);
            fim.setProximo(no);
            this.fim = no;
        }
        quantidade++;
    }

    public void inserir(No no, int posicao) {
        if (isVazia() || posicao <= 1) {
            inserirInicio(no);
        } else if (posicao > quantidade) {
            inserirFim(no);
        } else {
            No aux = this.inicio;
            for (int i = 1; i < posicao; i++) {
                aux = aux.getProximo();
            }
            no.setProximo(aux);
            no.setAnterior(aux.getAnterior());
            no.getAnterior().setProximo(no);
            aux.setAnterior(no);
        }
        quantidade++;
    }

    public void imprimir(){
        if(isVazia()){
            System.out.println("A lista está vazia!");
        }else{
            No aux = this.inicio;
            while(aux != null){
                System.out.println(aux.getElemento());
                aux = aux.getProximo();
            }
        }
    }

    public No remover(int posicao) {
        No aux = inicio;
        if (!isVazia() && posicao >= 1 && posicao <= quantidade) {
            if (posicao == 1) {
                inicio = aux.getProximo();

                if (inicio != null) {
                    inicio.setAnterior(null);
                } else if (posicao == quantidade) {
                    aux = fim;
                    fim = fim.getAnterior();
                    fim.setProximo(null);

                }
            } else {
                for (int i = 1; i < posicao; i++) {
                    aux = aux.getProximo();
                }
                aux.getAnterior().setProximo(aux.getProximo());
                aux.getProximo().setAnterior(aux.getAnterior());
            }
            aux.setProximo(null);
            aux.setAnterior(null);
            quantidade--;
        }
        return aux;
    }

    //01
    public boolean removerExtremidades(){
        if(!isVazia()){
            this.remover();
            this.remover(quantidade);
            return true;
        }else{
            System.out.println("A lista está vazia!");
            return false;
        }
    }
}
