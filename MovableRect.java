import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

public class MovableRect {
	
	private Rectangle _rectangle;
	private RectangleProxy _proxy;
	
	public MovableRect(RectangleProxy proxy) {
		_proxy = proxy;
		_rectangle = new Rectangle(100, 100);
		_rectangle.setOnMousePressed(new MouseHandler(this));
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
	
	public Rectangle getRect() {
		return _rectangle;
	}
	
	private class MouseHandler implements EventHandler<MouseEvent> {
		
		private MovableRect _rect;
		
		public MouseHandler(MovableRect rect) {
			_rect = rect;
		}
		
		public void handle(MouseEvent event) {
			_proxy.setRectangle(_rect);
		}
		
	}

}
