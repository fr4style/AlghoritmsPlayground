/**
 * https://leetcode.com/problems/3sum/
 */
class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); // O(n log(n))

        List<List<Integer>> result = new ArrayList();
        HashMap<Integer, Integer> lookUpTable = buildHashSet(nums); // O(n)

        int k = -1;

        for(int i=0; i<nums.length-2; i++){ //O (n^2)
            if(i > 0 && nums[i-1] == nums[i]) continue;

            for(int j = i+1; j<nums.length-1; j++){
                if(j > i+1 && nums[j] == nums[j-1]) continue;

                k = get3rdIndex((-1) * (nums[i] + nums[j]), lookUpTable, j);

                if(k > 0)
                    result.add(addOneResult(nums[i], nums[j], nums[k]));
            }
        }
        return result;
    }

    private List<Integer> addOneResult(int i, int j, int k){
        List<Integer> result = new ArrayList();
        result.add(i);
        result.add(j);
        result.add(k);
        return result;
    }

    /*
     * O(n) required to fill the table
     */
    private HashMap<Integer, Integer> buildHashSet(int[] nums){
        HashMap<Integer, Integer> result = new HashMap();

        for(int i = 0; i<nums.length; i++)
           result.put(nums[i], i);

        return result;
    }

    /**
     * O(1)
     */
    private int get3rdIndex(int value, HashMap<Integer, Integer> map, int j){
        Integer index = map.get(value);
            if(index != null && index > j) return index;

        return -1;
    }
}


    
