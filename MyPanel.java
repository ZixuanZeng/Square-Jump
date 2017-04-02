import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyPanel extends JApplet implements Background, ActionListener{
	
	JLabel text;
	JToggleButton button1, button2, button3, button4;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graphics graph = null;
		MyPanel panel = new MyPanel();
		panel.setLayout(null);
		panel.displayTutorial();
		panel.paint(graph);
		panel.drawObstacles(0, 0, 1, graph, 2);
		panel.playBackgroundMusic();
		panel.playGameMusic();
		panel.run();
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new MyPanel();
				//new MyPanel().makeGUI();
			}
		});
	}
	
	MyPanel(){
		JFrame game = new JFrame  ("A game similar to Doodle Jump ---- Square-Jump");
		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel myPanel = new JPanel();
		myPanel.setOpaque(true);
		myPanel.setBackground(Color.BLACK);
		myPanel.setLayout(null);
		
		JLabel gameName = new JLabel("Welcom to    Square Jump", JLabel.CENTER);
		gameName.setSize(1000, 30);
        gameName.setLocation(5, 5);
		gameName.setFont(new Font("Courier New", Font.ITALIC, 30));
	    gameName.setForeground(Color.BLUE);
	    
	    button1 = new JToggleButton("Start");
	    button1.setSize(100, 30);
        button1.setLocation(400, 200);
        
        button2 = new JToggleButton("Tutorial");
        button2.setSize(100,30);
        button2.setLocation(400,300);
        
        button3 = new JToggleButton("Score Board");
        button3.setSize(100,30);
        button3.setLocation(400,400);
        
        button4 = new JToggleButton("Quit");
        button4.setSize(100,30);
        button4.setLocation(400,500);
        
	    myPanel.add(button1);
	    myPanel.add(button2);
	    myPanel.add(button3);
	    myPanel.add(button4);
	    myPanel.add(gameName);
	    game.setContentPane(myPanel);
	    game.setSize(1000,800);
	    //game.setLocationByPlatform(true);
		//game.setLayout(new FlowLayout());
	    //game.add(gameName);
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
		text = new JLabel ("Start game!");
		button1 = new JToggleButton("Start");
		button1.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent ie){
				if(button1.isSelected()){
					text.setText("Start game!");
				}
			}
		});
		
		add(button1);
		add(text);
	}

	@Override
	public void displayTutorial() {
		// TODO Auto-generated method stub
		System.out.println("Testing displayTutorial");
	}

	@Override
	public void playBackgroundMusic() {
		// TODO Auto-generated method stub
		System.out.println("Testing playBackgroundMusic");
	}

	@Override
	public void playGameMusic() {
		// TODO Auto-generated method stub
		System.out.println("Testing playGameMusic");
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		System.out.println("Testing paint");
	}

	@Override
	public void drawObstacles(int x, int y, int sizeLenght, Graphics g, int type) {
		// TODO Auto-generated method stub
		System.out.println("Testing drawObstacles");
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Testing run");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
