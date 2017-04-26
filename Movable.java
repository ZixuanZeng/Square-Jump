
public interface Movable {
    public static final int Speed = 4; // smaller is faster
    public static final int JumpDistance = 25;
	
    public void setStartTime(int time);
    public void setTime(int time);
    public void moveByGravity();
    public void moveLeft();
    public void moveRight();
    public int getBackgroundMove();
}
