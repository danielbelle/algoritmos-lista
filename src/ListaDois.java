import java.util.Scanner;

public class ListaDois {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.print("Digite o número do exercício (1 a 31) ou 0 para sair: ");
      int exemple = scanner.nextInt();

      if (!scanner.hasNextInt() || exemple == 0) {
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
}