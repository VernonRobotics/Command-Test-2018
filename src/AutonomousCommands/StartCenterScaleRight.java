package AutonomousCommands;

import org.usfirst.frc.team1989.robot.Robot;
import org.usfirst.frc.team1989.robot.RobotMap;
import org.usfirst.frc.team1989.robot.commands.AutoDrive;
import org.usfirst.frc.team1989.robot.commands.AutoRotate;
import org.usfirst.frc.team1989.robot.commands.Delay;

import edu.wpi.first.wpilibj.command.CommandGroup;


public class StartCenterScaleRight extends CommandGroup {

    public StartCenterScaleRight() {
    		requires(Robot.driveTrain);
    		//requires(Robot.tower);
    		//requires(Robot.boxArm);
    		
    		//TODO : add command for start of match
    		
		addSequential(new AutoDrive(AutoDistances.startToSwitchSide, 0, 0.5, RobotMap.r1));
		addSequential(new Delay(1));
		addSequential(new AutoDrive(AutoDistances.closePathToRightScale, 0.5, 0, RobotMap.r3));
		addSequential(new Delay(1));
		addSequential(new AutoDrive(AutoDistances.closePathToLeftScale, 0, 0.5, RobotMap.r1));
		addSequential(new Delay(1));
		addSequential(new AutoDrive(AutoDistances.switchToRightScale, 0, 0.5, RobotMap.r1));
		addSequential(new Delay(1));
		addSequential(new AutoRotate(-90));
		addSequential(new Delay(1));
		
		//TODO : add tower and box output
		
    }
}
