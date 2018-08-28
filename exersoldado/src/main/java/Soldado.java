public class Soldado {

    private static int total = 0;
    private int ident=0;
    private int pos=0;
    private final String ARMA = "fuzil";
    private final int DIST = 4;


    public Soldado(){

        total++;

        ident = total;

    }

    public void atacar(String arma) {
        if (arma != "baioneta" && arma != "punho" && arma != "fuzil") {
            System.out.println("Arma inválida");
        } else {
            if (Soldado.getTotal() < 10) {
                System.out.println("Ainda não, esperando exército ficar maior");
            } else {
                System.out.println("Soldado " + Integer.toString(this.ident) + " Atacou com " + arma);
            }
        }
    }

    public void atacar() {
        this.atacar(ARMA);
    }

    public void mover(int dist){
        pos = pos + dist;
    }

    public void mover(){
        this.mover(DIST);
    }

    public static int getTotal(){
        return total;
    }

    public int getPos(){
        return pos;
    }
}
