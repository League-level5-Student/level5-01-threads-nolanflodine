package _02_Advanced_Robot_Race;

import java.util.Random;

import org.jointheleague.graphical.robot.Robot;

public class AdvancedRobotRace {
	static // Re-do the robot race recipe from level 3 module 0. 
	// This time, use threads to make all of the robots go at the same time.
	Robot[] r = new Robot[5];

	public static void main(String[] args) {
		
		// 2. create an array of 5 robots.
		// 3. use a for loop to initialize the robots.
		for (int i = 0; i < r.length; i++) {
			r[i] = new Robot();
			r[i].setSpeed(100);
		}
		// 4. make each robot start at the bottom of the screen, side by side, facing up
		r[0].setX(50);
		r[0].setY(452);
		r[1].setX(150);
		r[1].setY(452);
		r[2].setX(250);
		r[2].setY(452);
		r[3].setX(350);
		r[3].setY(452);
		r[4].setX(450);
		r[4].setY(452);
		// 5. use another for loop to iterate through the array and make each robot move
		// a random amount less than 50.
		AdvancedRobotRace ARR = new AdvancedRobotRace();
		Thread r0 = new Thread(()->ARR.meth(r[0]));
		Thread r1 = new Thread(()->ARR.meth(r[1]));
		Thread r2 = new Thread(()->ARR.meth(r[2]));
		Thread r3 = new Thread(()->ARR.meth(r[3]));
		Thread r4 = new Thread(()->ARR.meth(r[4]));
		r0.start();
		r1.start();
		r2.start();
		r3.start();
		r4.start();
	}
	public void meth(Robot rob) {
		boolean stop = false;
		Random rand = new Random();
		for (int j = 0; j < 9999; j++) {
			for (int i = 0; i < r.length; i++) {
				if (stop == false) {
					if (rob.getY() >= 50) {
						rob.move(rand.nextInt(50));
						rob.turn(5);
						if (rob.getY() >= 450 && rob.getY() <= 500 && rob.getX() < 400) {
							rob.turn(999);
							stop = true;
						}
					}
				}
			}
		}
	}
}
