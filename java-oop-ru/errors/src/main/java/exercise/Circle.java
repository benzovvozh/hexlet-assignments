package exercise;

// BEGIN
public class Circle {
    Point point;
    int radius;
    final double PI_VALUE = 3.14159;

    public Circle(Point point, int radius) {
        this.point = point;
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public double getSquare() throws NegativeRadiusException {
        double square = radius * radius * PI_VALUE;
        if (radius < 0) {
            throw new NegativeRadiusException("");
        }
        return square;
    }
}
// END
