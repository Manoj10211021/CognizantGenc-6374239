public class Main {
    public static void main(String[] args) {
        double initialAmount = 10000;
        double annualGrowthRate = 0.08; // 8% growth
        int forecastYears = 5;

        double resultRecursive = Forecast.forecastValue(initialAmount, annualGrowthRate, forecastYears);
        double resultIterative = Forecast.forecastIterative(initialAmount, annualGrowthRate, forecastYears);

        System.out.printf("📈 Recursive Forecast after %d years: ₹%.2f\n", forecastYears, resultRecursive);
        System.out.printf("📊 Iterative Forecast after %d years: ₹%.2f\n", forecastYears, resultIterative);
    }
}