package org.usfirst.frc.team1989.robot.commands;

import org.usfirst.frc.team1989.robot.Robot;
import org.usfirst.frc.team1989.robot.RobotMap;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoRotate extends Command {
	 
    double angle;
    ADXRS450_Gyro gyro;
    boolean reachedAngle = false;

    public AutoRotate(double angle) {
        requires(Robot.driveTrain);
        this.angle = angle;
    }

    protected void initialize() {
    		RobotMap.gyro.reset();    //resets gyro angle 
    }

    protected void execute() {
    		//checks if the desired angle is reached
    		double gyroAngle = gyro.getAngle();
    		if (Math.abs(gyroAngle) >= Math.abs(angle)) {
    			reachedAngle = true;
    		} else {
    			Robot.driveTrain.autoRotate(angle);
    		}    		
    }

    protected boolean isFinished() {
        return reachedAngle;
    }

    protected void end() {
    		Robot.driveTrain.driveStop();
    }

    protected void interrupted() {
    }
}
