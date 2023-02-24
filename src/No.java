public class No<T> {
    private T conteudo;
    private No proximoNo = null;

    
    public No(T conteudo) {
        this.conteudo = conteudo;
    }

    public T getConteudo() {
        return conteudo;
    }

    public void setConteudo(T conteudo) {
        this.conteudo = conteudo;
    }

    public No getProximoNo() {
        return proximoNo;
    }

    public void setProximoNo(No proximoNo) {
        this.proximoNo = proximoNo;
    }

    @Override
    public String toString() {
    return "No{"+
        "conteudo='"+conteudo+'\''+'}';
    }

    public static void main(String[] args) throws Exception {
        No<String> no1 = new No<String>("conteudo No1");
        No<String> no2 = new No<String>("conteudo No2");
        No<String> no3 = new No<String>("conteudo No3");
        No<String> no4 = new No<String>("conteudo No4");

        no1.setProximoNo(no2);
        no2.setProximoNo(no3);
        no3.setProximoNo(no4);

        System.out.println(no1);
        System.out.println(no1.getProximoNo());
        System.out.println(no1.getProximoNo().getProximoNo());
        System.out.println(no1.getProximoNo().getProximoNo().getProximoNo());
    }
}
