import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class MyPanel extends JApplet implements Background, ActionListener{
	
	JFrame game;
	JPanel myPanel;
	JLabel gameName;
	JToggleButton button1, button2, button3, button4;
	ScoreBoard score;
	private boolean started = false;
	private GameBackground gameBackground;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new MyPanel().makeGUI();;
				new GameBackground();
			}
		});
	}
	
	MyPanel(){
		
		game = new JFrame  ("A game similar to Doodle Jump ---- Square-Jump");
		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		myPanel = new JPanel();
		myPanel.setOpaque(true);
		myPanel.setBackground(Color.WHITE);
		myPanel.setLayout(null);
		
		gameName = new JLabel("Welcom to    Square Jump", JLabel.CENTER);
		gameName.setSize(1000, 30);
        gameName.setLocation(5, 5);
		gameName.setFont(new Font("Courier New", Font.ITALIC, 30));
	    gameName.setForeground(Color.BLUE);
	    myPanel.add(gameName);
	    score = new ScoreBoard();
	    
	    
	    button1 = new JToggleButton("Start");
	    button1.setSize(100, 30);
        button1.setLocation(400, 200);
        myPanel.add(button1);
        button1.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent arg0){
        		if(started) {
        			Stage primaryStage = new Stage();
        			//gameBackground.restart(primaryStage);
        		}
        		else {
        		new Thread() {
                    @Override
                    public void run() {
                        javafx.application.Application.launch(GameBackground.class);
                    }
                }.start();
                gameBackground = GameBackground.waitForGameBackground();
                started = true;
        		}
        	}
        });
        
        button2 = new JToggleButton("Control");
        button2.setSize(100,30);
        button2.setLocation(400,300);
        myPanel.add(button2);
        button2.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent arg0){
        		JOptionPane.showMessageDialog(null, "Press 'A' or 'D' to control.");
        	}
        });
        
        button3 = new JToggleButton("Score Board");
        button3.setSize(150,30);
        button3.setLocation(375,400);
        myPanel.add(button3);
        button3.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent arg0){
        		JOptionPane.showMessageDialog(null, "Your score is " + score.awardPoints());
        	}
        });
        
        button4 = new JToggleButton("Quit");
        button4.addActionListener(e->System.exit(0));
        button4.setSize(100,30);
        button4.setLocation(400,500);
        myPanel.add(button4);
        
	    game.setContentPane(myPanel);
	    game.setSize(1000,800);
		game.setVisible(true);
	}
	
	public void init(){
		try{
			SwingUtilities.invokeAndWait(new Runnable(){
				public void run(){
					makeGUI();
				}
			});
		}catch(Exception exc){
			System.out.println("Can't create because of" + exc);
		}
	}
	
	private void makeGUI(){
		setLayout(new FlowLayout());
		button1 = new JToggleButton("Start");
		button4 = new JToggleButton("Quit");
		button1.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent ie){
				if(button1.isSelected()){
					
				}
				
			}
		});
		
		button4.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent ie){
				if(button4.isSelected()){
					System.exit(0);
				}
				
			}
		});
		
		add(button1);
		add(button4);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void playBackgroundMusic() {
		// TODO Auto-generated method stub
		
	}

}
