import java.util.*;
import java.io.*;
public class SPA {
    private static int size = 100;
    public static void main (String [] args){
        /*Read file in*/
        File File = new File("Underground.csv");
        String [][] Map = new String[size][size]; //distances between locations

        try{
            Scanner sc = new Scanner(File);
            for(int i = 0; i < size; i++){
                String line = sc.nextLine(); //scan line in
                String [] parts = line.split(","); //split line up - store in array

                for(int j = 0; j < size; j++){
                    Map[i][j] = parts[j].trim(); //gets location and puts in matrix
                }
            }
            sc.close();

            dijkstra(Map, 61);
        }
        catch (Exception e){

        }
    }

    public static void dijkstra(String map[][], int src){
        int [] dist = new int[size]; //tracks shortest path to nodes
        boolean [] SPT = new boolean[size]; //tracks shortest path taken

        for(int i = 0; i < size; i++){  //initializing values
            dist[i] = Integer.MAX_VALUE;
            SPT[i] = false;
        }

        dist[src] = 0; // start

        for(int i = 0; i < size - 1; i++){
            int minIndex = min(dist,SPT);
            System.out.println(minIndex);
            SPT[minIndex] = true;

            for (int j = 0; j < size; j++){
                if(isNumeric(map[minIndex][j])){
                    if(!SPT[j] /*&& !map[minIndex][j].equals("*")*/ && dist[minIndex] != Integer.MAX_VALUE
                            && (dist[minIndex] + Integer.parseInt(map[minIndex][j])) < dist[j]){
                        dist[j] = dist[minIndex] + Integer.parseInt(map[minIndex][j]);
                    }
                }
            }
        }
        System.out.println(SPT[src]);
        printSolution(dist);
    }

    public static int min(int [] dist, boolean [] SPT){
        int min = Integer.MAX_VALUE, minIndex = -1;

        for(int i = 0; i < size; i++){
            if(SPT[i] == false && dist[i] <= min){
                min = dist[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    //helper function to determine if it's int or not
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static void printSolution(int dist[]){
        System.out.println(
                "Vertex \t\t Distance from Source");
        for (int i = 0; i < size; i++)
            System.out.println(i + " \t\t " + dist[i]);
    }
}
