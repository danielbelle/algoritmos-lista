import javax.swing.*;

import exemples.MediaAritmeticaSimples;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Exercícios Algoritmos - Daniel Henrique Bellé");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(fullWidth() - 100, fullHeight() - 100);
        frame.setLayout(new BorderLayout());

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
                "Exemplo 7",
                "Exemplo 8",
                "Exemplo 9",
                "Exemplo 10",
                "Exemplo 11"
        };

        // Create a JList to display exercises
        JList<String> exerciseList = new JList<>(exercises);
        exerciseList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(exerciseList);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Create a button to show the selected exercise
        JButton showButton = new JButton("Mostrar exemplo");
        frame.add(showButton, BorderLayout.PAGE_END);

        // Add action listener to the button
        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedExercise = exerciseList.getSelectedValue();
                if (selectedExercise != null) {
                    // JOptionPane.showMessageDialog(frame, "Você selecionou: " + selectedExercise);
                    // Call the corresponding example class based on the selection
                    switch (selectedExercise) {
                        case "Exemplo 1 - Média Aritmética Simples":
                            new MediaAritmeticaSimples().run();
                            break;
                        /*
                         * case "Exemplo 2 - Média Aritmética Ponderada":
                         * new Exemplo2().run();
                         * break;
                         * case "Exemplo 3 - Salário Final":
                         * new Exemplo3().run();
                         * break;
                         * case "Exemplo 4 - Velocidade Média":
                         * new Exemplo4().run();
                         * break;
                         * case "Exemplo 5 - Variação de Tempo":
                         * new Exemplo5().run();
                         * break;
                         * case "Exemplo 6 - Variação de Distância":
                         * new Exemplo6().run();
                         * break;
                         * case "Exemplo 7":
                         * new Exemplo7().run();
                         * break;
                         * case "Exemplo 8":
                         * new Exemplo8().run();
                         * break;
                         * case "Exemplo 9":
                         * new Exemplo9().run();
                         * break;
                         * case "Exemplo 10":
                         * new Exemplo10().run();
                         * break;
                         * case "Exemplo 11":
                         * new Exemplo11().run();
                         * break;
                         */
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Selecione um exemplo.");
                }
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