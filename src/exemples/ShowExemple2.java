package exemples;

import javax.swing.*;

import exemples.Calculator.Operation;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowExemple2 {
	private GroupLayout layout; // Declare the layout field

	public void main(JPanel container) {
		layout = new GroupLayout(container);
		container.setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
	}

	public void run(Calculator.Operation selectedOp, JPanel container) {

		// Título da operação
		JLabel formulaLabel = new JLabel("Operação: " + selectedOp.getOperationPtbr(), SwingConstants.CENTER);
		formulaLabel.setFont(new Font("Arial", Font.BOLD, 18));

		/*
		 * try {
		 * // Verifica se a operação é válida
		 * 
		 * if (selectedOp.isComplex()) {
		 * Operation[] listedOperations = {
		 * Operation.time_variation,
		 * Operation.distance_variation,
		 * Operation.average_speed
		 * };
		 * 
		 * 
		 * IMPORTANTE
		 * String[] operationNames = new String[0];
		 * operationNames = Stream.of(relatedOps)
		 * .flatMap(op -> Stream.of(op.getVariables()))
		 * .toArray(String[]::new);
		 * for (String operationName : operationNames) {
		 * System.out.println(operationName);
		 * }
		 * 
		 * String[] variables = new String[relatedOps.length];
		 * String[] variablesNamesPtbr = new String[relatedOps.length];
		 * 
		 * String[] operationNamesPtbr = new String[relatedOps.length];
		 * for (int i = 0; i < relatedOps.length; i++) {
		 * operationNamesPtbr[i] = relatedOps[i].getOperationPtbr();
		 * }
		 * 
		 * for (int i = 0; i < relatedOps.length; i++) {
		 * variables[i] = relatedOps[i].getOperation();
		 * variablesNamesPtbr[i] = relatedOps[i].getOperationPtbr();
		 * // System.out.println("Variable: " + variables[i] + ", Name (Pt-BR): " +
		 * // variablesNamesPtbr[i]);
		 * }
		 * 
		 * complexOp.setVariables(variables);
		 * complexOp.setVariablesNamesPtbr(variablesNamesPtbr);
		 * complexOp.setRelatedOperations(relatedOps);
		 * 
		 * // Valores para cada operação relacionada
		 * double[][] values = {
		 * { 100, 2 },
		 * { 100, 50 },
		 * { 50, 2 }
		 * };
		 * 
		 * 
		 * 
		 * 
		 * // double[] result = solveComplexProblem(complexOp, values);
		 * 
		 * // System.out.println("Resultado do Problema Complexo: " + result);
		 * }
		 * 
		 * } catch (IllegalArgumentException e) {
		 * System.out.println("Invalid operation selected!");
		 * }
		 * 
		 * 
		 */

		if (selectedOp.isComplex()) {
			Operation[] listedOperations = null;
			try {
				// Verifica se a operação é válida

				listedOperations = new Operation[] {
						Operation.time_variation,
						Operation.distance_variation,
						Operation.average_speed
				};
				// Painel de entrada
				JPanel inputPanel = new JPanel(new GridLayout(listedOperations.length, 2, 5, 5));
				JTextField[] inputFields = new JTextField[selectedOp.getOperation().length()];
				// Painel de botões
				JButton calculateButton = new JButton("Calcular");
				JButton clearButton = new JButton("Limpar");

				// Rótulo de resultado
				JLabel resultLabel = new JLabel("Resultado: ");
				resultLabel.setFont(new Font("Arial", Font.BOLD, 12)); // Fonte menor para o resultado

				// Configuração do layout horizontal
				layout.setHorizontalGroup(
						layout.createParallelGroup(GroupLayout.Alignment.CENTER)
								.addComponent(formulaLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(inputPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGroup(layout.createSequentialGroup()
										.addComponent(calculateButton)
										.addComponent(clearButton))
								.addComponent(resultLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE));

				// Configuração do layout vertical
				layout.setVerticalGroup(
						layout.createSequentialGroup()
								.addGap(20) // Espaçamento superior
								.addComponent(formulaLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGap(10) // Espaçamento entre o título e o painel de entrada
								.addComponent(inputPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGap(10) // Espaçamento entre o painel de entrada e os botões
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(calculateButton)
										.addComponent(clearButton))
								.addGap(10) // Espaçamento entre os botões e o rótulo de resultado
								.addComponent(resultLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGap(20) // Espaçamento inferior
				);

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
							JOptionPane.showMessageDialog(container, "Por favor, insira números válidos.", "Erro",
									JOptionPane.ERROR_MESSAGE);
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(container, ex.getMessage(), "Erro",
									JOptionPane.ERROR_MESSAGE);
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
			} catch (IllegalArgumentException e) {
				System.out.println("Invalid operation selected!");
			}

			/*
			 * for (int i = 0; i < selectedOp.getVariables().length; i++) {
			 * JLabel label = new JLabel(selectedOp.getVariablesNamesPtbr()[i] + ":");
			 * label.setFont(new Font("Arial", Font.PLAIN, 12)); // Fonte menor para os
			 * rótulos
			 * JTextField textField = new JTextField(8); // Define o tamanho preferido do
			 * campo de texto
			 * inputFields[i] = textField;
			 * inputPanel.add(label);
			 * inputPanel.add(textField);
			 * }
			 */

		} else

		{
			// Painel de entrada
			JPanel inputPanel = new JPanel(new GridLayout(selectedOp.getVariables().length, 2, 5, 5));
			JTextField[] inputFields = new JTextField[selectedOp.getVariables().length];
			for (int i = 0; i < selectedOp.getVariables().length; i++) {
				JLabel label = new JLabel(selectedOp.getVariablesNamesPtbr()[i] + ":");
				label.setFont(new Font("Arial", Font.PLAIN, 12)); // Fonte menor para os rótulos
				JTextField textField = new JTextField(8); // Define o tamanho preferido do campo de texto
				inputFields[i] = textField;
				inputPanel.add(label);
				inputPanel.add(textField);
			}

			// Painel de botões
			JButton calculateButton = new JButton("Calcular");
			JButton clearButton = new JButton("Limpar");

			// Rótulo de resultado
			JLabel resultLabel = new JLabel("Resultado: ");
			resultLabel.setFont(new Font("Arial", Font.BOLD, 12)); // Fonte menor para o resultado

			// Configuração do layout horizontal
			layout.setHorizontalGroup(
					layout.createParallelGroup(GroupLayout.Alignment.CENTER)
							.addComponent(formulaLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(inputPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addGroup(layout.createSequentialGroup()
									.addComponent(calculateButton)
									.addComponent(clearButton))
							.addComponent(resultLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE));

			// Configuração do layout vertical
			layout.setVerticalGroup(
					layout.createSequentialGroup()
							.addGap(20) // Espaçamento superior
							.addComponent(formulaLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addGap(10) // Espaçamento entre o título e o painel de entrada
							.addComponent(inputPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addGap(10) // Espaçamento entre o painel de entrada e os botões
							.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
									.addComponent(calculateButton)
									.addComponent(clearButton))
							.addGap(10) // Espaçamento entre os botões e o rótulo de resultado
							.addComponent(resultLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addGap(20) // Espaçamento inferior
			);

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
						JOptionPane.showMessageDialog(container, "Por favor, insira números válidos.", "Erro",
								JOptionPane.ERROR_MESSAGE);
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(container, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
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
		}
	}
}