/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1989.robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Timer;
//import edu.wpi.first.wpilibj.Ultrasonic;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	static CANTalon1989 frontLeft = new CANTalon1989(6);
	static CANTalon1989 backLeft = new CANTalon1989(7);
	static CANTalon1989 frontRight = new CANTalon1989(3);
	static CANTalon1989 backRight = new CANTalon1989(9);
	static CANTalon1989 armsLeft = new CANTalon1989(2);
	static CANTalon1989 armsRight = new CANTalon1989(1);
	static CANTalon1989 towerLeft = new CANTalon1989(4);
	static CANTalon1989 towerRight = new CANTalon1989(5);
	
	static Servo servo = new Servo(0);
	public static ADXRS450_Gyro gyro = new ADXRS450_Gyro();  

	public static Timer delayTimer = new Timer();
	
	/*public static Ultrasonic r1 = new Ultrasonic(9,8);
	public static Ultrasonic r2 = new Ultrasonic(7,6);
	public static Ultrasonic r3 = new Ultrasonic(5,4);*/
}