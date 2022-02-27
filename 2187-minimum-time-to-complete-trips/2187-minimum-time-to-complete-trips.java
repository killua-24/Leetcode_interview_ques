class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        
        Arrays.sort(time);
        long st = 0;
        long en = totalTrips * (long)time[0];
        long ans = 0;
        while(st <= en){
            long mid = (st + en) /2;
            
            boolean canTrip = bS(mid, time , totalTrips);
            
            if(!canTrip){
                st = mid + 1;
            }else{
                ans = mid;
                en = mid - 1;
            }
            
        }
        return ans;
    }
    
    private boolean bS(long t , int[] time , int trips){
        int cnt = 0;
        for(int it : time){
            cnt += t/it;
            
            if(cnt >= trips) return true;
        }
        
        
        
        return false;
    }
    
}