
public class MovableRectProxy {
	
	private MovableRect _movingRectangle;
	
	public MovableRectProxy() {
		/* Constructor doesn't need to do anything because PaneOrganizer will call setHexagon(...)*/
	}
	
	public void setRectangle(MovableRect rect) {
		_movingRectangle = rect;
	}
	
	public void moveUp() {
		_movingRectangle.moveUp();
	}
	
	public void moveDown() {
		_movingRectangle.moveDown();
	}
	
	public void moveRight() {
		_movingRectangle.moveRight();
	}
	
	public void moveLeft() {
		_movingRectangle.moveLeft();
	}
}
