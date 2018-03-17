package org.usfirst.frc.team1989.robot.commands.auto;

import org.usfirst.frc.team1989.robot.Robot;
import org.usfirst.frc.team1989.robot.commands.AutoTimedDrive;
import org.usfirst.frc.team1989.robot.commands.AutoTower;
import org.usfirst.frc.team1989.robot.commands.BoxOutput;
import org.usfirst.frc.team1989.robot.commands.Delay;

import edu.wpi.first.wpilibj.command.CommandGroup;


public class StartCenterSwitchRight extends CommandGroup {

    public StartCenterSwitchRight() {
    		requires(Robot.driveTrain); 
    		requires(Robot.tower);
    		requires(Robot.boxArm);
    		
    		addParallel(new AutoTower(1.25, 1));
		addSequential(new AutoTimedDrive(0.5, 0, 0.4));
		addSequential(new Delay());
		addSequential(new AutoTimedDrive(2, 0.6, 0));
		addSequential(new Delay());
		addSequential(new AutoTimedDrive(2.75, 0, 0.4));
		addSequential(new Delay());
		addSequential(new BoxOutput(-1), 2);		
    }
}
