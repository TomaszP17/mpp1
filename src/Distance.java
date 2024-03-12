public class Distance implements Comparable<Distance>{
    private final double value;
    private final Flower X;
    private final Flower Point;

    public Distance(double value, Flower x, Flower point) {
        this.value = value;
        X = x;
        Point = point;
    }
    public Flower getPoint() {
        return Point;
    }
    @Override
    public String toString() {
        return "Distance{" +
                "value=" + value +
                ", X=" + X +
                ", Point=" + Point +
                '}';
    }

    @Override
    public int compareTo(Distance o) {
        return Double.compare(this.value, o.value);
    }
}
