public class Contador {
    private int valor;

    public Contador(){
        valor = 0;
    }
    public void inc() {
        valor = valor + 1;
    }
    public int retValor() {
        return valor;
    }
    public void reset(){
        valor = 0;
    }
}
