import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import java.util.concurrent.CountDownLatch;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
 
 
public class GameBackground extends Application {
	// private class constant and some variables
	private static final int FPS = 25;
    private static final Integer STARTTIME = 0;
    public static final int Width = 400;
    public static final int Height = 620;
    
    private Timeline timeline;
    private Integer timeFrames = STARTTIME;
    private GamePanel gamePanel;
    public Square s;
    
    public static final CountDownLatch latch = new CountDownLatch(1);
    public static GameBackground gameBackground = null;
    
    public GameBackground(){
    	setGameBackground(this);
    }
    
    public static GameBackground waitForGameBackground() {
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return gameBackground;
    }
    
    public static void setGameBackground(GameBackground gameBackground0) {
        gameBackground = gameBackground0;
        latch.countDown();
    }
 
    @Override
    public void start(Stage primaryStage) {
 
        // Setup the Stage and the Scene (the scene graph)
        primaryStage.setTitle("Square Jump");
        Group root = new Group();
        Scene scene = new Scene(root, Width, Height+80);
        Canvas canvas = new Canvas(Width, Height);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gamePanel = new GamePanel(Width, Height);
        s = gamePanel.getSquare();
 
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
					gamePanel.setTime(timeFrames);
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
        KeyPressed(scene, s);
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
    
    private void KeyPressed(Scene scene, Square s){
    	scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
    	      @Override public void handle(KeyEvent event) {
    	        switch (event.getCode()) {
    	        case A:
    	        	s.moveLeft();
    	        	System.out.println("Move left");
    	        	break;
    	        case D:
    	        	s.moveRight();
    	        	System.out.println("Move right");
    	        	break;
				default:
					break;
    	        }
    	      }
    	    });
    }
    
}
