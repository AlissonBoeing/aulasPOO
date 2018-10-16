public class Principal {


    public static void main(String[] args) throws InterruptedException {

        Ola teste = new Ola(1);
        System.out.println("inicio");
        teste.start();

        try {
            teste.join();
        } catch (Exception e) {
            System.out.println("não rolou");

        }
        System.out.println("final");





    }



}
