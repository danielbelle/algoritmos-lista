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
        simple_average("simple_average", "Média Aritmética Simples",
                new String[] { "value1", "value2" },
                new String[] { "Valor 1", "Valor 2" }),
        weighted_average("weighted_average", "Média Aritmética Ponderada",
                new String[] { "value1", "value2", "weight1", "weight2" },
                new String[] { "Valor 1", "Valor 2", "Peso 1", "Peso 2" }),
        full_salary("full_salary", "Salário Final",
                new String[] { "salary", "salesTotal" },
                new String[] { "Salario", "Total de Vendas" }),
        average_speed("average_speed", "Velocidade Média",
                new String[] { "distVariation", "timeVariation" },
                new String[] { "Variação de Distância", "Variação de Tempo" }),
        time_variation("time_variation", "Variação de Tempo",
                new String[] { "distVariation", "averageVelocity" },
                new String[] { "Variação de Distância", "Velocidade Média" }),
        distance_variation("distance_variation", "Variação de Distância",
                new String[] { "averageVelocity", "timeVariation" },
                new String[] { "Velocidade Média", "Variação de Tempo" });

        private final String operation;
        private final String operationPtbr;
        private final String[] variables;
        private final String[] variablesNamesPtbr;

        Operation(String operation, String operationPtbr,
                String[] variables,
                String[] variablesNamesPtbr) {
            this.operation = operation;
            this.operationPtbr = operationPtbr;
            this.variables = variables;
            this.variablesNamesPtbr = variablesNamesPtbr;
        }

        public String getOperation() {
            return operation;
        }

        public String getOperationPtbr() {
            return operationPtbr;
        }

        public String[] getVariables() {
            return variables;
        }

        public String[] getVariablesNamesPtbr() {
            return variablesNamesPtbr;
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