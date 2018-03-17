/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1989.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team1989.robot.RobotMap;
import org.usfirst.frc.team1989.robot.commands.auto.*;
import org.usfirst.frc.team1989.robot.subsystems.BoxArm;
import org.usfirst.frc.team1989.robot.subsystems.DriveTrain;
import org.usfirst.frc.team1989.robot.subsystems.Tower;

import com.ctre.phoenix.motorcontrol.NeutralMode;




/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	
	public static final DriveTrain driveTrain = new DriveTrain(RobotMap.frontLeft, RobotMap.backLeft, RobotMap.frontRight, RobotMap.backRight, RobotMap.gyro);
	public static final BoxArm boxArm = new BoxArm(RobotMap.armsLeft, RobotMap.armsRight);
	public static final Tower tower = new Tower(RobotMap.towerRight, RobotMap.towerRight);
	public static OI m_oi;
	
	public String gameData;
	
	boolean btn0;
	boolean btn1;
	boolean btn2;
	boolean btn3;
	
	double slider0;
	double slider1;
	double slider2;
	double slider3;

	//CANTalon1989 slaveMotor;
	//CANTalon1989 masterMotor;
	
	Command m_autonomousCommand;
	SendableChooser<Command> autoChooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		m_oi = new OI();
		RobotMap.frontLeft.setInverted(true);
		RobotMap.frontRight.setInverted(true);
		RobotMap.backLeft.setInverted(true);
		RobotMap.armsRight.setInverted(true);
		RobotMap.towerLeft.setNeutralMode(NeutralMode.Brake);
		RobotMap.towerRight.setNeutralMode(NeutralMode.Brake);
		
		/*slaveMotor = RobotMap.towerLeft; 
		masterMotor = RobotMap.towerRight;
		slaveMotor.changeControlMode(CANTalon.TalonControlMode.Follower);
		slaveMotor.set(masterMotor.getDeviceID());*/
		
		CameraServer.getInstance().startAutomaticCapture();
		//RobotMap.r1.setAutomaticMode(true);
		
		//m_autonomousCommand = new Test();
		
		//autoChooser.addDefault("Default Command", new AutoSelector("default"));
		//autoChooser.addObject("Left/Scale", new AutoSelector("Left/Scale"));
		SmartDashboard.putData("Auto mode", autoChooser);

	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
		RobotMap.gyro.reset();
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		//m_autonomousCommand = (Command) autoChooser.getSelected();
		
		gameData = DriverStation.getInstance().getGameSpecificMessage();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */
	
		btn0 = SmartDashboard.getBoolean("DB/Button 0", false);
		btn1 = SmartDashboard.getBoolean("DB/Button 1", false);
		btn2 = SmartDashboard.getBoolean("DB/Button 2", false);
		btn3 = SmartDashboard.getBoolean("DB/Button 3", false);
		
		slider0 = SmartDashboard.getNumber("DB/Slider 0", 0);
		slider1 = SmartDashboard.getNumber("DB/Slider 1", 0);
		slider2 = SmartDashboard.getNumber("DB/Slider 2", 0);
		slider3 = SmartDashboard.getNumber("DB/Slider 3", 0);
		
		switch(gameData.charAt(0)) {
			case('L'):
				if(btn0) {
					if(btn3) {
						m_autonomousCommand = new StartLeftSwitchLeft();
					} else {
						m_autonomousCommand = new StartLeftScaleLeft();
					}
				} else if(btn1) {
					if(btn3) {
						m_autonomousCommand = new StartCenterSwitchLeft();
					} else {
						//m_autonomousCommand = new StartCenterScaleLeft();
					}
				} else if(btn2) {
					if(btn3) {
						//m_autonomousCommand = new StartRightSwitchLeft();
					} else {
						// m_autonomousCommand = new StartRightScaleLeft();
					}
				}
			break;
			case('R'):
				if(btn0) {
					if(btn3) {
						m_autonomousCommand = new StartLeftSwitchRight();
					} else {
						m_autonomousCommand = new StartLeftScaleRight();
					}
				} else if(btn1) {
					if(btn3) {
						m_autonomousCommand = new StartCenterSwitchRight();
					} else {
						//m_autonomousCommand = new StartCenterScaleRight();
					}
				} else if(btn2) {
					if(btn3) {
						//m_autonomousCommand = new StartRightSwitchRight();
					} else {
						// m_autonomousCommand = new StartRightScaleRight();
					}
				}
			break;
		}
		
		
		// schedule the autonomous command (example)
		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		
		RobotMap.dashboardTimer.stop();
		RobotMap.dashboardTimer.reset();
		
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
