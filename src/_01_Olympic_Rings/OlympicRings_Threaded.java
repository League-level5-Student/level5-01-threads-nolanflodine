package _01_Olympic_Rings;

import java.awt.Color;

import org.jointheleague.graphical.robot.Robot;

public class OlympicRings_Threaded {
	// Make A Program that uses Threads and robots to draw the Olympic rings. One
	// robot should draw one ring simultaneously with the other 4 robots.
	public static void main(String[] args) {
		Robot blue = new Robot("batman");
		Robot black = new Robot("batman");
		Robot red = new Robot("batman");
		Robot yellow = new Robot("batman");
		Robot green = new Robot("batman");
		OlympicRings_Threaded OR = new OlympicRings_Threaded();
		OR.start(blue, 300, 300, Color.blue);
		OR.start(black, 600, 300, Color.black);
		OR.start(red, 900, 300, Color.red);
		OR.start(yellow, 450, 420, Color.yellow);
		OR.start(green, 750, 420, Color.green);
		Thread r1 = new Thread(()->OR.circle(blue));
		Thread r2 = new Thread(()->OR.circle(black));
		Thread r3 = new Thread(()->OR.circle(red));
		Thread r4 = new Thread(()->OR.circle(yellow));
		Thread r5 = new Thread(()->OR.circle(green));
		r1.start();
		r2.start();
		r3.start();
		r4.start();
		r5.start();
	}

	public void start(Robot r, int x, int y, Color c) {
		r.moveTo(x, y);
		r.penDown();
		r.setPenColor(c);
	}

	public void circle(Robot r) {
		for (int i = 0; i < 360; i++) {
			r.move(2);
			r.turn(1);
		}
	}
}
