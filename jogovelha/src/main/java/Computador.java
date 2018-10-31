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


    public int possoperderL(int teste) {

        int eu, adv, soma0 = 0, soma1 = 0, soma2 = 0;
        int tabu[][] = JogoVelha.getTabuleiro().getMatriz();

        if (JogoVelha.isJogadorDaVez()) {
            eu = 2;
            adv = 20;
        } else {
            eu = 20;
            adv = 2;
        }
        if (teste == 1){
            adv = eu;
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

    public int possoperderC(int teste) {

        int eu, adv, soma0 = 0, soma1 = 0, soma2 = 0;
        int tabu[][] = JogoVelha.getTabuleiro().getMatriz();


        if (JogoVelha.isJogadorDaVez()) {
            adv = 20;
            eu = 2;
        } else {
            adv = 2;
            eu = 20;
        }

        if (teste == 1){
            adv = eu;
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

    public int possoperderD(int teste) {

        int eu, adv, soma0 = 0, soma1 = 0, soma2 = 0;
        int tabu[][] = JogoVelha.getTabuleiro().getMatriz();

        if (JogoVelha.isJogadorDaVez()) {
            eu = 1;
            adv = 20;
        } else {
            eu = 10;
            adv = 2;
        }

        if (teste == 1){
            adv = eu;
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


    public boolean planejarVitoria() {
        int eu = 0;


        int tabu[][] = JogoVelha.getTabuleiro().getMatriz();
        if(possoperderC(1) == 3 && possoperderD(1) == 3 && possoperderL(1) == 3) { //com parametro 1, possoperder vira possoganhar

            if(tabu[1][1] == 0) {
                JogoVelha.getTabuleiro().marcarJogada(1, 1); return true;
            } else {
                for(int i =0; i<3; i++) {
                    for(int j = 0;j<3; j++){
                        if(tabu[i][j] == 0) {
                            JogoVelha.getTabuleiro().marcarJogada(i, j); return true;
                        }
                    }
                }
            }



        }else if (possoperderL(1) != 3){ // nao perder vira GANHAR
            switch (possoperderL(1)) {
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
        } else if(possoperderC(1) != 3) {
            switch(possoperderC(1)) {
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
        } else if(possoperderD(1) != 3){
            switch(possoperderD(1)) {
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




    @Override
    public boolean jogar(int x, int y) {

        if(possoperderC(1) != 3 || possoperderD(1) != 3 || possoperderL(1) != 3) {
            this.planejarVitoria();
            return true;
        }
        if(possoperderC(0) == 3 && possoperderD(0) == 3 && possoperderL(0) == 3) { // planejar vitoria
            this.planejarVitoria();
            return true;
        } else if (possoperderL(0) != 3){ // nao perder
            switch (possoperderL(0)) {
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
            } else if(possoperderC(0) != 3) {
            switch(possoperderC(0)) {
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
        } else if(possoperderD(0) != 3){
            switch(possoperderD(0)) {
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



