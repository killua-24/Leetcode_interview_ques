class Solution {
    public List<String> summaryRanges(int[] nums) {
        
        List<String> ranges = new ArrayList<>();
        if(nums == null && nums.length == 0) return ranges;
        int i = 0;
        
        while (i < nums.length) {
            String range = String.valueOf(nums[i]);
            String rangeEnd = "";
            while (i + 1 < nums.length && nums[i + 1] - nums[i] == 1) {
                rangeEnd = String.valueOf(nums[++i]);
            }
            if (rangeEnd.length() > 0) {
                range = range + "->" + rangeEnd;
            }
            ranges.add(range);
            i++;
        }
        return ranges;
    }
}