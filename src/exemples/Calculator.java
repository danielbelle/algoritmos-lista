package exemples;

import exemples.Calculator.Operation;

public class Calculator {
	private static String choice;

	public static String getChoice() {
		return choice;
	}

	// Operation details storage
	public enum Operation {
		simple_average("simple_average", "Média Aritmética Simples",
				new String[] { "value1", "value2" },
				new String[] { "Valor 1", "Valor 2" },
				false, null),
		weighted_average("weighted_average", "Média Aritmética Ponderada",
				new String[] { "value1", "value2", "weight1", "weight2" },
				new String[] { "Valor 1", "Valor 2", "Peso 1", "Peso 2" },
				false, null),
		full_salary("full_salary", "Salário Final",
				new String[] { "salary", "salesTotal" },
				new String[] { "Salario", "Total de Vendas" },
				false, null),
		average_speed("average_speed", "Velocidade Média",
				new String[] { "distVariation", "timeVariation" },
				new String[] { "Variação de Distância", "Variação de Tempo" },
				false, null),
		time_variation("time_variation", "Variação de Tempo",
				new String[] { "distVariation", "averageVelocity" },
				new String[] { "Variação de Distância", "Velocidade Média" },
				false, null),
		distance_variation("distance_variation", "Variação de Distância",
				new String[] { "averageVelocity", "timeVariation" },
				new String[] { "Velocidade Média", "Variação de Tempo" },
				false, null),
		complex_problem("complex_problem", "Problema Complexo",
				null,
				null, true,
				new Operation[] {});

		private final String operation;
		private final String operationPtbr;
		private String[] variables;
		private String[] variablesNamesPtbr;
		private final boolean isComplex;
		private Operation[] relatedOperations;

		Operation(String operation, String operationPtbr,
				String[] variables,
				String[] variablesNamesPtbr,
				boolean isComplex,
				Operation[] relatedOperations) {
			this.operation = operation;
			this.operationPtbr = operationPtbr;
			this.variables = variables;
			this.variablesNamesPtbr = variablesNamesPtbr;
			this.isComplex = isComplex;
			this.relatedOperations = relatedOperations;
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

		public void setVariables(String[] variables) {
			if (!isComplex) {
				throw new UnsupportedOperationException("Only complex operations can have related operations.");
			}
			this.variables = variables;
		}

		public String[] getVariablesNamesPtbr() {
			return variablesNamesPtbr;
		}

		public void setVariablesNamesPtbr(String[] variablesNamesPtbr) {
			if (!isComplex) {
				throw new UnsupportedOperationException("Only complex operations can have related operations.");
			}
			this.variablesNamesPtbr = variablesNamesPtbr;
		}

		public boolean isComplex() {
			return isComplex;
		}

		public Operation[] getRelatedOperations() {
			return relatedOperations;
		}

		public void setRelatedOperations(Operation[] relatedOperations) {
			if (!isComplex) {
				throw new UnsupportedOperationException("Only complex operations can have related operations.");
			}

			this.relatedOperations = relatedOperations;
		}

	}

	public static void main(String[] args) {

	}

	public static double[] solveComplexProblem(Operation operation, double[][] values) {
		if (!operation.isComplex()) {
			throw new IllegalArgumentException("A operação não é complexa.");
		}

		Operation[] relatedOperations = operation.getRelatedOperations();
		double[] result = new double[relatedOperations.length];

		for (int i = 0; i < relatedOperations.length; i++) {
			result[i] = calculateFormula(relatedOperations[i].getOperation(), values[i]);
		}

		return result;
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