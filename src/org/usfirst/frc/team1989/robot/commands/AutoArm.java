package org.usfirst.frc.team1989.robot.commands;

import org.usfirst.frc.team1989.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoArm extends Command {

	double speed;
	
    public AutoArm(double speed) {
        requires(Robot.boxArm);
        this.speed = speed;
    }

    protected void initialize() {
    		setTimeout(6);    // sets a timed clock that will return true once the set time is reached
    }

    protected void execute() {
    		Robot.boxArm.armControl(speed);    // moves motors at the desired speed 
    }

    protected boolean isFinished() {
        return isTimedOut();	    // is true when time runs out
    }

    protected void end() {
    		Robot.boxArm.stop();		// sets motors to zero 
    }

    protected void interrupted() {
    }
}
