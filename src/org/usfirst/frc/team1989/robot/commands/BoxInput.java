package org.usfirst.frc.team1989.robot.commands;

import org.usfirst.frc.team1989.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class BoxInput extends Command {
	
	private int speed;

    public BoxInput(int speed) {
        // Use requires() here to declare subsystem dependencies
    		requires(Robot.boxArm);
    		this.speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		Robot.boxArm.boxPull(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    		Robot.boxArm.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
