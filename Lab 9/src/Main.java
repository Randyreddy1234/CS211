import java.util.*;
public class Main {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a integer n: ");
        int n = sc.nextInt();

        int [][] nums = new int[2][n];

        collatzLengths(nums);
        quickSort(nums,0,n-1);

        while(true){
            System.out.println("Enter a number between 1 and " + n);
            int i = sc.nextInt();;
            //i++;

            System.out.println("Number: " + nums[0][i] + ". Collatz Value: " + nums[1][i]);
        }

//        for(int i = 0; i < 10; i++){
//            System.out.println("Number: " + nums[0][i] + ". Collatz Value: " + nums[1][i]);
//        }
    }

    public static int collatzLength(int n){
//        if(n == 1){
//            return 1;
//        }
//        else if(n % 2 == 0){
//            return collatzLength(n/2) + 1;
//        }
//        else{
//            return collatzLength((n*3)+1) + 1;
//        }

        int i = 1;

        while(n > 1){
            if(n % 2 == 0){
                n = (n/2);
            }
            else{
                n = (n*3) + 1;
            }
            i++;
        }

        return i;
    }

    public static void collatzLengths(int [][] nums){
        for(int i = 0; i < nums[0].length; i++) {
            nums[0][i] = i + 1;
            nums[1][i] = collatzLength(i + 1);
        }
    }

    public static void swap (int [][] CL, int i, int j){
        int temp1 = CL[0][i];
        int temp2 = CL[1][i];

        CL[0][i] = CL[0][j];
        CL[1][i] = CL[1][j];
        CL[0][j] = temp1;
        CL[1][j] = temp2;
    }

    public static int partition(int [][] arr, int low, int high){
        int pivot  = arr[1][high];

        int i = (low - 1);

        for(int j = low; j < high; j++){
            if(arr[1][j] < pivot){
                i++;
                swap(arr,i,j);
            }
            else if(arr[1][j] == pivot){
                if(arr[0][j] < arr[0][high]){
                    i++;
                    swap(arr,i,j);
                }
            }
        }

        swap(arr, i+1, high);
        return (i+1);
    }

    public static void quickSort(int [][] arr, int low, int high){
        if(low<high){
            int pi = partition(arr,low,high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
}
