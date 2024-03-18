import java.util.Scanner;
import java.util.ArrayList;
public class Day1_Sample_Program {
    public static void main(String[] Args) {
        try (Scanner input = new Scanner(System.in)) {
            ArrayList<Integer> nums = new ArrayList<>();
            int num = input.nextInt();
            while (num != 0) {
                nums.add(num);
                System.out.println(nums);
                num = input.nextInt();
            }
            nums.add(0);
            for(int repetitions = nums.size(); repetitions > 1; repetitions--) {
                nums.add(repetitions - 1);
            }
            System.out.println(nums);
        }
    }
}
