public class ListaCircular<T> {
  private No<T> cabeça;
  private No<T> cauda;
  private int tamanhoLista;

  public ListaCircular() {
    this.tamanhoLista = 0;
  }

  public Boolean isEmpty() {
    return (size() == 0) ? true : false;
  }
  
  public T get(int index){
    return getNo(index).getConteudo();
  }

  public void remove(int index){
    if(index >= tamanhoLista) throw new IndexOutOfBoundsException("Lista vazia");

    No<T> noAuxiliar = cauda;
    if(index == 0){
      cauda = cauda.getProximoNo();
      cabeça.setProximoNo(cauda);
    } else if(index == 1){
      cauda.setProximoNo(cauda.getProximoNo().getProximoNo());
    } else{
      for(int i = 0; i < index -1; i++){
        noAuxiliar = noAuxiliar.getProximoNo();
      }
      noAuxiliar.setProximoNo(noAuxiliar.getProximoNo().getProximoNo());
    }
    tamanhoLista--;
  }

  public int size() {
    return tamanhoLista;
  }


  private No<T> getNo(int index) {
    if (isEmpty())
      throw new IndexOutOfBoundsException("Lista está vazia!");

    if (tamanhoLista == 0)
      return cauda;

    No<T> noAuxiliar = cabeça;
    for (int i = 0; (i < index) && (noAuxiliar != null); i++) {
      noAuxiliar = noAuxiliar.getProximoNo();
    }
    return noAuxiliar;
  }
}
