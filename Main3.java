import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        RollerIntake intake = new RollerIntake();

        System.out.println("Robot starting...\n");

        System.out.print("Is outside limit reached? (true/false): ");
        boolean outside = scanner.nextBoolean();

        intake.getOutsideLimit().set(outside);

        intake.intakeBall();

        System.out.println();

        System.out.print("Is inside limit reached? (true/false): ");
        boolean inside = scanner.nextBoolean();

        intake.getInsideLimit().set(inside);

        intake.ejectBall();

        scanner.close();

    }

}


class BaseSensor {

    private boolean value;

    public BaseSensor() {
        value = false;
    }

    public boolean get() {
        return value;
    }

    public void set(boolean value) {
        this.value = value;
    }
}

class BallSensor extends BaseSensor {

    public boolean haveBall() {
        return get();
    }
}

class LimitSensor extends BaseSensor {

    public boolean atLimit() {
        return get();
    }
}

class Motor {
    private double power;

    public Motor() {
        power = 0;
    }


    public void setPower(double power) {
        if(power > 1) {
            this.power = 1;
        }

        else if(power < -1) {
            this.power = -1;
        }

        else {
            this.power = power;
        }

        System.out.println("Motor power: " + this.power);
    }


    public void stop() {
        power = 0;
        System.out.println("Motor stopped");
    }
}



class RollerIntake {
    private Motor motor;
    private BallSensor firstBallSensor;
    private BallSensor secondBallSensor;
    private LimitSensor outsideLimit;
    private LimitSensor insideLimit;



    public RollerIntake() {

        motor = new Motor();
        firstBallSensor = new BallSensor();
        secondBallSensor = new BallSensor();
        outsideLimit = new LimitSensor();
        insideLimit = new LimitSensor();
    }



    public LimitSensor getOutsideLimit() {
        return outsideLimit;
    }


    public LimitSensor getInsideLimit() {
        return insideLimit;
    }



    public void intakeBall() {
        System.out.println("Opening intake...");
        motor.setPower(1);

        if(outsideLimit.atLimit()) {
            motor.stop();
            System.out.println("Outside limit reached");
        }

        System.out.println("Collecting ball...");
        motor.setPower(1);
        firstBallSensor.set(true);

        if(firstBallSensor.haveBall()) {
            System.out.println("First sensor detected ball");
            motor.setPower(0.3);
        }


        secondBallSensor.set(true);

        if(secondBallSensor.haveBall()) {
            System.out.println("Second sensor detected ball");
            motor.stop();
        }
    }

    public void ejectBall() {
        System.out.println("Ejecting ball...");
        motor.setPower(-1);

        if(insideLimit.atLimit()) {
            motor.stop();
            System.out.println("Closed position reached");
        }
    }
}