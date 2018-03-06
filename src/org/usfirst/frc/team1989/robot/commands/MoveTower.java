package org.usfirst.frc.team1989.robot.commands;

import org.usfirst.frc.team1989.robot.OI;
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
    		Robot.tower.towerControl(OI.uStick);    //send the value of the UStick to the tower subsystem
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
