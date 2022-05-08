import java.util.Scanner;
import java.util.Arrays;

class Question1 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in); 
        System.out.println("Enter the total no of floors");
        int noOfDays = sc.nextInt();
        int l;
        int[] arr = new int[noOfDays];
        for(l = 1; l <= noOfDays; l++) {
            System.out.println("Enter the size given on day" + l);
            arr[l-1] = sc.nextInt();
        }
        int top = noOfDays;
        int[] parsingArray = new int[noOfDays];
        int i, j = 0;
        for(i=0; i <noOfDays; i++) {
            int loopVariable = noOfDays -i;
            System.out.println("Day : " + (i + 1));
            //System.out.println("Loop vAriable "+  loopVariable);
            //System.out.println("array value "+ arr[i]);
            if(loopVariable > arr[i]) {
                parsingArray[j] = arr[i];
                j++;
            }
            else {
                if(arr[i] == top) {
                    System.out.println(arr[i]);
                    top = top - 1;
                    Arrays.sort(parsingArray);
                for(int k = parsingArray.length -1; k >= 0; k--) {
                   // System.out.println("top " +top);
                   // System.out.println(" parsing aray = "+ parsingArray[k]);
                    if(parsingArray[k] == top && parsingArray[k] != 0) {
                        System.out.print(parsingArray[k]+ " ");
                        parsingArray[k] = 0;
                        top = top - 1;
                        j--;
                    }
                
                }
                }
                else {
                    parsingArray[j] = arr[i];
                j++;
                }
                
                
            }
        }
        
    }
}