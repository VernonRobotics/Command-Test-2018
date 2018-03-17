package org.usfirst.frc.team1989.robot.commands;

import org.usfirst.frc.team1989.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoTimedDrive extends Command {
	
	double time;
	double ySpeed;
	double xSpeed;
	boolean currentReached;

    public AutoTimedDrive(double time, double xSpeed, double ySpeed) {
        requires(Robot.driveTrain);
        this.time = time;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    protected void initialize() {
    		setTimeout(time);    //adds delay to command 
    }

    protected void execute() {
    		Robot.driveTrain.autoDrive(xSpeed, ySpeed);
    		if(Robot.driveTrain.leftCurrent > 30 && Robot.driveTrain.rightCurrent > 30) {
    			currentReached = true;
    		}
    }

    protected boolean isFinished() {
        return isTimedOut()||currentReached;    //is true when time is reached or when both front motors use over 30 amps
    }

    protected void end() {
    		Robot.driveTrain.driveStop();    //sets motor value to zero at end of command
    }

    protected void interrupted() {
    }
}
