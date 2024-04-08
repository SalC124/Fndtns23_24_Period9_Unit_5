
import java.util.ArrayList;
import java.util.Scanner;
/**
 * ArrayList_Fundamentals
 */
public class ArrayListPatterns {

    // Variations of the first 5 fundamental patterns appeared in the lab:

    /**
     * Read lines from in, until the specified ending. The lines (not including the ending) are returned as an ArrayList.
     * @param ending
     * @param in
     * @return all lines read from in, up to (but not including) ending
     */
    public static ArrayList<String> readUntilEnding(String ending, Scanner in){
        ArrayList<String> list = new ArrayList<String>();
        String line = in.nextLine();
        while(! line.equals(ending)){
            list.add(line);
            line = in.nextLine();
        }
        return list;
    }

    /**
     * Read lines from in, until a line is read that is in validList. 
     * @param validList
     * @param in
     * @return the first line read that is in validList
     */
    public static String readUntilValid(ArrayList<String> validList, Scanner in){
        String line = in.nextLine();
        while(! validList.contains(line)){
            line = in.nextLine();
        }
        return line;
    }

    /**
     * Get a random element from list, chosen with uniform probability.
     * @param list
     * @return a random element from list.
     */
    public static String getRandomElement(ArrayList<String> list){
        int index = (int) (Math.random() * list.size());
        return list.get(index);
    }

    /**
     * Count the number of elements in list that are equal to matchMe.
     * @param list
     * @param matchMe
     * @return number of elements in list that equal matchMe
     */
    public static int countMatches(ArrayList<String> list, String matchMe){
        int count = 0;
        for(int i = 0; i < list.size(); i++){
            String element = list.get(i);
            if (matchMe.equals(element)){
                count++;
            }
        }
        return count;
    }

    /**
     * Get the distinct (that is, unique) elements of list.
     * The order of the distinct items should be in the order that they first appear in the list.
     * @param list
     * @return all distinct elements of list
     */
    public static ArrayList<String> getDistinct(ArrayList<String> list){
        ArrayList<String> distinct = new ArrayList<String>();

        for(int i = 0; i < list.size(); i++){
            String element = list.get(i);
            if ( ! distinct.contains(element)){
                distinct.add(element);
            }
        }

        return distinct;
    }

    /**
     * Get all elements of list that start with the specified prefix.
     * @param list
     * @param prefix
     * @return all elements of list that start with prefix
     */
    public static ArrayList<String> filterByPrefix(ArrayList<String> list, String prefix){
        ArrayList<String> filtered = new ArrayList<String>();

        for(int i = 0; i < list.size(); i++){
            String element = list.get(i);
            if (element.startsWith(prefix)){
                filtered.add(element);
            }
        }
        return filtered;
    }
    
    /**
     * Get all elements in list in reversed order. The original list is left unchanged.
     * @param list
     * @return reversed list 
     */
    public static ArrayList<String> getReversed(ArrayList<String> list){
        ArrayList<String> reversed = new ArrayList<String>();

        for(int i = list.size() - 1; i >= 0; i--){
            String element = list.get(i);
            reversed.add(element);
        }
        return reversed;
    }

    /**
     * Replace all elements in list that equal findMe with replaceWith. Nothing is returned; the original list is updated.
     * @param list
     * @param findMe
     * @param replaceWith
     */
    public static void replaceAll(ArrayList<String> list, String findMe, String replaceWith){
        for(int i = 0; i < list.size(); i++){
            String element = list.get(i);
            if (element.equals(findMe)){
                list.set(i, replaceWith);
            }
        }
    }

    /**
     * Get all indexes of elements in list that are equal to findMe.
     * @param list
     * @param findMe
     * @return all indexes of findMe in list
     */
    public static ArrayList<Integer> allIndexesOf(ArrayList<String> list, String findMe){
        ArrayList<Integer> indexes = new ArrayList<Integer>();

        for(int i = 0; i < list.size(); i++){
            String element = list.get(i);
            if (element.equals(findMe)){
                indexes.add(i);
            }
        }
        return indexes;
    }


    /**
     * Remove all elements in list that equal removeMe. Nothing is returned; the original list is updated.
     * @param list
     * @param removeMe
     */
    public static void removeAll(ArrayList<String> list, String removeMe){
        for(int i = list.size() - 1; i >= 0; i--){
            String element = list.get(i);
            if (element.equals(removeMe)){
                list.remove(i);
            }
        }

        // alternative solution:
        // while (list.contains(removeMe)){
        //     list.remove(removeMe);
        // }
    }

}