## 📚 Projeto: Exercícios de Algoritmos

Este projeto implementa soluções para 11 questões de algoritmos utilizando Java.
A interface gráfica foi desenvolvida com `Swing`, permitindo a seleção e
execução de exemplos diretamente no aplicativo.

---

### 📋 Estrutura do Projeto

- **`DanielHenriqueBelle.java`**: Arquivo principal que inicializa a interface
  gráfica e gerencia a seleção dos exemplos.
- **`ShowExemple.java`**: Responsável por renderizar os painéis dinâmicos para
  entrada de dados e exibição de resultados.
- **`Calculator.java`**: Contém a lógica de cálculo para cada exemplo, incluindo
  operações simples e complexas.

---

### 🧮 Exemplos Implementados

#### **Exemplo 1 - Média Aritmética Simples**

- **Descrição**: Calcula a média aritmética simples entre dois números inteiros.
- **Fórmula**: `(valor1 + valor2) / 2`

#### **Exemplo 2 - Média Aritmética Ponderada**

- **Descrição**: Calcula a média ponderada entre dois números, com pesos 2,5 e
  3,5.
- **Fórmula**: `(valor1 * peso1 + valor2 * peso2) / (peso1 + peso2)`

#### **Exemplo 3 - Salário Final**

- **Descrição**: Calcula o salário final de um vendedor, considerando uma
  comissão de 15% sobre o total de vendas.
- **Fórmula**: `SalárioFinal = SalárioBase + (TotalVendas * 15%)`

#### **Exemplo 4 - Velocidade Média**

- **Descrição**: Calcula a velocidade média de um deslocamento em km/h.
- **Fórmula**: `(Distância * 60) / TempoEmMinutos`

#### **Exemplo 5 - Variação de Tempo**

- **Descrição**: Calcula o tempo necessário para percorrer uma distância a uma
  velocidade média.
- **Fórmula**: `Tempo = Distância / VelocidadeMédia`

#### **Exemplo 6 - Variação de Distância**

- **Descrição**: Calcula a distância percorrida com base na velocidade e no
  tempo.
- **Fórmula**: `Distância = Velocidade * Tempo`

#### **Exemplo 7 - Motorista do Ônibus**

- **Descrição**: Calcula informações sobre a viagem de um motorista de ônibus,
  incluindo tempo restante e distância percorrida.
- **Fórmulas**:
  - `TempoTotal = DistânciaTotal / VelocidadeMédia`
  - `DistânciaPercorrida = VelocidadeMédia * Intervalo`
  - `DistânciaRestante = DistânciaTotal - DistânciaPercorrida`
  - `TempoRestante = DistânciaRestante / VelocidadeMédia`

#### **Exemplo 8 - Metrô**

- **Descrição**: Calcula informações sobre o trajeto de um metrô, considerando
  velocidades padrão e ajustada.
- **Fórmulas**:
  - `TempoPadrão = ExtensãoTotal / VelocidadePadrão`
  - `TempoAjustado = ExtensãoTotal / VelocidadeAjustada`
  - `DiferençaTempo = TempoPadrão - TempoAjustado`
  - `DistânciaPossível = VelocidadeAjustada * TempoPadrão`
  - `DiferençaDistância = ExtensãoTotal - DistânciaPossível`

#### **Exemplo 9 - Aeronave**

- **Descrição**: Calcula informações sobre o trajeto de uma aeronave,
  considerando piloto automático e cruzeiro.
- **Fórmulas**:
  - `TempoTotal = Extensão / VelocidadeCruzeiro`
  - `DistânciaPilotoAutomático = VelocidadeAutomática * Intervalo`
  - `DistânciaRestante = Extensão - DistânciaPilotoAutomático`
  - `TempoRestante = TempoTotal - Intervalo`
  - `VelocidadeNecessária = DistânciaRestante / TempoRestante`
  - `TempoAutomático = Extensão / VelocidadeAutomática`

#### **Exemplo 10 - Aluguel**

- **Descrição**: Calcula o valor pago pelo aluguel e o percentual do salário
  utilizado.
- **Fórmulas**:
  - `ValorAluguel = (Salário / 11) * Partes`
  - `Percentual = (ValorAluguel / Salário) * 100`

#### **Exemplo 11 - Preço por kg**

