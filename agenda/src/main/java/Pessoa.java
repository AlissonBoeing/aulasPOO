import java.time.LocalDate;

public class Pessoa {
    private String nome;
    private String sobrenome;
    public LocalDate dataNasc;
    public Telefone telefones;
    public Email emails;

    public Pessoa(String n, String s, Telefone t, Email e) {
        nome = n;
        sobrenome = s;
        telefones = t;
        emails = e;
    }

    public Pessoa(String n, String s) {
        nome = n;
        sobrenome = s;
        telefones = null;
        emails = null;
    }

    public boolean addTelefone(String r, String n) {

    }

    public boolean addEmail(String r, String e) {

    }

    public boolean removeTelefone(String r) {


    }

    public boolean removeEmail(String r) {


    }

    public boolean updateTelefone(String r, String n) {


    }

    public boolean updateEmail(String r, String e) {


    }

    public String toString() {


    }

}
