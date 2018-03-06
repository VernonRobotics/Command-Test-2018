/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1989.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team1989.robot.RobotMap;
import org.usfirst.frc.team1989.robot.subsystems.BoxArm;
import org.usfirst.frc.team1989.robot.subsystems.DriveTrain;
import org.usfirst.frc.team1989.robot.subsystems.Tower;

import com.ctre.phoenix.motorcontrol.ControlMode;
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

	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		m_oi = new OI();
		//m_chooser.addDefault("Default Auto", new ExampleCommand());
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", m_chooser);
		RobotMap.frontLeft.setInverted(true);
		RobotMap.frontRight.setInverted(true);
		RobotMap.backLeft.setInverted(true);
		RobotMap.armsRight.setInverted(true);
		RobotMap.towerLeft.set(ControlMode.Follower, 5);
		RobotMap.towerLeft.setNeutralMode(NeutralMode.Brake);
		RobotMap.towerRight.setNeutralMode(NeutralMode.Brake);
		CameraServer.getInstance().startAutomaticCapture();
		RobotMap.r1.setAutomaticMode(true);
		
		m_autonomousCommand = new AutonomousCommands.Test();
		/*gameData = DriverStation.getInstance().getGameSpecificMessage();
		
		if(gameData.length() > 0) {
			
			if (SmartDashboard.getBoolean("DB/Button 0", true)) {
						if (SmartDashboard.getBoolean("DB/Button 3", true)) {
							if (gameData.charAt(1) == 'L') {
								m_autonomousCommand = new AutonomousCommands.StartLeftScaleLeft();
							} else {
								m_autonomousCommand = new AutonomousCommands.StartLeftScaleRight();
							}
						} else {
							if (gameData.charAt(0) == 'L') {
								m_autonomousCommand = new AutonomousCommands.StartLeftSwitchLeft();
							} else {
								m_autonomousCommand = new AutonomousCommands.StartLeftSwitchRight();
							}
						}
			
					} else if (SmartDashboard.getBoolean("DB/Button 1", true)) {
						if (SmartDashboard.getBoolean("DB/Button 3", true)) {
							if (gameData.charAt(1) == 'L') {
								m_autonomousCommand = new AutonomousCommands.StartCenterScaleLeft();
							} else {
								m_autonomousCommand = new AutonomousCommands.StartCenterScaleRight();
							}
						} else {
							if (gameData.charAt(0) == 'L') {
								m_autonomousCommand = new AutonomousCommands.StartCenterSwitchLeft();
							} else {
								m_autonomousCommand = new AutonomousCommands.StartCenterSwitchRight();
							}
						}
					} else if (SmartDashboard.getBoolean("DB/Button 2", true)) {
						if (SmartDashboard.getBoolean("DB/Button 3", true)) {
							if (gameData.charAt(1) == 'L') {
								m_autonomousCommand = new AutonomousCommands.StartRightScaleLeft();
							} else {
								m_autonomousCommand = new AutonomousCommands.StartRightScaleRight();
							}
						} else {
						if (gameData.charAt(0) == 'L') {
							m_autonomousCommand = new AutonomousCommands.StartRightSwitchLeft();
						} else {
							m_autonomousCommand = new AutonomousCommands.StartRightSwitchRight();
							}
						}
					} else {
						// DriveForward.run();
			 		}
			}*/
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

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
		m_autonomousCommand = m_chooser.getSelected();
		
		

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

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
