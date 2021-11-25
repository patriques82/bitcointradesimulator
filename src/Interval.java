public class Interval {
    private final int start;
    private final int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStartTime() {
        return this.start;
    }

    public int getEndTime() {
        return this.end;
    }
}
