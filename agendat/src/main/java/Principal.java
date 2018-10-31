import java.io.*;

public class Principal {
    private Pessoa[] agenda = new Pessoa[2];

    public void salvarEmDisco(){
        File arquivo = new File("agenda.dat");
        try {
            FileOutputStream fout = new FileOutputStream(arquivo);
            ObjectOutputStream oos = new ObjectOutputStream(fout);

            oos.writeObject(this.agenda);

            oos.flush();
            oos.close();
            fout.close();
        } catch (Exception ex) {
            System.err.println("erro: " + ex.toString());
        }

    }
    public void lerDoDisco(){
        File arquivo = new File("agenda.dat");
        try {
            FileInputStream fin = new FileInputStream(arquivo);
            ObjectInputStream oin = new ObjectInputStream(fin);

            this.agenda = (Pessoa[]) oin.readObject();

            oin.close();
            fin.close();

            for(Pessoa p : this.agenda) {
                p.imprimir();
            }
        } catch (Exception ex) {
            System.err.println("erro: " + ex.toString());
        }
    }

    public static void main(String[] args) {
        Principal p = new Principal();

        p.agenda[0] = new Pessoa("Alisson", "12345");
        p.agenda[1] = new Pessoa("Boeing", "54321");

        p.salvarEmDisco();
        p.lerDoDisco();
    }


}