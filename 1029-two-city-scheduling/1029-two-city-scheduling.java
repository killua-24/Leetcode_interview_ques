class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> {
            return (a[0] - a[1]) - (b[0] - b[1]);
        });
        int n = costs.length;
        int ans = 0;
        
        for(int i = 0; i < n ; i++){
            if(i < n/2){
                ans += costs[i][0];
            }else{
                ans += costs[i][1];
            }
        }
        
       
        
        return ans;
    }
}