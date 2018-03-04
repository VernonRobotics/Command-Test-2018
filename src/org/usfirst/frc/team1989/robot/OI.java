/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1989.robot;

import org.usfirst.frc.team1989.robot.commands.BoxInput;
import org.usfirst.frc.team1989.robot.commands.BoxOutput;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public static final int leftJoystickPort = 1;
	public static final int rightJoystickPort = 0;
	
	public JsScaled driveStick = new JsScaled(rightJoystickPort);
	public static JsScaled uStick = new JsScaled(leftJoystickPort);
	public static Button  inButton = new JoystickButton(uStick, 2);
	public static Button outButton = new JoystickButton(uStick, 1);
	
	public OI() {
		//sets arm motor values when button is pressed and when released
		inButton.whenPressed(new BoxInput(1));
		inButton.whenReleased(new BoxInput(0));
		outButton.whenPressed(new BoxOutput(-1));
		outButton.whenReleased(new BoxOutput(0));
	}
	
	public Joystick getUStick() {
		return uStick;
	}
	
	public Joystick getDriveStick() {
		return driveStick;
	}
}
