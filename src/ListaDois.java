import java.util.Scanner;

public class ListaDois {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.print("Digite o número do exercício (1 a 31) ou 0 para sair: ");
      int exemple = scanner.nextInt();

      if (exemple == 0) {
        System.out.println("Encerrando o programa.");
        break;
      }

      selectedExemple(exemple);
    }
    scanner.close();
  }

  public static void selectedExemple(int exemple) {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.println("Exercício " + exemple + ":");
      try {
        ListaDois.class.getMethod("exemple" + exemple, Scanner.class).invoke(null, scanner);
      } catch (Exception e) {
        System.out.println("Exercício não encontrado ou ocorreu um erro.");
      }
      System.out.print("Digite 'sair' para voltar ao menu ou pressione Enter para repetir o exercício: ");
      String input = scanner.nextLine();
      if (input.equalsIgnoreCase("sair")) {
        break;
      }
    }
  }

  public static void exemple12(Scanner scanner) {
    double relativeHeight = 0;
    System.out.println("Digite a altura total de um dos prédios");
    double buildingHeight1 = scanner.nextInt();

    System.out.println("Digite a altura total do outro prédio");
    double buildingHeight2 = scanner.nextInt();

    System.out.println("Digite a distância entre os prédios");
    double distanceBetween = scanner.nextInt();

    if (buildingHeight1 <= 0 || buildingHeight2 <= 0) {
      System.out.println("As alturas devem ser maiores que zero.");
      return;
    } else if (distanceBetween == 0) {
      System.out.println("Os prédios são os mesmos ou estão colados.");
      return;
    } else if (distanceBetween < 0) {
      distanceBetween = Math.abs(distanceBetween);
    }

    if (buildingHeight1 < buildingHeight2) {
      System.out.println("O prédio 2 é mais alto que o prédio 1.");
      relativeHeight = buildingHeight2 - buildingHeight1;

    } else if (buildingHeight1 > buildingHeight2) {
      System.out.println("O prédio 1 é mais alto que o prédio 2.");
      relativeHeight = buildingHeight1 - buildingHeight2;

    } else {
      System.out.println("Os prédios têm a mesma altura.");
    }

    double ziplineLength = Math.sqrt(Math.pow(distanceBetween, 2) + Math.pow(relativeHeight, 2));
    System.out.println(
        "Com a altura do Prédio 1: " + buildingHeight1 + "m do Prédio 2: " + buildingHeight2
            + "m, a distância entre eles: " + distanceBetween
            + "m, o comprimento da tirolesa é de aproximadamente: "
            + String.format("%.2f", ziplineLength) + "m.");
  }

  public static void exemple13(Scanner scanner) {
    double riverWidth = 0;
    String axisX = "leste";
    String axisY = "norte";

    System.out.println("Digite a distância, em metros, da trajetória linear do barqueiro:");
    double linearPath = scanner.nextInt();

    System.out.println("Digite a distância, em metros, da distância relativa entre os dois píeres:");
    double relativeDistance = scanner.nextInt();

    if (linearPath == 0) {
      System.out.println("Os píeres são os mesmos ou estão colados.");
      return;
    } else if (relativeDistance == 0) {
      riverWidth = linearPath;
      axisY = "";
    } else if (linearPath <= 0) {
      System.out.println(
          "Você adicionou um valor negativo, mas vou considerar o valor absoluto, ou seja, partindo do princípio que o barqueiro está fazendo a viagem de ida.");
      relativeDistance = Math.abs(relativeDistance);
    } else if (relativeDistance <= 0) {
      relativeDistance = Math.abs(relativeDistance);
      axisX = "oeste";
    }

    riverWidth = Math.sqrt(Math.pow(linearPath, 2) - Math.pow(relativeDistance, 2));

    if (riverWidth < 0) {
      riverWidth = Math.abs(riverWidth);
      axisY = "sul";
    } else if (riverWidth == 0) {
      System.out.println("O barqueiro não se afastou do píer.");
      axisY = "";
      axisX = "";

    }

    System.out.println(
        "No desenho, tomando como referência o primeiro píere da esquerda para a direita, sabemos que a distância entre os dois píeres é de: "
            + relativeDistance + "m, na direção " + axisX
            + ". Bem como, sabemos que a trajetória linear do barqueiro é de: " + linearPath
            + "m. Então a largura do rio em metros é: " + String.format("%.2f",
                riverWidth)
            + (axisX.isEmpty() ? "" : " " + axisX)
            + (axisY.isEmpty() ? "" : " " + axisY) + ".");

  }

  public static void exemple14(Scanner scanner) {
    double buildingHeight = 0;
    double humanHeight = 1.70;
    String axisX = "leste";

    System.out.println("Digite a distância até o prédio em metros:");
    double buildingDistance = scanner.nextInt();

    System.out.println("Digite os ângulos em graus:");
    double buildingAngleDegree = scanner.nextInt();

    if (buildingAngleDegree < 90 && buildingAngleDegree > 0) {
      axisX = "leste";
    } else if (buildingAngleDegree > 90 && buildingAngleDegree < 180) {
      System.out.println("O ângulo de elevação é maior que 90°, o que significa que o prédio está atrás de você.");
      buildingAngleDegree = 180 - buildingAngleDegree;
      axisX = "oeste";
    } else if (buildingAngleDegree == 90) {
      System.out.println("O ângulo de elevação é 90°, o que significa que o prédio está diretamente acima de você.");
      return;
    } else {
      System.out.println("Pode ser que o prédio está no mesmo nível que você. Ou você está olhando para baixo.");
      return;
    }

    if (buildingDistance < 0) {
      System.out.println(
          "Você digitou um valor negativo, mas vou considerar o valor absoluto, ou seja, partindo do princípio que você está olhando para trás.");
      buildingDistance = Math.abs(buildingDistance);
      axisX = "oeste";
    } else if (buildingDistance == 0) {
      System.out.println("O prédio está colado a você.");
      return;
    }

    buildingHeight = buildingDistance * Math.tan(buildingAngleDegree * Math.PI / 180) + humanHeight;

    System.out.println(
        "Sabendo que a distância do prédio é de: "
            + buildingDistance + "m, e o ângulo de elevação é de: " + buildingAngleDegree
            + "°, podemos concluir que o prédio está a uma altura de: "
            + String.format("%.2f", buildingHeight) + "m, na direção " + axisX + ".");
  }

  public static void exemple15(Scanner scanner) {
    double totalArea = 0;
    double pricePerCan = 0;
    double canYield = 0;

    System.out.println("Digite a área total em m²:");
    String areaInput = scanner.next().replace(",", ".");
    System.out.println("Digite o preço da lata de tinta em R$:");
    String priceInput = scanner.next().replace(",", ".");
    System.out.println("Digite o rendimento de cada lata em m²:");
    String yieldInput = scanner.next().replace(",", ".");

    try {
      totalArea = Double.parseDouble(areaInput);
      pricePerCan = Double.parseDouble(priceInput);
      canYield = Double.parseDouble(yieldInput);
    } catch (NumberFormatException e) {
      System.out.println("Valor inválido. Por favor, insira números válidos.");
      return;
    }

    if (totalArea <= 0 || pricePerCan <= 0 || canYield <= 0) {
      System.out.println("Os valores devem ser maiores que zero.");
      return;
    }
    int totalCans = (int) Math.ceil(totalArea / canYield);
    double totalPrice = totalCans * pricePerCan;

    System.out.println("A quantidade de latas necessárias é: " + (int) totalCans
        + ", e o preço total da tinta é: R$" + String.format("%,.2f", totalPrice).replace('.', ',') + ".");

  }

  public static void exemple16(Scanner scanner) {
    int nPeople2 = 2;
    int nPeople3 = 3;
    int nPeople4 = 4;
    int experimentDays = 10;
    int totalChain2 = 0;
    int totalChain3 = 0;
    int totalChain4 = 0;

    for (int days = 1; days <= experimentDays; days++) {

      totalChain2 += (int) Math.floor(nPeople2 * ((Math.pow(nPeople2, days) - 1)) / (nPeople2 - 1));
      totalChain3 += (int) Math.floor(nPeople3 * ((Math.pow(nPeople3, days) - 1)) / (nPeople3 - 1));
      totalChain4 += (int) Math.floor(nPeople4 * ((Math.pow(nPeople4, days) - 1)) / (nPeople4 - 1));
    }
    System.out.println("Resultados da corrente: ");
    System.out.println("Ajudando " + nPeople2 + " pessoa inicialmente, foi atingido " + totalChain2 + " pessoas.");
    System.out.println("Ajudando " + nPeople3 + " pessoa inicialmente, foi atingido " + totalChain3 + " pessoas.");
    System.out.println("Ajudando " + nPeople4 + " pessoa inicialmente, foi atingido " + totalChain4 + " pessoas.");
  }

  public static void exemple17(Scanner scanner) {
    int totalCongressHours = 0;
    int presentHours = 0;

    System.out.println("Digite quantas horas o congresso possui no total:");
    totalCongressHours = scanner.nextInt();
    System.out.println("Digite quantas horas você participou:");
    presentHours = scanner.nextInt();

    if (totalCongressHours <= 0 || presentHours <= 0) {
      System.out.println("Os valores devem ser maiores que zero.");
      return;
    }
    if (presentHours > totalCongressHours) {
      System.out.println("Você não pode participar de mais horas do que o congresso possui.");
      return;
    }
    int percentage = (int) Math.floor((presentHours * 100) / totalCongressHours);

    if (percentage >= 75) {
      System.out.println("Você pode receber o certificado de participação.");
    } else {
      System.out.println("Você não pode receber o certificado de participação.");
    }
  }

  public static void exemple18(Scanner scanner) {
    double purchaseTotal = 0;
    double minimumPurchase = 120.00;

    System.out.println("Digite o valor total da compra, iremos calcular o frete:");
    String purchaseInput = scanner.next().replace(",", ".");

    try {
      purchaseTotal = Double.parseDouble(purchaseInput);
    } catch (NumberFormatException e) {
      System.out.println("Valor inválido. Por favor, insira um número válido.");
      return;
    }

    if (purchaseTotal <= 0) {
      System.out.println("Pelo jeito você não comprou nada.");
      return;
    }

    if (purchaseTotal >= minimumPurchase) {
      System.out.println("Seu frete é grátis, pois o valor da compra é maior que R$"
          + String.format("%,.2f", minimumPurchase).replace('.', ',') + ". O valor total da compra foi de R$"
          + String.format("%,.2f", purchaseTotal).replace('.', ',') + ".");

    } else {
      System.out.println("Seu frete é de R$ 15,00 e o valor total com o frete é de R$"
          + String.format("%,.2f", purchaseTotal + 15.00).replace('.', ',') + ".");
    }

  }

  public static void exemple19(Scanner scanner) {
    int year = 0;

    System.out.println("Digite o ano que deseja verificar se é bissexto:");
    year = scanner.nextInt();

    if (year < 0) {
      System.out.println(
          "Você digitou um ano negativo, mas vou considerar o valor absoluto, ou seja, partindo do princípio que o ano é de Antes da Era Comum.");
      year = Math.abs(year);
    }

    int leapYear = year % 4;
    if (leapYear == 0) {
      System.out.println("O ano " + year + " é bissexto.");
    } else {
      System.out.println("O ano " + year + " não é bissexto.");
    }
  }

  public static void exemple20(Scanner scanner) {
    int year = 0;
    int leapYear = 0;
    System.out.println("Digite o ano que deseja verificar se é bissexto:");
    year = scanner.nextInt();

    if (year < 0) {
      System.out.println(
          "Você digitou um ano negativo, mas vou considerar o valor absoluto, ou seja, partindo do princípio que o ano é de Antes da Era Comum.");
      year = Math.abs(year);
    }

    if ((year % 4 == 0) && (year % 400 == 0 || year % 100 != 0)) {
      System.out.println("O ano " + year + " é bissexto.");
    } else {
      System.out.println("O ano " + year + " não é bissexto.");
    }
  }

  public static void exemple21(Scanner scanner) {
    int experimentSeconds = 0;

    System.out.println("Digite o tempo em segundos:");
    experimentSeconds = scanner.nextInt();

    if (experimentSeconds < 0) {
      System.out.println("Você digitou um valor negativo, mas vou considerar o valor absoluto.");
      experimentSeconds = Math.abs(experimentSeconds);
    }
    System.out.println("O formato do tempo é: dias-horas:minutos:segundos");
    System.out.println(String.format("%02d-%02d:%02d:%02d", experimentSeconds / (3600 * 24), experimentSeconds / 3600,
        (experimentSeconds % 3600) / 60,
        experimentSeconds % 60));

  }

  public static void exemple22(Scanner scanner) {
    int valA = 0;
    int valB = 0;
    int valC = 0;
    int valD = 0;

    System.out.println("Digite quatro valores inteiros:");
    System.out.println("Valor A:");
    valA = scanner.nextInt();
    System.out.println("Valor B:");
    valB = scanner.nextInt();
    System.out.println("Valor C:");
    valC = scanner.nextInt();
    System.out.println("Valor D:");
    valD = scanner.nextInt();

    if (valB > valC) {
      if (valD > valA) {
        if (valC + valD > valA + valB) {
          if (valC > 0 && valD > 0) {
            if (valA % 2 == 0) {
              System.out.println("Valor válido");
            } else {
              System.out.println("O valor A é ímpar.");
              System.out.println("Valor inválido");
            }
          } else {
            System.out.println("O valor C ou D é menor ou igual a zero.");
            System.out.println("Valor inválido");
          }
        } else {
          System.out.println("A soma de C e D é menor ou igual a soma de A e B.");
          System.out.println("Valor inválido");
        }
      } else {
        System.out.println("O valor D é menor ou igual a A.");
        System.out.println("Valor inválido");
      }
    } else {
      System.out.println("O valor B é menor ou igual a C.");
      System.out.println("Valor inválido");
    }

  }

  public static void exemple23(Scanner scanner) {
    int meninos = 0;
    int meninas = 0;

    System.out.println("Digite o número de meninos:");
    meninos = scanner.nextInt();
    System.out.println("Digite o número de meninas:");
    meninas = scanner.nextInt();

    if (meninas < 0 || meninos < 0) {
      System.out.println("O número de meninos e meninas nao pode ser negativo.");
      return;
    }
    int totalEscoteiros = meninas + meninos;

    int quantidadeChefes = (int) Math.ceil(totalEscoteiros / 6.0) + 1;

    System.out.println(quantidadeChefes);

    if (meninas > 0 && meninos > 0) {
      System.out.println("Meninas: " + meninas + ", Meninos: " + meninos + ", Total de escoteiros: " + totalEscoteiros
          + ", Total de chefes: " + quantidadeChefes);
    } else if (meninas > 0 && meninos == 0) {
      System.out.println("Meninas: " + meninas + ", Meninos: " + meninos + ", Total de escoteiros: " + totalEscoteiros
          + ", Total de chefes: " + quantidadeChefes);
    } else {
      System.out.println("Meninas: " + meninas + ", Meninos: " + meninos + ", Total de escoteiros: " + totalEscoteiros
          + ", Total de chefes: " + quantidadeChefes);
    }

  }

  public static void exemple24(Scanner scanner) {
    double valA = 0;
    double valB = 0;
    double valC = 0;

    System.out.println("Digite os valores de");
    System.out.println("A:");
    valA = scanner.nextInt();
    System.out.println("B:");
    valB = scanner.nextInt();
    System.out.println("C:");
    valC = scanner.nextInt();

    if (valA == 0) {
      System.out.println("Não é uma euqação de segundo grau.");
      return;
    }
    if (valB == 0 || valC == 0) {
      System.out.println("Equação incompleta.");
      return;
    } else {
      System.out.println("Equação é: " + valA + "x² + " + valB + "x + " + valC + " = 0 .");
    }
    double delta = Math.pow(valB, 2) - (4 * valA * valC);
    System.out.println("O valor de delta é: " + delta);

    if (delta < 0) {
      System.out.println("A equação não possui raízes reais.");
      return;
    } else if (delta == 0) {
      System.out.println("A equação possui uma raiz real, que é: " + (-valB / (2 * valA)));
    } else {
      System.out.println("A equação possui duas raízes reais, que são: ");
      System.out.println("x'1 = " + String.format("%.2f", (-valB + Math.sqrt(delta)) / (2 * valA)));
      System.out.println("x'2 = " + String.format("%.2f", (-valB - Math.sqrt(delta)) / (2 * valA)));
    }
  }

  public static void exempleProva4(Scanner scanner) {
    double largura = 0;

    System.out.println("Digite a largura em cm do aquário:");
    largura = scanner.nextInt();

    if (largura <= 0) {
      System.out.println("A largura deve ser maior que zero.");
      return;
    }

    double areaSuperficial = 4 * Math.PI * Math.pow((largura / 2), 2);
    double volume = (4.0 / 3.0) * Math.PI * Math.pow((largura / 2), 3);
    System.out.println("A área superficial do aquário é: " + String.format("%.2f", areaSuperficial) + "cm².");
    System.out.println("O volume do aquário é: " + String.format("%.2f", volume * 0.001) + "L.");
  }

  public static void exempleProva3(Scanner scanner) {

    int codigo = 0;
    double temperatura = 0;
    String produto = "";

    System.out.println("1 - clorofórmio");
    System.out.println("2 - propano");
    System.out.println("3 - éter etílico");
    System.out.println("Digite o código numérico do produto: ");

    codigo = scanner.nextInt();

    System.out.println("Digite a temperatura em graus Celsius: ");
    temperatura = scanner.nextInt();

    switch (codigo) {
      case 1:
        produto = "clorofórmio";
        verificaEstado(temperatura, produto, -63.5, 61.2);
        break;
      case 2:
        produto = "propano";
        verificaEstado(temperatura, produto, -190, -45);
        break;
      case 3:
        produto = "éter etílico";
        verificaEstado(temperatura, produto, -116, 35);
        break;
      default:
        System.out.println("Código inválido. O código deve ser entre 1 e 3.");
        break;
    }
  }

  private static void verificaEstado(double temperatura, String produto, double pontoDeFusao, double pontoDeEbulicao) {
    if (temperatura < pontoDeFusao) {
      System.out.println("O " + produto + " está no estado sólido.");
    } else if (temperatura >= pontoDeEbulicao) {
      System.out.println("O " + produto + " está no estado gasoso.");
    } else {
      System.out.println("O " + produto + " está no estado líquido.");
    }
  }

}