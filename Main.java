//import utils
//import java.math.RoundingMode;
import java.util.Scanner;


// public class Main {

//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
                
//              getting data
//             System.out.print("is there any obstacle");
//             boolean frontObstacle = scanner.nextBoolean();

            
//             while (true) { 
//                 System.out.print("Robot Speed (-4 - 4):");
//                  double robotSpeed = scanner.nextDouble();
//                 if(robotSpeed >= 100) {
//                 break;
//                 }

//             System.out.print("is the robot powerd on?");
//             boolean enabled = scanner.nextBoolean();
            
//              cheking and outputting data
//             if (frontObstacle){
//                 System.out.println("there is an obstacle in front");
//             }
//             else {
//                 System.out.println("there is an obstacle in front");
//             }

            
//             if (enabled) {
//                 System.out.println("the robot is powerd on");
//             }
//             else {
//                 System.out.println("robot is powerd off");
//             }
//         }
//     scanner.close();
//     }
// }



// public class Main {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         System.out.print("enter Number of Measurments:");
//         int numofMeasurements = scanner.nextInt();        

//         double[] speeds = new double[numofMeasurements];
//         int from = Math.max(0, numofMeasurements-100);
//         for (int i = 0; i < numofMeasurements; i++)  {
//             speeds[i] = Math.random()*4.0-2.0;
//          }      
//         for (int i = from; i < numofMeasurements; i++)  {
//             System.out.println("speeds[" + i + "] = " + speeds[i] + " m/s");
//         }        

//         double sum = 0;
//         double max = Double.NEGATIVE_INFINITY;
//         double min = Double.POSITIVE_INFINITY;
       
//         for (double speed : speeds) {
//             sum += speed;  
//             if (speed > max) max = speed; 
//             if (speed < min) min = speed;
//         }        
//         double avg = sum / numofMeasurements;        
//         System.out.println("___ Velocity Stats ___");
//         System.out.println("Average: " + avg + " m/s");
//         System.out.println("Max: " + max + " m/s");
//         System.out.println("Min: " + min + " m/s");
//         scanner.close();
//     }
// }


// public class Main {
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

// public class Main {
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


public class Main {

    public static void main(String[] args) {
         try (Scanner sacanner = new Scanner(System.in)) {
            System.out.println("enter the robot's weghit:");
             double robotWeight = sacanner.nextDouble();
             
             System.out.println("enter the robot's max speed:");
             double robotMaxSpeed = sacanner.nextDouble();

             System.out.println("enter the robot's max acceleration:");
             double robotAcceleration = sacanner.nextDouble();

             System.out.println("Enter robot's name:");
             String robotName = sacanner.next();

             //1. time to max speed
             double accelerationTime = robotMaxSpeed / robotAcceleration ;

             //2.Distance while accelerating
             double accelerationDist = 0.5 * robotAcceleration *Math.pow(accelerationTime, 2);

             //3 time to travel 4m
             double totalTime4;
                if (accelerationDist >= 4){
                    totalTime4 = Math.sqrt((2 * 4) / robotAcceleration );
                }
                else {
                    double remaining4 = 12 -accelerationDist;
                    totalTime4 = accelerationTime + (remaining4 / robotMaxSpeed);
                }

             //4 .time to travel 12m
             double totalTime12;
            if (accelerationDist >= 12) {
                totalTime12 = Math.sqrt((2 * 12) / robotAcceleration);
            }
            else{
                double remaining12 = 12 - accelerationDist;
                totalTime12 = accelerationTime + (remaining12 / robotMaxSpeed);
            }

             //5 kinetic E
             double kineticenerg = 0.5 * robotWeight * Math.pow(robotMaxSpeed, 2);

             //6deceleration in 5cm
             double stopDist = 0.05;
             double deceleration = -(Math.pow(robotMaxSpeed, 2) / (2 * stopDist));
             double stopTime = robotMaxSpeed / Math.abs(deceleration);


            System.out.println("\n_____ RESULTS _____");

            System.out.println("Robot Name: " + robotName);
            System.out.println("Weight: " + robotWeight + " kg");
            System.out.println("Max Speed: " + robotMaxSpeed + " m/s");
            System.out.println("Acceleration: " + robotAcceleration + " m/s^2");
            System.out.println("\nTime to reach max speed: " + accelerationTime + " seconds");
            System.out.println("Distance during acceleration: " + accelerationDist + " meters");
            System.out.println("\nTime to travel 4 meters: " + totalTime4 + " seconds");
            System.out.println("Time to travel 12 meters: " + totalTime12 + " seconds");
            System.out.println("\nKinetic Energy: " + kineticenerg + " Joules");
            System.out.println("\nRequired deceleration to stop in 5 cm: " + deceleration + " m/s^2");
            System.out.println("Stopping time: " + stopTime +" seconds");

            //output:
            //             _____ RESULTS _____
            // Robot Name: robot3
            // Weight: 50.0 kg
            // Max Speed: 4.0 m/s
            // Acceleration: 6.0 m/s^2

            // Time to reach max speed: 0.6666666666666666 seconds
            // Distance during acceleration: 1.3333333333333333 meters

            // Time to travel 4 meters: 3.333333333333333 seconds
            // Time to travel 12 meters: 3.333333333333333 seconds

            // Kinetic Energy: 400.0 Joules

            // Required deceleration to stop in 5 cm: -160.0 m/s^2
            // Stopping time: 0.025 seconds
        }
    }
}