- **Descrição**: Calcula o preço por quilograma de carne.
- **Fórmula**: `ValorPorQuilo = ValorPago / Quantidade`

---

### 🖥️ Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/algoritmos-lista.git
   ```
2. Abra o projeto no Visual Studio Code ou em sua IDE preferida.
3. Compile e execute o arquivo DanielHenriqueBelle.java.

---

### Alterações Realizadas

1. Atualizei o nome do arquivo principal para
   [DanielHenriqueBelle.java](http://_vscodecontentref_/1).
2. Ajustei os nomes das variáveis e descrições para refletir as alterações
   realizadas no código.

---

### 🌐 English Version

## 📚 Project: Algorithm Exercises

This project implements solutions for 11 algorithm problems using Java. The
graphical interface was developed with `Swing`, allowing users to select and
execute examples directly in the application.

---

### 📋 Project Structure

- **`DanielHenriqueBelle.java`**: Main file that initializes the graphical
  interface and manages example selection.
- **`ShowExemple.java`**: Responsible for rendering dynamic panels for data
  input and result display.
- **`Calculator.java`**: Contains the calculation logic for each example,
  including simple and complex operations.

---

### 🧮 Implemented Examples

#### **Example 1 - Simple Arithmetic Mean**

- **Description**: Calculates the simple arithmetic mean between two integers.
- **Formula**: `(value1 + value2) / 2`

#### **Example 2 - Weighted Arithmetic Mean**

- **Description**: Calculates the weighted mean between two numbers, with
  weights 2.5 and 3.5.
- **Formula**: `(value1 * weight1 + value2 * weight2) / (weight1 + weight2)`

#### **Example 3 - Final Salary**

- **Description**: Calculates the final salary of a salesperson, considering a
  15% commission on total sales.
- **Formula**: `FinalSalary = BaseSalary + (TotalSales * 15%)`

#### **Example 4 - Average Speed**

- **Description**: Calculates the average speed of a trip in km/h.
- **Formula**: `(Distance * 60) / TimeInMinutes`

#### **Example 5 - Time Variation**

- **Description**: Calculates the time required to cover a distance at a given
  average speed.
- **Formula**: `Time = Distance / AverageSpeed`

#### **Example 6 - Distance Variation**

- **Description**: Calculates the distance covered based on speed and time.
- **Formula**: `Distance = Speed * Time`

#### **Example 7 - Bus Driver**

- **Description**: Calculates trip information for a bus driver, including
  remaining time and distance covered.
- **Formulas**:
  - `TotalTime = TotalDistance / AverageSpeed`
  - `DistanceCovered = AverageSpeed * Interval`
  - `RemainingDistance = TotalDistance - DistanceCovered`
  - `RemainingTime = RemainingDistance / AverageSpeed`

#### **Example 8 - Subway**

- **Description**: Calculates trip information for a subway, considering
  standard and adjusted speeds.
- **Formulas**:
  - `StandardTime = TotalExtension / StandardSpeed`
  - `AdjustedTime = TotalExtension / AdjustedSpeed`
  - `TimeDifference = StandardTime - AdjustedTime`
  - `PossibleDistance = AdjustedSpeed * StandardTime`
  - `DistanceDifference = TotalExtension - PossibleDistance`

#### **Example 9 - Aircraft**

- **Description**: Calculates trip information for an aircraft, considering
  autopilot and cruise modes.
- **Formulas**:
  - `TotalTime = Extension / CruiseSpeed`
  - `AutopilotDistance = AutomaticSpeed * Interval`
  - `RemainingDistance = Extension - AutopilotDistance`
  - `RemainingTime = TotalTime - Interval`
  - `RequiredSpeed = RemainingDistance / RemainingTime`
  - `AutomaticTime = Extension / AutomaticSpeed`

#### **Example 10 - Rent**

- **Description**: Calculates the rent amount and the percentage of the salary
  used.
- **Formulas**:
  - `RentValue = (Salary / 11) * Parts`
  - `Percentage = (RentValue / Salary) * 100`

#### **Example 11 - Price per kg**

- **Description**: Calculates the price per kilogram of meat.
- **Formula**: `PricePerKg = TotalValue / Quantity`

---

### 🖥️ How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/algorithms-list.git
   ```
2. Open the project in Visual Studio Code or your preferred IDE.
3. Compile and run the DanielHenriqueBelle.java file.
