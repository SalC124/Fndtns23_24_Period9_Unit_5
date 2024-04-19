// I, Salvatore Calafiore, didn't use outside help

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StateCapitalList {
    private ArrayList<State> states = new ArrayList<>();

    public StateCapitalList(String filename) throws IOException {
        Scanner in = new Scanner(new FileReader(filename));

        while (in.hasNextLine()) {
            String line = in.nextLine();
            String statename = line.substring(0, line.indexOf(","));
            String capital = line.substring(line.indexOf(",") + 1, line.lastIndexOf(":"));
            String region = line.substring(line.lastIndexOf(":") + 1);
            State newState = new State(region, statename, capital);
            states.add(newState);
        }
    }

    public int getTotalStates() {
        return states.size();
    }

    public void printStateList() {
    	for (int i = 0; i < states.size(); i++) {
            System.out.println(states.get(i).getRegion() + " - " + states.get(i).getStatename() + " (" + states.get(i).getCapital() + ")");
        }
    }

    public ArrayList<String> getRegionList() {
        ArrayList<String> regions = new ArrayList<>();
        for (int i = 0; i < states.size(); i++) {
            if (!regions.contains(states.get(i).getRegion())) {
                regions.add(states.get(i).getRegion());
            }
        }
        return regions;
    }

    public ArrayList<State> getStatesForRegion(String region) {
        ArrayList<State> statesInRegion = new ArrayList<>();
        for (int i = 0; i < states.size(); i++) {
            if (states.get(i).getRegion().equals(region)) {
                statesInRegion.add(states.get(i));
            }
        }
        return statesInRegion;
    }

}
