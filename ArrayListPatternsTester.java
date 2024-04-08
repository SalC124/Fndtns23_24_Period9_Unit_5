
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListPatternsTester {

    public static void checkCorrect(Object givenAnswer, Object correctSolution) {
        if (correctSolution.equals(givenAnswer))
            System.out.printf("PASSED!\n\tAnswer: %s\n\n", givenAnswer);
        else
            System.out.printf("FAILED!\n\tExpected: %s\n\tActual: %s\n\n", correctSolution, givenAnswer);
    }

    public static void testReadUntilEnding() {
        System.out.println("\n**TESTING readUntilEnding(String ending, Scanner in):**\n");

        // Test 1
        String ending1 = "STOP";
        String scannerInput1 = "Read this\nAnd this\nAlso this\nSTOP\nDon't read this";

        System.out.printf("Test #1 Input: ending = \"%s\"; Scanner in reads:\n%s\n\n", ending1, scannerInput1);

        ArrayList<String> output1 = ArrayListPatterns.readUntilEnding(ending1, new Scanner(scannerInput1));
        List<String> solution1 = List.of("Read this", "And this", "Also this");

        checkCorrect(output1, solution1);

        // Test 2 (Edge Case - ending on first line)
        String ending2 = "Never mind";
        String scannerInput2 = "Never mind\nNot even this";

        System.out.printf("Test #2 Input: ending = \"%s\"; Scanner in reads:\n%s\n\n", ending2, scannerInput2);

        ArrayList<String> output2 = ArrayListPatterns.readUntilEnding(ending2, new Scanner(scannerInput2));
        List<String> solution2 = new ArrayList<String>(); // empty ArrayList

        checkCorrect(output2, solution2);
    }

    public static void testReadUntilValid() {
        System.out.println("\n**TESTING readUntilValid(ArrayList<String> validList, Scanner in):**\n");

        // Test 1
        ArrayList<String> validList1 = new ArrayList<String>(List.of("bread", "cheese", "lobster"));
        String scannerInput1 = "candy\ntoast\ncheese\ntrash\nlobster\n";
        System.out.printf("Test #1 Input: validList = %s; Scanner in reads:\n%s\n\n", validList1, scannerInput1);

        String output1 = ArrayListPatterns.readUntilValid(validList1, new Scanner(scannerInput1));
        String solution1 = "cheese";

        checkCorrect(output1, solution1);

        // Test 2 (Edge Case - valid option on first line)
        ArrayList<String> validList2 = new ArrayList<String>(List.of("cats", "dogs"));
        String scannerInput2 = "cats\nfish\n";
        System.out.printf("Test #2 Input: validList = %s; Scanner in reads:\n%s\n\n", validList2, scannerInput2);

        String output2 = ArrayListPatterns.readUntilValid(validList2, new Scanner(scannerInput2));
        String solution2 = "cats";

        checkCorrect(output2, solution2);
    }

    public static void testGetRandomElement() {
        System.out.println("\n**TESTING getRandomElement(ArrayList<String> list):**\n");

        ArrayList<String> input1 = new ArrayList<String>(List.of("A", "B", "C", "D"));
        System.out.printf("Test #1 Input: list = %s\n\n", input1);
        // call handful of times:
        ArrayList<String> output1 = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            String elm = ArrayListPatterns.getRandomElement(input1);
            output1.add(elm);
        }
        System.out.printf("20 random selections: %s\n", output1);
        boolean failed = false;
        for (String s : input1) {
            if (!output1.contains(s)) {
                failed = true;
                break;
            }
        }
        System.out.println(failed ? "FAILED (probably)" : "PASSED (probably)");
    }

    public static void testCountMatches() {
        System.out.println("\n**TESTING countMatches(ArrayList<String> list, String matchMe):**\n");

        // Test 1
        ArrayList<String> input1 = new ArrayList<String>(List.of("yo", "hey", "hi", "hi", "yo", "hey", "sup", "yo"));
        String matchMe1 = "yo";
        System.out.printf("Test #1 Input: list = %s, matchMe = \"%s\"\n\n", input1, matchMe1);

        int output1 = ArrayListPatterns.countMatches(input1, matchMe1);
        int solution1 = 3;

        checkCorrect(output1, solution1);

        // Test 2 (Edge Case - no matches)
        ArrayList<String> input2 = new ArrayList<String>(List.of("hidden", "missing", "hiding", "gone", "void"));
        String matchMe2 = "elusive";
        System.out.printf("Test #2 Input: list = %s, matchMe = \"%s\"\n\n", input2, matchMe2);

        int output2 = ArrayListPatterns.countMatches(input2, matchMe2);
        int solution2 = 0;

        checkCorrect(output2, solution2);
    }

    public static void testGetDistinct() {
        System.out.println("\n**TESTING getDistinct(ArrayList<String> list):**\n");

        // Test 1
        ArrayList<String> input1 = new ArrayList<String>(
                List.of("bees", "threes", "threes", "trees", "bees", "bees", "threes", "trees"));
        System.out.printf("Test #1 Input: list = %s\n\n", input1);

        ArrayList<String> output1 = ArrayListPatterns.getDistinct(input1);
        List<String> solution1 = List.of("bees", "threes", "trees");

        checkCorrect(output1, solution1);

        // Test 2
        ArrayList<String> input2 = new ArrayList<String>(List.of("you", "you", "you", "you", "thou", "you"));
        System.out.printf("Test #2 Input: list = %s\n\n", input2);

        ArrayList<String> output2 = ArrayListPatterns.getDistinct(input2);
        List<String> solution2 = List.of("you", "thou");

        checkCorrect(output2, solution2);

    }

    public static void testFilterByPrefix() {
        System.out.println("\n**TESTING filterByPrefix(ArrayList<String> list, String prefix):**\n");

        // Test 1
        ArrayList<String> input1 = new ArrayList<String>(
                List.of("pizza", "pie", "pasta", "pickle", "pierogie", "pastry", "potato"));
        String prefix1 = "pi";
        System.out.printf("Test #1 Input: list = %s, prefix = \"%s\"\n\n", input1, prefix1);

        ArrayList<String> output1 = ArrayListPatterns.filterByPrefix(input1, prefix1);
        List<String> solution1 = List.of("pizza", "pie", "pickle", "pierogie");

        checkCorrect(output1, solution1);

        // Test 2
        ArrayList<String> input2 = new ArrayList<String>(List.of("10", "0x10", "1", "0", "0xFA", "0x1B"));
        String prefix2 = "0x";
        System.out.printf("Test #2 Input: list = %s, prefix = \"%s\"\n\n", input2, prefix2);

        ArrayList<String> output2 = ArrayListPatterns.filterByPrefix(input2, prefix2);
        List<String> solution2 = List.of("0x10", "0xFA", "0x1B");

        checkCorrect(output2, solution2);
    }

    public static void testGetReversed() {
        System.out.println("\n**TESTING getReversed(ArrayList<String> list):**\n");

        // Test 1
        ArrayList<String> input1 = new ArrayList<String>(List.of("have", "a", "nice", "day"));
        System.out.printf("Test #1 Input: list = %s\n\n", input1);

        ArrayList<String> output1 = ArrayListPatterns.getReversed(input1);
        List<String> solution1 = List.of("day", "nice", "a", "have");

        checkCorrect(output1, solution1);

        // Test 2
        ArrayList<String> input2 = new ArrayList<String>(List.of("1", "2", "3", "4", "5"));
        System.out.printf("Test #2 Input: list = %s\n\n", input2);

        ArrayList<String> output2 = ArrayListPatterns.getReversed(input2);
        List<String> solution2 = List.of("5", "4", "3", "2", "1");

        checkCorrect(output2, solution2);

    }

    public static void testReplaceAll() {
        System.out.println("\n**TESTING replaceveAll(ArrayList<String> list, String findMe, String replaceWith):**\n");

        // Test 1
        ArrayList<String> input1 = new ArrayList<String>(
                List.of("candy", "veggies", "protein", "protein", "candy", "veggies", "carbs", "candy"));
        String findMe1 = "candy";
        String replaceWith1 = "healthy snack";
        System.out.printf("Test #1 Input: list = %s, findMe = \"%s\", replaceWith = \"%s\"\n\n", input1, findMe1,
                replaceWith1);

        ArrayListPatterns.replaceAll(input1, findMe1, replaceWith1);
        List<String> solution1 = List.of("healthy snack", "veggies", "protein", "protein", "healthy snack", "veggies",
                "carbs", "healthy snack");

        checkCorrect(input1, solution1);

        // Test 2
        ArrayList<String> input2 = new ArrayList<String>(List.of("glad", "sad", "sad", "mad", "sad", "sad", "rad"));
        String findMe2 = "sad";
        String replaceWith2 = "meh";

        System.out.printf("Test #2 Input: list = %s, findMe = \"%s\", replaceWith = \"%s\"\n\n", input2, findMe2,
                replaceWith2);

        ArrayListPatterns.replaceAll(input2, findMe2, replaceWith2);
        List<String> solution2 = List.of("glad", "meh", "meh", "mad", "meh", "meh", "rad");

        checkCorrect(input2, solution2);

    }

    public static void testAllIndexesOf() {
        System.out.println("\n**TESTING allIndexesOf(ArrayList<String> list, String findMe):**\n");

        // Test 1
        ArrayList<String> input1 = new ArrayList<String>(List.of("yo", "hey", "hi", "hi", "yo", "hey", "sup", "yo"));
        String findMe1 = "yo";
        System.out.printf("Test #1 Input: list = %s, findMe = \"%s\"\n\n", input1, findMe1);

        ArrayList<Integer> output1 = ArrayListPatterns.allIndexesOf(input1, findMe1);
        List<Integer> solution1 = List.of(0, 4, 7);

        checkCorrect(output1, solution1);

        // Test 2 (Edge Case - not found)
        ArrayList<String> input2 = new ArrayList<String>(List.of("hidden", "missing", "hiding", "gone", "void"));
        String findMe2 = "elusive";
        System.out.printf("Test #2 Input: list = %s, findMe = \"%s\"\n\n", input2, findMe2);

        ArrayList<Integer> output2 = ArrayListPatterns.allIndexesOf(input2, findMe2);
        List<Integer> solution2 = List.of();

        checkCorrect(output2, solution2);
    }

    public static void testRemoveAll() {
        System.out.println("\n**TESTING removeAll(ArrayList<String> list, String removeMe):**\n");

        // Test 1
        ArrayList<String> input1 = new ArrayList<String>(
                List.of("candy", "veggies", "protein", "protein", "candy", "veggies", "carbs", "candy"));
        String removeMe1 = "candy";
        System.out.printf("Test #1 Input: list = %s, removeMe = \"%s\"\n\n", input1, removeMe1);

        ArrayListPatterns.removeAll(input1, removeMe1);
        List<String> solution1 = List.of("veggies", "protein", "protein", "veggies", "carbs");

        checkCorrect(input1, solution1);

        // Test 2 - *adjacent* elements to remove
        ArrayList<String> input2 = new ArrayList<String>(List.of("glad", "sad", "sad", "mad", "sad", "sad", "rad"));
        String removeMe2 = "sad";
        System.out.printf("Test #2 Input: list = %s, removeMe = \"%s\"\n\n", input2, removeMe2);

        ArrayListPatterns.removeAll(input2, removeMe2);
        List<String> solution2 = List.of("glad", "mad", "rad");

        checkCorrect(input2, solution2);

    }

    public static void main(String[] args) {
        System.out.println(
                "To test your methods in ArrayList_Fundamentals, un-comment the various method calls in the main method.");
        testReadUntilEnding();
        testReadUntilValid();
        testGetRandomElement();
        testCountMatches();
        testGetDistinct();
        testFilterByPrefix();
        testGetReversed();
        testReplaceAll();
        testAllIndexesOf();
        testRemoveAll();
    }
}
