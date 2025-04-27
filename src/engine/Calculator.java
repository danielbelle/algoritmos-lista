package engine;

import javax.swing.JLabel;

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
				false, null, null),
		weighted_average("weighted_average", "Média Aritmética Ponderada",
				new String[] { "value1", "value2", "weight1", "weight2" },
				new String[] { "Valor 1", "Valor 2", "Peso 1", "Peso 2"
				},
				false, null,
				null),
		full_salary("full_salary", "Salário Final",
				new String[] { "salary", "salesTotal" },
				new String[] { "Salário", "Total de Vendas" },
				false, null,
				null),
		average_speed("average_speed", "Velocidade Média",
				new String[] { "distVariation", "timeVariation" },
				new String[] { "Variação de Distância", "Variação de Tempo" },
				false, null,
				null),
		time_variation("time_variation", "Variação de Tempo",
				new String[] { "distVariation", "averageVelocity" },
				new String[] { "Variação de Distância", "Velocidade Média" },
				false, null,
				null),
		distance_variation("distance_variation", "Variação de Distância",
				new String[] { "averageVelocity", "timeVariation" },
				new String[] { "Velocidade Média", "Variação de Tempo" },
				false, null, null),
		rent_divide("rent_divide", "Aluguel",
				new String[] { "salary", "rentParts" },
				new String[] { "Salário", "Aluguel" },
				false, null,
				null),
		kg_price("kg_price", "Preço por Quilograma",
				new String[] { "totalPrice", "totalWeight" },
				new String[] { "Preço Pago", "Peso" }, false, null,
				null),
		complex_problem("complex_problem", "Problema Complexo",
				null,
				new String[] {}, true,
				new Operation[] {},
				new String[] {});

		private final String operation;
		private final String operationPtbr;
		private String[] variables;
		private String[] variablesNamesPtbr;
		private final boolean isComplex;
		private Operation[] relatedOperations;
		private String[] simplePanelNamesInput;

		Operation(String operation, String operationPtbr,
				String[] variables,
				String[] variablesNamesPtbr,
				boolean isComplex,
				Operation[] relatedOperations, String[] simplePanelNamesInput) {
			this.operation = operation;
			this.operationPtbr = operationPtbr;
			this.variables = variables;
			this.variablesNamesPtbr = variablesNamesPtbr;
			this.isComplex = isComplex;
			this.relatedOperations = relatedOperations;
			this.simplePanelNamesInput = simplePanelNamesInput;
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
				throw new UnsupportedOperationException("Apenas operações complexas podem ter operações relacionadas.");
			}

			this.relatedOperations = relatedOperations;
		}

		public String[] getSimplePanelNamesInput() {
			return simplePanelNamesInput;
		}

		public void setSimplePanelNamesInput(String[] simplePanelNamesInput) {

			this.simplePanelNamesInput = simplePanelNamesInput;
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
		switch (operation) {
			case "weighted_average", "simple_average", "rent_divide" -> {
				if (values.length > 2) {
					if (values[2] + values[3] != 0) {
						return (values[0] * values[2] + values[1] * values[3]) / (values[2] + values[3]);
					} else {
						throw new ArithmeticException("Division by zero is not allowed.");
					}
				} else if (values.length == 2 && operation.equals("rent_divide")) {
					return (values[0] / 11) * values[1];
				} else {
					return (values[0] + values[1]) / 2;
				}
			}
			case "full_salary" -> {
				return values[0] + values[1] * 0.15;
			}
			case "distance_variation" -> {
				return values[0] * values[1];
			}
			default -> {
				if (values[1] != 0) {
					return values[0] / values[1];
				} else {
					throw new ArithmeticException("Division by zero is not allowed.");
				}
			}
		}
	}

	public static Double calculateComplexFormula(
			int index,
			java.util.List<Double> savedData,
			JLabel label,
			String exempleName) {
		if (savedData == null
				|| (savedData.size() < 6 && !exempleName.equals("Exemplo 10 - Aluguel"))) {
			throw new IllegalArgumentException("Dados insuficientes para o cálculo.");
		}

		double value = 0.0;
		String unit = "";

		switch (exempleName) {
			case "Exemplo 7 - Motorista do Ônibus" -> {
				value = switch (index) {
					case 0 -> savedData.get(2) * 60;
					case 1 -> savedData.get(5);
					case 2 -> Math.abs(savedData.get(5) - savedData.get(0));
					case 3 -> (savedData.get(1) != 0 && savedData.get(5) != 0)
							? Math.abs(savedData.get(5) - savedData.get(0)) * 60 / savedData.get(1)
							: Double.NaN;
					default -> Double.NaN;
				};

				unit = switch (index) {
					case 0, 3 -> " minutos";
					case 1, 2 -> " km";
					default -> "";
				};
			}
			case "Exemplo 8 - Metrô" -> {
				value = switch (index) {
					case 0 -> savedData.get(1) != 0 ? savedData.get(0) / savedData.get(1) : Double.NaN;
					case 1 -> savedData.get(2) != 0 ? savedData.get(0) / savedData.get(2) : Double.NaN;
					case 2 -> (savedData.get(1) != 0 && savedData.get(2) != 0)
							? Math.abs((savedData.get(0) / savedData.get(1)) - (savedData.get(0) / savedData.get(2)))
							: Double.NaN;
					case 3 ->
						savedData.get(1) != 0 ? (savedData.get(0) / savedData.get(1)) * savedData.get(2) : Double.NaN;
					default -> Double.NaN;
				};

				unit = switch (index) {
					case 0, 1, 2 -> " horas";
					case 3 -> " km";
					default -> "";
				};
			}
			case "Exemplo 9 - Aeronave" -> {
				double cruisingDistance = savedData.get(3) - savedData.get(2);
				double totalTime = savedData.get(4) != 0
						? savedData.get(1) + cruisingDistance / savedData.get(4)
						: Double.NaN;
				value = switch (index) {
					case 0 -> totalTime;
					case 1 -> savedData.get(2);
					case 2 -> cruisingDistance;
					case 3 -> savedData.get(4) != 0
							? cruisingDistance / savedData.get(4)
							: Double.NaN;
					case 4 -> savedData.get(4);
					case 5 -> savedData.get(0) != 0
							? savedData.get(3) / savedData.get(0)
							: Double.NaN;
					default -> Double.NaN;
				};

				unit = switch (index) {
					case 0, 3, 5 -> " horas";
					case 1, 2 -> " km";
					case 4 -> " km/h";
					default -> "";
				};
			}
			case "Exemplo 10 - Aluguel" -> {
				value = switch (index) {
					case 0 -> savedData.get(2);
					case 1 -> savedData.get(0) != 0
							? (savedData.get(2) / savedData.get(0)) * 100
							: Double.NaN;
					default -> Double.NaN;
				};

				unit = switch (index) {
					case 0 -> " Reais por mês";
					case 1 -> " %";
					default -> "";
				};
			}
		}

		label.setText(Double.isNaN(value) ? "N/A" : String.format("%.2f", value) + unit);
		return value;
	}
}
