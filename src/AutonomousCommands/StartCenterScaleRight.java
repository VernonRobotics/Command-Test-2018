package AutonomousCommands;

import org.usfirst.frc.team1989.robot.Robot;
import org.usfirst.frc.team1989.robot.RobotMap;
import org.usfirst.frc.team1989.robot.commands.AutoDrive;
import org.usfirst.frc.team1989.robot.commands.AutoRotate;
import org.usfirst.frc.team1989.robot.commands.AutoTimedDrive;
import org.usfirst.frc.team1989.robot.commands.AutoTower;
import org.usfirst.frc.team1989.robot.commands.BoxOutput;
import org.usfirst.frc.team1989.robot.commands.Delay;

import edu.wpi.first.wpilibj.command.CommandGroup;


public class StartCenterScaleRight extends CommandGroup {
	
	double x = 0;

    public StartCenterScaleRight() {
    		requires(Robot.driveTrain);
    		requires(Robot.tower);
    		requires(Robot.boxArm);
    		
    		addParallel(new AutoTower(1, 1));
		addSequential(new AutoDrive(AutoDistances.startToSwitchSide, 0, 0.5, RobotMap.r1));
		addSequential(new Delay());
		addSequential(new AutoDrive(AutoDistances.closePathToRightScale, 0.5, 0, RobotMap.r3));
		addSequential(new Delay());
		addSequential(new AutoDrive(AutoDistances.closePathToLeftScale, 0, 0.5, RobotMap.r1));
		addSequential(new Delay());
		addSequential(new AutoDrive(AutoDistances.switchToRightScale, 0, 0.5, RobotMap.r1));
		addSequential(new Delay());
		addSequential(new AutoRotate(-90));
		addSequential(new Delay());
		addSequential(new AutoTimedDrive(x, 1, 0));
		addSequential(new Delay());
		addSequential(new BoxOutput(-1), 4);
    }
}
