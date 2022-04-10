import java.util.HashMap;

public class TwoSum {
    public static int[] findTwoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(); // To store numbers and their indices
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; // Find the number we need to reach the target
            
            if (map.containsKey(complement)) {
                // If we already have the needed number, return its index and current index
                return new int[] { map.get(complement), i };
            }
            
            // Otherwise, store the current number with its index
            map.put(nums[i], i);
        }
        
        return new int[0]; // Return an empty array if no solution
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15}; // Example array
        int target = 9;              // Target sum

        int[] result = findTwoSum(nums, target);
        if (result.length > 0) {
            System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
        } else {
            System.out.println("No solution found.");
        }
    }
}
