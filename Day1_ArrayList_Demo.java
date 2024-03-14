import java.util.ArrayList;

public class Day1_ArrayList_Demo {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();

        // add method
        names.add("Hitanshee");
        names.add("Sal");
        names.add("ipek");
        System.out.println(names);

        // size method
        System.out.println(names.size());

        // get method
        System.out.println(names.get(1));
        System.out.println("index 2: " + names.get(1));
        
        // print all names
        for(int i = 0; i < names.size(/***3*/); i++) {
            if(i == names.size(/*** 3 */) - 1) {
                System.out.print(names.get(i));
            } else {
                System.out.print(names.get(i) + "-");
            }
        }
        System.out.println();

        // iterating over the list (mr. sen's method)
        String result = names.get(0);
        for (int i = 1; i < names.size(); i++) {
            result = result + "-" + names.get(i);
        }
        System.out.println(result);

        // set method
        names.set(2, "Vaishnavi");
        System.out.println(names);
        names.set(2, "Gabriel");
        System.out.println(names);

        // remove method with index
        names.remove(0);
        System.out.println(names);
        names.remove("Gabriel");
        System.out.println(names);
    }
}