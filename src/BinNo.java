public class BinNo<T extends Comparable<T>> {
  private T conteudo;
  private BinNo<T> NoEsq;
  private BinNo<T> NoDir;

  public BinNo(T conteudo) {
    this.conteudo = conteudo;
    NoEsq = NoDir = null;
  }

  public BinNo() {
  }

  public T getConteudo() {
    return conteudo;
  }

  public void setConteudo(T conteudo) {
    this.conteudo = conteudo;
  }

  public BinNo<T> getNoEsq() {
    return NoEsq;
  }

  public void setNoEsq(BinNo<T> noEsq) {
    NoEsq = noEsq;
  }

  public BinNo<T> getNoDir() {
    return NoDir;
  }

  public void setNoDir(BinNo<T> noDir) {
    NoDir = noDir;
  }

  @Override
  public String toString() {
    return "BinNo [conteudo=" + conteudo + "]";
  }
  
}
