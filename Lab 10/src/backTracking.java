import java.io.File;
import java.util.*;

public class backTracking {
    private static int size = 100;
    public static void main(String [] args){
        /*Read file in*/
        File File = new File("Deliveries.csv");
        String [] addresses = new String[size]; //location name
        int [][] distances = new int[size][size]; //distances between locations

        try {
            Scanner sc = new Scanner(File);
            for (int i = 0; i < size; i++) {
                String line = sc.nextLine(); //scan line in
                String[] parts = line.split(","); //split line up - store in array
                addresses[i] = parts[0]; //put address name in add. array

                for (int j = 0; j < size; j++) {
                    distances[i][j] = Integer.parseInt(parts[j + 1].trim()); //gets location and puts in matrix
                }
            }
            sc.close();

            boolean [] visited = new boolean[size];
            visited[0] = true;
            int ans = Integer.MAX_VALUE;

            ans = TSP(distances, visited, 0, size,1,0,ans);
            System.out.println(ans);

        }
        catch(Exception e){
            System.err.println(e);
        }
    }

    public static int TSP(int [][] distances, boolean [] visited, int currPos, int r, int count, int cost, int ans){

        if(count == r && distances[currPos][0] > 0){
            ans = Math.min(ans, cost + distances[currPos][0]);
            return ans;
        }

        //back-tracking step
        for(int i = 0; i < r; i++){
            if (visited[i] == false && distances[currPos][i] > 0)
            {

                // Mark as visited
                visited[i] = true;
                ans = TSP(distances, visited, i, r, count + 1,
                        cost + distances[currPos][i], ans);

                // Mark ith node as unvisited
                visited[i] = false;
            }
        }
        return ans;
    }
}
