// { Driver Code Starts
import java.io.*;
import java.util.*;

  public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            System.out.println(new Solution().maxProduct(arr, n));
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to find maximum product subarray
    long maxProduct(int[] arr, int n) {
        long max = arr[0];
        long curr2 = arr[0];
        long curr1 = arr[0];
        for(int i = 1; i < arr.length ; i++){
            long p1 = curr1 * arr[i];
            long p2 = curr2 * arr[i];
            
            curr1 = Math.max(arr[i] , Math.max(p1,p2));
            curr2 = Math.min(arr[i] , Math.min(p1,p2));
            max = Math.max(max , curr1);
            
        }
        return max;
    }
}