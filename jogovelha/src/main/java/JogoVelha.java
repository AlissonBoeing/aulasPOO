import java.util.Random;

public class JogoVelha {

    static Tabuleiro tabuleiro;
    private Jogador player1;
    private Jogador player2;
    static boolean jogadorDaVez;
    private boolean primeiro;
    private int qtdPartidas;


    public JogoVelha(int i) {

        tabuleiro = new Tabuleiro();
        qtdPartidas = 1;

        if (i == 0) {
            player1 = new Humano(1);
            player2 = new Humano(2);
        } else if (i == 1) {
            player1 = new Humano(1);
            player2 = new Computador(2);
        } else if (i == 2) {
            player1 = new Computador(1);
            player2 = new Computador(2);
        }

        Random a = new Random();

        int b = a.nextInt(20);
        if (b < 10) {
            jogadorDaVez = true;
            primeiro = true;
        } else {
            jogadorDaVez = false;
            primeiro = false;
        }
    }

    public void jogarNovamente() {

        tabuleiro = new Tabuleiro();
        if (primeiro) {
            jogadorDaVez = false;
            primeiro = false;
        } else {
            jogadorDaVez = true;
            primeiro = true;
        }
        qtdPartidas = qtdPartidas + 1;

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


    public static Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public static void setTabuleiro(Tabuleiro tabuleiro) {
        tabuleiro = tabuleiro;
    }

    public Jogador getPlayer1() {
        return player1;
    }

    public void setPlayer1(Jogador player1) {
        this.player1 = player1;
    }

    public Jogador getPlayer2() {
        return player2;
    }

    public void setPlayer2(Jogador player2) {
        this.player2 = player2;
    }

    public static boolean isJogadorDaVez() {
        return jogadorDaVez;
    }

    public static void setJogadorDaVez(boolean teste) {
        jogadorDaVez = teste;
    }

    public boolean isPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(boolean primeiro) {
        this.primeiro = primeiro;
    }

    public int getQtdPartidas() {
        return qtdPartidas;
    }

    public void setQtdPartidas(int qtdPartidas) {
        this.qtdPartidas = qtdPartidas;
    }
}



