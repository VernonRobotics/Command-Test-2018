package org.usfirst.frc.team1989.robot.subsystems;

import org.usfirst.frc.team1989.robot.CANTalon1989;
import org.usfirst.frc.team1989.robot.commands.MoveTower;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Tower extends Subsystem {
	
	CANTalon1989 rightMotor;
	CANTalon1989 leftMotor;
	
	public Tower(CANTalon1989 rightMotor, CANTalon1989 leftMotor) {
		this.rightMotor = rightMotor;
		this.leftMotor = leftMotor;
		leftMotor.setSafetyEnabled(true);
		rightMotor.setSafetyEnabled(true);
	}

    public void initDefaultCommand() {
    		setDefaultCommand(new MoveTower());
    }
    
    public void towerControl(Joystick joy){
		rightMotor.set(-joy.getY());
		leftMotor.set(-joy.getY());
	}
	
    public void autoTowerControl(double speed) {
    		rightMotor.set(speed);
    		leftMotor.set(speed);
    }
	
	public void towerStop() {
		rightMotor.set(0);
		leftMotor.set(0);
	}
	
}

