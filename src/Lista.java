//Feitos: 1, 2, 3, 4, 5, 9, 10
//Não feitos: 6, 7, 8
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
            quantidade++;
        }

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

    public void imprimir() {
        if (isVazia()) {
            System.out.println("A lista está vazia!");
        } else {
            No aux = this.inicio;
            while (aux != null) {
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
    public No removerPrimeiro(){
        return this.remover(1);
    }

    //01
    public No removerUltimo(){
        return this.remover(quantidade);
    }

    //02
    public double maior() {
        double maior = 0;
        int contador = 0;
        if (!isVazia()) {
            No aux = this.inicio;
            while (aux != null) {
                if (aux.getElemento() > maior) {
                    maior = aux.getElemento();
                }
                aux = aux.getProximo();
            }
            return maior;
        } else {
            System.out.println("Não foi possível mostrar o maior, pois a lista está vazia!");
            return 0.0;
        }
    }

    //02
    public double menor() {
        double menor = 0;
        int contador = 0;
        if (!isVazia()) {
            No aux = this.inicio;
            while (aux != null) {
                if (contador == 0) {
                    menor = aux.getElemento();
                    contador++;
                } else if (aux.getElemento() < menor) {
                    menor = aux.getElemento();
                }
                aux = aux.getProximo();
            }
            return menor;
        } else {
            System.out.println("Não foi possível mostrar o menor, pois a lista está vazia!");
            return 0.0;
        }
    }

    //02
    public double media() {
        double media = 0;
        int acumulador = 0;
        double contador = 0;
        if (!isVazia()) {
            No aux = this.inicio;
            while (aux != null) {
                acumulador += aux.getElemento();
                aux = aux.getProximo();
                contador++;
            }
            media = acumulador / contador;
            return media;
        } else {
            System.out.println("Não foi possível calcular, pois a lista está vazia!");
            return 0.0;
        }
    }

    //03
    public int pares() {
        int contador = 0;
        if (!isVazia()) {
            No aux = this.inicio;
            while (aux != null) {
                if (aux.getElemento() % 2 == 0) {
                    contador++;
                }
                aux = aux.getProximo();
            }
            return contador;
        } else {
            System.out.println("Não foi possível ver quantos pares tem, pois a lista está vazia!");
            return 0;
        }
    }

    //04
    public Lista trocarValor(Lista lista, int antigo, int novo) {
        Lista nova = new Lista();
        No aux = lista.inicio;
        if (!lista.isVazia()) {
            while (aux != null) {
                if (aux.getElemento() == antigo) {
                    nova.inserirFim(new No(novo));
                } else {
                    nova.inserirFim(new No(aux.getElemento()));
                }
                aux = aux.getProximo();
            }
            return nova;
        } else {
            System.out.println("A lista passada está vazia!");
            return null;
        }
    }

    public boolean contem(int valor) {
        No aux = this.inicio;
        if (!isVazia()) {
            while (aux != null) {
                if (aux.getElemento() == valor) {
                    return true;
                } else {
                    aux = aux.getProximo();
                }
            }
            return false;
        } else {
            System.out.println("A lista está vazia!");
            return false;
        }
    }

    public Lista eliminarRepetidos() {
        Lista nova = new Lista();
        No aux = this.inicio;
        if (!isVazia()) {
            while (aux != null) {
                if (!nova.contem(aux.getElemento())) {
                    nova.inserirFim(new No(aux.getElemento()));
                }
                aux = aux.getProximo();
            }
            return nova;
        } else {
            System.out.println("A lista está vazia, chefe!");
            return null;
        }
    }


    //05
    public Lista uniao(Lista parametro) {
        if (!this.isVazia() && !parametro.isVazia()) {
            Lista todos = this.clonarNaLista(parametro);
            todos = todos.eliminarRepetidos();
            return todos;
        } else {
            System.out.println("Aconteceu algum erro!");
            return null;
        }

    }

    //05
    public Lista interseccao(Lista parametro) {
        if (!isVazia() && !parametro.isVazia()) {
            Lista nova = new Lista();
            No aux = this.inicio;
            while (aux != null) {
                if (parametro.contem(aux.getElemento())) {
                    nova.inserirFim(new No(aux.getElemento()));
                }
                aux = aux.getProximo();
            }
            return nova;
        } else {
            System.out.println("Aconteceu algum erro na intersecção!");
            return null;
        }
    }

    //05
    public Lista diferenca(Lista parametro) {
        if (!isVazia() && !parametro.isVazia()) {
            Lista nova = new Lista();
            No aux = this.inicio;
            while (aux != null) {
                if (!parametro.contem(aux.getElemento())) {
                    nova.inserirFim(new No(aux.getElemento()));
                }
                aux = aux.getProximo();
            }
            return nova;
        } else {
            System.out.println("Houve erro em encotrar a diferença!");
            return null;
        }
    }

    public Lista zerar() {
        this.inicio = null;
        this.fim = null;
        this.quantidade = 0;
        return this;
    }


    /*
    //07
    public boolean eIgual(Lista parametro) {
        if (this.quantidade == parametro.quantidade) {

        } else {
            System.out.println("As listas não são iguais!");
            return false;
        }
    }
    */
    //08
    public Lista ordenar() {
        Lista ordenada = new Lista();
        if(!isVazia()){
            No aux = inicio;
            while(aux != null){
                ordenada.inserirOrdenado(new No(aux.getElemento()));
                aux = aux.getProximo();
            }
            return ordenada;
        }else{
            return null;
        }

    }

    //09
    public Lista dividir(int posicao) {
        Lista nova = new Lista();

        if(isVazia()){
            return null;
        }

        for(int i = posicao; i < this.quantidade; i++) {
            nova.inserirFim(new No(this.pegarPosicao(i).getElemento()));
        }

        return nova;
    }

    public No pegarPosicao(int pos) {
        if(isVazia()){
            return null;
        }
        if(pos == 0) {
            return this.inicio;
        }
        No aux = this.inicio;

        for(int i = 0; i < pos; i++) {
            aux = aux.getProximo();
        }

        return aux;
    }

    //10
    public Lista clonarNaLista(Lista parametro) {
        No aux = this.inicio;
        if (!isVazia()) {
            while (aux != null) {
                parametro.inserirFim(new No(aux.getElemento()));
                aux = aux.getProximo();
            }
            return parametro;
        } else {
            System.out.println("A lista está vazia!");
            return null;
        }
    }

    public void inserirOrdenado(No no){
        if(isVazia()){
            inicio = no;
        }else{
            No aux = inicio;
            No anterior = inicio;

            if(no.getElemento() < inicio.getElemento()){
                no.setProximo(inicio);
                inicio =  no;
            }else{
                while(no.getElemento() > aux.getElemento() || aux.getProximo() != null){
                    anterior =  aux;
                    aux = aux.getProximo();
                }
                anterior.setProximo(no);
                no.setProximo(aux);
            }
        }

    }
}