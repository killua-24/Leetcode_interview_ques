class Solution {
    public int maximumGroups(int[] grades) {
        int n = grades.length;
        return (-1 + (int)Math.sqrt(1 + 8*n))/2;
    }
}