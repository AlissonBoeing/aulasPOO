import java.util.Arrays;
import java.util.Random;

public class Tabuleiro {

    private int[][] tabuleiro;
    Jogador player1;
    Jogador player2;
    boolean jogadorDaVez;


    public Tabuleiro(int jog, int comp) {


        tabuleiro = new int[3][3];
        for(int i = 0; i< 3; i++) {
            for(int j = 0; j<3 ; j++) {
                tabuleiro[i][j] = 0;
            }
        }


        if (comp == jog) {
             player1 = new Jogador(1);
             player2 = new Computador(2);
        } else  if (jog == 2){
             player1 = new Jogador(1);
             player2 = new Jogador(2);
        } else if (comp == 2) {
             player1 = new Computador(1);
             player2 = new Computador(2);
        }

        Random a = new Random();
        int b = a.nextInt(20);
        if (b < 10){
            jogadorDaVez = true;
        } else {
            jogadorDaVez = false;
        }
    }

    public boolean marcarJogada(int x, int y){

        if (this.jogadorDaVez){
            this.tabuleiro[x][y] = 1;
            jogadorDaVez = false;
            return true;
        } else {
            this.tabuleiro[x][y] = 10;
            jogadorDaVez = true;
            return true;
        }



    }

    public int fimdoJogo() {

        int i, j, soma1 = 0, soma2 = 0, soma3 = 0, soma33 = 0;
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                soma1 = soma1 + this.tabuleiro[i][j];
            }
            if (soma1 == 3 || soma1 == 30) {
                break;
            } else {
                soma1 = 0;
            }
        }

        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                soma2 = soma2 + this.tabuleiro[j][i];
            }
            if (soma2 == 3 || soma2 == 30) {
                break;
            } else {
                soma2 = 0;
            }
        }

        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                if (i == j) {
                    soma3 = soma3 + this.tabuleiro[i][j];
                }
            }
        }
        soma33 = this.tabuleiro[0][2] + this.tabuleiro[1][1] + this.tabuleiro[2][0];

        if (soma1 == 3 || soma2 == 3 || soma3 == 3 || soma33 == 3) {
            return 3;
        } else if (soma1 == 30 || soma2 == 30 || soma3 == 30 || soma33 == 30) {
            return 30;
        } else {
            return 0;
        }


    }

    public String vencedor(int soma) {

        String ret = "";
        if(soma == 3) {
            ret = this.player1.getNome() + " Venceu!!";
            this.player1.setPlacar(this.player1.getPlacar() + 1);
        } else if(soma == 30) {
            ret = this.player2.getNome() + " Venceu!!";
            this.player2.setPlacar(this.player2.getPlacar() + 1);
        }
        return ret;
    }

    public boolean isJogadorDaVez() {
        return jogadorDaVez;
    }

    public void setJogadorDaVez(boolean jogadorDaVez) {
        this.jogadorDaVez = jogadorDaVez;
    }

    public int[][] getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(int[][] tabuleiro) {
        this.tabuleiro = tabuleiro;
    }
}
