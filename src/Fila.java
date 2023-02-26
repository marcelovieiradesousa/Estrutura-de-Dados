public class Fila<T> {
  private No<T> refNoEntradaFila;

  public Fila() {
    this.refNoEntradaFila = null;
  }

  public T first() {
    if (!isEmpty()) {
      No<T> primeiroNo = refNoEntradaFila;
      while (true) {
        if (primeiroNo.getProximoNo() != null) {
          primeiroNo = primeiroNo.getProximoNo();
        } else {
          break;
        }
      }
      return (T) primeiroNo;
    }
    return null;
  }

  public void enqueue(T object) {
    No novoNo = new No(object);
    novoNo.setProximoNo(refNoEntradaFila);
    refNoEntradaFila = novoNo;
  }

  public No<T> dequeue() {
    if (!isEmpty()) {
      No<T> primeiroNo = refNoEntradaFila;
      No<T> noAuxiliar = refNoEntradaFila;
      while (true) {
        if (primeiroNo.getProximoNo() != null) {
          noAuxiliar = primeiroNo;
          primeiroNo = primeiroNo.getProximoNo();
        } else {
          noAuxiliar.setProximoNo(null);
          break;
        }
      }
      return primeiroNo;
    }
    return null;
  }

  public Boolean isEmpty() {
    return refNoEntradaFila == null ? true : false;
  }

  @Override
  public String toString() {
    String stringRetorno = "";
    No<T> noAuxiliar = refNoEntradaFila;

    if (refNoEntradaFila != null) {
      while (true) {
        stringRetorno += "[No{dado=" + noAuxiliar.getConteudo() + "}]--->";
        if (noAuxiliar.getProximoNo() != null) {
          noAuxiliar = noAuxiliar.getProximoNo();
        } else {
          stringRetorno += "null";
          break;
        }
      }
    } else {
      stringRetorno = "null";
    }
    return stringRetorno;
  }

  public static void main(String[] args) {
    Fila<Integer> minhaFila = new Fila<>();

    minhaFila.enqueue(1);
    minhaFila.enqueue(2);
    minhaFila.enqueue(3);
    minhaFila.enqueue(4);

    System.out.println(minhaFila);

    System.out.println("dequeue:::"+minhaFila.dequeue());

    System.out.println(minhaFila);

    minhaFila.enqueue(5);

    System.out.println("enqueue '5' :::"+minhaFila);

    System.out.println("first:::"+minhaFila.first());

    System.out.println(minhaFila);
  }
}
