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
	private MovableRectProxy _proxy;
	
	enum Direction {
		UP,
		DOWN,
		RIGHT,
		LEFT
	}

	public PaneOrganizer() {
		_root = new BorderPane();
		
		_proxy = new MovableRectProxy();	
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
		upButton.setOnAction(new MoveHandler(Direction.UP));
		GridPane.setHalignment(upButton, HPos.CENTER);
		buttonBox.add(upButton, 1, 0);
		
		Button downButton = new Button("Down");
		downButton.setOnAction(new MoveHandler(Direction.DOWN));
		GridPane.setHalignment(downButton, HPos.CENTER);
		buttonBox.add(downButton, 1, 2);

		Button rightButton = new Button("Right");
		rightButton.setOnAction(new MoveHandler(Direction.RIGHT));
		GridPane.setHalignment(rightButton, HPos.RIGHT);
		buttonBox.add(rightButton, 2, 1);
		
		Button leftButton = new Button("Left");
		leftButton.setOnAction(new MoveHandler(Direction.LEFT));
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
		rect1.getNode().setX(70);
		rect1.getNode().setY(100);
		rect1.getNode().setFill(Color.BISQUE);
		MovableRect rect2 = new MovableRect(_proxy);
		rect2.getNode().setX(300);
		rect2.getNode().setY(200);
		rect2.getNode().setFill(Color.CADETBLUE);
		
		Pane rectPane = new Pane();
		rectPane.getChildren().addAll(rect1.getNode(), rect2.getNode());
		_root.getChildren().add(rectPane);
		
		_proxy.setRectangle(rect1);
	}

	private class MoveHandler implements EventHandler<ActionEvent> {
		
		Direction _direction;
		
		public MoveHandler(Direction direction) {
			_direction = direction;
		}
		
		public void handle(ActionEvent event) {
			switch(_direction) {
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
		
		public void handle (ActionEvent event) {
			System.exit(0);
		}
	}
}
