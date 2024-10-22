import java.io.File;
import java.util.*;
public class Prims2 {
    private static int size = 100;
    public static void main(String [] args){
        /*Read file in*/
        File File = new File("Deliveries.csv");
        String [] addresses = new String[size]; //location name
        int [][] distances = new int[size][size]; //distances between locations

        try{
            Scanner sc = new Scanner(File);
            for(int i = 0; i < size; i++){
                String line = sc.nextLine(); //scan line in
                String [] parts = line.split(","); //split line up - store in array
                addresses[i] = parts[0]; //put address name in add. array

                for(int j = 0; j < size; j++){
                    distances[i][j] = Integer.parseInt(parts[j+1].trim()); //gets location and puts in matrix
                }
            }
            sc.close();

            for (String i:addresses
                 ) {
             //   System.out.println(i);
            }
            //System.out.println("Address size: " + addresses.length);
            TSP(distances,addresses);
        }
        catch(Exception e){
            System.err.println(e);
        }
    }

    /*method to find min key vertex from set of vertices not in the MST  */
    public static int minKey(int [] key, boolean [] mstSet){
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        //mstSet[0] = true;
        for(int i = 0; i < size; i++){
            if(!mstSet[i] && key[i] < min){
                min = key[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    /*Method using Prim's algorithm for MST formation*/
    public static void primsMST(int [][] matrix, int [] parent){
        int [] key = new int[size];
        boolean [] mstSet = new boolean[size];

        Arrays.fill(key,Integer.MAX_VALUE);
        Arrays.fill(mstSet,false);

        key[0] = 0;
        parent[0] = 0; //-1

        for(int i = 0; i < size - 1; i++){
            int r = minKey(key,mstSet);
            mstSet[r] = true;

            for(int j = 0; j < size; j++){
                if(matrix[r][j] != 0 && !mstSet[j] && matrix[r][j] < key[j]){ //update key if current distance is smaller than existing key and j not in MSt
                    parent[j] = r;
                    key[j] = matrix[r][j];
                }
            }
        }
    }

    public static void TSP(int [][] matrix, String [] addresses){
        int [] parent = new int[size];
        int root = 0;
        primsMST(matrix,parent);

        int cost = 0;
        List<String> route = new ArrayList<>();
        int curr = root;
        //route.add(addresses[curr]);
        System.out.println("Test: " + parent[0]);

        for(int i = 0; i < size; i++){
           // System.out.println("Line 81: " + parent[i]);
            curr = parent[i];
            route.add(addresses[curr]);
            cost += matrix[parent[i]][i];
        }

        route.add(addresses[root]);
        cost += matrix[parent[curr]][root];


        System.out.println("Route:");
        for(String address : route) {
            System.out.println(address);
        }

        System.out.println("Total distance: " + cost + "m");
        System.out.println("Route size: " + route.size());
    }
}
