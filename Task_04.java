
import java.util.Scanner;

// Interface for fetching exchange rates
interface ExchangeRateService {
    double getExchangeRate(String baseCurrency, String targetCurrency);
}

// Mock implementation of ExchangeRateService
class MockExchangeRateService implements ExchangeRateService {
    @Override
    public double getExchangeRate(String baseCurrency, String targetCurrency) {
        // In a real application, fetch exchange rates from a reliable API
        // For simplicity, we'll use fixed rates in this example
        if (baseCurrency.equals("USD") && targetCurrency.equals("EUR")) {
            return 0.85; // 1 USD to EUR rate
        } else if (baseCurrency.equals("USD") && targetCurrency.equals("GBP")) {
            return 0.75; // 1 USD to GBP rate
        } else {
            return 1.0; // Default rate (1:1)
        }
    }
}

// CurrencyConverter class
class CurrencyConverter {
    private ExchangeRateService exchangeRateService;

    public CurrencyConverter(ExchangeRateService exchangeRateService) {
        this.exchangeRateService = exchangeRateService;
    }

    public double convert(String baseCurrency, String targetCurrency, double amount) {
        double exchangeRate = exchangeRateService.getExchangeRate(baseCurrency, targetCurrency);
        return amount * exchangeRate;
    }
}

// UserInterface class
class Task_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter base currency: ");
        String baseCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Enter target currency: ");
        String targetCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Enter amount to convert: ");
        double amount = scanner.nextDouble();

        // Create an instance of the CurrencyConverter with a mock exchange rate service
        CurrencyConverter currencyConverter = new CurrencyConverter(new MockExchangeRateService());

        // Perform currency conversion
        double convertedAmount = currencyConverter.convert(baseCurrency, targetCurrency, amount);

        // Display the result
        System.out.println("Converted amount: " + convertedAmount + " " + targetCurrency);
    }
}
