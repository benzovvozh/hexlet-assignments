package exercise;

// BEGIN
public class Cottage implements Home {
    private double cottageArea;
    private int cottageFloorCount;

    public Cottage(double cottageArea, int cottageFloorCount) {
        this.cottageArea = cottageArea;
        this.cottageFloorCount = cottageFloorCount;
    }

    @Override
    public String toString() {
        String str = cottageFloorCount + " этажный коттедж площадью " + cottageArea + " метров";
        return str;
    }

    public double getArea() {
        return cottageArea * cottageFloorCount;
    }


    public int compareTo(Home anotherHome) {
        double someHomeAre = anotherHome.getArea();
        if (getArea() > someHomeAre) {
            return 1;
        } else if (getArea() < someHomeAre) {
            return -1;
        } else {
            return 0;
        }
    }
}
// END
