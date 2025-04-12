package exemples;

public class CalculatorSave {

    // Atributos
    private static double value1, value2, weight1, weight2;

    public static void main(String[] args) {

        String operation = "weighted_average"; // pode ser

        String inputVariables = getInputVariables(operation);
        Double result = calculate(inputVariables);

        System.out.println("inputVariables: " + inputVariables + "result: " + result);
    }

    public static String getInputVariables(String operation) {
        switch (operation) {
            case "simple_average":
                return "double value1, double value2";
            case "weighted_average":
                return "double value1, double value2, double weight1, double weight2";
            case "full_salary":
            case "average_speed":
            case "time_variation":
            case "distance_variation":
            default:
                throw new IllegalArgumentException("Invalid operation: " + operation);
        }
    }

    public static double calculate(String operation) {

        switch (operation) {

            case "simple_average":
                return (value1 + value2) / 2;
            case "weighted_average":
                return ((value1 * weight1) + (value2 * weight2)) / (weight1 + weight2);
            case "*":
                return value1 * value2;
            case "/":
                if (value2 != 0) {
                    return value1 / value2;
                } else {
                    throw new ArithmeticException("Division by zero is not allowed.");
                }

            default:
                throw new IllegalArgumentException("Invalid operation: " + operation);
        }

    }
}
