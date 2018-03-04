package org.usfirst.frc.team1989.robot.commands;

import org.usfirst.frc.team1989.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveTower extends Command {

    public MoveTower() {
    		requires(Robot.tower);
    }

    protected void initialize() {
    }

    protected void execute() {
    		Robot.tower.towerControl(Robot.m_oi.getUStick());    //gets the value of the UStick
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    		Robot.tower.towerStop();
    }

    protected void interrupted() {
    }
}
