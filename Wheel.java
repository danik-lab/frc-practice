// public class Wheel {
//     private double diameter;      
//     private double rotationSpeed;  
//     private double position;     
//     private String Name;      
//     private  double circumference;
   
//     public Wheel(double wheelDiameter, String name) {
//         diameter = wheelDiameter;
//        this.Name = name;
//         rotationSpeed = 0.0;
//         position = 0;
//         circumference = Math.PI * diameter;
//     }
   
//     public void setRotationSpeed(double rps) {
//         rotationSpeed = rps;
//     }
   
//     public double getLinearSpeed() {
//         return (circumference * rotationSpeed);
//     }
//     public double getVelocityInRPS() {
//         return rotationSpeed;
//     }

//     public void addRotation(double r) {
//         position += r;
//     }
   
//     public double getDistanceTraveled() {
//         return (circumference * position);
//     }
   
//     public void reset() {
//         position= 0;
//         rotationSpeed = 0.0;
//     }
// }


// import java.util.Scanner;

// public class Wheel {

//     // 4 buttons, all start as not pressed
//     private boolean[] buttons = new boolean[5];

//     // Method that asks the user if each button is pressed
//     public void isPressed() {
//         Scanner scanner = new Scanner(System.in);

//         // Loop 4 times (for each button)
//         for (int i = 1; i < buttons.length; i++) {
//             System.out.print("Is button " + i + " pressed? (true/false): ");
//             boolean pressed = scanner.nextBoolean();

//             buttons[i] = pressed;

//             if (pressed) {
//                 System.out.println("Button " + i + " IS pressed.");
//             } else {
//                 System.out.println("Button " + i + " is NOT pressed.");
//             }
//         }
//     }

//     public static void main(String[] args) {
//         Wheel controller = new Wheel();

//         // Call the method once — it handles all 4 buttons
//         controller.isPressed();

//         System.out.println("All buttons checked.");
//     }
// }




import java.util.Scanner;

public class Wheel {

    public static void main(String[] args) {

        Wheel controller = new Wheel();
        ServoMotor motor1 = new ServoMotor();
        ServoMotor motor2 = new ServoMotor();

        for (int cycle = 1; cycle <= 50; cycle++) {

            System.out.println("\nCycle " + cycle);

            boolean[] buttons = controller.isPr\essed();

            if (buttons[1]) {
                motor1.setAngle(0);
                motor2.setAngle(180);
            }

            if (buttons[2]) {
                motor2.setAngle(45);
            }

            if (buttons[3]) {
                motor1.setAngle(135);
            }

            if (buttons[4]) {
                motor1.setAngle(90);
                motor2.setAngle(90);
            }

            motor1.periodic();
            motor2.periodic();

            System.out.print("Buttons pressed: ");

            boolean pressed = false;

            for (int button = 1; button < buttons.length; button++) {
                if (buttons[button]) {
                    System.out.print(button + " ");
                    pressed = true;
                }
            }

            if (!pressed) {
                System.out.print("None");
            }

            System.out.println();

            System.out.println("Motor1 angle: " + motor1.getAngle());
            System.out.println("Motor2 angle: " + motor2.getAngle());
        }

        System.out.println("\nSimulation complete.");
    }
}

class Wheel2 {

    public boolean[] isPressed() {

        boolean[] buttons = new boolean[5];

        int randomButton = (int)(Math.random() * 5);

        if (randomButton > 0) {
            buttons[randomButton] = true;
        }

        return buttons;
    }
}

class ServoMotor {

    private int angle;

    public ServoMotor() {
        angle = 90;
    }

    public void setAngle(int angle) {

        if (angle < 0) {
            this.angle = 0;
        } 
        else if (angle > 180) {
            this.angle = 180;
        } 
        else {
            this.angle = angle;
        }
    }

    public int getAngle() {
        return angle;
    }

    public void periodic() {
    }
}