public class PriceInterval extends Interval {
    private int price;

    public PriceInterval(int start, int end, int price) {
        super(start, end);
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }
}
