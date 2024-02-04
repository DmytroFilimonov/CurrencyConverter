import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Приветствуем в CurrencyConverter!");


        Scanner scanner = new Scanner(System.in);


        int inpCurrency;
        int outCurrency;
        double sumToConvert;

        double euroToUsdRate = 1.2;
        double euroToTlRate = 10.0;

        do {
            System.out.println("Выберите исходную валюту:");
            System.out.println("1. EURO");
            System.out.println("2. USD");
            System.out.println("3. TL");
            System.out.println("4. Выход из программы");

            inpCurrency = scanner.nextInt();

            switch (inpCurrency) {
                case 1:
                    System.out.println("Вы выбрали EURO");
                    break;
                case 2:
                    System.out.println("Вы выбрали USD");
                    break;
                case 3:
                    System.out.println("Вы выбрали TL");
                    break;
                case 4:
                    System.out.println("Выход из программы. До свидания!");
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте еще раз.");
                    continue;
            }


            if (inpCurrency == 4) {
                break;
            }

            System.out.println("Выберите целевую валюту:");
            System.out.println("1. EURO");
            System.out.println("2. USD");
            System.out.println("3. TL");

            outCurrency = scanner.nextInt();

            System.out.println("Введите сумму перевода (через запятую):");
            sumToConvert = scanner.nextDouble();

            double result;
            switch (outCurrency) {
                case 1:
                    result = sumToConvert;
                    System.out.println("Результат конвертации: " + result + " EURO");
                    break;
                case 2:
                    result = sumToConvert / euroToUsdRate;
                    System.out.println("Результат конвертации: " + result + " USD");
                    break;
                case 3:
                    result = sumToConvert / euroToTlRate;
                    System.out.println("Результат конвертации: " + result + " TL");
                    break;
                default:
                    System.out.println("Неверный выбор целевой валюты. Попробуйте еще раз.");
            }

        } while (inpCurrency != 4);

        scanner.close();
    }
}