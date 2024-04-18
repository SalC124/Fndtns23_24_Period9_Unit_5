package circles;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.SpringLayout;


public class CircleManager {
    private ArrayList<Circle2d> circleList;

    /** 
     * Creates a new CircleManager with no circles. 
     */
    public CircleManager() {
        circleList = new ArrayList<>();
    }

    /** Creates a new circle manager, loading its initial values from 'filename'.
     * The format of the file is x;y;radius. There is one circle per line.
     * 
     * @param fileName
     * @throws IOException
     */
    public CircleManager (String fileName) throws IOException {
        Scanner in = new Scanner(new FileReader(fileName));

        circleList = new ArrayList<Circle2d>();

        while (in.hasNextLine()) {
            String line = in.nextLine();
            double x = Double.parseDouble(line.substring(0, line.indexOf(";")));
            double y = Double.parseDouble(line.substring(line.indexOf(";")+1, line.lastIndexOf(";")));
            double r = Double.parseDouble(line.substring(line.lastIndexOf(";")+1));
            Circle2d newCircle = new Circle2d(x, y, r);
            circleList.add(newCircle);



            /* TODO:
             * 
             * Examine circles1.txt to understand the format of the file.
             * The variable line contains a single line in the file.
             * Use String methods to extract the x,y,and radius values from the line.
             * Instantiate a new Circle object.
             * Add the new circle to the list.
             *  
             */
        }
    }

    /** 
     * Prints the list of circles, one circle per line, using the default 
     * toString behavior of Circle2d 
     * */
    public void printListOfCircles() {
        for (int i = 0; i < circleList.size(); i++) {
            System.out.println(i+1 + ": " + circleList.get(i));
        }
    }

    /** 
     * Returns a new ArrayList that contains all circles that 
     * have a circumference less than or equal to "maxCircumference" 
     * */
    public ArrayList<Circle2d> getSmallCircles (double maxCircumference) {
        ArrayList<Circle2d> smallCircles = new ArrayList<>();
        for (int i = 0; i < circleList.size(); i++) {
            if (circleList.get(i).getCircumference() <= maxCircumference) {
                smallCircles.add(circleList.get(i));
            }
        }
        return smallCircles;
    }

    /*
     * Returns the largest radius in the list of circles.  
     */
    public double largestRadius() {
        double before = 0;
        for (int i = 0; i < circleList.size(); i++) {
            if (circleList.get(i).getRadius() >= before) {
                before = circleList.get(i).getRadius();
            }
        }
        return before;
    }


    /*
     * Returns the sum of the area of the list of circles.
     */
    public double getTotalAreaOfAllCircles () {
        double total = 0;
        for (int i = 0; i < circleList.size(); i++) {
            total += circleList.get(i).getArea();
        }
        return total;
    }
    
    /*
     * Creates a random circle with random x, y, and radius values,
     * each in the range of [0, max).
     * 
     * Adds the new circle to the list. 
     */
    public void addRandomCircle(double maxX, double maxY, double maxR) {
        Circle2d random = new Circle2d(Math.random() * maxX, Math.random() * maxY, Math.random() * maxR);
        circleList.add(random);
    }

    /*
     * Removes circles with an xcoordinate within the range [from, to]
     * from the list. Returns a count of the number of circles removed. 
     */
    public int removeCirclesWithXCoordinateInRange (double from, double to)
    {
        int removed = 0;
        for (int i = 0; i < circleList.size(); i++) {
            if (from <= circleList.get(i).getX() && circleList.get(i).getX() <= to) {
                removed++;
            }
        }
        return removed;
    }

    /** 
     * Challenge!
     * 
     * Return a new list containing exactly two circles. These two circles should be
     * the pair with the shortest distance between them of all of the pairs in the list.
     * 
     * precondition: circleList contains at least 2 circles.  
     * (You can assume that a precondition is true.)
     */
    public ArrayList<Circle2d> nearestCircles() {
        ArrayList<Circle2d> nearCircles = new ArrayList<>();
        nearCircles.add(0, null);
        nearCircles.add(1, null);
        double dist = 9999;
        for (int i = 0; i < circleList.size(); i++) {
            for (int j = 0; j < circleList.size(); j++) {
                if (circleList.get(i).distance(circleList.get(j)) < dist && circleList.get(i) != circleList.get(j)) {
                    nearCircles.set(0, circleList.get(i));
                    nearCircles.set(1, circleList.get(j));
                }
            }
        }
        return nearCircles;
    }

}
