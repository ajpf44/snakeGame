package gameInterface;


import javax.swing.JFrame;

public class GameWindow {
	public  int width = 900;
	public  int height = 800;
	
	public JFrame createWindow() {
		JFrame frame = new JFrame();
		frame.setTitle("Snake Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(this.width, this.height);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		return frame;
	}
	
	
}
