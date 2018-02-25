package org.usfirst.frc.team1989.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1989.robot.*;

/**
 *
 */
public class BoxArm extends Subsystem {
	
	public BoxArm(CANTalon1989 armsLeft, CANTalon1989 armsRight) {
		this.armsLeft = armsLeft;
		this.armsRight = armsRight;
	}
	
	CANTalon1989 armsLeft;
	CANTalon1989 armsRight;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void boxPull(int speed) {
    		armsLeft.set(speed);
    		armsRight.set(speed);
    }
    
    public void boxPush(int speed) {
    		armsLeft.set(speed);
    		armsRight.set(speed);
    }
    
    public void stop() {
    		armsLeft.set(0);
    		armsRight.set(0);
    }
    
}

