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
    
    protected void initialize() {
    		//stops, resets, and starts timer found in RobotMap.java
    		RobotMap.autoTimer.stop();
    		RobotMap.autoTimer.reset();
    		RobotMap.autoTimer.start();
    }

    protected void execute() {
    		//check is time has passed
    		if(RobotMap.autoTimer.get() >= time) {
    			timerFinished = true;
    		}
    }

    protected boolean isFinished() {
        return timerFinished;
    }

    protected void end() {
    		//stops timer and resets it when the command has finished
    		RobotMap.autoTimer.stop();
    		RobotMap.autoTimer.reset();
    }

    protected void interrupted() {
    }
}
