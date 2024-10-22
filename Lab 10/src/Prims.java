import java.io.File;
import java.util.*;
public class Prims{
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

            /*Prim's Algorithm implementation - get MST*/
            int [] MST = new int[size]; // array to store constructed MST
            int [] key = new int[size]; // store weight of edge that connects node to MST
            boolean [] mstNodes = new boolean[size]; // keep track of nodes included in MST

            for(int i = 0; i < size; i++){
                key[i] = Integer.MAX_VALUE; // initialize key to some number (max is most unlikely to occur in weight)
                mstNodes[i] = false; // initialize bool. array to false - no nodes in MST
            }

            key[0] = 0; //include first 1st vertex in MST - make key = 0 so this vertex is picked first

            MST[0] = -1; // first node root of MST

            for(int i = 0; i < size - 1; i++){
                int r = minKey(key,mstNodes); //  get min. key index

                mstNodes[r] = true; // add picked vertex to mstNodes

                for(int j = 0; j < size; j++){ //update key and MST for adjacent vertices of picked vertex
                    if(distances[r][j] != 0 && !mstNodes[j] && distances[r][j] < key[j]){ //update key if current distance is smaller than existing key and j not in MSt
                        MST[j] = r;
                        key[j] = distances[r][j];
                    }
                }
            }

            /*Traverse MST to create route using DFS*/
            List<Integer> route = new ArrayList<>();
            boolean [] visited = new boolean[size];
            DFS(0, MST, distances, route, visited,false);

            int totalDistance = 0;
            for(int i = 0; i < route.size() - 1; i++){
                int from = route.get(i);
                int to = route.get(i+1);
                totalDistance += distances[from][to];
            }

            System.out.println("Route: " + route);
            for(int i = 0; i < route.size(); i++){
               int address = route.get(i);
               System.out.println(addresses[address]);
            }
            System.out.println("Total Distance: " + totalDistance);

        }
        catch(Exception e){
            System.err.println(e);
        }
    }

    /*method to find vertex with min. value key*/
    public static int minKey(int [] key, boolean [] mstNodes){
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for(int i = 0; i < size; i++){
            if(!mstNodes[i] && key[i] < min){
                min = key[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    /*method to perform depth-first search on MST*/
    public static void DFS(int r, int [] MST, int [][] distances, List<Integer> route, boolean [] visited, boolean originVisited){
        if(r == 0 && originVisited){
            return;
        }

        if(r == 0){
            originVisited = true;
        }
        route.add(r);
        visited[r] = true;
        boolean allVisited = true;

        for(int i = 0; i < size; i++){
            if(MST[i] == r && !visited[i]){
                allVisited = false;
                DFS(i,MST, distances, route, visited, originVisited);
            }
        }

        if(allVisited && r != 0 && !originVisited){
            route.add(0);
        }
    }
}
