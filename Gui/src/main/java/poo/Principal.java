package poo;

import javax.accessibility.AccessibleRelation;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Principal {
    private JPanel painelPrincipal;
    private JLabel nomeLabel;
    private JTextField nomeTF;
    private JButton confirmarButton;
    private JLabel resultadoLabel;
    private JRadioButton femininoRadioButton;
    private JRadioButton masculinoRadioButton;

    public Principal() {

        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mensagem = nomeTF.getText();

                if(femininoRadioButton.isSelected()) {
                    resultadoLabel.setText("Bom dia Senhora, " + mensagem);
                } else {
                    resultadoLabel.setText("Bom dia Senhor, " + mensagem);
                }

                nomeTF.setText("");
            }
        });
        nomeTF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String mensagem = nomeTF.getText();

                if(femininoRadioButton.isSelected()) {
                    resultadoLabel.setText("Bom dia Senhora, " + mensagem);
                } else {
                    resultadoLabel.setText("Bom dia Senhor, " + mensagem);
                }

                nomeTF.setText("");
            }
        });
        nomeTF.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if (nomeTF.getText().length() > 0) {
                    confirmarButton.setEnabled(true);
                } else {
                    confirmarButton.setEnabled(false);
                }
            }
        });
        confirmarButton.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if (nomeTF.getText().length() > 0) {
                    confirmarButton.setEnabled(true);
                } else {
                    confirmarButton.setEnabled(false);
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Principal");
        frame.setContentPane(new Principal().painelPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
