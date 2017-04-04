
public interface Movable {
    public static final int Speed = 6; // smaller is faster
    public static final int JumpDistance = 30;
	
    public void setStartTime(int time);
    public void setTime(int time);
    public void moveByGravity();
    public void moveLeft();
    public void moveRight();
}
