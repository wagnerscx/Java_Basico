import java.awt.*;
import javax.swing.*;

public class GameFrame extends JFrame{

	PainelDoJogo panel;
	
	GameFrame(){
		panel = new PainelDoJogo();
		this.add(panel);
		this.setTitle(" Pong ");
		this.setResizable(false);
		this.setBackground(Color.blue);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}