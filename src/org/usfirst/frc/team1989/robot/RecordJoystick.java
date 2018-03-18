package org.usfirst.frc.team1989.robot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import edu.wpi.first.wpilibj.Timer;

public class RecordJoystick {
	
	JsScaled driveStick;
	JsScaled uStick;
	
	Map <Double, ArrayList<Double>> autoXValues = new HashMap <Double, ArrayList<Double>>();
	Map <Double, ArrayList<Double>> autoYValues = new HashMap <Double, ArrayList<Double>>();
	Map <Double, ArrayList<Double>> autoZValues = new HashMap <Double, ArrayList<Double>>();
	Map <Double, ArrayList<Double>> autoTowerValues = new HashMap <Double, ArrayList<Double>>();
	
	ArrayList<Double> driveXInfo = new ArrayList<Double>();
	ArrayList<Double> driveYInfo = new ArrayList<Double>();
	ArrayList<Double> driveZInfo = new ArrayList<Double>();
	ArrayList<Double> towerYInfo = new ArrayList<Double>();
	
	
	double driveX;
	double driveY;
	double driveTwist;
	double towerY;
	
	Timer totalTime = new Timer();
	Timer timeDrivedX = new Timer();
	Timer timeDrivedY = new Timer();
	Timer timeDrivedTwist = new Timer();
	Timer timeTowerY = new Timer();
	
	public RecordJoystick(JsScaled driveStick, JsScaled uStick) {
		this.driveStick = driveStick;
		this.uStick = uStick;
		totalTime.start();
	}
	
	public void recordJoystickValue() {
		driveXInfo.clear();
		driveYInfo.clear();
		driveZInfo.clear();
		towerYInfo.clear();
		
		driveX = driveStick.sgetX();
		driveY = driveStick.sgetY();
		driveTwist = driveStick.sgetTwist();
		towerY = uStick.sgetY();
		
		timerController(driveX, timeDrivedX);
		timerController(driveY, timeDrivedY);
		timerController(driveTwist, timeDrivedTwist);
		timerController(towerY, timeTowerY);
		
		driveXInfo.add(driveX);
		driveXInfo.add(timeDrivedX.get());
		
		driveYInfo.add(driveY);
		driveYInfo.add(timeDrivedY.get());
		
		driveZInfo.add(driveTwist);
		driveZInfo.add(timeDrivedTwist.get());
		
		towerYInfo.add(towerY);
		towerYInfo.add(timeTowerY.get());
		
		autoXValues.put(totalTime.get(), driveXInfo);
		autoYValues.put(totalTime.get(), driveYInfo);
		autoZValues.put(totalTime.get(), driveZInfo);
		autoTowerValues.put(totalTime.get(), towerYInfo);
	}
	
	public void timerController(double driveStickValue, Timer timer) {
		if(driveStickValue > 0 && timer.get() == 0) {
			timer.start();
		}
		
		if(driveStickValue == 0 && timer.get() == 0) {
			timer.stop();
			timer.reset();
		}
	}
	
	public void resetTimer() {
		totalTime.stop();
		totalTime.reset();
	}
}


