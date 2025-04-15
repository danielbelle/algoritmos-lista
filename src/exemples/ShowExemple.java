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

		if (selectedOp.isComplex()) {
			// Configura o layout GroupLayout
			layout = new GroupLayout(container);
			container.setLayout(layout);
			layout.setAutoCreateGaps(true);
			layout.setAutoCreateContainerGaps(true);

			// Criação dos 3 painéis usando o método simplePanel
			JPanel panelOne = simplePanel(selectedOp);
			JPanel panelTwo = simplePanel(selectedOp);
			JPanel panelThree = simplePanel(selectedOp);

			// Configuração do layout horizontal
			layout.setHorizontalGroup(
					layout.createParallelGroup(GroupLayout.Alignment.CENTER)
							.addGroup(layout.createSequentialGroup()
									.addComponent(panelOne, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
											GroupLayout.PREFERRED_SIZE)
									.addComponent(panelTwo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
											GroupLayout.PREFERRED_SIZE)
									.addComponent(panelThree, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
											GroupLayout.PREFERRED_SIZE)));

			// Configuração do layout vertical
			layout.setVerticalGroup(
					layout.createSequentialGroup()
							.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
									.addComponent(panelOne, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
											GroupLayout.PREFERRED_SIZE)
									.addComponent(panelTwo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
											GroupLayout.PREFERRED_SIZE)
									.addComponent(panelThree, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
											GroupLayout.PREFERRED_SIZE)));
		} else {
			// Configuração para operações simples
			JPanel inputPanel = simplePanel(selectedOp);
			container.setLayout(new BorderLayout());
			container.add(inputPanel, BorderLayout.CENTER);
		}

		container.revalidate();
		container.repaint();
	}

	public JPanel simplePanel(Operation selectedOp) {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		// Usa BoxLayout para organizar os componentes verticalmente

		// Título da operação
		JLabel formulaLabel = new JLabel("Operação: " + selectedOp.getOperationPtbr(), SwingConstants.CENTER);
		formulaLabel.setFont(new Font("Arial", Font.BOLD, 12));
		panel.add(formulaLabel);

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