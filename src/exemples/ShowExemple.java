package exemples;

import javax.swing.*;

import exemples.Calculator.Operation;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowExemple {
  private GroupLayout layout; // Declare the layout field

  public void main(JPanel container) {
    layout = new GroupLayout(container);
    container.setLayout(layout);
    layout.setAutoCreateGaps(true);
    layout.setAutoCreateContainerGaps(true);
  }

  public void run(Operation selectedOp, JPanel container) {
    container.removeAll(); // Limpa o container antes de adicionar novos componentes

    // Configura o layout GroupLayout
    layout = new GroupLayout(container);
    container.setLayout(layout);
    layout.setAutoCreateGaps(true);
    layout.setAutoCreateContainerGaps(true);

    // Define as operações listadas
    Operation[] listedOperations = selectedOp.getRelatedOperations();

    int numberOfPanel = !selectedOp.isComplex() ? 1 : listedOperations.length;

    // Array para armazenar os painéis criados
    JPanel[] panels = new JPanel[numberOfPanel];

    // Loop para criar os painéis dinamicamente
    for (int i = 0; i < numberOfPanel; i++) {
      Operation currentOp = numberOfPanel > 1 ? listedOperations[i] : selectedOp;
      panels[i] = simplePanel(currentOp);
    }

    // Configuração do layout horizontal
    GroupLayout.SequentialGroup horizontalGroup = layout.createSequentialGroup();
    for (JPanel panel : panels) {
      horizontalGroup.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
          GroupLayout.PREFERRED_SIZE);
    }
    layout.setHorizontalGroup(
        layout.createParallelGroup(GroupLayout.Alignment.CENTER)
            .addGroup(horizontalGroup));

    // Configuração do layout vertical
    GroupLayout.ParallelGroup verticalGroup = layout.createParallelGroup(GroupLayout.Alignment.LEADING);
    for (JPanel panel : panels) {
      verticalGroup.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
          GroupLayout.PREFERRED_SIZE);
    }

    // Adiciona o painel de combinação de resultados apenas se numberOfPanel > 1
    if (numberOfPanel > 1) {
      // Painel para exibir a combinação de resultados
      JPanel combinedResultPanel = new JPanel();
      combinedResultPanel.setLayout(new BoxLayout(combinedResultPanel, BoxLayout.Y_AXIS));
      combinedResultPanel.setBorder(BorderFactory.createTitledBorder(
          BorderFactory.createCompoundBorder(
              BorderFactory.createLineBorder(Color.BLACK),
              BorderFactory.createEmptyBorder(5, 5, 5, 5)),
          "Combinação de Resultados"));
      combinedResultPanel.setPreferredSize(new Dimension(350, 200));

      // Adiciona labels para cada variável da operação
      for (int i = 0; i < selectedOp.getVariablesNamesPtbr().length; i++) {
        JLabel variableLabel = new JLabel(selectedOp.getVariablesNamesPtbr()[i]);
        variableLabel.setFont(new Font("Arial", Font.BOLD, 12));
        combinedResultPanel.add(variableLabel);
      }

      JButton calculateCombinedButton = new JButton("Calcular Combinação");
      combinedResultPanel.add(calculateCombinedButton);

      JLabel combinedResultLabel = new JLabel();

      // Ação do botão "Calcular Combinação"
      calculateCombinedButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          try {
            double combinedResult = 0;
            for (JPanel panel : panels) {
              JLabel resultLabel = (JLabel) panel.getComponent(panel.getComponentCount() - 1);
              String text = resultLabel.getText().replace("Resultado: ", "").trim();
              if (!text.isEmpty()) {
                combinedResult += Double.parseDouble(text);
              }
            }
            combinedResultLabel.setText("Resultado Combinado: " + combinedResult);
          } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(container, "Erro ao combinar resultados.", "Erro",
                JOptionPane.ERROR_MESSAGE);
          }
        }
      });

      // Adiciona o painel de combinação ao layout
      layout.setHorizontalGroup(
          layout.createParallelGroup(GroupLayout.Alignment.CENTER)
              .addGroup(horizontalGroup)
              .addComponent(combinedResultPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                  GroupLayout.PREFERRED_SIZE));

      layout.setVerticalGroup(
          layout.createSequentialGroup()
              .addGroup(verticalGroup)
              .addComponent(combinedResultPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                  GroupLayout.PREFERRED_SIZE));
    } else {
      layout.setVerticalGroup(
          layout.createSequentialGroup()
              .addGroup(verticalGroup));
    }

    container.revalidate();
    container.repaint();
  }

  public JPanel simplePanel(Operation selectedOp) {
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    panel.setBorder(BorderFactory.createTitledBorder(
        BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.BLACK),
            BorderFactory.createEmptyBorder(2, 15, 15, 15)),
        selectedOp.getOperationPtbr()));

    // Campos de entrada
    JPanel inputPanel = new JPanel(new GridLayout(selectedOp.getVariables().length, 1, 5, 5));
    JTextField[] inputFields = new JTextField[selectedOp.getVariables().length];
    for (int i = 0; i < selectedOp.getVariables().length; i++) {
      JLabel label = new JLabel(selectedOp.getVariablesNamesPtbr()[i] + ":");
      label.setFont(new Font("Arial", Font.PLAIN, 12));
      JTextField textField = new JTextField(8);
      inputFields[i] = textField;
      inputPanel.add(label);
      inputPanel.add(textField);
    }
    panel.add(inputPanel);

    // Botões
    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
    JButton calculateButton = new JButton("Calcular");
    JButton clearButton = new JButton("Limpar");
    buttonPanel.add(calculateButton);
    buttonPanel.add(clearButton);
    panel.add(buttonPanel);

    // Rótulo de resultado
    JLabel resultLabel = new JLabel("Resultado: ");
    resultLabel.setFont(new Font("Arial", Font.BOLD, 12));
    panel.add(resultLabel);

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
          JOptionPane.showMessageDialog(panel, "Por favor, insira números válidos.", "Erro",
              JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
          JOptionPane.showMessageDialog(panel, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
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

    return panel;
  }
}