import javafx.scene.control.Tab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
    private Tabuleiro tab;



    public void refresh() {

        int tabu[][] = tab.getTabuleiro();

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

        if (tab.jogadorDaVez) {
            jogadorvez.setText(tab.player1.getNome());
        } else {
            jogadorvez.setText(tab.player2.getNome());
        }


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
                    if (tipodeJogo.getSelectedIndex() == 0) {
                        tab = new Tabuleiro(2, 0);
                        refresh();
                    } else if (tipodeJogo.getSelectedIndex() == 1) {
                        tab = new Tabuleiro(1, 1);
                        refresh();
                    } else if (tipodeJogo.getSelectedIndex() == 2) {
                        tab = new Tabuleiro(0, 2);
                        refresh();
                }
                player1Name.setText(tab.player1.getNome() + ": ");
                player1Points.setText(Integer.toString(tab.player1.getPlacar()));
                player2Name.setText(tab.player2.getNome() + ": ");
                player2Points.setText(Integer.toString(tab.player2.getPlacar()));


            }
        });


        MouseAdapter listener = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(tab.fimdoJogo() == 0 ) {
                JButton clicado = ((JButton) e.getSource());

                String nomeClicado = clicado.getName();
                System.out.println(nomeClicado);
                int num = Integer.parseInt(nomeClicado);

                int x = (num/10) -1 ;
                int y = (num % 10) -1;

                    if (tab.jogadorDaVez && clicado.getText() == "" && tab.player1.getTipo()  != "Computador") {
                        tab.player1.jogar(x, y, tab);
                        refresh();
                        if (tab.player2.getTipo() == "Computador") {

                            pos11.doClick();

                        }

                    } else if (tab.jogadorDaVez == false && clicado.getText() == "" && tab.player2.getTipo()  != "Computador"){
                        tab.player2.jogar(x, y, tab);
                        jogadorvez.setText(tab.player2.getNome());
                        refresh();
                        if (tab.player1.getTipo() == "Computador") {


                            pos11.doClick();
                        }
                    } else if (tab.jogadorDaVez && tab.player1.getTipo()  == "Computador") {
                        tab.player1.jogar(0,0, tab);
                        jogadorvez.setText(tab.player1.getNome());
                        refresh();
                    } else if (tab.jogadorDaVez == false  && tab.player2.getTipo()  == "Computador") {
                        tab.player2.jogar(0,0,  tab);
                        jogadorvez.setText(tab.player2.getNome());
                        refresh();
                    }
                    if (tab.fimdoJogo() == 3) {
                        jogadorvez.setText(tab.vencedor(3));
                    } else if (tab.fimdoJogo() == 30) {
                        jogadorvez.setText(tab.vencedor(30));
                    }
                    player1Points.setText(Integer.toString(tab.player1.getPlacar()));
                    player2Points.setText(Integer.toString(tab.player2.getPlacar()));
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
                int tabul[][] = new int[3][3];
                for(int i = 0; i< 3; i++) {
                    for(int j = 0; j<3 ; j++) {
                        tabul[i][j] = 0;
                    }
                }
                tab.setTabuleiro(tabul);
                player1Points.setText(Integer.toString(tab.player1.getPlacar()));
                player2Points.setText(Integer.toString(tab.player2.getPlacar()));

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
