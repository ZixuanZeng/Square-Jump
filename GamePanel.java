import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class GamePanel {
	private List<Shape> Elements = new ArrayList<Shape>();
	private List<Integer> UsedRows;
	private int Time;
	private int Width;
	private int Height;
	private Square s;
	private Collision collision;
	
	public GamePanel(int width, int height) {
		Time = 0;
		Random rand = new Random();
		UsedRows = new ArrayList<Integer>(height/20);
		Width = width;
		Height = height;
		for(int i = 0; i < height/20; i++) {
			UsedRows.add(0); // set to unused
			if(i%3 == 0) {
				Platform p = new Platform(rand.nextInt(width-50), i*20);
				Elements.add(p);
				UsedRows.set(i, 1);
			}
		}
		s = new Square(width/2, height-20, Time);
		Elements.add(s);
		collision = new CollisionEvent(Elements);
	}
	
	public void setTime(int time) {
		Time = time;
		for(Shape s : Elements) {
			if(s instanceof Square) {
				Square square = (Square)s;
				if(collision.checkCollision()) square.setStartTime(time);
				square.setTime(Time);
			}
		}
	}
	
	public List<Shape> getElements() {
		return Elements;
	}
	
	public Square getSquare(){
		return s;
	}
	
    
}
