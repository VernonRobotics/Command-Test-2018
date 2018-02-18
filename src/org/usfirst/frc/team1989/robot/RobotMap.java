/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1989.robot;


/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	
	static CANTalon1989 frontLeft = new CANTalon1989(6);
	static CANTalon1989 backLeft = new CANTalon1989(7);
	static CANTalon1989 frontRight = new CANTalon1989(3);
	static CANTalon1989 backRight = new CANTalon1989(9);
	static CANTalon1989 armsLeft = new CANTalon1989(2);
	static CANTalon1989 armsRight = new CANTalon1989(1);
	static CANTalon1989 towerLeft = new CANTalon1989(4);
	static CANTalon1989 towerRight = new CANTalon1989(5);

}
