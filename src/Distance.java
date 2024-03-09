public class Distance implements Comparable<Distance>{
    private double value;
    private Flower X;
    private Flower Point;

    public Distance(double value, Flower x, Flower point) {
        this.value = value;
        X = x;
        Point = point;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Flower getX() {
        return X;
    }

    public void setX(Flower x) {
        X = x;
    }

    public Flower getPoint() {
        return Point;
    }

    public void setPoint(Flower point) {
        Point = point;
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
