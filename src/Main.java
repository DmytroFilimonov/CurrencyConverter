import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Приветствуем в CurrencyConverter!");

        CurrencyConverterCLI converterCLI = new CurrencyConverterCLI();
        converterCLI.start();
    }
}

class CurrencyConverter {
    private final double[] currencyRates;
    private final String[] availableCurrencies;

    public CurrencyConverter() {
        // установка значений по умолчанию через пустой конструктор

        this.availableCurrencies = new String[]{"EURO", "USD", "TL"};
        this.currencyRates = new double[]{1.0, 1.2, 10.0};
    }

    public CurrencyConverter(double[] currencyRates) {
        this.currencyRates = currencyRates;
        this.availableCurrencies = new String[currencyRates.length];
        for (int i = 0; i < currencyRates.length; i++) {
            this.availableCurrencies[i] = "Currency " + (i + 1);
        }
    }

    public CurrencyConverter(double[] currencyRates, String[] availableCurrencies) {
        this.currencyRates = currencyRates;
        this.availableCurrencies = availableCurrencies;
    }

    public double[] getCurrencyRates() {
        return currencyRates;
    }

    public String[] getAvailableCurrencies() {
        return availableCurrencies;
    }
}

class CurrencyConverterCLI {
    private final Scanner scanner;
    private final CurrencyConverter converter;

    public CurrencyConverterCLI() {
        scanner = new Scanner(System.in);
        converter = new CurrencyConverter();
    }

    public void start() {
        int inpCurrency;
        int outCurrency;
        double sumToConvert;

        do {
            System.out.println("Выберите исходную валюту:");
            String[] availableCurrencies = converter.getAvailableCurrencies();
            for (int i = 0; i < availableCurrencies.length; i++) {
                System.out.println((i + 1) + ". " + availableCurrencies[i]);
            }
            System.out.println((availableCurrencies.length + 1) + ". Выход из программы");

            inpCurrency = scanner.nextInt();

            if (inpCurrency == availableCurrencies.length + 1) {
                break;
            }

            System.out.println("Выберите целевую валюту:");
            for (int i = 0; i < availableCurrencies.length; i++) {
                System.out.println((i + 1) + ". " + availableCurrencies[i]);
            }

            outCurrency = scanner.nextInt();

            System.out.println("Введите сумму перевода (через запятую):");
            sumToConvert = scanner.nextDouble();

            double[] currencyRates = converter.getCurrencyRates();
            double result = sumToConvert / currencyRates[inpCurrency - 1] * currencyRates[outCurrency - 1];

            System.out.println("Результат конвертации: " + result + " " + availableCurrencies[outCurrency - 1]);

        } while (inpCurrency != converter.getAvailableCurrencies().length + 1);

        scanner.close();
    }
}
