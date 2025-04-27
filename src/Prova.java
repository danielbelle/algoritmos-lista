import java.util.Scanner;

public class Prova {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Digite o número do exercício (2 a 4) ou 0 para sair: ");
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
                ListaDois.class.getMethod("exempleProva" + exemple, Scanner.class).invoke(null, scanner);
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

    public static void exempleProva2(Scanner scanner) {
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
            System.out.println(
                    "Meninas: " + meninas + ", Meninos: " + meninos + ", Total de escoteiros: " + totalEscoteiros
                            + ", Total de chefes: " + quantidadeChefes);
        } else if (meninas > 0 && meninos == 0) {
            System.out.println(
                    "Meninas: " + meninas + ", Meninos: " + meninos + ", Total de escoteiros: " + totalEscoteiros
                            + ", Total de chefes: " + quantidadeChefes);
        } else {
            System.out.println(
                    "Meninas: " + meninas + ", Meninos: " + meninos + ", Total de escoteiros: " + totalEscoteiros
                            + ", Total de chefes: " + quantidadeChefes);
        }

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

    private static void verificaEstado(double temperatura, String produto, double pontoDeFusao,
            double pontoDeEbulicao) {
        if (temperatura < pontoDeFusao) {
            System.out.println("O " + produto + " está no estado sólido.");
        } else if (temperatura >= pontoDeEbulicao) {
            System.out.println("O " + produto + " está no estado gasoso.");
        } else {
            System.out.println("O " + produto + " está no estado líquido.");
        }
    }

}