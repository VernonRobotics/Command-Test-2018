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

    // Called just before this Command runs the first time
    protected void initialize() {
    		setTimeout(time);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		Robot.driveTrain.autoDrive(ySpeed, xSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    		Robot.driveTrain.driveStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
