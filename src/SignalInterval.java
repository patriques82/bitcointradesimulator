public class SignalInterval {
    private final int startTime;
    private final int endTime;
    private final Signal signal; // BUY, SELL

    public SignalInterval(int startTime, int endTime, Signal signal) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.signal = signal;
    }

    public String getSignal() {
        return switch(this.signal) {
            case BUY -> "Buy";
            case SELL -> "Sell";
        };
    }
}
