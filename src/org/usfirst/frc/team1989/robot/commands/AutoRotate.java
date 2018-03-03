package org.usfirst.frc.team1989.robot.commands;

import org.usfirst.frc.team1989.robot.Robot;
import org.usfirst.frc.team1989.robot.RobotMap;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoRotate extends Command {

    public AutoRotate(double angle) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveTrain);
        this.angle = angle;
    }
    
    double angle;
    ADXRS450_Gyro gyro;
    boolean reachedAngle = false;

    // Called just before this Command runs the first time
    protected void initialize() {
    		RobotMap.gyro.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		double gyroAngle = gyro.getAngle();
    		if (Math.abs(gyroAngle) >= Math.abs(angle)) {
    			reachedAngle = true;
    		} else {
    			Robot.driveTrain.autoRotate(angle);
    		}    		
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return reachedAngle;
    }

    // Called once after isFinished returns true
    protected void end() {
    		Robot.driveTrain.driveStop();
		setTimeout(1);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
