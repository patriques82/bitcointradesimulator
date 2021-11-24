import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Date date = new Date(2020, 11, 24, 14, 33, 0);
        int[] prices = {
                350, 349, 553, 560, 800,
                300, 200, 223, 577, 800,
                900, 299, 432, 888, 90,
                621, 66, 900, 1000, 777,
                776, 221, 882, 100 }; // 24h
        Interval[] intervals = Main.createIntervals(prices);
        SignalInterval[] signals = Main.createSignals(intervals, 300); // used by other program to know whether to buy/sell

        for (int i = 0; i < signals.length; i++) {
            System.out.println(signals[i].getSignal() + ": " + intervals[i].getStockPrice()); // BUY: 299, SELL: 700
        }
    }

    private static SignalInterval[] createSignals(Interval[] intervals, int limit) {
        SignalInterval[] signals = new SignalInterval[24]; // null, null, null ... null
        for (int i = 0; i < intervals.length; i++) {
            Interval currentInterval = intervals[i];
            if (currentInterval.getStockPrice() <= limit) {
                // Köp
                signals[i] = new SignalInterval(currentInterval.getStartTime(), currentInterval.getEndTime(), Signal.BUY);
            } else {
                // Sälj
                signals[i] = new SignalInterval(currentInterval.getStartTime(), currentInterval.getEndTime(), Signal.SELL);
            }
        }
        return signals;
    }

    private static Interval[] createIntervals(int[] prices) {
        Interval[] intervals = new Interval[24];
        for (int i = 0; i < prices.length; i++) {
            intervals[i] = new Interval(i, i+1, prices[i]);
        }
        return intervals;
    }
}
