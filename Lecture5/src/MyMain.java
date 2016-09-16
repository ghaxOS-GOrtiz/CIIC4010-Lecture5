import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyMain
{
	public static void main(String[] args) throws InterruptedException
	{
		JFrame frame = new JFrame();
		frame.setSize(400, 400);
		CarStage theComponent = new CarStage(frame.getHeight());
		
		frame.add(theComponent);
		
		
		frame.setTitle("CIIC 4010 / ICOM 4015 Developers");	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		while(!theComponent.someCarWon()) {
			frame.repaint();
			Thread.sleep(10);
		}
		
		JOptionPane.showMessageDialog(null, "END OF RACE");
		
		System.exit(0);
		
	}
}
