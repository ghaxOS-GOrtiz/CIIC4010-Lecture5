import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JComponent;

public class CarStage extends JComponent {

	private static final long serialVersionUID = 1L;

	static int counter = 0;
	
	MutableCar[] cars;

//	MutableCar theCar1 = new MutableCar(0, 10, Color.BLUE, 5, 1, 1);
//	MutableCar theCar2 = new MutableCar(0, 60, Color.RED, 5, 1, 2);
//	MutableCar theCar3 = new MutableCar(0, 110, Color.YELLOW, 5, 1, 3);
//	MutableCar theCar4 = new MutableCar(0, 160, Color.BLUE, 5, 1, 4);
//	MutableCar theCar5 = new MutableCar(0, 210, Color.RED, 5, 1, 5);
//	MutableCar theCar6 = new MutableCar(0, 260, Color.YELLOW, 5, 1, 6);
//	MutableCar theCar7 = new MutableCar(0, 310, Color.BLUE, 5, 1, 7);
//	MutableCar theCar8 = new MutableCar(0, 360, Color.RED, 5, 1, 8);
//	MutableCar theCar9 = new MutableCar(0, 410, Color.YELLOW, 5, 1, 9);
//	MutableCar theCar10 = new MutableCar(0, 460, Color.BLUE, 5, 1, 10);
//	MutableCar theCar11 = new MutableCar(0, 510, Color.RED, 5, 1, 11);
//	MutableCar theCar12 = new MutableCar(0, 560, Color.YELLOW, 5, 1, 12);

	boolean onAWall = false;
	
	boolean someCarWon = false;

	boolean carReachedBottom = false;

	Random randomNumbers = new Random();

		
	public CarStage(long frame) {
		
		int laneHeight = 50;
		int numberOfLanes = Math.round(frame / laneHeight) - 1;
		//Make sure that numberOfLanes fit the frame
		cars = new MutableCar[numberOfLanes];
		
		int nextYPos = 0;
		for (int i=0; i < numberOfLanes; i++) {
			cars[i] = new MutableCar(0, nextYPos, Color.BLUE, 10, 1, i);
			nextYPos += laneHeight;
		}
		
	}
	
	public boolean someCarWon() { return someCarWon; }

	public void paintComponent (Graphics g) {

		for (MutableCar car : cars) {
			car.draw(g);
			int deltaXCar = randomNumbers.nextInt(car.getHorizontalSpeed());
			car.moveInX(deltaXCar);
			if (car.getXPos() + 60 >= this.getWidth()) {
				//Car  hits the wall
				car.setPosition(this.getWidth(), car.getYPos());
				someCarWon = true;
			}
		}
//		theCar1.draw(g);
//		theCar2.draw(g);
//		theCar3.draw(g);
//		theCar4.draw(g);
//		theCar5.draw(g);
//		theCar6.draw(g);
//		theCar7.draw(g);
//		theCar8.draw(g);
//		theCar9.draw(g);
//		theCar10.draw(g);
//		theCar11.draw(g);
//		theCar12.draw(g);
//		
//		int deltaXCar1 = randomNumbers.nextInt(theCar1.getHorizontalSpeed());
//		int deltaXCar2 = randomNumbers.nextInt(theCar2.getHorizontalSpeed());
//		int deltaXCar3 = randomNumbers.nextInt(theCar3.getHorizontalSpeed());
//		int deltaXCar4 = randomNumbers.nextInt(theCar4.getHorizontalSpeed());
//		int deltaXCar5 = randomNumbers.nextInt(theCar5.getHorizontalSpeed());;
//		
//		theCar1.moveInX(deltaXCar1);
//		theCar2.moveInX(deltaXCar2);
//		theCar3.moveInX(deltaXCar3);
//		theCar4.moveInX(deltaXCar4);
//		theCar5.moveInX(deltaXCar5);
//		theCar6.moveInX(theCar3.getHorizontalSpeed());
//		theCar7.moveInX(theCar1.getHorizontalSpeed());
//		theCar8.moveInX(theCar2.getHorizontalSpeed());
//		theCar9.moveInX(theCar3.getHorizontalSpeed());
//		theCar10.moveInX(theCar1.getHorizontalSpeed());
//		theCar11.moveInX(theCar2.getHorizontalSpeed());
//		theCar12.moveInX(theCar3.getHorizontalSpeed());
//		
//		if(theCar1.getXPos() + 60 >= this.getWidth()) {
//			//Car 1 hit the wall
//			theCar1.setPosition(this.getWidth() - 60, theCar1.getYPos());
//			someCarWon = true;
//		}
//		if(theCar2.getXPos() + 60 >= this.getWidth()) {
//			//Car 1 hit the wall
//			theCar2.setPosition(this.getWidth() - 60, theCar2.getYPos());
//			someCarWon = true;
//		}
//		if(theCar3.getXPos() + 60 >= this.getWidth()) {
//			//Car 1 hit the wall
//			theCar3.setPosition(this.getWidth() - 60, theCar3.getYPos());
//			someCarWon = true;
//		}
//		if(theCar4.getXPos() + 60 >= this.getWidth()) {
//			//Car 1 hit the wall
//			theCar4.setPosition(this.getWidth() - 60, theCar4.getYPos());
//			someCarWon = true;
//		}
//		if(theCar1.getXPos() + 60 >= this.getWidth()) {
//			//Car 1 hit the wall
//			theCar1.setPosition(this.getWidth() - 60, theCar1.getYPos());
//			someCarWon = true;
//		}
//		if(theCar1.getXPos() + 60 >= this.getWidth()) {
//			//Car 1 hit the wall
//			theCar1.setPosition(this.getWidth() - 60, theCar1.getYPos());
//			someCarWon = true;
//		}
//		if (onAWall) {
//			if (theCar1.getYPos()+70 > this.getHeight()) {
//				// Car reached bottom
//				carReachedBottom = true;
//				return;
//			}
//			theCar1.setPosition(theCar1.getXPos(), theCar1.getYPos()+40);
//			theCar1.setHorizontalDirection(theCar1.getHorizontalDirection()*-1);
//			onAWall = false;
//		}
//		else {
//			if (theCar1.getXPos() + 60 >= this.getWidth() && theCar1.getHorizontalDirection()>0) {
//				// Car would hit right wall
//				theCar1.setPosition(this.getWidth()-60, theCar1.getYPos());
//				//theCar.setHorizontalDirection(-1);
//				onAWall = true;
//			}
//			else if (theCar1.getXPos() <= 0 && theCar1.getHorizontalDirection() < 0) {
//				// Car would hit the left wall
//				theCar1.setPosition(0, theCar1.getYPos());
//				//theCar.setHorizontalDirection(1);
//				onAWall = true;
//			}
//			else {
//				theCar1.setPosition(
//						theCar1.getXPos()+(theCar1.getHorizontalDirection()*theCar1.getHorizontalSpeed()), 
//						theCar1.getYPos());
//			}
//		}
		System.out.println(counter++);
	}
}
