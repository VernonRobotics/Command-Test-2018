package org.usfirst.frc.team1989.robot.subsystems;

import org.usfirst.frc.team1989.robot.CANTalon1989;
import org.usfirst.frc.team1989.robot.commands.Drive;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

/**
 *
 */

public class DriveTrain extends Subsystem {
	
	public DriveTrain(CANTalon1989 frontLeft, CANTalon1989 backLeft, CANTalon1989 frontRight, CANTalon1989 backRight) {
		this.frontLeft = frontLeft;
		this.frontRight = frontRight;
		this.backLeft = backLeft;
		this.backRight = backRight;
		mdrive = new MecanumDrive(frontLeft, backLeft, frontRight, backRight);
	}
	
	CANTalon1989 frontLeft;
	CANTalon1989 backLeft;
	CANTalon1989 frontRight;
	CANTalon1989 backRight;
	MecanumDrive mdrive;
	
	

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new Drive());
    }
    
    public void moveRobot(Joystick joy) {
    		Double moveY = -joy.getY();
    		Double moveX = joy.getX();
    		Double moveTwist = joy.getZ();
    		mdrive.driveCartesian(moveX, moveY, moveTwist, 0);
    		
    }
    
    public void driveStop() {
    		frontLeft.set(0);
    		frontRight.set(0);
    		backRight.set(0);
    		backLeft.set(0);
    }
}

