import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
 
 
public class GameBackground extends Application {
	// private class constant and some variables
	private static final int FPS = 25;
    private static final Integer STARTTIME = 0;
    private static final int Width = 400;
    private static final int Height = 700;
    
    private Timeline timeline;
    private Integer timeFrames = STARTTIME;
    private GamePanel gamePanel;
    
 
    public static void main(String[] args) {
        Application.launch(args);
    }
 
    @Override
    public void start(Stage primaryStage) {
 
        // Setup the Stage and the Scene (the scene graph)
        primaryStage.setTitle("Square Jump");
        Group root = new Group();
        Scene scene = new Scene(root, Width, Height);
        Canvas canvas = new Canvas(Width, Height);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gamePanel = new GamePanel(Width, Height);
 
        // Create and configure the Button
        Button button = new Button();
        button.setText("pause");
        
        if (timeline != null) {
            timeline.stop();
        }
        timeFrames = STARTTIME;
        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(
                new KeyFrame(Duration.millis(1000/FPS),
                  event -> {
					// TODO Auto-generated method stub
					timeFrames++;
				    drawShapes(gc);
				}));
        timeline.playFromStart();
 
        // Create and configure VBox
        // gap between components is 20
        VBox vb = new VBox(20);
        // center the components within VBox
        vb.setAlignment(Pos.CENTER);
        // Make it as wide as the application frame (scene)
        vb.setPrefWidth(scene.getWidth());
        // Move the VBox down a bit
        vb.setLayoutY(30);
        // Add the button and timerLabel to the VBox
        vb.getChildren().addAll(button, canvas);
        // Add the VBox to the root component
        root.getChildren().add(vb);
 
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void drawShapes(GraphicsContext gc) {
    	gc.clearRect(0, 0, Width, Height);
    	for(Shape shape : gamePanel.getElements()) {
    		if(shape instanceof Square || shape instanceof Platform) {
    			gc.setFill(shape.getColor());
    			gc.fillRect(shape.getXPos(), shape.getYPos(), shape.getWidth(), shape.getHeight());
    		}         
    	}
    }
}