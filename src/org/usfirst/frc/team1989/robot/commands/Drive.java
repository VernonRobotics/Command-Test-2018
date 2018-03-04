package org.usfirst.frc.team1989.robot.commands;

import org.usfirst.frc.team1989.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class Drive extends Command {

	public Drive() {
        requires(Robot.driveTrain);
    }
	
    protected void initialize() {
    }

    protected void execute() {
    		Robot.driveTrain.moveRobot(Robot.m_oi.getDriveStick());    //gets the value of the JsScaled DriveStick
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    		Robot.driveTrain.driveStop();
    }

    protected void interrupted() {
    }
}
