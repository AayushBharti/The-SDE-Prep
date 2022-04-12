```markdown
### Question
- **Given** an array of integers `nums` and an integer `target`, return the **indices** of the two numbers such that they add up to `target`.  
- You may assume:
  1. Each input will have exactly **one solution**.
  2. You may not use the same element twice.
- You can return the answer in **any order**.

### Sample Input
```plaintext
nums = [2, 7, 11, 15], target = 9
nums = [3, 2, 4], target = 6
```

### Sample Output
```plaintext
[0, 1]  // for nums = [2, 7, 11, 15], target = 9
[1, 2]  // for nums = [3, 2, 4], target = 6
```

### Solution
- We will use a **HashMap** to store the difference `(target - element)` along with its index as we iterate through the array.
- If at any point, the current element exists in the map, it means the required pair has been found, and their indices are returned.
- The logic ensures that both indices are returned in constant time.

### Code
```java
public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        if (map.containsKey(nums[i])) { // Checks if nums[i] is already in the map
            return new int[] {map.get(nums[i]), i};
        }
        map.put(target - nums[i], i);  // Stores the difference (target - nums[i]) with the current index
    }
    return new int[0]; // Return an empty array if no solution exists
}
```

### Edge Cases
- Not applicable since each input is guaranteed to have one solution.

### Other Techniques
1. **Brute Force**:
   - Use nested loops to check all pairs.
   - Complexity: \(O(n^2)\)

### Complexity
1. **Time Complexity**: \(O(n)\)  
   - Each element is processed once during the loop and the lookup in `HashMap` is \(O(1)\).
2. **Space Complexity**: \(O(n)\)  
   - The `HashMap` stores up to \(n\) elements.
```
