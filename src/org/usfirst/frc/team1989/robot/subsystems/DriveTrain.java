package org.usfirst.frc.team1989.robot.subsystems;

import org.usfirst.frc.team1989.robot.CANTalon1989;
import org.usfirst.frc.team1989.robot.commands.Drive;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

/**
 *
 */

public class DriveTrain extends Subsystem {

	CANTalon1989 frontLeft;
	CANTalon1989 backLeft;
	CANTalon1989 frontRight;
	CANTalon1989 backRight;
	ADXRS450_Gyro gyro;
	MecanumDrive mdrive;
	
	static double error = 0;
	static double kP = 0.00975;

	
	public DriveTrain(CANTalon1989 frontLeft, CANTalon1989 backLeft, CANTalon1989 frontRight, CANTalon1989 backRight, ADXRS450_Gyro gyro) {
		this.frontLeft = frontLeft;
		this.frontRight = frontRight;
		this.backLeft = backLeft;
		this.backRight = backRight;
		this.gyro = gyro;
		mdrive = new MecanumDrive(frontLeft, backLeft, frontRight, backRight);
		mdrive.setSafetyEnabled(true);
	}
	
    public void initDefaultCommand() {
        setDefaultCommand(new Drive());
    }
    
    public void moveRobot(Joystick joy) {
    		//takes in DriveStick values to move the robot
    		double moveY = joy.getY();
    		double moveX = -joy.getX();
    		double moveTwist = -joy.getZ();
    		mdrive.driveCartesian(moveX, moveY, moveTwist, 0);
    		
    }
    
    public void autoDrive(double ySpeed, double xSpeed) {
    		//method to move the robot in the x and y plain during autonomous
    		mdrive.driveCartesian(ySpeed, xSpeed, 0);   
    }
    
    public void autoRotate(double angle) {
    		//turns the robot using PID system
    		error = angle - gyro.getAngle();
    		mdrive.driveCartesian(0, 0, error*kP);
    }
    
    public void driveStop() {
    		//method to stop the drive motors 
    		frontLeft.set(0);
    		frontRight.set(0);
    		backRight.set(0);
    		backLeft.set(0);
    }
    
    
}

