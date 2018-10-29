import jdk.internal.org.objectweb.asm.tree.TableSwitchInsnNode;

public class Humano extends Jogador{

    public Humano(int i) {
        placar = 0;
        if (i == 1){
            marcador = "X";
        } else {
            marcador = "O";
        }
        tipo = "Humano";
        nome = "Humano " + marcador;
    }

    public boolean jogar(int x, int y) {

        JogoVelha.getTabuleiro().marcarJogada(x,y);

        return true;

    }

}
