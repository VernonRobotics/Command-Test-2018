package org.usfirst.frc.team1989.robot.commands.auto;

import org.usfirst.frc.team1989.robot.Robot;
import org.usfirst.frc.team1989.robot.RobotMap;
import org.usfirst.frc.team1989.robot.commands.AutoDrive;
import org.usfirst.frc.team1989.robot.commands.AutoTimedDrive;
import org.usfirst.frc.team1989.robot.commands.AutoTower;
import org.usfirst.frc.team1989.robot.commands.BoxOutput;
import org.usfirst.frc.team1989.robot.commands.Delay;

import edu.wpi.first.wpilibj.command.CommandGroup;


public class StartCenterSwitchRight extends CommandGroup {
	
	//place holder value to be determined for timed drive
	double x = 0;

    public StartCenterSwitchRight() {
    		requires(Robot.driveTrain); 
    		requires(Robot.tower);
    		requires(Robot.boxArm);
    		
    		addParallel(new AutoTower(1, 1));
		addSequential(new AutoTimedDrive(0.5, 0.4, 0));
		addSequential(new Delay());
		addSequential(new AutoTimedDrive(2, 0, 0.6));
		addSequential(new Delay());
		addSequential(new AutoTower(2, 1));
		addSequential(new Delay());
		addSequential(new AutoTimedDrive(2.5, 0.4, 0));
		addSequential(new Delay());
		addSequential(new BoxOutput(-1), 4);		
    }
}
