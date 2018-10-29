import javax.print.attribute.standard.JobOriginatingUserName;

public class Computador extends Jogador {


    public Computador(int i) {

        placar = 0;

        if (i == 1) {
            marcador = "X";
        } else {
            marcador = "O";
        }
        tipo = "Computador";
        nome = "Computador " + marcador;

    }


    public int possoperderL() {

        int eu, adv, soma0 = 0, soma1 = 0, soma2 = 0;
        int tabu[][] = JogoVelha.getTabuleiro().getMatriz();

        if (JogoVelha.isJogadorDaVez()) {
            eu = 1;
            adv = 20;
        } else {
            eu = 10;
            adv = 2;
        }


        for (int j = 0; j < 3; j++) {
            soma0 = soma0 + tabu[0][j];
            soma1 = soma1 + tabu[1][j];
            soma2 = soma2 + tabu[2][j];
        }

        if (soma0 == adv) {
            return 0;
        } else if (soma1 == adv) {
            return 1;
        } else if (soma2 == adv) {
            return 2;
        } else {
            return 3;
        }

    }

    public int possoperderC() {

        int eu, adv, soma0 = 0, soma1 = 0, soma2 = 0;
        int tabu[][] = JogoVelha.getTabuleiro().getMatriz();


        if (JogoVelha.isJogadorDaVez()) {
            adv = 20;
        } else {
            adv = 2;
        }

        for (int i = 0; i < 3; i++) {
            soma0 = soma0 + tabu[i][0];
            soma1 = soma1 + tabu[i][1];
            soma2 = soma2 + tabu[i][2];
        }

        if (soma0 == adv) {
            return 0;
        } else if (soma1 == adv) {
            return 1;
        } else if (soma2 == adv) {
            return 2;
        } else {
            return 3;
        }

    }

    public int possoperderD() {

        int eu, adv, soma0 = 0, soma1 = 0, soma2 = 0;
        int tabu[][] = JogoVelha.getTabuleiro().getMatriz();

        if (JogoVelha.isJogadorDaVez()) {
            eu = 1;
            adv = 20;
        } else {
            eu = 10;
            adv = 2;
        }


        soma0 = tabu[0][0] + tabu[1][1] + tabu[2][2];
        soma1 = tabu[0][2] + tabu[1][1] + tabu[2][0];

        if (soma0 == adv) {
            return 0;
        } else if (soma1 == adv) {
            return 1;
        } else {
            return 3;
        }

    }
    public boolean naoPerder(int q, int num) { //q = linha coluna ou diagonal, num = numero da linha ou coluna ou diagonal
        int tabu[][] = JogoVelha.getTabuleiro().getMatriz();
        switch (q) {
            case 0:
                for (int j = 0; j < 3; j++) {
                    if (tabu[num][j] == 0) {
                        JogoVelha.getTabuleiro().marcarJogada(num, j);
                        return true;
                    }
                }
            case 1:
                for (int i = 0; i < 3; i++) {
                    if (tabu[i][num] == 0) {
                        JogoVelha.getTabuleiro().marcarJogada(i, num);
                        return true;
                    }
                }
            case 2:
                if (num == 0) {
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            if (tabu[i][j] == 0) {
                                JogoVelha.getTabuleiro().marcarJogada(i, j);
                                return true;
                            }
                        }
                    }
                } else {
                    if(tabu[0][2] == 0) { JogoVelha.getTabuleiro().marcarJogada(0, 2); return true; }
                    if (tabu[1][1] == 0) {JogoVelha.getTabuleiro().marcarJogada(1, 1); return true; }
                    if (tabu[2][0] == 0) {JogoVelha.getTabuleiro().marcarJogada(2, 0); return true; }
                }


        }

        return true;
        }


   // public boolean planejarVitoria() {

    //}

    @Override
    public boolean jogar(int x, int y) {




        if(possoperderC() == 3 && possoperderD() == 3 && possoperderL() == 3) { // planejar vitoria
            JogoVelha.getTabuleiro().marcarJogada(1, 1);
            return true;

        } else if (possoperderL() != 3){ // nao perder
            switch (possoperderL()) {
                case 0:
                    this.naoPerder(0, 0);
                    return true;
                case 1:
                    this.naoPerder(0, 1);
                    return true;
                case 2:
                    this.naoPerder(0, 2);
                    return true;
            }
            } else if(possoperderC() != 3) {
            switch(possoperderC()) {
                case 0:
                    this.naoPerder(1, 0);
                    return true;
                case 1:
                    this.naoPerder(1, 1);
                    return true;
                case 2:
                    this.naoPerder(1, 2);
                    return true;
            }
        } else if(possoperderD() != 3){
            switch(possoperderD()) {
                case 0:
                    this.naoPerder(2, 0);
                    return true;
                case 1:
                    this.naoPerder(2, 1);
                    return true;
            }
        }



        return false;

    }

}



