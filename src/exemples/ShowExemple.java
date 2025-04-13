package exemples;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowExemple {

    public void run(Calculator.Operation selectedOp) {
        JFrame frame = new JFrame("Resolução de Exemplo: " + selectedOp.getOperation());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(5, 1));

        JLabel formulaLabel = new JLabel("Operação: " + selectedOp.getOperation(), SwingConstants.CENTER);
        frame.add(formulaLabel);

        JPanel inputPanel = new JPanel(new GridLayout(0, 2));

        // Campos de entrada para as variáveis da operação
        JTextField[] inputFields = new JTextField[selectedOp.getVariables().length];
        for (int i = 0; i < selectedOp.getVariables().length; i++) {
            JLabel label = new JLabel(selectedOp.getVariables()[i] + ":");
            JTextField textField = new JTextField();
            inputFields[i] = textField;
            inputPanel.add(label);
            inputPanel.add(textField);
        }
        frame.add(inputPanel);

        JButton calculateButton = new JButton("Calcular");
        frame.add(calculateButton);

        JButton clearButton = new JButton("Limpar");
        frame.add(clearButton);

        JLabel resultLabel = new JLabel("Resultado: ", SwingConstants.CENTER);
        frame.add(resultLabel);

        // Ação do botão "Calcular"
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double[] values = new double[inputFields.length];
                    for (int i = 0; i < inputFields.length; i++) {
                        values[i] = Double.parseDouble(inputFields[i].getText());
                    }

                    // Chama o método de cálculo do Calculator
                    double result = Calculator.calculateFormula(selectedOp.getOperation(), values);
                    resultLabel.setText("Resultado: " + result);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, insira números válidos.", "Erro",
                            JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Ação do botão "Limpar"
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (JTextField field : inputFields) {
                    field.setText("");
                }
                resultLabel.setText("Resultado: ");
            }
        });

        frame.setVisible(true);
    }
}