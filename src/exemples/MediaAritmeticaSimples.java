package exemples;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MediaAritmeticaSimples {
    public static void main(String[] args) {

    }

    public void run() {
        JFrame frame = new JFrame("Cálculo de Média Aritmética Simples");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(5, 1));

        JLabel formulaLabel = new JLabel("Fórmula: Média = (Valor1 + Valor2) / 2", SwingConstants.CENTER);
        frame.add(formulaLabel);

        JPanel inputPanel = new JPanel(new GridLayout(1, 4));
        JLabel label1 = new JLabel("Valor 1:");
        JTextField value1Field = new JTextField();
        JLabel label2 = new JLabel("Valor 2:");
        JTextField value2Field = new JTextField();
        inputPanel.add(label1);
        inputPanel.add(value1Field);
        inputPanel.add(label2);
        inputPanel.add(value2Field);
        frame.add(inputPanel);

        JButton calculateButton = new JButton("Calcular");
        frame.add(calculateButton);

        JButton clearButton = new JButton("Limpar");
        frame.add(clearButton);

        JLabel resultLabel = new JLabel("Resultado: ", SwingConstants.CENTER);
        frame.add(resultLabel);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double value1 = Double.parseDouble(value1Field.getText());
                    double value2 = Double.parseDouble(value2Field.getText());
                    double result = (value1 + value2) / 2;
                    resultLabel.setText("Resultado: " + result);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, insira números válidos.", "Erro",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    value1Field.setText("");
                    value2Field.setText("");
                    resultLabel.setText("Resultado: ");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Não conseguimos limpar.", "Erro",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.setVisible(true);
    }
}