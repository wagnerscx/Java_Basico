import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class PainelDoJogo extends JPanel implements Runnable{

	static final int GAME_WIDTH = 1000;
	static final int GAME_HEIGHT = (int)(GAME_WIDTH * (0.5555));
	static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH,GAME_HEIGHT);
	static final int BALL_DIAMETER = 20;
	static final int PADDLE_WIDTH = 25;
	static final int PADDLE_HEIGHT = 100;
	Thread gameThread;
	Image image;
	Graphics graphics;
	Random random;
	Raquete raquete1;
	Raquete raquete2;
	Bola bola;
	Pontos score;
	
	PainelDoJogo(){
		newPaddles();
		newBall();
		score = new Pontos(GAME_WIDTH,GAME_HEIGHT);
		this.setFocusable(true);
		this.addKeyListener(new AL());
		this.setPreferredSize(SCREEN_SIZE);
		
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	public void newBall() {
		random = new Random();
		bola = new Bola((GAME_WIDTH/2)-(BALL_DIAMETER/2),random.nextInt(GAME_HEIGHT-BALL_DIAMETER),BALL_DIAMETER,BALL_DIAMETER);
	}
	public void newPaddles() {
		raquete1 = new Raquete(0,(GAME_HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT,1);
		raquete2 = new Raquete(GAME_WIDTH-PADDLE_WIDTH,(GAME_HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT,2);
	}
	public void paint(Graphics g) {
		image = createImage(getWidth(),getHeight());
		graphics = image.getGraphics();
		draw(graphics);
		g.drawImage(image,0,0,this);
	}
	public void draw(Graphics g) {
		raquete1.draw(g);
		raquete2.draw(g);
		bola.draw(g);
		score.draw(g);
Toolkit.getDefaultToolkit().sync(); // I forgot to add this line of code in the video, it helps with the animation

	}
	public void move() {
		raquete1.move();
		raquete2.move();
		bola.move();
	}
	public void checkCollision() {
		
		//bounce ball off top & bottom window edges
		if(bola.y <=0) {
			bola.setYDirection(-bola.yVelocity);
		}
		if(bola.y >= GAME_HEIGHT-BALL_DIAMETER) {
			bola.setYDirection(-bola.yVelocity);
		}
		//bounce ball off paddles
		if(bola.intersects(raquete1)) {
			bola.xVelocity = Math.abs(bola.xVelocity);
			bola.xVelocity++; //optional for more difficulty
			if(bola.yVelocity>0)
				bola.yVelocity++; //optional for more difficulty
			else
				bola.yVelocity--;
			bola.setXDirection(bola.xVelocity);
			bola.setYDirection(bola.yVelocity);
		}
		if(bola.intersects(raquete2)) {
			bola.xVelocity = Math.abs(bola.xVelocity);
			bola.xVelocity++; //optional for more difficulty
			if(bola.yVelocity>0)
				bola.yVelocity++; //optional for more difficulty
			else
				bola.yVelocity--;
			bola.setXDirection(-bola.xVelocity);
			bola.setYDirection(bola.yVelocity);
		}
		//stops paddles at window edges
		if(raquete1.y<=0)
			raquete1.y=0;
		if(raquete1.y >= (GAME_HEIGHT-PADDLE_HEIGHT))
			raquete1.y = GAME_HEIGHT-PADDLE_HEIGHT;
		if(raquete2.y<=0)
			raquete2.y=0;
		if(raquete2.y >= (GAME_HEIGHT-PADDLE_HEIGHT))
			raquete2.y = GAME_HEIGHT-PADDLE_HEIGHT;
		//give a player 1 point and creates new paddles & ball
		if(bola.x <=0) {
			score.player2++;
			newPaddles();
			newBall();
			System.out.println("Player 2: "+score.player2);
		}
		if(bola.x >= GAME_WIDTH-BALL_DIAMETER) {
			score.player1++;
			newPaddles();
			newBall();
			System.out.println("Player 1: "+score.player1);
		}
	}
	public void run() {
		//game loop
		long lastTime = System.nanoTime();
		double amountOfTicks =60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		while(true) {
			long now = System.nanoTime();
			delta += (now -lastTime)/ns;
			lastTime = now;
			if(delta >=1) {
				move();
				checkCollision();
				repaint();
				delta--;
			}
		}
	}
	public class AL extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			raquete1.keyPressed(e);
			raquete2.keyPressed(e);
		}
		public void keyReleased(KeyEvent e) {
			raquete1.keyReleased(e);
			raquete2.keyReleased(e);
		}
	}
}