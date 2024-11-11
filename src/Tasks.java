import java.util.Scanner;
import java.util.Random;

public class Tasks {
    public static void main(String[] args) {
        //Variable setup
        int[] dataPoints = new int[100];
        int dataSum = 0, dataAvg = 0, userCount = 0, userInput = 0, userPosition = 0, minVal = 100, maxVal = 1;
        boolean isMatch = false;
        Scanner in = new Scanner(System.in);
        Random rand = new Random();

        //Populate array dataPoints with random values 1-100
        for (int i = 0; i < dataPoints.length; i++) {
            dataPoints[i] = rand.nextInt(100) + 1;
        }
        //Print entire array while also summing and averaging its values
        System.out.println("The values of dataPoints are as follows:");
        for (int dataPoint : dataPoints) {
            System.out.print(dataPoint + " | ");
            dataSum += dataPoint;
        }
        dataAvg = dataSum / dataPoints.length;
        System.out.println("\nThe sum of values in dataPoints is " + dataSum + ".");
        System.out.println("The average of values in dataPoints is " + dataAvg + ".");

        //Take user input, search array for values matching input
        userInput = SafeInput.getRangedInt(in, "Input a value", 1, 100);
        for (int dataPoint : dataPoints) {
            if (userInput == dataPoint) {
                userCount++;
            }
        }
        System.out.println("\nYour value of " + userInput + " was found in dataPoints " + userCount + " times.");

        //Prompt user again, finds first instance of value in array and stops loop
        userCount = 0;
        userInput = SafeInput.getRangedInt(in, "Input a value again", 1, 100);
        for (int i = 0; i < dataPoints.length; i++) {
            if (userInput == dataPoints[i]) {
                isMatch = true;
                userPosition = i + 1;
                userCount++;
                break;
            }
        }
        if (isMatch) {
            System.out.println("\nYour value of " + userInput + " was found in dataPoints at the index " + userPosition + ".");
        }
        else{
            System.out.println("\nYour value of " + userInput + " was not found in dataPoints.");
        }

        for (int dataPoint : dataPoints) {
            if (dataPoint <= minVal){
                minVal = dataPoint;
            }
            if(dataPoint >= maxVal){
                maxVal = dataPoint;
            }
        }
        System.out.println("The minimum value in dataPoints is " + minVal + ".");
        System.out.println("The maximum value in dataPoints is " + maxVal + ".");

        System.out.println("Average of dataPoints is: " + getAverage(dataPoints));
    }

    public static double getAverage(int[] values) {
        double avg = 0;
        for (double dataPoint : values){
            avg += dataPoint;
        }
        avg = avg / values.length;
        return avg;
    }
}
