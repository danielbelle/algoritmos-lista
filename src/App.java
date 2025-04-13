import javax.swing.*;
import java.awt.*;
import exemples.Calculator;
import exemples.ShowExemple;

public class App {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Exercícios Algoritmos - Daniel Henrique Bellé");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(fullWidth() - 100, fullHeight() - 100);

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
                "Exemplo 7 - Exemplo do Ônibus"

        };

        // Create a JList to display exercises
        JList<String> exerciseList = new JList<>(exercises);
        exerciseList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(exerciseList);

        // Create a panel for the right side (ShowExemple)
        JPanel rightPanel = new JPanel(new BorderLayout());

        // Create a JSplitPane to divide the main frame
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollPane, rightPanel);
        splitPane.setDividerLocation(250); // Set initial divider position
        frame.add(splitPane);

        // Add action listener to the list
        exerciseList.addListSelectionListener(e -> {
            String selectedExercise = exerciseList.getSelectedValue();
            if (selectedExercise != null) {
                Calculator.Operation selectedOp = null;
                switch (selectedExercise) {
                    case "Exemplo 1 - Média Aritmética Simples":
                        selectedOp = Calculator.Operation.simple_average;
                        break;
                    case "Exemplo 2 - Média Aritmética Ponderada":
                        selectedOp = Calculator.Operation.weighted_average;
                        break;
                    case "Exemplo 3 - Salário Final":
                        selectedOp = Calculator.Operation.full_salary;
                        break;
                    case "Exemplo 4 - Velocidade Média":
                        selectedOp = Calculator.Operation.average_speed;
                        break;
                    case "Exemplo 5 - Variação de Tempo":
                        selectedOp = Calculator.Operation.time_variation;
                        break;
                    case "Exemplo 6 - Variação de Distância":
                        selectedOp = Calculator.Operation.distance_variation;
                        break;
                    default:
                        JOptionPane.showMessageDialog(frame, "Exemplo não implementado.");
                        return;
                }

                // Clear the right panel and add ShowExemple
                rightPanel.removeAll();
                ShowExemple showExemple = new ShowExemple();
                showExemple.run(selectedOp, rightPanel);
                rightPanel.revalidate();
                rightPanel.repaint();
            }
        });

        // Make the frame visible
        frame.setVisible(true);
    }

    private static int fullHeight() {
        // get full height of the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        return (int) screenSize.getHeight();
    }

    private static int fullWidth() {
        // get full width of the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        return (int) screenSize.getWidth();
    }
}