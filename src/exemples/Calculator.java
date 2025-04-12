package exemples;

public class Calculator {

    // Atributos
    private static double value1, value2, weight1, weight2;
    private static String operation = "weighted_average"; // pode ser

    public static void main(String[] args) {
        Object[] processArray = getProcess(operation);
        Double[] inputVariables = getInputVariables(processArray[0]);
        Double processResult = startProcess(inputVariables, processArray[1]);
        System.out.println(processResult);
        /*
         * for (Object line : processArray) {
         * System.out.println(line);
         * }
         */
    }

    public static Double startProcess(Double[] inputVariables, Object processArray) {

        for (Object line : inputVariables) {
            // System.out.println(line);
        }

        Double extractFormula = (Double) processArray;

        return extractFormula;
    }

    public static Double[] getInputVariables(Object processArray) {

        value1 = 10;
        value2 = 20;
        weight1 = 2;
        weight2 = 3;

        return new Double[] {
                value1,
                value2,
                weight1,
                weight2
        };

    }

    public static Object[] getProcess(String operation) {

        switch (operation) {
            case "simple_average":
                return new Object[] {
                        "double value1, double value2",
                        (value1 + value2) / 2
                };
            case "weighted_average":
                return new Object[] {
                        "double value1, double value2, double weight1, double weight2",
                        (((value1 * weight1) + (value2 * weight2)) / (weight1 + weight2))
                };
            case "/":
                if (value2 != 0) {
                    return new Object[] {
                            "double value1, double value2",
                            (value1 / value2)
                    };
                } else {
                    throw new ArithmeticException("Division by zero is not allowed.");
                }
            default:
                throw new IllegalArgumentException("Invalid operation: " + operation);
        }
    }

    /*
     * 
     * 
     * 
     * 
     * public static double getProcess(String operation){
     * 
     * switch (operation) {
     * case "simple_average":
     * return (value1 + value2) / 2;
     * case "weighted_average":
     * return ((value1 * weight1) + (value2 * weight2)) / (weight1 + weight2);
     * case "*":
     * return value1 * value2;
     * case "/":
     * if (value2 != 0) {
     * return value1 / value2;
     * } else {
     * throw new ArithmeticException("Division by zero is not allowed.");
     * }
     * 
     * default:
     * throw new IllegalArgumentException("Invalid operation: " + operation);
     * }
     * 
     */

}
