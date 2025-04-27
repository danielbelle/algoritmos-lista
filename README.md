## 📚 Projeto: Exercícios de Algoritmos

Este projeto implementa soluções para as listas 1 e 2 de algoritmos do curso de
Análise e Desenvolvimento de Sistemas (ADS) do IFRS - Erechim. A **Lista 1**
utiliza uma interface gráfica desenvolvida com `Swing`, enquanto a **Lista 2** é
resolvida apenas com inputs e outputs via prompt.

---

### 📋 Estrutura do Projeto

- **`ListaUm.java`**: Arquivo principal que inicializa a interface gráfica e
  gerencia a seleção dos exemplos da Lista 1.
- **`ShowExemple.java`**: Responsável por renderizar os painéis dinâmicos para
  entrada de dados e exibição de resultados na Lista 1.
- **`Calculator.java`**: Contém a lógica de cálculo para cada exemplo da Lista
  1, incluindo operações simples e complexas.
- **`ListaDois.java`**: Arquivo principal que contém a resolução dos exercícios
  da Lista 2, utilizando inputs e outputs via prompt.

---

### 🧮 Exemplos Implementados - Lista 1

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

### 🧮 Exemplos Implementados - Lista 2

A Lista 2 contém exercícios resolvidos utilizando apenas inputs e outputs via
prompt. Aqui estão os exemplos implementados:

#### **Exemplo 12 - Comprimento da Tirolesa**

- **Descrição**: Calcula o comprimento de uma tirolesa entre dois prédios com
  base em suas alturas e a distância entre eles.

#### **Exemplo 13 - Largura do Rio**

- **Descrição**: Calcula a largura de um rio com base na trajetória linear de um
  barqueiro e a distância relativa entre dois píeres.

#### **Exemplo 14 - Altura de um Prédio**

- **Descrição**: Calcula a altura de um prédio com base na distância até ele e
  no ângulo de elevação.

#### **Exemplo 15 - Quantidade de Tinta**

- **Descrição**: Calcula a quantidade de latas de tinta necessárias para pintar
  uma área e o custo total.

#### **Exemplo 16 - Corrente de Ajuda**

- **Descrição**: Simula uma corrente de ajuda, calculando o número de pessoas
  atingidas após 10 dias.

#### **Exemplo 17 - Certificado de Participação**

- **Descrição**: Verifica se o participante de um congresso pode receber o
  certificado com base no percentual de horas assistidas.

#### **Exemplo 18 - Frete Grátis**

- **Descrição**: Calcula se o frete é grátis ou não com base no valor total da
  compra.

#### **Exemplo 19 - Ano Bissexto (Simples)**

- **Descrição**: Verifica se um ano é bissexto com base na divisão por 4.

#### **Exemplo 20 - Ano Bissexto (Completo)**

- **Descrição**: Verifica se um ano é bissexto considerando as regras completas
  (divisível por 4, mas não por 100, exceto se for divisível por 400).

#### **Exemplo 21 - Conversão de Segundos**

- **Descrição**: Converte um valor em segundos para o formato
  `dias-horas:minutos:segundos`.

#### **Exemplo 22 - Validação de Valores**

- **Descrição**: Valida quatro valores inteiros com base em condições
  específicas.

#### **Exemplo 23 - Equação do Segundo Grau**

- **Descrição**: Resolve uma equação do segundo grau, calculando o delta e as
  raízes reais (se existirem).

#### **Exemplo 24 - Intervalos Numéricos**

- **Descrição**: Verifica se um número real pertence a intervalos específicos.

#### **Exemplo 25 - Localização de um Ponto**

- **Descrição**: Determina a localização de um ponto no plano cartesiano
  (origem, eixos ou quadrantes).

#### **Exemplo 26 - Ordenação de Três Números**

- **Descrição**: Ordena três números inteiros em ordem crescente.

#### **Exemplo 27 - Tipos de Triângulos**

- **Descrição**: Determina o tipo de triângulo (acutângulo, retângulo,
  obtusângulo) com base nos lados fornecidos.

#### **Exemplo 28 - Par ou Ímpar**

- **Descrição**: Verifica se um número é par ou ímpar, positivo ou negativo.

#### **Exemplo 29 - Descobrir o Animal**

- **Descrição**: Determina o animal com base em características fornecidas (tipo
  e dieta).

#### **Exemplo 30 - Média Ponderada**

- **Descrição**: Calcula a média ponderada de três notas (trabalho de
  laboratório, avaliação semestral e exame final) e determina o conceito final.

#### **Exemplo 31 - Reajuste Salarial**

- **Descrição**: Calcula o novo salário com base em faixas de reajuste.

---

### 🖥️ Como Executar

#### Lista 1

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/algoritmos-lista.git
   ```
2. Abra o projeto no Visual Studio Code ou em sua IDE preferida.
3. Compile e execute o arquivo ListaUm.java.

#### Lista 2

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/algoritmos-lista.git
   ```
2. Abra o projeto no Visual Studio Code ou em sua IDE preferida.
3. Compile e execute o arquivo ListaDois.java.
