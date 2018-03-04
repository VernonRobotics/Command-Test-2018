package org.usfirst.frc.team1989.robot.commands;

import org.usfirst.frc.team1989.robot.Robot;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Command;


public class AutoDrive extends Command {

	Ultrasonic rf;
	double xSpeed;
	double ySpeed;
	double distance;
	double rangeFinderDistance;
	boolean reachedDistance = false;

	public AutoDrive(double distance, double ySpeed, double xSpeed, Ultrasonic rf) {
        requires(Robot.driveTrain);
    		this.xSpeed = xSpeed;
    		this.ySpeed = ySpeed;
    		this.distance = distance;
    		this.rf = rf;
    }

    protected void initialize() {
    		// determines the the range finder value to move to
    		double currentDistance = rf.getRangeInches();
    		rangeFinderDistance = currentDistance - distance;
    		//checks if the robot has moved the set distance 
    		if (rf.getRangeInches() <= rangeFinderDistance) {
    			reachedDistance = true;
    		}
    }

    protected void execute() {
    		Robot.driveTrain.autoDrive(ySpeed, xSpeed);
    }

    protected boolean isFinished() {
    		return reachedDistance;
    }

    protected void end() {
    		Robot.driveTrain.driveStop();    //stops the drive train motors 
    }

    protected void interrupted() {
    }
}
