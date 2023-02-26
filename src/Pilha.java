public class Pilha {
  NoInteiro refNoEntradaPilha = null;

  public void push(NoInteiro novo){
    NoInteiro noAuxiliar = refNoEntradaPilha;
    refNoEntradaPilha = novo;
    refNoEntradaPilha.setRefNo(noAuxiliar);
  }
  public NoInteiro pop(){
    if(!isEmpty()){
      NoInteiro noPoped = refNoEntradaPilha;
      refNoEntradaPilha.getRefNo();
      return noPoped;
    }
    return null;
  }
  public NoInteiro top(){
    if(!isEmpty()){
      return refNoEntradaPilha;
    }
    return null;
  }

  public boolean isEmpty(){
    return refNoEntradaPilha == null? true : false;
}
  @Override
  public String toString() {
    String stringRetorno = "------------\n";
    stringRetorno += "   Pilha\n";
    stringRetorno += "------------\n";
    NoInteiro noAuxiliar = refNoEntradaPilha;
    while (true) {
      if (noAuxiliar != null) {
        stringRetorno += "[No{dado=" + noAuxiliar.getDado() + "}]\n";
        noAuxiliar = noAuxiliar.getRefNo();
      } else {
        break;
      }
    }
    stringRetorno += "============";
    return stringRetorno;
  }

  public static void main(String args[]){
    Pilha minhaPilha = new Pilha();
    minhaPilha.push(new NoInteiro(1));
    minhaPilha.push(new NoInteiro(2));
    minhaPilha.push(new NoInteiro(3));
    minhaPilha.push(new NoInteiro(4));
    minhaPilha.push(new NoInteiro(5));
    minhaPilha.push(new NoInteiro(6));

    System.out.println(minhaPilha);

    System.out.println(minhaPilha.pop());

    System.out.println(minhaPilha);

    minhaPilha.push(new NoInteiro(99));
    System.out.println(minhaPilha);
}

}