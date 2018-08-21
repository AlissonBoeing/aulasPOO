public class Principal {
    public static void main(String[] args) {
        Contador x = new Contador();

        for(int i = 0; i < 10; i++) {
            x.inc();
            int j = x.retValor();
            System.out.println("Valor atual do contador: " + j);
        }

        x.reset();

        System.out.println("Contador Zerado!");

        for(int i = 0; i < 10; i++) {
            x.inc();
            int j = x.retValor();
            System.out.println("Valor atual do contador: " + j);
        }
    }
}
