import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void out(Object o) {
        System.out.println(o);
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("/root/IdeaProjects/lintcode/LintCode/src/Dictionary"));
        sc.useDelimiter(",");
        List<Integer> se = new ArrayList<>();
        while (sc.hasNextInt()) {
            se.add(sc.nextInt());
        }
        findDuplicate(se.stream().mapToInt(e -> e).toArray());
        out(se.size());
    }
    public static int findDuplicate(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        for (int i = 0; i < nums.length;) {
            int index = nums[i];
            int temp = nums[index - 1];
            if (temp == index) {
                if (i == index - 1) {
                    i++;
                    continue;
                }
                return temp;
            }
            nums[index - 1] = index;
            nums[i] = temp;
        }
        return 0;
    }
}
