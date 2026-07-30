import java.util.Scanner;
//import java.util.Arrays;

public class homework2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter Number of Measurments:");
        int numofMeasurements = scanner.nextInt();        

        double[] speeds = new double[numofMeasurements];
        int from = Math.max(0, numofMeasurements-100);
        for (int i = 0; i < numofMeasurements; i++)  {
            speeds[i] = Math.random()*4.0-2.0;
         }      
        for (int i = from; i < numofMeasurements; i++)  {
            System.out.println("speeds[" + i + "] = " + speeds[i] + " m/s");
        }        

        double sum = 0;
        double max = Double.NEGATIVE_INFINITY;
        double min = Double.POSITIVE_INFINITY;
       
        for (double speed : speeds) {
            sum += speed;  
            if (speed > max) max = speed; 
            if (speed < min) min = speed;
        }        
        double avg = sum / numofMeasurements;        
        System.out.println("___ Velocity Stats ___");
        System.out.println("Average: " + avg + " m/s");
        System.out.println("Max: " + max + " m/s");
        System.out.println("Min: " + min + " m/s");
        scanner.close();
    }
}


// public class homework2 {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         while (true) {
//             System.out.print("Enter starting voltage: ");
//             double currentVolt = sc.nextDouble();

//             if (currentVolt >= 12.6) {
//                 System.out.println("Voltage is already high enough. Exiting.");
//                 break;
//             }

//             int cycles = 0;

//             while (currentVolt < 12.6) {
//                 double increase = 0.06 + 0.05 * (13.0 - currentVolt);
//                 currentVolt += increase;
//                 cycles++;

//                 if (cycles % 3 == 0) {
//                     System.out.printf("Cycle %d: Current voltage = %.3f", cycles, currentVolt);
//                 }
//             }

//             System.out.println("Total cycles required: " + cycles);
//             System.out.printf("Final voltage: %.3f", currentVolt);
//             System.out.println("-----------------------------------");
//         }

//         sc.close();
//     }
// }



// import java.util.Arrays;

// public class homework2 {
//     public static void main(String[] args) {

//         double[] arr = new double[1000];

//         for (int i = 0; i < arr.length; i++) {
//             arr[i] = Math.random() * 1000;
//         }

//         double min = arr[0], max = arr[0], sum = 0;

//         for (double v : arr) {
//             if (v < min) min = v;
//             if (v > max) max = v;
//             sum += v;
//         }

//         double avg = sum / arr.length;

//         double sum2 = sum - min - max;
//         double avg2 = sum2 / (arr.length - 2);

//         int outliers = 0;
//         double highLimit = avg * 1.5;
//         double lowLimit = avg / 4.0;

//         for (double v : arr) {
//             if (v > highLimit || v < lowLimit) {
//                 outliers++;
//             }
//         }

//         double[] cleanArr = new double[arr.length - outliers];
//         int idx = 0;
//         for (double v : arr) {
//             if (!(v > highLimit || v < lowLimit)) {
//                 cleanArr[idx++] = v;
//             }
//         }

//         Arrays.sort(cleanArr);
//         double median;
//         if (cleanArr.length % 2 == 0) {
//             median = (cleanArr[cleanArr.length/2 - 1] + cleanArr[cleanArr.length/2]) / 2.0;
//         } else {
//             median = cleanArr[cleanArr.length/2];
//         }

   
//         System.out.println("Minimum: " + min);
//         System.out.println("Maximum: " + max);
//         System.out.println("Average: " + avg);
//         System.out.println("Average without extremes: " + avg2);
//         System.out.println("Outlier count: " + outliers);
//         System.out.println("Clean array size: " + cleanArr.length);
//         System.out.println("Median: " + median);
//     }
// }