public class Main {

    public static void main(String[] args) {
        int[] pricesData = {
                350, 349, 553, 560, 800,
                300, 200, 223, 577, 800,
                900, 299, 432, 888, 90,
                621, 66, 900, 1000, 777,
                776, 221, 882, 100 }; // 24h
        PriceInterval[] prices = Main.createPrices(pricesData);
        SignalInterval[] signals = Main.createSignals(prices, 300); // used by other program to know whether to buy/sell

        for (int i = 0; i < signals.length; i++) {
            System.out.println(signals[i].getSignal() + ": " + prices[i].getPrice()); // BUY: 299, SELL: 700
        }
    }

    private static SignalInterval[] createSignals(PriceInterval[] intervals, int limit) {
        SignalInterval[] signals = new SignalInterval[24]; // null, null, null ... null
        for (int i = 0; i < intervals.length; i++) {
            PriceInterval currentInterval = intervals[i];
            if (currentInterval.getPrice() <= limit) {
                // Köp
                signals[i] = new SignalInterval(currentInterval.getStartTime(), currentInterval.getEndTime(), Signal.BUY);
            } else {
                // Sälj
                signals[i] = new SignalInterval(currentInterval.getStartTime(), currentInterval.getEndTime(), Signal.SELL);
            }
        }
        return signals;
    }

    private static PriceInterval[] createPrices(int[] priceData) {
        PriceInterval[] prices = new PriceInterval[24];
        for (int i = 0; i < prices.length; i++) {
            prices[i] = new PriceInterval(i, i+1, priceData[i]);
        }
        return prices;
    }
}
