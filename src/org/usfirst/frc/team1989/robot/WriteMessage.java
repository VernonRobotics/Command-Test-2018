package org.usfirst.frc.team1989.robot;


import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class WriteMessage {
	
	public Timer t1 = new Timer();
	
	public String[] msg = new String[10] ;
	public static String[] lastmsg = new String[10];
	//public static Boolean[] led = new Boolean[5];
	//public static Boolean[] lastled = new Boolean[5];
	
	public WriteMessage() {
		
		for (int i = 0; i < 10; i++) {
			msg[i] = "";
		
			lastmsg[i] = "";
			SmartDashboard.putString("DB/String " + i, "");
			/*if (i < 5) {
				led[i] = false;
				lastled[i] = false;
				SmartDashboard.putBoolean("DB/LED " + i, false);
			}*/
		} 
		t1.start();
	}
	
	public void setmessage(int index, String msg) {
		this.msg[index] = msg;
	}

	/*public void setboolean(int index, Boolean b) {
		led[index] = b;
	}*/

	public void updatedash() {
		String curr ;
		String last;
		//boolean lastled;
		//boolean currled;
		if (t1.get() > .25) {
			t1.reset();
			t1.start();

			for (int i = 0; i < 10; i++) {
				curr = msg[i].toString();
				last = lastmsg[i].toString();
				
				if (!(curr.equals(last.toString()))) {
					SmartDashboard.putString("DB/String " + i, curr);
					lastmsg[i] = curr;
				}
				/*if (i < 5) {
					lastled = lastled[i].booleanValue();
					currled = led[i].booleanValue();
					if (currled != lastled) {
						SmartDashboard.putBoolean("DB/LED " + i, currled);
						lastled[i] = currled;
					}
				}*/
			}
		}

	}
}
