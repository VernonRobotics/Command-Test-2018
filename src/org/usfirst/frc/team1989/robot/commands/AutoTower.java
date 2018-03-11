package org.usfirst.frc.team1989.robot.commands;

import org.usfirst.frc.team1989.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoTower extends Command {
	
    double time;
    double speed;

    public AutoTower(double time, double speed) {
    		requires(Robot.tower);
    		this.time = time;
    		this.speed = speed;
    }

    protected void initialize() {
    		setTimeout(this.time);
    }

    protected void execute() {
    		Robot.tower.autoTowerControl(this.speed);
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
