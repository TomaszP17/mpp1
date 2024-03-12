public record Flower(double a, double b, double c, double d, String name) {
    @Override
    public String toString() {
        return "Flower{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                ", name='" + name + '\'' +
                '}';
    }
}
