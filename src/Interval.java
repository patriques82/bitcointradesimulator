public class Interval {
    private final int start;
    private final int end;
    private final int price;

    public Interval(int start, int end, int price) {
        this.start = start;
        this.end = end;
        this.price = price;
    }

    public int getStockPrice() {
        return this.price;
    }

    public int getStartTime() {
        return this.start;
    }

    public int getEndTime() {
        return this.end;
    }

    public boolean equals(Interval other) {
        return
    }
}
