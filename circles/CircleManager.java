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
        System.out.println("TODO!");
        return null;
    }

    /*
     * Returns the largest radius in the list of circles.  
     */
    public double largestRadius() {
        System.out.println("TODO!");
        return -1;
    }


    /*
     * Returns the sum of the area of the list of circles.
     */
    public double getTotalAreaOfAllCircles () {
        System.out.println("TODO!");
        return -1;
    }
    
    /*
     * Creates a random circle with random x, y, and radius values,
     * each in the range of [0, max).
     * 
     * Adds the new circle to the list. 
     */
    public void addRandomCircle(double maxX, double maxY, double maxR) {
        System.out.println("TODO!");
    }

    /*
     * Removes circles with an xcoordinate within the range [from, to]
     * from the list. Returns a count of the number of circles removed. 
     */
    public int removeCirclesWithXCoordinateInRange (double from, double to)
    {
        System.out.println("TODO!");
        return -1;
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
        System.out.println("TODO!");
        return null;
    }

}
