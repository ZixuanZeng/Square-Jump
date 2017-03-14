import java.awt.Graphics;
public interface Background {
	// if there are some variables
	void displayTutorial();
	void playBackgroundMusic();
	void playGameMusic();
	void paint(Graphics g);
	void drawObstacles(int x, int y, int sizeLenght, Graphics g,
			int type);
	void run();
	
}
