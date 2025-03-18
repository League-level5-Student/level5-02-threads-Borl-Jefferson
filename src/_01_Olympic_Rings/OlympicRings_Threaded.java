package _01_Olympic_Rings;

import org.jointheleague.graphical.robot.Robot;

import java.awt.Color;
import java.awt.Graphics; 
import java.awt.Graphics2D;
import java.util.Iterator;

public class OlympicRings_Threaded {
	// Make A Program that uses Threads and robots to draw the Olympic rings. One robot should draw one ring simultaneously with the other 4 robots.
	public static void main(String[] args) {
		Robot rob1 = new Robot( 50,945);
		Robot rob2 = new Robot(150,945);
		Robot rob3 = new Robot(250,945);
		Robot rob4 = new Robot(350,945);
		Robot rob5 = new Robot(450,945);
	/*	rob1.moveTo(350, 400);
		rob2.moveTo(500, 550);
		rob3.moveTo(650, 400);
		rob4.moveTo(800, 550);
		rob5.moveTo(950, 400);
		*/
		rob1.setSpeed(5);
		rob1.setPenColor(Color.blue);
		rob1.setPenWidth(9);
		
		rob2.setSpeed(4);
		rob2.setPenColor(Color.yellow);
		rob2.setPenWidth(9);

		rob3.setSpeed(5);
		rob3.setPenColor(Color.black);
		rob3.setPenWidth(9);
		
		rob4.setSpeed(4);
		rob4.setPenColor(Color.green);
		rob4.setPenWidth(9);
		
		rob5.setSpeed(5);
		rob5.setPenColor(Color.red);
		rob5.setPenWidth(9);
		
		Thread m1 = new Thread(() -> rob1.moveTo(350, 400));
		Thread m2 = new Thread(() -> rob2.moveTo(500, 550));
		Thread m3 = new Thread(() -> rob3.moveTo(650, 400));
		Thread m4 = new Thread(() -> rob4.moveTo(800, 550));
		m1.start();
		m2.start();
		m3.start();
		m4.start();
		rob5.moveTo(950, 400);
		
		Thread r1 = new Thread(() -> robrotate(rob1));
		Thread r2 = new Thread(() -> robrotate(rob2));
		Thread r3 = new Thread(() -> robrotate(rob3));
		Thread r4 = new Thread(() -> robrotate(rob4));
		Thread r5 = new Thread(() -> robrotate(rob5));
		
		r1.start();
		r2.start();
		r3.start();
		r4.start();
		r5.start();
	
	}
	public static void robrotate(Robot r) {
		r.penDown();
		for(int i=0; i < 359; i++) {
				r.turn(1);
		r.move(2);
		}
	r.penUp();
	}

}

