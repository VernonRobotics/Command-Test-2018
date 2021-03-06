package org.usfirst.frc.team1989.robot.commands.auto;

import org.usfirst.frc.team1989.robot.Robot;
import org.usfirst.frc.team1989.robot.commands.AutoRotate;
import org.usfirst.frc.team1989.robot.commands.AutoTimedDrive;
import org.usfirst.frc.team1989.robot.commands.AutoTower;
import org.usfirst.frc.team1989.robot.commands.BoxOutput;
import org.usfirst.frc.team1989.robot.commands.Delay;

import edu.wpi.first.wpilibj.command.CommandGroup;


public class StartLeftScaleLeft extends CommandGroup {
	
	//place holder value to be determined for timed drive
	double x = 0;

    public StartLeftScaleLeft() {
    		requires(Robot.driveTrain); 
    		requires(Robot.tower);
    		requires(Robot.boxArm);
    
    		addParallel(new AutoTower(1, 1));
		//addSequential(new AutoDrive(AutoDistances.startToClosePath, 0, 0.5, RobotMap.r1));
		addSequential(new Delay());
		//addSequential(new AutoDrive(AutoDistances.adjustForScale, -0.5, 0, RobotMap.r2));
		addSequential(new Delay());
		//addSequential(new AutoDrive(AutoDistances.closePathToLeftScale, 0, 0.5, RobotMap.r1));
		addSequential(new Delay());
		addSequential(new AutoRotate(90));
		addSequential(new Delay());
		addSequential(new Delay());
		addSequential(new AutoTimedDrive(x, 1, 0));
		addSequential(new Delay());
		addSequential(new BoxOutput(-1), 4);
    }
}
