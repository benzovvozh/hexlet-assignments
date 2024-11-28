package exercise;

// BEGIN
public class Flat implements Home {
    private double flatArea;
    private double flatBalconyArea;
    private int floor;

    public Flat(double flatArea, double flatBalconyArea, int floor) {
        this.flatBalconyArea = flatBalconyArea;
        this.flatArea = flatArea;
        this.floor = floor;
    }

    public double getArea() {
        return flatArea + flatBalconyArea;
    }

    @Override
    public int compareTo(Home anotherHome) {
        double someHome = anotherHome.getArea();
        if (getArea() > someHome) {
            return 1;
        } else if (getArea() < someHome) {
            return -1;
        } else {
            return 0;
        }

    }


    @Override
    public String toString() {
        String str = "Квартира площадью " + getArea() + " метров на " + floor + " этаже";
        return str;
    }

}
// END
