public class Principal {

    public static void main(String[] args) {

        Tempo t = new Tempo(24);
        Tempo t2 = new Tempo(24,60);
        Tempo t3 = new Tempo(24,40,59);
        Tempo t4 = new Tempo();

        System.out.println(t.toString());
        System.out.println(t2.toString());
        System.out.println(t3.toString());
        System.out.println(t4.toString());

        System.out.println(t.retLong());

    }
}

