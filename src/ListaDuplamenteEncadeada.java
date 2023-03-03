public class ListaDuplamenteEncadeada<T> {
  private NoDuplo<T> primeiroNo;
  private NoDuplo<T> ultimoNo;
  private int tamanhoLista;

  public ListaDuplamenteEncadeada() {
    this.primeiroNo = null;
    this.ultimoNo = null;
    this.tamanhoLista = 0;
  }

  public void add(T conteudo) {
    NoDuplo<T> novoNo = new NoDuplo<T>(conteudo);
    novoNo.setProximoNo(null);
    novoNo.setAnteriorNo(ultimoNo);
    if (primeiroNo == null) {
      primeiroNo = novoNo;
    }
    if (ultimoNo != null) {
      ultimoNo.setProximoNo(novoNo);
    }
    ultimoNo = novoNo;
    tamanhoLista++;
  }

  public void add(int index, T conteudo) {
    NoDuplo<T> noAux = getNo(index);
    NoDuplo<T> novoNoDuplo = new NoDuplo<>(conteudo);
    novoNoDuplo.setProximoNo(noAux);
    if (novoNoDuplo.getProximoNo() != null) {
      novoNoDuplo.setAnteriorNo(novoNoDuplo.getAnteriorNo());
      novoNoDuplo.getProximoNo().setAnteriorNo(novoNoDuplo);
    } else {
      novoNoDuplo.setAnteriorNo(ultimoNo);
      ultimoNo = novoNoDuplo;
    }
    if (index == 0) {
      primeiroNo = novoNoDuplo;
    } else {
      novoNoDuplo.getAnteriorNo().setProximoNo(novoNoDuplo);
    }
    tamanhoLista++;
  }

  public int size() {
    return tamanhoLista;
  }

  public T get(int index) {
    return getNo(index).getConteudo();
  }

  private NoDuplo<T> getNo(int index) {
    NoDuplo<T> noAuxiliar = primeiroNo;
    for (int i = 0; (i < index) && (noAuxiliar != null); i++) {
      noAuxiliar = noAuxiliar.getProximoNo();
    }
    return noAuxiliar;
  }
}
