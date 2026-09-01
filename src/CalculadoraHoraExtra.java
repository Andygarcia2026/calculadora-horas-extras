import java.util.Scanner; //importa

public class CalculadoraHoraExtra {

    public static void executar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== CALCULADORA DE HORAS EXTRAS - V1.4 ===");
        System.out.println("Base CLT: 220h mensais\n");

        double salarioMensal = lerValor(scanner, "Digite seu salário mensal (ex: 3500 ou 3.500 ou 2500,50): ");
        double valorHora = calcularValorHora(salarioMensal);
        System.out.printf("Seu valor por hora é: R$ %.2f%n", valorHora);

        double horasExtras = lerValor(scanner, "\nQuantas horas extras fez: ");
        double porcentagem = lerValor(scanner, "Porcentagem do adicional (50, 70, 100): ");

        double valorExtra = calcularHoraExtra(valorHora, horasExtras, porcentagem);

        exibirResultado(salarioMensal, valorExtra, porcentagem);

        scanner.close();
    }

    // função pra ler qualquer valor que o usuário digitar
    public static double lerValor(Scanner scanner, String mensagem) {
        System.out.print(mensagem);
        String texto = scanner.nextLine();
        return converterParaDouble(texto);
    }

    // função que calcula o valor da hora
    public static double calcularValorHora(double salario) {
        return salario / 220;
    }

    // função que calcula o valor da hora extra
    public static double calcularHoraExtra(double valorHora, double horas, double porcentagem) {
        return valorHora * (1 + porcentagem / 100) * horas;
    }

    // resultado organizado
    public static void exibirResultado(double salario, double valorExtra, double porcentagem) {
        System.out.println("\n------------------------------");
        System.out.printf("Salário base: R$ %.2f%n", salario);
        System.out.printf("Horas extras (%.0f%%): R$ %.2f%n", porcentagem, valorExtra);
        System.out.printf("TOTAL: R$ %.2f%n", salario + valorExtra);
        System.out.println("------------------------------");
    }

    // 5. metodo para converter qualquer numero com ponto e virgula e transformar em double aceitavel
    public static double converterParaDouble(String texto) {
        texto = texto.trim();
        if (texto.contains(",") && texto.contains(".")) { //se o texto conter , ele converte para .
            texto = texto.replace(".", "").replace(",", "."); //se conter . ele remove
        } else if (texto.contains(",")) { //senao se tiver virgula
            texto = texto.replace(",", "."); // transforma a virgula em ponto
        } else if (texto.contains(".")) {
            String[] partes = texto.split("\\."); // se o usuario digitar somente ponto ele verifica se é milhar  (3,500) e separa 3 do 500 para ler milahr no java
            if (partes.length > 1 && partes[partes.length - 1].length() == 3) { // verifica se o numero foi digitado em mais de 2 partes
                texto = texto.replace(".", ""); // elimina os pontos
            }
        }
        return Double.parseDouble(texto); //retorna o valor digitado pelo usuário ja convertido em double
    }
}