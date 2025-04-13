package exemples;

import java.util.Scanner;

public class Calculator {

    // Operation details storage
    private enum Operation {
        simple_average("simple_average", new String[] { "value1", "value2" }),
        weighted_average("weighted_average", new String[] { "value1", "value2", "weight1", "weight2" }),
        full_salary("full_salary", new String[] { "salary", "salesTotal" }),
        average_speed("average_speed", new String[] { "distVariation", "timeVariation" }),
        time_variation("time_variation", new String[] { "distVariation", "averageVelocity" }),
        distance_variation("distance_variation", new String[] { "averageVelocity", "timeVariation" });

        private final String operation;
        private final String[] variables;

        Operation(String operation, String[] variables) {
            this.operation = operation;
            this.variables = variables;
        }

        public String getOperation() {
            return operation;
        }

        public String[] getVariables() {
            return variables;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String choice = "distance_variation";

        try {
            Operation selectedOp = Operation.valueOf(choice);
            calculateOperation(selectedOp, scanner);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid operation selected!");
        }

        scanner.close();
    }

    private static void calculateOperation(Operation operation, Scanner scanner) {
        System.out.printf("\nOperation %s selected: %s%n", operation.name(), operation.getOperation());

        // Get input values for each variable
        double[] values = new double[operation.getVariables().length];
        for (int i = 0; i < operation.getVariables().length; i++) {
            System.out.printf("Enter value for %s: ", operation.getVariables()[i]);
            values[i] = scanner.nextDouble();
        }

        // Calculate result based on operation
        double result = calculateFormula(operation.getOperation(), values);
        System.out.printf("Result: %.2f%n", result);
    }

    private static double calculateFormula(String operation, double[] values) {

        if (operation == "weighted_average" || operation == "simple_average") {
            // used boolean logic that it values[2] != 0 && values[3] != 0 && values[2] &&
            // values[3] != 0
            // is values[2]+values[3]!=0

            if (values[2] + values[3] != 0) {
                return (values[0] * values[2] + values[1] * values[3]) / (values[2] + values[3]);
            } else {
                return (values[0] + values[1]) / 2;
            }
        } else if (operation == "full_salary") {
            return values[0] + values[1] * (0.15);
        } else {
            if (values[1] != 0) {
                return (values[0] / values[1]);
            } else {
                throw new ArithmeticException("Division by zero is not allowed.");
            }
        }
    }
}
