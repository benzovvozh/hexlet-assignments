package exercise;

// BEGIN
public class Segment {
    private Point beginPoint;
    private Point endPoint;

    public Point getEndPoint() {
        return endPoint;
    }

    public Point getMidPoint() {
        Point midPoint = new Point((beginPoint.getX() + endPoint.getX()) / 2,
                (beginPoint.getY() + endPoint.getY()) / 2);
        return midPoint;
    }

    public Point getBeginPoint() {
        return beginPoint;
    }


    public Segment(Point beginPoint, Point endPoint) {
        this.beginPoint = beginPoint;
        this.endPoint = endPoint;
    }
}
// END