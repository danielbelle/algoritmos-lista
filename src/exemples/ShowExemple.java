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
      Operation currentOp;
      if ("rent_divide".equals(selectedOp.getRelatedOperations()[i].getOperation())) {
        currentOp = selectedOp.getRelatedOperations()[i];
        panels[i] = simplePanel(currentOp);
      } else {
        currentOp = numberOfPanel > 1 ? listedOperations[i] : selectedOp;
        panels[i] = simplePanel(currentOp);
      }
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

      for (int i = 0; i < selectedOp.getVariablesNamesPtbr().length; i++) {
        JPanel variableResultPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel variableLabel = new JLabel(selectedOp.getVariablesNamesPtbr()[i] + ": ");
        variableLabel.setFont(new Font("Arial", Font.BOLD, 12));
        JLabel resultValueLabel = new JLabel("0.0");
        resultValueLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        variableResultPanel.add(variableLabel);
        variableResultPanel.add(resultValueLabel);
        combinedResultPanel.add(variableResultPanel);
      }

      JButton calculateCombinedButton = new JButton("Calcular Combinação");
      combinedResultPanel.add(calculateCombinedButton);

      // Ação do botão "Calcular Combinação"
      calculateCombinedButton.addActionListener(e -> {
        try {
          java.util.List<Double> savedData = new java.util.ArrayList<>();

          // Itera sobre os painéis para acessar os valores de inputFields[] e resultLabel
          for (JPanel panel : panels) {
            JPanel inputPanel = (JPanel) panel.getComponent(0); // Assume que o inputPanel é o primeiro componente
            for (Component component : inputPanel.getComponents()) {
              if (component instanceof JTextField) {
                String inputText = ((JTextField) component).getText().trim();
                if (!inputText.isEmpty()) {
                  savedData.add(Double.parseDouble(inputText));
                }
              }
            }
            JLabel resultLabel = (JLabel) panel.getComponent(panel.getComponentCount() - 1); // Último componente
            String resultText = resultLabel.getText().replaceAll("[^0-9.]", "").trim();
            if (!resultText.isEmpty()) {
              savedData.add(Double.parseDouble(resultText));
            }
          }

          // Atualiza os valores no painel de combinação de resultados
          Component[] combinedResultComponents = combinedResultPanel.getComponents();
          for (int index = 0; index < combinedResultComponents.length; index++) {
            if (combinedResultComponents[index] instanceof JPanel variableResultPanel) {
              for (Component subComponent : variableResultPanel.getComponents()) {
                if (subComponent instanceof JLabel label && !label.getFont().isBold()) {
                  Calculator.calculateComplexFormula(index, savedData, label, selectedOp.getVariables()[0]);
                }
              }
            }
          }

        } catch (NumberFormatException ex) {
          JOptionPane.showMessageDialog(combinedResultPanel,
              "Por favor, insira números válidos e certifique-se de calcular os resultados individuais antes de calcular a combinação.",
              "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
          JOptionPane.showMessageDialog(combinedResultPanel,
              "Por favor, insira números válidos e certifique-se de calcular os resultados individuais antes de calcular a combinação.",
              "Erro", JOptionPane.ERROR_MESSAGE);
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
    } else if (numberOfPanel == 1) {
      // Painel para exibir a combinação de resultados
      JPanel combinedResultPanel = new JPanel();
      combinedResultPanel.setLayout(new BoxLayout(combinedResultPanel, BoxLayout.Y_AXIS));
      combinedResultPanel.setBorder(BorderFactory.createTitledBorder(
          BorderFactory.createCompoundBorder(
              BorderFactory.createLineBorder(Color.BLACK),
              BorderFactory.createEmptyBorder(5, 5, 5, 5)),
          "Combinação de Resultados"));
      combinedResultPanel.setPreferredSize(new Dimension(350, 200));

      for (int i = 0; i < selectedOp.getVariablesNamesPtbr().length; i++) {
        JPanel variableResultPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel variableLabel = new JLabel(selectedOp.getVariablesNamesPtbr()[i] + ": ");
        variableLabel.setFont(new Font("Arial", Font.BOLD, 12));
        JLabel resultValueLabel = new JLabel("0.0");
        resultValueLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        variableResultPanel.add(variableLabel);
        variableResultPanel.add(resultValueLabel);
        combinedResultPanel.add(variableResultPanel);
      }

      JButton calculateCombinedButton = new JButton("Calcular Combinação");
      combinedResultPanel.add(calculateCombinedButton);

      // Ação do botão "Calcular Combinação"
      calculateCombinedButton.addActionListener(e -> {
        try {
          java.util.List<Double> savedData = new java.util.ArrayList<>();

          // Itera sobre os painéis para acessar os valores de inputFields[] e resultLabel
          for (JPanel panel : panels) {
            JPanel inputPanel = (JPanel) panel.getComponent(0); // Assume que o inputPanel é o primeiro componente
            for (Component component : inputPanel.getComponents()) {
              if (component instanceof JTextField) {
                String inputText = ((JTextField) component).getText().trim();
                if (!inputText.isEmpty()) {
                  savedData.add(Double.parseDouble(inputText));
                }
              }
            }
            JLabel resultLabel = (JLabel) panel.getComponent(panel.getComponentCount() - 1); // Último componente
            String resultText = resultLabel.getText().replaceAll("[^0-9.]", "").trim();
            if (!resultText.isEmpty()) {
              savedData.add(Double.parseDouble(resultText));
            }
          }

          int index = 0; // Initialize index to track the component position
          for (Component component : combinedResultPanel.getComponents()) {
            if (component instanceof JPanel variableResultPanel) {
              for (Component subComponent : variableResultPanel.getComponents()) {
                if (subComponent instanceof JLabel label && "0.0".equals(label.getText())) {
                  Calculator.calculateComplexFormula(index, savedData, label, selectedOp.getVariables()[0]);
                }
              }
              index++; // Increment index for each variableResultPanel
            }
          }

        } catch (NumberFormatException ex) {
          JOptionPane.showMessageDialog(combinedResultPanel,
              "Por favor, insira números válidos e certifique-se de calcular os resultados individuais antes de calcular a combinação.",
              "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
          JOptionPane.showMessageDialog(combinedResultPanel,
              "Por favor, insira números válidos e certifique-se de calcular os resultados individuais antes de calcular a combinação.",
              "Erro", JOptionPane.ERROR_MESSAGE);
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