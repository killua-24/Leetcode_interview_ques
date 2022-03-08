// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int M = Integer.parseInt(input_line[1]);
            
            input_line = read.readLine().trim().split("\\s+");
            ArrayList<ArrayList<Integer>> Edges = new ArrayList<ArrayList<Integer>>(); 
            for(int i = 0; i < M; i++){
                ArrayList<Integer> e = new ArrayList<Integer>();
                e.add(Integer.parseInt(input_line[2*i]));
                e.add(Integer.parseInt(input_line[2*i+1]));
                Edges.add(e);
            }
            Solution ob = new Solution();
            if(ob.check(N, M, Edges)){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }
    } 
} // } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges) 
    { 
        boolean[] vis = new boolean[N + 1];
        List<List<Integer>> adj= new ArrayList<>();
        
        for(int i = 0 ; i <= N ; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(var e :  Edges) {
            adj.get(e.get(1)).add(e.get(0));
            adj.get(e.get(0)).add(e.get(1));
        }
        
        for(int i = 1 ; i <= N ; i++) {
            if( !vis[i] && dfs(i , 1 , N , adj , vis)) return true;
        }
        
        return false;
    }
    
    private boolean dfs(int node , int cnt ,int N, List<List<Integer>> adj , boolean[] vis) {
        if(cnt == N) return true;
        vis[node] = true;
        for(var it : adj.get(node)){
            if( !vis[it] && dfs( it , cnt+1 , N , adj , vis) ) return true;
        }
        vis[node] = false;
        return false;
    }
} 