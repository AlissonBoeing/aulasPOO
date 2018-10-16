public class Ola extends Thread {

    private int num;
    String nome;

    public Ola (int cont){

        if (cont == 11) {
            this.stop();
        }

        num = cont;
        nome = "thread " + cont;

    }


    public void run() {


        System.out.println("Olá eu sou a : " + this.nome);
        Thread teste = new Ola(this.num + 1);
        teste.start();



    }

}
