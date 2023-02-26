public class Fila {
  private NoInteiro refNoEntradaFila = null;

  public Fila() {
    this.refNoEntradaFila = null;
  }

  public NoInteiro first() {
    if (!isEmpty()) {
      NoInteiro primeiroNo = refNoEntradaFila;
      while (true) {
        if (primeiroNo.getRefNo() != null) {
          primeiroNo = primeiroNo.getRefNo();
        } else {
          break;
        }
      }
      return primeiroNo;
    }
    return null;
  }

  public void enqueue(NoInteiro novoNo) {
    novoNo.setRefNo(refNoEntradaFila);
    refNoEntradaFila = novoNo;
  }

  public NoInteiro dequeue() {
    if (!isEmpty()) {
      NoInteiro primeiroNo = refNoEntradaFila;
      NoInteiro noAuxiliar = refNoEntradaFila;
      while (true) {
        if (primeiroNo.getRefNo() != null) {
          noAuxiliar = primeiroNo;
          primeiroNo = primeiroNo.getRefNo();
        } else {
          noAuxiliar.setRefNo(null);
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
    NoInteiro noAuxiliar = refNoEntradaFila;

    if (refNoEntradaFila != null) {
      while (true) {
        stringRetorno += "[No{dado=" + noAuxiliar.getDado() + "}]--->";
        if (noAuxiliar.getRefNo() != null) {
          noAuxiliar = noAuxiliar.getRefNo();
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
    Fila minhaFila = new Fila();

    minhaFila.enqueue(new NoInteiro(1));
    minhaFila.enqueue(new NoInteiro(2));
    minhaFila.enqueue(new NoInteiro(3));
    minhaFila.enqueue(new NoInteiro(4));

    System.out.println(minhaFila);

    System.out.println(minhaFila.dequeue());

    System.out.println(minhaFila);

    minhaFila.enqueue(new NoInteiro(5));

    System.out.println(minhaFila);

    System.out.println(minhaFila.first());

    System.out.println(minhaFila);
  }
}
