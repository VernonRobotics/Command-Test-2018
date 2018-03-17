package org.usfirst.frc.team1989.robot.commands;

import org.usfirst.frc.team1989.robot.OI;
import org.usfirst.frc.team1989.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Drive extends Command {

	public Drive() {
        requires(Robot.driveTrain);
    }
	
    protected void initialize() {
    }

    protected void execute() {
    		Robot.driveTrain.moveRobot(OI.driveStick);    //gets the value of the DriveStick
    		if(Robot.driveTrain.leftCurrent > 30 && Robot.driveTrain.rightCurrent > 30) {
    			//SmartDashboard.putData("", "Running motors over 30 amps");
    		}
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
