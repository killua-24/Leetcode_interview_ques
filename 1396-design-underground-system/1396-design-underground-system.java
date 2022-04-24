class UndergroundSystem {
    
    HashMap<Integer, Pair<String, Integer>> check_in = new HashMap<>();
    HashMap<String, HashMap<String, int[]>> time_differences = new HashMap<>();
    public UndergroundSystem() {}
    
    public void checkIn(int id, String stationName, int t) {
        check_in.put(id, new Pair(stationName, t));
    }
    
    public void checkOut(int id, String end, int t) {
        Pair<String, Integer> start = check_in.get(id);
        time_differences.putIfAbsent(start.getKey(), new HashMap<>());
        time_differences.get(start.getKey()).putIfAbsent(end, new int[2]);
        time_differences.get(start.getKey()).get(end)[0]++;
        time_differences.get(start.getKey()).get(end)[1] += (t - start.getValue());
    }
    
    public double getAverageTime(String startStation, String endStation) {
        HashMap<String, int[]> trips = time_differences.get(startStation);
        
        int[] arr = trips.get(endStation);
        return (double) arr[1] / arr[0];
    }
    
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */