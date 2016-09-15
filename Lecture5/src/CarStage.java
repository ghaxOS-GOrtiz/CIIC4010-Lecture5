import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class CarStage extends JComponent {

	private static final long serialVersionUID = 1L;

	static int counter = 0;

	MutableCar theCar = new MutableCar(0, 0, Color.BLUE, 5, 1);

	boolean onAWall = false;

	boolean carReachedBottom = false;

	public boolean getReachedBottom() { return carReachedBottom; }

	public void paintComponent (Graphics g) {

		theCar.draw(g);

		if (onAWall) {
			if (theCar.getYPos()+70 > this.getHeight()) {
				// Car reached bottom
				carReachedBottom = true;
				return;
			}
			theCar.setPosition(theCar.getXPos(), theCar.getYPos()+40);
			theCar.setHorizontalDirection(theCar.getHorizontalDirection()*-1);
			onAWall = false;
		}
		else {
			if (theCar.getXPos() + 60 >= this.getWidth() && theCar.getHorizontalDirection()>0) {
				// Car would hit right wall
				theCar.setPosition(this.getWidth()-60, theCar.getYPos());
				//theCar.setHorizontalDirection(-1);
				onAWall = true;
			}
			else if (theCar.getXPos() <= 0 && theCar.getHorizontalDirection() < 0) {
				// Car would hit the left wall
				theCar.setPosition(0, theCar.getYPos());
				//theCar.setHorizontalDirection(1);
				onAWall = true;
			}
			else {
				theCar.setPosition(
						theCar.getXPos()+(theCar.getHorizontalDirection()*theCar.getHorizontalSpeed()), 
						theCar.getYPos());
			}
		}
		System.out.println(counter++);
	}
}
