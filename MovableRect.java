import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

public class MovableRect {
	
	private Rectangle _rectangle;
	private MovableRectProxy _proxy;
	
	public MovableRect(MovableRectProxy proxy) {
		_proxy = proxy;
		_rectangle = new Rectangle(100, 100);
		_rectangle.setOnMousePressed(new MouseHandler());
	}
	
	public void moveUp() {
		_rectangle.setY(_rectangle.getY() - 10);
	}
	
	public void moveDown() {
		_rectangle.setY(_rectangle.getY() + 10);
	}
	
	public void moveRight() {
		_rectangle.setX(_rectangle.getX() + 10);
	}
	
	public void moveLeft() {
		_rectangle.setX(_rectangle.getX() - 10);
	}
	
	public Rectangle getNode() {
		return _rectangle;
	}
	
	private class MouseHandler implements EventHandler<MouseEvent> {
		
		public void handle(MouseEvent event) {
			_proxy.setRectangle(MovableRect.this);
		}
		
	}

}
