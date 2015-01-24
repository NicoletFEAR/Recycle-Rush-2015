package com.nicoletfear.Robot2015.xbox;

public class Velocities {
    private double left;
    private double right;
    public Velocities(double leftVelocity, double rightVelocity) {
        left = leftVelocity;
        right = rightVelocity;
    }
    
    public double getLeftVelocity() {
        return left;
    }
    public double getRightVelocity() {
        return right;
    }
}