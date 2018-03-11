package org.usfirst.frc.team1989.robot.commands;

import org.usfirst.frc.team1989.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Delay extends Command {

    boolean timerFinished = false;

    public Delay() {
    }
    
    protected void initialize() {
    		//stops, resets, and starts timer found in RobotMap.java
    		RobotMap.delayTimer.stop();
    		RobotMap.delayTimer.reset();
    		RobotMap.delayTimer.start();
    }

    protected void execute() {
    		//check is time has passed
    		if(RobotMap.delayTimer.get() >= 0.5) {
    			timerFinished = true;
    		}
    }

    protected boolean isFinished() {
        return timerFinished;
    }

    protected void end() {
    		//stops timer and resets it when the command has finished
    		RobotMap.delayTimer.stop();
    		RobotMap.delayTimer.reset();
    }

    protected void interrupted() {
    }
}
