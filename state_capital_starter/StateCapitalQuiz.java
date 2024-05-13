// Sal
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StateCapitalQuiz {

    public static ArrayList<State> pickRegionStates(Scanner in, StateCapitalList sclist) {
        System.out.println("\nHere are the regions available for the quiz:");

        for (int i = 0; i < sclist.getRegionList().size(); i++) {
            System.out.println(sclist.getRegionList().get(i));
        }

        System.out.println("\nWhich region would you like to study?");

        int selectedRegion = 124;
        while (selectedRegion == 124) {
            String tempIn = in.nextLine();
            for (int i = 0; i < sclist.getRegionList().size(); i++) {
                if (tempIn.equals(sclist.getRegionList().get(i))) {
                    selectedRegion = i;
                }
            }
            if (selectedRegion == 124) {
                System.out.println("That region doesn't exist, please re-enter.");
            }
        }

        return sclist.getStatesForRegion(sclist.getRegionList().get(selectedRegion));
    }

    public static void runQuiz(Scanner in, ArrayList<State> states) {
        System.out.println("\nLet's begin your quiz. Type QUIT to end early.\n\n");
        
        int correct = 0;
        int guesses = 0;
        String statename;
        String capital;
        String response = "HAMBURGER";
        ArrayList<State> wrongStates = new ArrayList<>();
        while (!response.equals("QUIT") && states.size() != 0) {

            int randQuestion;
            randQuestion = (int)(Math.random() * states.size());
            statename = states.get(randQuestion).getStatename();
            capital = states.get(randQuestion).getCapital();

            System.out.println("What is the capital of " + statename + "?");
            response = in.nextLine();
            
            if (!response.equals("QUIT")) {
                guesses++;
                if (response.equals(capital)) {
                    correct++;
                    states.remove(randQuestion);
                    System.out.println("Correct!");
                } else {
                    System.out.println("Incorrect! " + capital + " is the correct answer.\n");
                    wrongStates.add(states.get(randQuestion));
                }
            }
        }
        
        if (response.equals("QUIT")) {
            System.out.println("You got " + (correct) + " state(s) correct in " + (guesses) + " guess(es).\n\n");
            if (guesses > correct) {
                System.out.println("You needed more than one guess for each of the following states:");
                for (int i = 0; i < wrongStates.size(); i++) {
                    System.out.println(wrongStates.get(i));
                }
            }
        } else if (guesses > correct) {
            System.out.println("You got all " + correct + " states correct in " + guesses + " guesses!\n\n");
            System.out.println("You needed more than one guess for each of the following states:");

            for (int i = 0; i < wrongStates.size(); i++) {
                System.out.println(wrongStates.get(i));
            }
        } else if (guesses == correct) {
            System.out.println("You got all " + correct + " states correct in " + guesses + " guesses!\n\nYou were perfect -- no missed guesses! Congratulations!");
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        StateCapitalList sclist = new StateCapitalList("states.txt");

        System.out.println("Welcome to the state capital quiz!");

        ArrayList<State> states = pickRegionStates(in, sclist);
        runQuiz(in, states);
    }
}
