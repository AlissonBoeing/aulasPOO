import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Principal {
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
    private JLabel posicao13;
    private JLabel posicao33;
    private JLabel posicao23;
    private JLabel posicao22;
    private JLabel posicao12;
    private JLabel posicao32;
    private JLabel posicao21;
    private JLabel posicao11;
    private JLabel posicao31;
    private JPanel painelJogadordavez;
    private JLabel jogadorvez;

    public Principal() {
        posicao11.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (posicao11.getText() == "X") {
                    posicao11.setText("0");
                } else {
                    posicao11.setText("X");
                }
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
