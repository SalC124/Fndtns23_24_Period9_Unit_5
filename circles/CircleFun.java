package circles;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CircleFun {
    public static void printMenu() {
        System.out.println();
        System.out.println("Pick an option:");
        System.out.println("1) Reload circle list from 'circles1.txt'");
        System.out.println("2) Print the list of circles");
        System.out.println("3) Print the list of circles with a circumference <= 10");
        System.out.println("4) Show the total area of all the circles");
        System.out.println("5) Add a random circle");
        System.out.println("6) Print the largest radius");
        System.out.println("7) Remove all circles with an X coordinate in the range [10,25]");
        System.out.println("8) Print the pair of circles that closest to one another");

        System.out.println("E) Exit the program");
    }



    public static void main(String[] args) throws IOException {
        CircleManager cm = new CircleManager();
        Scanner s = new Scanner(System.in);
        String choice = ""; 

        while (!choice.equals("E")){
            printMenu();
            choice = s.nextLine();

            if (choice.equals("1")) {
                cm = new CircleManager("circles/circles1.txt");
            }
            else if (choice.equals("2")) {
                cm.printListOfCircles();
            }
            else if (choice.equals("3")) {
                ArrayList<Circle2d> list = cm.getSmallCircles(10);
                System.out.println("Circle with a circumference <= 10:");
                for (int i=0; i<list.size(); i++) {
                    System.out.println(list.get(i));
                }
            }
            else if (choice.equals("4")) {
                double a = cm.getTotalAreaOfAllCircles();
                System.out.printf("Total Area: %.2f\n", a);
            }
            else if (choice.equals("5")) {
                cm.addRandomCircle(100, 100, 10);
            }
            else if (choice.equals("6")) {
                double r = cm.largestRadius();
                System.out.printf("Largest Radius: %.2f\n", r);
            }
            else if (choice.equals("7")) {
                int count = cm.removeCirclesWithXCoordinateInRange(10, 25);
                System.out.println(count + " circles removed.");
            }
            else if (choice.equals("8")) {
                ArrayList<Circle2d> pair = cm.nearestCircles();
                Circle2d c1 = pair.get(0);
                Circle2d c2 = pair.get(1);

                System.out.println("Circle 1: " + c1);
                System.out.println("Circle 2: " + c2);

                System.out.printf ("Distance: %.2f\n", c1.distance(c2));
            }
        }
        s.close();
    }
}