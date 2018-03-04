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

    protected void initialize() {
    		setTimeout(time);
    }

    protected void execute() {
    		Robot.tower.autoTowerControl(direction);
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
    		Robot.tower.towerStop();
    }
    
    protected void interrupted() {
    }
}
