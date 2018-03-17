package org.usfirst.frc.team1989.robot.commands.auto;

import org.usfirst.frc.team1989.robot.Robot;
import org.usfirst.frc.team1989.robot.commands.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CrossAutoLine extends CommandGroup {

    public CrossAutoLine() {
        requires(Robot.driveTrain);
        requires(Robot.boxArm);
        
        addSequential(new AutoTimedDrive(3, 0, 0.5));
    }
}
