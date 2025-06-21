public class Forecast {

    /**
     * Recursively calculates the forecasted value after n years.
     * @param presentValue Initial amount
     * @param growthRate Annual growth rate (e.g., 0.05 for 5%)
     * @param years Number of future years
     * @return Forecasted future value
     */
    public static double forecastValue(double presentValue, double growthRate, int years) {
        if (years == 0) {
            return presentValue;
        }
        return forecastValue(presentValue * (1 + growthRate), growthRate, years - 1);
    }

    /**
     * Optimized version using iteration to avoid stack overflow.
     */
    public static double forecastIterative(double presentValue, double growthRate, int years) {
        for (int i = 0; i < years; i++) {
            presentValue *= (1 + growthRate);
        }
        return presentValue;
    }
}