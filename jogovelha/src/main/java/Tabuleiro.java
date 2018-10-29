import javax.print.attribute.standard.JobOriginatingUserName;
import java.util.Random;

public class Tabuleiro {

    private int[][] matriz;


    public Tabuleiro() {

        matriz = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matriz[i][j] = 0;
            }
        }

    }

    public boolean marcarJogada(int x, int y){

        if (JogoVelha.isJogadorDaVez()){
            this.matriz[x][y] = 1;
            JogoVelha.setJogadorDaVez(false);
            return true;
        } else {
            this.matriz[x][y] = 10;
            JogoVelha.setJogadorDaVez(true);
            return true;
        }

    }

    public int fimdoJogo() {

        int i, j, soma1 = 0, soma2 = 0, soma3 = 0, soma33 = 0;
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                soma1 = soma1 + this.matriz[i][j];
            }
            if (soma1 == 3 || soma1 == 30) {
                break;
            } else {
                soma1 = 0;
            }
        }

        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                soma2 = soma2 + this.matriz[j][i];
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
                    soma3 = soma3 + this.matriz[i][j];
                }
            }
        }
        int velha = 0;
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                velha = velha + this.matriz[i][j];
            }
        }

        soma33 = this.matriz[0][2] + this.matriz[1][1] + this.matriz[2][0];

        if (soma1 == 3 || soma2 == 3 || soma3 == 3 || soma33 == 3) {
            return 3;
        } else if (soma1 == 30 || soma2 == 30 || soma3 == 30 || soma33 == 30) {
            return 30;
        } else if (velha == 45 || velha == 54){
            return 50;
        } else {
            return 0;
        }


    }

    public int[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(int[][] tabuleiro) {
        this.matriz = tabuleiro;
    }

}
