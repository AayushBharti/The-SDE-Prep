```markdown
### Question
- **Given** an array `height` representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

### Sample Input
```plaintext
height = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
height = [4, 2, 0, 3, 2, 5]
```

### Sample Output
```plaintext
6   // for height = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
9   // for height = [4, 2, 0, 3, 2, 5]
```

### Solution
- To calculate trapped water, the amount of water above each bar is determined by the **minimum of the maximum heights to the left and right** of the bar minus the bar's height.  
- We use two arrays:
  1. `leftMax` to store the maximum height to the left of each bar.
  2. `rightMax` to store the maximum height to the right of each bar.
- Finally, iterate through the array to compute the trapped water for each bar.

### Code
```java
public int trap(int[] height) {
    if (height == null || height.length == 0) return 0;

    int n = height.length;
    int[] leftMax = new int[n];
    int[] rightMax = new int[n];

    // Fill leftMax array
    leftMax[0] = height[0];
    for (int i = 1; i < n; i++) {
        leftMax[i] = Math.max(leftMax[i - 1], height[i]);
    }

    // Fill rightMax array
    rightMax[n - 1] = height[n - 1];
    for (int i = n - 2; i >= 0; i--) {
        rightMax[i] = Math.max(rightMax[i + 1], height[i]);
    }

    // Calculate trapped water
    int totalWater = 0;
    for (int i = 0; i < n; i++) {
        totalWater += Math.min(leftMax[i], rightMax[i]) - height[i];
    }

    return totalWater;
}
```

### Edge Cases
- Input array is empty (`height = []`) → Output: `0`
- Input array has one or two bars (`height = [1]` or `height = [1, 2]`) → Output: `0`
- All bars are the same height (`height = [2, 2, 2]`) → Output: `0`

### Other Techniques
1. **Two-Pointer Approach**:
   - Use two pointers (`left` and `right`) to avoid using extra space.
   - Complexity: \(O(n)\) time, \(O(1)\) space.
2. **Stack-Based Approach**:
   - Use a stack to keep track of the bars that need to be processed.
   - Complexity: \(O(n)\) time, \(O(n)\) space.

### Complexity
1. **Time Complexity**: \(O(n)\)  
   - Two passes are required to fill the `leftMax` and `rightMax` arrays, and one pass to calculate the trapped water.
2. **Space Complexity**: \(O(n)\)  
   - Additional space is used for the `leftMax` and `rightMax` arrays.
```
