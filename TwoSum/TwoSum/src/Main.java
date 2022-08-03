import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {


    /**
     Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
     You may assume that each input would have exactly one solution, and you may not use the same element twice.
     You can return the answer in any order.

     Example 1:

     Input: nums = [2,7,11,15], target = 9
     Output: [0,1]
     Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
     Example 2:

     Input: nums = [3,2,4], target = 6
     Output: [1,2]
     Example 3:

     Input: nums = [3,3], target = 6
     Output: [0,1]

     Constraints:

     2 <= nums.length <= 104
     -109 <= nums[i] <= 109
     -109 <= target <= 109
     Only one valid answer exists.


     Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
     * @param args
     */
    public static void main(String[] args){

        List<Input> inputs = new ArrayList<>();

        inputs.add(new Input(new int[]{2,7,11,15}, 9));
        inputs.add(new Input(new int[]{3,2,4}, 6));
        inputs.add(new Input(new int[]{3,3}, 6));

        for (Input input: inputs) {
            String output;
            output = generateOutput(solution1(input.nums, input.target));
            System.out.print(output);
            output = generateOutput(solutionOpt(input.nums, input.target));
            System.out.print(output);
        }
    }

    private static String generateOutput(int[] solution){
        if(solution == null) return "INVALID SOLUTION";
        return String.format("[ %d, %d]", solution[0], solution[1]);
    }


    /**
     *  Solution O(n^2)
     *
     * @param nums
     * @param target
     * @return
     */
    private static int[] solution1(int[] nums, int target){
        for(int i =0; i<nums.length; i++)
            for(int j=i+1; j<nums.length; j++)
                if(nums[i]+nums[j] == target) return new int[]{i,j};

        return null;
    }

    /**
     * Solution O(n)
     *
     * @param nums
     * @param target
     * @return
     */
     private static int[] solutionOpt(int[] nums, int target){
        Map<Integer, Integer> candidates = new HashMap<>();
        candidates.put(nums[0], 0);
        for(int i=1; i<nums.length; i++){
            Integer suitablePosition = candidates.get(target - nums[i]);
            if(suitablePosition != null) return new int[]{suitablePosition, i};
            else candidates.put(nums[i], i);
        }
        return null;
    }


    private static class Input{
        private int[] nums;
        private int target;

        private Input(int[] nums, int target){
            this.nums = nums;
            this.target = target;
        }
    }
}
