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

    public AutoTimedDrive(double time, double ySpeed, double xSpeed) {
        requires(Robot.driveTrain);
        this.time = time;
        this.ySpeed = ySpeed;
        this.xSpeed = xSpeed;
    }

    protected void initialize() {
    		setTimeout(time);    //adds delay to command 
    }

    protected void execute() {
    		Robot.driveTrain.autoDrive(ySpeed, xSpeed);
    }

    protected boolean isFinished() {
        return isTimedOut();    //is true when time is reached 
    }

    protected void end() {
    		Robot.driveTrain.driveStop();    //sets motor value to zero
    }

    protected void interrupted() {
    }
}
