package org.usfirst.frc.team1989.robot.subsystems;

import org.usfirst.frc.team1989.robot.CANTalon1989;
import org.usfirst.frc.team1989.robot.commands.MoveTower;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Tower extends Subsystem {
	
	public Tower(CANTalon1989 rightMotor, CANTalon1989 leftMotor) {
		this.rightMotor = rightMotor;
		this.leftMotor = leftMotor;
	}
	
	CANTalon1989 rightMotor;
	CANTalon1989 leftMotor;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    		setDefaultCommand(new MoveTower());
    }
    
    public void towerControl(Joystick joy){
		rightMotor.set(-joy.getY());
		leftMotor.set(-joy.getY());
	}
	
	
	public void towerStop() {
		rightMotor.set(0);
		leftMotor.set(0);
	}
	
}

