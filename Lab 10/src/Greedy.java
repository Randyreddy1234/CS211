import java.util.*;
import java.io.File;
public class Greedy {
    private static int size = 100;
    public static void main (String [] args){
        /*Read file in and creating adjacency matrix*/
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

            TSP(distances);

        }
        catch(Exception e){
            System.err.println(e);
        }
    }

    public static void TSP(int [][] matrix){
        int cost = 0, count = 0, i = 0, j = 0, minCost = Integer.MIN_VALUE;
        List <Integer> visitedRoutes = new ArrayList<>();
        visitedRoutes.add(0);
        int [] route = new int[matrix.length];


        while(i < matrix.length && j < matrix[i].length){
            if(count >= matrix[i].length - 1){  //break if count value exceeds size of matrix
                break;
            }

            if(j != i && !(visitedRoutes.contains(j))){ //if j not equal i and selected element at index j is 0
                if(matrix[i][j] < minCost){ // if lower than current min cost
                    minCost = matrix[i][j]; //update min cost
                    route[count] = j+1; // increment route count
                }
            }
            j++;

            if(j == matrix[i].length){
                cost += minCost; //adding min cost to total cost
                minCost = Integer.MIN_VALUE; //resetting minCost
                visitedRoutes.add(route[count] - 1); //updating route as 1
                j = 0; //resetting j
                i = route[count] - 1; //
                count++;
                //System.out.println("Test");
            }
        }

        i = route[count - 1] - 1; // breaks code

        for(j = 0; j < matrix.length; j++){
            if((i != j) && matrix[i][j] < minCost){
                minCost = matrix[i][j];
                route[count] = j + 1;
            }
        }

        cost += minCost;

        System.out.println("Distance: " + cost);
    }
}
