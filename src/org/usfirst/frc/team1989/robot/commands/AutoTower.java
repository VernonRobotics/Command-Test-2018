package org.usfirst.frc.team1989.robot.commands;

import org.usfirst.frc.team1989.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoTower extends Command {
	
    double time;
    double direction;

    public AutoTower(double time, double direction) {
    		requires(Robot.tower);
    		this.time = time;
    		this.direction = direction;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    		setTimeout(time);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		Robot.tower.autoTowerControl(direction);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    		Robot.tower.towerStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
