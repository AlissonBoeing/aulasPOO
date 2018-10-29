//import javafx.scene.control.Tab;

import javax.swing.*;
import javax.swing.plaf.TableUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Principal {

    private JButton[][] botoes = new JButton[3][3];
    private JPanel painelPrincipal;
    private JPanel velha33;
    private JPanel velha13;
    private JPanel velha23;
    private JPanel velha22;
    private JPanel velha12;
    private JPanel velha32;
    private JPanel velha21;
    private JPanel velha11;
    private JPanel velha31;
    private JPanel placarPainel;
    private JLabel posicao11;
    private JPanel painelJogadordavez;
    private JLabel jogadorvez;
    private JPanel newGamePanel;
    private JComboBox tipodeJogo;
    private JButton newGameButton;
    private JButton pos11;
    private JButton pos21;
    private JButton pos31;
    private JButton pos12;
    private JButton pos22;
    private JButton pos32;
    private JButton pos13;
    private JButton pos23;
    private JButton pos33;
    private JButton restartButton;
    private JLabel player1Name;
    private JLabel player2Name;
    private JLabel player1Points;
    private JLabel player2Points;
    private JogoVelha game;



    public void refresh() {

        int tabu[][] = JogoVelha.getTabuleiro().getMatriz();

        for(int i= 0;i<3;i++){
            for(int j=0;j<3;j++) {
                if (tabu[i][j] == 0) {
                    botoes[i][j].setText("");
                } else if (tabu[i][j] == 1) {
                    botoes[i][j].setText("X");
                } else if (tabu[i][j] == 10) {
                    botoes[i][j].setText("O");
                }
            }
        }

        if (JogoVelha.isJogadorDaVez()) {
            jogadorvez.setText(game.getPlayer1().getNome());
            if (game.getPlayer1().getTipo() == "Computador" && JogoVelha.getTabuleiro().fimdoJogo() == 0) {
                game.getPlayer1().jogar(5,5);
                refresh();
            }
        } else {
            jogadorvez.setText(game.getPlayer2().getNome());
            if (game.getPlayer2().getTipo() == "Computador" && JogoVelha.getTabuleiro().fimdoJogo() == 0) {
                game.getPlayer2().jogar(5,5);
                refresh();
            }

        }

        if (JogoVelha.getTabuleiro().fimdoJogo() == 3) {
            jogadorvez.setText(game.vencedor(3));
        } else if (JogoVelha.getTabuleiro().fimdoJogo() == 30) {
            jogadorvez.setText(game.vencedor(30));
        } else if (JogoVelha.getTabuleiro().fimdoJogo() == 50) {
            jogadorvez.setText("DEU VELHA!!");
        }


        player1Points.setText(Integer.toString(game.getPlayer1().getPlacar()));
        player2Points.setText(Integer.toString(game.getPlayer2().getPlacar()));

    }

    public Principal() {

        botoes[0][0] = pos11;
        botoes[0][1] = pos12;
        botoes[0][2] = pos13;
        botoes[1][0] = pos21;
        botoes[1][1] = pos22;
        botoes[1][2] = pos23;
        botoes[2][0] = pos31;
        botoes[2][1] = pos32;
        botoes[2][2] = pos33;



        newGameButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                game = new JogoVelha(tipodeJogo.getSelectedIndex());

                player1Name.setText(game.getPlayer1().getNome() + ": ");
                player1Points.setText(Integer.toString(game.getPlayer1().getPlacar()));
                player2Name.setText(game.getPlayer2().getNome() + ": ");
                player2Points.setText(Integer.toString(game.getPlayer2().getPlacar()));

                if(JogoVelha.isJogadorDaVez()) {
                    if(game.getPlayer1().getTipo() == "Computador") {
                        Random x = new Random();
                        int w = x.nextInt(3);
                        int z = x.nextInt(3);
                        game.getPlayer1().jogar(w,z);
                        refresh();
                    } else {
                        refresh();
                    }
                } else {
                    if(game.getPlayer2().getTipo() == "Computador") {
                        Random h = new Random();
                        Random g = new Random();
                        int w = h.nextInt(3);
                        int z = g.nextInt(3);
                        game.getPlayer2().jogar(w,z);
                        refresh();
                    } else {
                        refresh();
                    }

                }


            }
        });


        MouseAdapter listener = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(JogoVelha.getTabuleiro().fimdoJogo() == 0 ) {
                JButton clicado = ((JButton) e.getSource());

                String nomeClicado = clicado.getName();
                System.out.println(nomeClicado);
                int num = Integer.parseInt(nomeClicado);

                int x = (num/10) -1 ;
                int y = (num % 10) -1;

                    if (JogoVelha.isJogadorDaVez() && clicado.getText() == "" && game.getPlayer1().getTipo()  != "Computador") {
                        game.getPlayer1().jogar(x, y);
                        refresh();
                    } else if (!JogoVelha.isJogadorDaVez() && clicado.getText() == "" && game.getPlayer2().getTipo()  != "Computador") {
                        game.getPlayer2().jogar(x, y);
                        refresh();
                    }

                }
            }
        };

        pos13.addMouseListener(listener);
        pos33.addMouseListener(listener);
        pos23.addMouseListener(listener);
        pos22.addMouseListener(listener);
        pos12.addMouseListener(listener);
        pos32.addMouseListener(listener);
        pos21.addMouseListener(listener);
        pos11.addMouseListener(listener);
        pos31.addMouseListener(listener);


        restartButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                game.jogarNovamente();

                refresh();

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Jogo da Velha");
        frame.setContentPane(new Principal().painelPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);


    }

}
