import javax.swing.*;
import javax.swing.JFrame;

public class GameFrame extends JFrame{

   
    GameFrame(){
		this.add(new GamePanel());
		this.setTitle("Jogo da cobrinha");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	
	}



}