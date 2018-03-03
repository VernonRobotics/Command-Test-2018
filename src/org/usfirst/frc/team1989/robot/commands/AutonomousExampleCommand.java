package org.usfirst.frc.team1989.robot.commands;

import org.usfirst.frc.team1989.robot.Robot;
import org.usfirst.frc.team1989.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousExampleCommand extends CommandGroup {

    public AutonomousExampleCommand() {
    		requires(Robot.driveTrain);
    		requires(Robot.tower);
    		requires(Robot.boxArm);
    		addSequential(new AutoDrive(230, 1, 0, RobotMap.r1));
    		addSequential(new Delay(1));
    		addSequential(new AutoRotate(-45));
    		addSequential(new Delay(1));
    		addSequential(new AutoTower(2, 1));
    		addSequential(new Delay(1));
        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
