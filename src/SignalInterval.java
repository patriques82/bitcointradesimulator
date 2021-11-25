public class SignalInterval extends Interval {
    private final Signal signal; // BUY, SELL

    public SignalInterval(int startTime, int endTime, Signal signal) {
        super(startTime, endTime);
        this.signal = signal;
    }

    public String getSignal() {
        return switch(this.signal) {
            case BUY -> "Buy";
            case SELL -> "Sell";
        };
    }
}
