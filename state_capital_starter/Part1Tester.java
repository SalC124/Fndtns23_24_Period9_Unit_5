
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Part1Tester {
    public static void main(String[] args) throws IOException{
        System.out.println("\n\nStep 1 - Implementing State: ");
        State s = new State("East","New Jersey", "Trenton");
        System.out.println(s);

        System.out.println("\n\nStep 2 - Constructor of StateCapitalList: ");
        StateCapitalList sclist = new StateCapitalList("states.txt");
        System.out.println(sclist.getTotalStates() + " total states\n");
        sclist.printStateList();

        System.out.println("\n\nStep 3 - All Regions: ");
        ArrayList<String> regions = sclist.getRegionList();
        Collections.sort(regions);
        System.out.println(regions);

        System.out.println("\n\nStep 4 - States by Region: ");
        for (int i=0;i<regions.size(); i++) {
            String regionName = regions.get(i);
            System.out.println("\nRegion: " + regionName) ;
            ArrayList<State> states = sclist.getStatesForRegion(regionName);

            for (int j=0; j<states.size(); j++) {
                System.out.println("\t" + states.get(j));
            }
        }
    }
}