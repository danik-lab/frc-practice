import java.util.Scanner;

public class homework1 {    

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
