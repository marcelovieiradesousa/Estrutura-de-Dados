public class NoInteiro {
  private int dado;
  private NoInteiro refNo = null;

  public NoInteiro() {
  }

  public NoInteiro(int dado) {
    this.dado = dado;
  }

  public int getDado() {
    return dado;
  }

  public void setDado(int dado) {
    this.dado = dado;
  }

  public NoInteiro getRefNo() {
    return refNo;
  }

  public void setRefNo(NoInteiro refNo) {
    this.refNo = refNo;
  }

  @Override
  public String toString() {
    return "NoInteiro{" +
        "dado=" + dado +
        '}';
  }
}
