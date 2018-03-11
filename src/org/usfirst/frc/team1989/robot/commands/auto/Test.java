package org.usfirst.frc.team1989.robot.commands.auto;

import org.usfirst.frc.team1989.robot.Robot;
import org.usfirst.frc.team1989.robot.commands.AutoTimedDrive;
import org.usfirst.frc.team1989.robot.commands.Delay;

import edu.wpi.first.wpilibj.command.CommandGroup;


public class Test extends CommandGroup {
	
	//place holder value to be determined for timed drive
	double x = 0;

    public Test() {
    		requires(Robot.driveTrain); 
    		
		addSequential(new AutoTimedDrive(4, 1, 0));
		addSequential(new Delay());
    }
}
