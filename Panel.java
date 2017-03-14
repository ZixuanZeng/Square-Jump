import java.awt.Graphics;

public class Panel implements Background{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graphics graph = null;
		Panel panel = new Panel();
		panel.displayTutorial();
		panel.paint(graph);
		panel.drawObstacles(0, 0, 1, graph, 2);
		panel.playBackgroundMusic();
		panel.playGameMusic();
		panel.run();
	}

	@Override
	public void displayTutorial() {
		// TODO Auto-generated method stub
		System.out.println("Testing displayTutorial");
	}

	@Override
	public void playBackgroundMusic() {
		// TODO Auto-generated method stub
		System.out.println("Testing playBackgroundMusic");
	}

	@Override
	public void playGameMusic() {
		// TODO Auto-generated method stub
		System.out.println("Testing playGameMusic");
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		System.out.println("Testing paint");
	}

	@Override
	public void drawObstacles(int x, int y, int sizeLenght, Graphics g, int type) {
		// TODO Auto-generated method stub
		System.out.println("Testing drawObstacles");
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Testing run");
	}

}
