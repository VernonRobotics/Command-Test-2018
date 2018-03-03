package org.usfirst.frc.team1989.robot.commands;

import org.usfirst.frc.team1989.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Delay extends Command {

    double time;
    boolean timerFinished = false;

    public Delay(double time) {
    		this.time = time;
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
    		RobotMap.autoTimer.stop();
    		RobotMap.autoTimer.reset();
    		RobotMap.autoTimer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		if(RobotMap.autoTimer.get() >= time) {
    			timerFinished = true;
    		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return timerFinished;
    }

    // Called once after isFinished returns true
    protected void end() {
    		RobotMap.autoTimer.stop();
    		RobotMap.autoTimer.reset();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
