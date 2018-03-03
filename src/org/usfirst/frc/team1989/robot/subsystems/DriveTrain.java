package org.usfirst.frc.team1989.robot.subsystems;

import org.usfirst.frc.team1989.robot.CANTalon1989;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

/**
 *
 */

public class DriveTrain extends Subsystem {
	
	public DriveTrain(CANTalon1989 frontLeft, CANTalon1989 backLeft, CANTalon1989 frontRight, CANTalon1989 backRight, ADXRS450_Gyro gyro) {
		this.frontLeft = frontLeft;
		this.frontRight = frontRight;
		this.backLeft = backLeft;
		this.backRight = backRight;
		this.gyro = gyro;
		mdrive = new MecanumDrive(frontLeft, backLeft, frontRight, backRight);
	}
	
	CANTalon1989 frontLeft;
	CANTalon1989 backLeft;
	CANTalon1989 frontRight;
	CANTalon1989 backRight;
	ADXRS450_Gyro gyro;
	MecanumDrive mdrive;
	
	static double error = 0;
	static double kP = 0.00975;
	

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new Drive());
    }
    
    public void moveRobot(Joystick joy) {
    		Double moveY = -joy.getY();
    		Double moveX = joy.getX();
    		Double moveTwist = joy.getZ();
    		mdrive.driveCartesian(moveX, moveY, moveTwist, 0);
    		
    }
    
    public void autoDrive(double ySpeed, double xSpeed) {
    		mdrive.driveCartesian(ySpeed, xSpeed, 0);
    }
    
    public void autoRotate(double angle) {
    		error = angle - gyro.getAngle();
    		mdrive.driveCartesian(0, 0, error*kP);
    }
    
    public void driveStop() {
    		frontLeft.set(0);
    		frontRight.set(0);
    		backRight.set(0);
    		backLeft.set(0);
    }
    
    
}

