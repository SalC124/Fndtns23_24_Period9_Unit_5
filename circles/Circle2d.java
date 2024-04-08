package circles;

/**
 * Created by bryres on 3/8/2017.
 */
public class Circle2d {
    double x;
    double y;
    double radius;


    public Circle2d(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public Circle2d(double x, double y) {
        this.x = x;
        this.y = y;
        radius = 1;
    }

    public double getArea()
    {
        return Math.PI * radius * radius;
    }

    public void expand(double amount)
    {
        radius += amount;
    }

    public void translate (double x, double y)
    {
        this.x += x;
        this.y += y;
    }

    public double getCircumference()
    {
        return 2 * Math.PI * radius;
    }

    public double distance(Circle2d c)
    {
        return Math.pow(Math.pow(c.x - this.x, 2) + Math.pow(c.y - this.y, 2), .5);
    }

    public boolean contains(double x, double y)
    {
        double d = Math.pow(Math.pow(x - this.x, 2) + Math.pow(y - this.y, 2), .5);

        return d <= radius;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String toString()
    {
        return String.format("Circle: (%.1f, %.1f); Radius: %.1f", x, y, radius);
    }
}
