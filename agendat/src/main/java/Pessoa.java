
import java.io.Serializable;

public class Pessoa implements Serializable{

        private String nome;
        private String cpf;

        public Pessoa(String nome, String cpf) {
            this.nome = nome;
            this.cpf = cpf;
        }

        public void imprimir(){
            System.out.println("Nome: " + nome + "\n" + "CPF: " + cpf);
        }
}
