public class homework3 {

    private double currentAngle;   
    private double targetAngle;  
    private String motorName;
    private int velocity; 

    public homework3(String motorName) {
        this.motorName = motorName;
        this.currentAngle = 90;
        this.targetAngle = 90;
        this.velocity = 0;
    }

    public double getAngle() {
        return currentAngle;
    }

    public boolean isAtTarget() {
        return currentAngle == targetAngle;
    }


    public void moveToAngle(double angle) {

        angle = Math.max(0, Math.min(180, angle));
        targetAngle = angle;

        if (targetAngle > currentAngle) {
            velocity = 90;   
        } else if (targetAngle < currentAngle) {
            velocity = -90;  // move backward
        } else {
            velocity = 0;    // already there
        }
    }


    public void periodicUpdate() {
        if (velocity == 0) return;

        // Change in angle = velocity * time
        double delta = velocity * 0.1;  // 0.1 seconds

        currentAngle += delta;

        // Prevent overshooting the target
        if (velocity > 0 && currentAngle > targetAngle) {
            currentAngle = targetAngle;
            velocity = 0;
        } else if (velocity < 0 && currentAngle < targetAngle) {
            currentAngle = targetAngle;
            velocity = 0;
        }
    }

    public String toString() {
        return motorName + " angle=" + currentAngle + " target=" + targetAngle + " vel=" + velocity;
    }
}
