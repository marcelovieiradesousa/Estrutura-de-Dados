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
      novoNoDuplo.setAnteriorNo(noAux.getAnteriorNo());
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

  public void remove(int index) {
    if (index == 0) {
      primeiroNo = primeiroNo.getProximoNo();
      if (primeiroNo != null) {
        primeiroNo.setAnteriorNo(null);
      }
    } else {
      NoDuplo<T> auxNoDuplo = getNo(index);
      auxNoDuplo.getAnteriorNo().setProximoNo(auxNoDuplo.getProximoNo());
      if (auxNoDuplo != ultimoNo) {
        auxNoDuplo.getProximoNo().setAnteriorNo(auxNoDuplo.getAnteriorNo());
      } else {
        ultimoNo = auxNoDuplo;
      }
    }
    this.tamanhoLista--;
  }

  public int size() {
    return tamanhoLista;
  }

  @Override
  public String toString() {
    String strRetorno = "";
    NoDuplo<T> noAuxiliar = primeiroNo;
    for (int i = 0; i < size(); i++) {
      strRetorno += "[No{conteudo=" + noAuxiliar.getConteudo() + "}]--->";
      noAuxiliar = noAuxiliar.getProximoNo();
    }
    strRetorno += "null";

    return strRetorno;
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

  public static void main(String[] args) {
    ListaDuplamenteEncadeada<String> minhaListaDupla = new ListaDuplamenteEncadeada<>();

    minhaListaDupla.add("alvin1");
    minhaListaDupla.add("alvin2");
    minhaListaDupla.add("alvin3");
    minhaListaDupla.add("alvin4");
    minhaListaDupla.add("alvin5");

    System.out.println(minhaListaDupla);

    minhaListaDupla.remove(4);

    System.out.println(minhaListaDupla);

    minhaListaDupla.add(1, "alvin22");

    System.out.println(minhaListaDupla);

    System.out.println(minhaListaDupla.get(3));
  }
}
