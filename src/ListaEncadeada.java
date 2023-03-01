public class ListaEncadeada<T> {
  private No<T> referenciaEntrada;
  // A referenciaEntrada vai ser sempre o nó de índice 0 para auxiliar a contagem da lista. Caso remova o índice 0, ela passa ser o nó de índice 1 e por aí em diante.
  public ListaEncadeada() {
    this.referenciaEntrada = null;
  }

  public void add(T conteudo) {
    No<T> novoNo = new No(conteudo);
    if (this.isEmpty()) {
      referenciaEntrada = novoNo; //entrada = nó[0]
      return;
    }
    No<T> noAuxiliar = referenciaEntrada;
    for (int i = 0; i < size() - 1; i++) {
      noAuxiliar = noAuxiliar.getProximoNo();
    }
    noAuxiliar.setProximoNo(novoNo);
  }

  public T get(int index) {
    return getNo(index).getConteudo();
  }

  public T remove(int index) {
    validaIndice(index);
    No<T> noPivor = getNo(index);
    if (index == 0) {
      referenciaEntrada = noPivor.getProximoNo();//entrada = nó[1]
      return noPivor.getConteudo();
    }
    No<T> noAnterior = getNo(index - 1);
    noAnterior.setProximoNo(noPivor.getProximoNo());
    return noPivor.getConteudo();
  }

  @Override
  public String toString() {
    String strRetorno = "";
    No<T> noAux = referenciaEntrada;
    for(int i=0; i < size(); i++){
      strRetorno += "[No{conteudo = "+ noAux.getConteudo()+"}] --->";
      noAux = noAux.getProximoNo();
    }
    return strRetorno;

  }

  private int size() {
    int tamanhoLista = 0;
    No<T> referenciaAux = referenciaEntrada;
    while (true) {
      if (referenciaAux != null) {
        tamanhoLista++;
        if (referenciaAux.getProximoNo() != null) {
          referenciaAux = referenciaAux.getProximoNo();
        } else {
          break;
        }
      } else {
        break;
      }
    }
    return tamanhoLista;
  }

  public boolean isEmpty() {
    return referenciaEntrada == null ? true : false;
  }

  private No<T> getNo(int index) {
    validaIndice(index);
    No<T> noAuxiliar = referenciaEntrada;
    No<T> noRetorno = null;
    for (int i = 0; i <= index; i++) {
      noRetorno = noAuxiliar;
      noAuxiliar = noAuxiliar.getProximoNo();
    }
    return noRetorno;
  }

  private void validaIndice(int index) {
    if (index >= size()) {
      int ultimoIndice = size() - 1;
      throw new IndexOutOfBoundsException("Não existe conteúdo no índice " + index
          + " desta lista. Esta lista só vai até o índice " + ultimoIndice + '.');
    }
  }


  public static void main(String args[]){

    ListaEncadeada<String> minhaListaEncadeada = new ListaEncadeada<>();

    minhaListaEncadeada.add("teste1");
    minhaListaEncadeada.add("teste2");
    minhaListaEncadeada.add("teste3");
    minhaListaEncadeada.add("teste4");

    System.out.println(minhaListaEncadeada.get(0));
    System.out.println(minhaListaEncadeada.get(1));
    System.out.println(minhaListaEncadeada.get(2));
    System.out.println(minhaListaEncadeada.get(3));

    System.out.println(minhaListaEncadeada);

    minhaListaEncadeada.remove(0);

    System.out.println(minhaListaEncadeada);

    minhaListaEncadeada.add("teste5");

    System.out.println(minhaListaEncadeada);

}
}
