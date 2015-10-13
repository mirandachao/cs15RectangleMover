import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class PaneOrganizer {
	
	private BorderPane _root;
	private Pane _rectPane;
	private RectangleProxy _proxy;
	
	enum Directions {
		UP,
		DOWN,
		RIGHT,
		LEFT
	}

	public PaneOrganizer() {
		_root = new BorderPane();
		_rectPane = new Pane();
		
		_root.getChildren().add(_rectPane);
		
		_proxy = new RectangleProxy();	
		this.setUpRectangles();
		this.setUpButtons();
	}
	
	public Pane getRoot() {
		return _root;
	}
	
	private void setUpButtons() {
		GridPane buttonBox = new GridPane();
		buttonBox.setAlignment(Pos.CENTER);
		
		Button upButton = new Button("Up");
		upButton.setOnAction(new MoveHandler(Directions.UP));
		GridPane.setHalignment(upButton, HPos.CENTER);
		buttonBox.add(upButton, 1, 0);
		
		Button downButton = new Button("Down");
		downButton.setOnAction(new MoveHandler(Directions.DOWN));
		GridPane.setHalignment(downButton, HPos.CENTER);
		buttonBox.add(downButton, 1, 2);

		Button rightButton = new Button("Right");
		rightButton.setOnAction(new MoveHandler(Directions.RIGHT));
		GridPane.setHalignment(rightButton, HPos.RIGHT);
		buttonBox.add(rightButton, 2, 1);
		
		Button leftButton = new Button("Left");
		leftButton.setOnAction(new MoveHandler(Directions.LEFT));
		GridPane.setHalignment(leftButton, HPos.LEFT);
		buttonBox.add(leftButton, 0, 1);
		
		Button quitButton = new Button("Quit");
		quitButton.setOnAction(new QuitHandler());
		GridPane.setHalignment(quitButton, HPos.CENTER);
		GridPane.setMargin(quitButton, new Insets(30));
		buttonBox.add(quitButton, 1, 3);	
		
		_root.setBottom(buttonBox);
		
	}
	
	private void setUpRectangles() {
		MovableRect rect1 = new MovableRect(_proxy);
		rect1.getRect().setX(70);
		rect1.getRect().setY(100);
		rect1.getRect().setFill(Color.BISQUE);
		MovableRect rect2 = new MovableRect(_proxy);
		rect2.getRect().setX(300);
		rect2.getRect().setY(200);
		rect2.getRect().setFill(Color.CADETBLUE);
		_rectPane.getChildren().addAll(rect1.getRect(), rect2.getRect());
		
		_proxy.setRectangle(rect1);
	}

	private class MoveHandler implements EventHandler<ActionEvent> {
		
		Directions _directions;
		
		public MoveHandler(Directions direction) {
			this._directions = direction;
		}
		
		public void handle(ActionEvent event) {
			switch(_directions) {
				case UP:
					_proxy.moveUp();
					break;
				case DOWN:
					_proxy.moveDown();
					break;
				case RIGHT:
					_proxy.moveRight();
					break;
				default:
					_proxy.moveLeft();
					break;
			}
		}
		
	}
	
	private class QuitHandler implements EventHandler<ActionEvent> {
		
		public QuitHandler() {
			
		}
		
		public void handle (ActionEvent event) {
			System.exit(0);
		}
	}
}
