package exemples;

public class Calculator {
    private static String choice;

    public static String getChoice() {
        return choice;
    }

    public static void setChoice(String newChoice) {
        choice = newChoice;
    }

    // Operation details storage
    public enum Operation {
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
        setChoice(args.length > 0 ? args[0] : "distance_variation");

        try {
            // Verifica se a operação é válida
            Operation selectedOp = Operation.valueOf(choice);

            // Chama a interface gráfica do ShowExemple
            ShowExemple showExemple = new ShowExemple();
            showExemple.run(selectedOp);

        } catch (IllegalArgumentException e) {
            System.out.println("Invalid operation selected!");
        }
    }

    public static double calculateFormula(String operation, double[] values) {
        if (operation.equals("weighted_average") || operation.equals("simple_average")) {
            if (values.length > 2) {
                if (values[2] + values[3] != 0) {
                    return (values[0] * values[2] + values[1] * values[3]) / (values[2] + values[3]);
                } else {
                    throw new ArithmeticException("Division by zero is not allowed.");
                }
            } else {
                return (values[0] + values[1]) / 2;
            }
        } else if (operation.equals("full_salary")) {
            return values[0] + values[1] * (0.15);
        } else if (operation.equals("distance_variation")) {
            return (values[0] * values[1]);
        } else {
            if (values[1] != 0) {
                return (values[0] / values[1]);
            } else {
                throw new ArithmeticException("Division by zero is not allowed.");
            }
        }
    }
}