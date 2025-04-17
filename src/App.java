import javax.swing.*;

import java.awt.event.MouseEvent;

import java.awt.*;
import exemples.Calculator.Operation;
import exemples.ShowExemple;
import java.awt.event.MouseAdapter;

public class App {

	public static void main(String[] args) {
		// Create the main frame
		JFrame frame = new JFrame("Exercícios Algoritmos - Daniel Henrique Bellé");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(getFullScreenSize(-150, -150));

		// Create a label
		JLabel label = new JLabel("Selecione um exemplo para executar:", SwingConstants.CENTER);
		label.setFont(new Font("Arial", Font.BOLD, 20));

		// Create a list of exercises
		String[] exercises = {
				"Exemplo 1 - Média Aritmética Simples",
				"Exemplo 2 - Média Aritmética Ponderada",
				"Exemplo 3 - Salário Final",
				"Exemplo 4 - Velocidade Média",
				"Exemplo 5 - Variação de Tempo",
				"Exemplo 6 - Variação de Distância",
				"Exemplo 7 - Motorista do Ônibus",
				"Exemplo 8 - Metrô",
				"Exemplo 9 - ",
				"Exemplo 10 - ",
				"Exemplo 11 - ",

		};

		// Create a JList to display exercises
		JList<String> exerciseList = new JList<>(exercises);
		exerciseList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane = new JScrollPane(exerciseList);

		// Create a panel for the right side (ShowExemple)
		JPanel leftPanel = new JPanel(new BorderLayout());

		// Create a JSplitPane to divide the main frame
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollPane, leftPanel);
		splitPane.setDividerLocation(250); // Set initial divider position
		frame.add(splitPane);

		// Clear the right panel and add ShowExemple
		leftPanel.removeAll();
		ShowExemple showExemple = new ShowExemple();
		showExemple.main(leftPanel);
		leftPanel.revalidate();
		leftPanel.repaint();

		// Add action listener to the list
		exerciseList.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String selectedExercise = exerciseList.getSelectedValue();
				if (selectedExercise != null) {
					Operation selectedOp = null;
					switch (selectedExercise) {
						case "Exemplo 1 - Média Aritmética Simples":
							selectedOp = Operation.simple_average;
							break;
						case "Exemplo 2 - Média Aritmética Ponderada":
							selectedOp = Operation.weighted_average;
							break;
						case "Exemplo 3 - Salário Final":
							selectedOp = Operation.full_salary;
							break;
						case "Exemplo 4 - Velocidade Média":
							selectedOp = Operation.average_speed;
							break;
						case "Exemplo 5 - Variação de Tempo":
							selectedOp = Operation.time_variation;
							break;
						case "Exemplo 6 - Variação de Distância":
							selectedOp = Operation.distance_variation;
							break;
						case "Exemplo 7 - Motorista do Ônibus":
							selectedOp = Operation.complex_problem;
							selectedOp.setRelatedOperations(
									new Operation[] { Operation.time_variation,
											Operation.distance_variation });
							selectedOp.setVariablesNamesPtbr(new String[] {
									"Tempo Total", "Distância Percorrida", "Distância Restante",
									"Tempo Restante"
							});
							selectedOp.setVariables(new String[] {
									"Exemplo 7 - Motorista do Ônibus" });
							break;
						case "Exemplo 8 - Metrô":
							selectedOp = Operation.complex_problem;
							selectedOp.setRelatedOperations(
									new Operation[] { Operation.time_variation,
											Operation.time_variation });
							selectedOp.setVariablesNamesPtbr(new String[] {
									"Tempo Total", "Tempo Ajustado", "Diferença de Tempo", "Diferença de Distância"
							});
							selectedOp.setVariables(new String[] {
									"Exemplo 8 - Metrô" });
							break;
						case "Exemplo 9 - ":
							selectedOp = Operation.complex_problem;
							selectedOp.setRelatedOperations(
									new Operation[] { Operation.time_variation,
											Operation.distance_variation });
							break;
						case "Exemplo 10 - ":
							selectedOp = Operation.complex_problem;
							selectedOp.setRelatedOperations(
									new Operation[] { Operation.time_variation,
											Operation.distance_variation });
							break;
						case "Exemplo 11 - ":
							selectedOp = Operation.complex_problem;
							selectedOp.setRelatedOperations(
									new Operation[] { Operation.time_variation,
											Operation.distance_variation });
							break;

						default:
							JOptionPane.showMessageDialog(frame, "Exemplo não implementado.");
							return;
					}
					// Clear the right panel and add ShowExemple
					leftPanel.removeAll();
					showExemple.run(selectedOp, leftPanel);
					leftPanel.revalidate();
					leftPanel.repaint();

				}
			}
		});

		// Make the frame visible
		frame.setVisible(true);
	}

	private static Dimension getFullScreenSize(int widthOffset, int heightOffset) {
		// Get full screen dimensions and apply offsets
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		return new Dimension(screenSize.width + widthOffset, screenSize.height + heightOffset);
	}

}