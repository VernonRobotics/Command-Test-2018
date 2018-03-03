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

    // Called just before this Command runs the first time
    protected void initialize() {
    		double currentDistance = rf.getRangeInches();
    		rangeFinderDistance = currentDistance - distance;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		Robot.driveTrain.autoDrive(ySpeed, xSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    		if (rf.getRangeInches() <= rangeFinderDistance) {
    			reachedDistance = true;
    		}
        return reachedDistance;
    }

    // Called once after isFinished returns true
    protected void end() {
    		Robot.driveTrain.driveStop();
    		//setTimeout(1);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
