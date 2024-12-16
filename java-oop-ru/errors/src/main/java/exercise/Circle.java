package exercise;

import static java.lang.Math.PI;

// BEGIN
public class Circle {
    Point point;
    int radius;


    public Circle(Point point, int radius) {
        this.point = point;
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public double getSquare() throws NegativeRadiusException {
        double square = radius * radius * PI;
        if (radius < 0) {
            throw new NegativeRadiusException("");
        }
        return square;
    }
}
// END
