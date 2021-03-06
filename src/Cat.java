import javax.swing.JPanel;
import java.awt.*;
import java.awt.geom.*;

public class Cat {
	// drawing constants are private - noone needs to know what we're doing
	// pick a head dimension
	private static final int HEAD_DIMENSION = 200;
	// eyes will be about 1/4 from top of head and 1/4 from left
	private static final int EYE_Y = HEAD_DIMENSION/4 - 5;
	private static final int EYE_X = HEAD_DIMENSION/4 + 5;
	private static final int EYE_SEPARATION = HEAD_DIMENSION/3;
	// pick eye dimensions
	private static final int EYE_HEIGHT = 40;
	private static final int EYE_WIDTH = 20;
	// pick mouth height, width is based on head dimension
	private static final int MOUTH_HEIGHT = 20;
	private static final int MOUTH_WIDTH = HEAD_DIMENSION/2;
	// mouth starts about 40% from left edge of head
	private static final int MOUTH_X = HEAD_DIMENSION/4 * 1;
	private static final int MOUTH_Y = HEAD_DIMENSION/4 * 3;

	// draw will render the Cat on the Graphics object
	public void draw(Graphics g, int catX, int catY)
	{

		Graphics2D g2 = (Graphics2D) g;
		int x=catX;
		int y=catY;
		// Draw the head
		g2.setColor(Color.black);
		g2.fillOval(x, y, HEAD_DIMENSION, HEAD_DIMENSION);
		// Draw the eyes
		g2.setColor(Color.blue);
		x = catX + EYE_X; 
		y = catY + EYE_Y;
		g2.fillOval(x, y, EYE_WIDTH, EYE_HEIGHT);
		x += EYE_SEPARATION;
		g2.fillOval(x, y, EYE_WIDTH, EYE_HEIGHT);
		// Draw the mouth
		g2.setColor(Color.white);
		x = catX + MOUTH_X;
		y = catY + MOUTH_Y;
		g2.fillOval(x, y, MOUTH_WIDTH, MOUTH_HEIGHT);
		// Meow text appears below cat head, +10 places below 
		// so it doesn't overlap the drawing
		g2.setColor(Color.black);
		g2.drawString("Meow", catX, catY+HEAD_DIMENSION+10);	

		//draw whiskers
		g2.setColor(Color.PINK);
		
		g2.rotate(Math.toRadians(20), x-15 + MOUTH_WIDTH / 2, y-30 + MOUTH_HEIGHT / 4);
		g2.fillRect(x - 15, y - 30, MOUTH_WIDTH / 2, MOUTH_HEIGHT / 4);
		g2.rotate(Math.toRadians(-20), x-15 + MOUTH_WIDTH / 2, y-30 + MOUTH_HEIGHT / 4);
		g2.fillRect(x - 15, y - 30, MOUTH_WIDTH / 2, MOUTH_HEIGHT / 4);
		g2.rotate(Math.toRadians(-20), x-15 + MOUTH_WIDTH / 2, y-30 + MOUTH_HEIGHT / 4);
		g2.fillRect(x - 15, y - 30, MOUTH_WIDTH / 2, MOUTH_HEIGHT / 4);
		// add right whiskers
		g2.rotate(Math.toRadians(20), x-15 + MOUTH_WIDTH / 2, y-30 + MOUTH_HEIGHT / 4);
		g2.fillRect(x + 15 + MOUTH_WIDTH / 2, y - 30, MOUTH_WIDTH / 2, MOUTH_HEIGHT / 4);
		g2.rotate(Math.toRadians(20), x+15 + MOUTH_WIDTH / 2, y-30 + MOUTH_HEIGHT / 4);
		g2.fillRect(x + 15 + MOUTH_WIDTH / 2, y - 30, MOUTH_WIDTH / 2, MOUTH_HEIGHT / 4);
		g2.rotate(Math.toRadians(-40), x+15 + MOUTH_WIDTH / 2, y-30 + MOUTH_HEIGHT / 4);
		g2.fillRect(x + 15 + MOUTH_WIDTH / 2, y - 30, MOUTH_WIDTH / 2, MOUTH_HEIGHT / 4);
		
		// return rotation to normal
		g2.rotate(Math.toRadians(20), x+15 + MOUTH_WIDTH / 2, y-30 + MOUTH_HEIGHT / 4);
		
		// draw nose
		g2.setColor(Color.white);
		g2.rotate(Math.toRadians(45),x + MOUTH_WIDTH / 2, y + MOUTH_HEIGHT / 4 - 33);
		g2.fillRect(x + MOUTH_WIDTH / 2 - 5, y + MOUTH_HEIGHT / 4 - 5 - 33, 10, 10);
		
		// return rotation to normal
		g2.rotate(Math.toRadians(-45),x + MOUTH_WIDTH / 2, y + MOUTH_HEIGHT / 4 - 33);
		
		// draw ears
		g2.setColor(Color.black);
		g2.rotate(Math.toRadians(85), 213, 77);
		g2.fillRect(198, 62, 30, 30);
		
		x = catX;
		y = catY;
		g2.rotate(Math.toRadians(-85), 213, 77);
		
		g2.rotate(Math.toRadians(-85), 90, 75);
		g2.fillRect(75, 60, 30, 30);

	}
}
