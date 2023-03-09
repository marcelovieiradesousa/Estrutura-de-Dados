public class ListaCircular<T> {
  private No<T> cabeça;
  private No<T> cauda;
  private int tamanhoLista;

  public ListaCircular() {
    this.cabeça = null;
    this.cauda = null;
    this.tamanhoLista = 0;
  }

  public void add(T conteudo){
    No<T> novoNo = new No<T>(conteudo);
    if(tamanhoLista == 0){
      cabeça = novoNo;
      cauda = cabeça;
      cabeça.setProximoNo(cauda);
    }else{
      novoNo.setProximoNo(cauda);
      cabeça.setProximoNo(novoNo);
      cauda = novoNo;
    }
    tamanhoLista++;
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
  @Override
  public String toString() {
      String strRetorno = "";
      No<T> noAuxiliar = this.cauda;
      for(int i = 0; i < size(); i++){
          strRetorno += "[No{conteudo=" + noAuxiliar.getConteudo() +"}]--->";
          noAuxiliar = noAuxiliar.getProximoNo();
      }
      strRetorno += size() != 0 ? "(Retorna ao início)" : "[]";
      return strRetorno;
  }

  public static void main(String[] args) {
    ListaCircular<String> minhListaCircular = new ListaCircular<>();

    minhListaCircular.add("pizza1");

    System.out.println((minhListaCircular.toString()));

    minhListaCircular.remove(0);

    System.out.println((minhListaCircular.toString()));
  }
}
