import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Screen extends JPanel
{
	static Snake snake = new Snake();
	static Food food = new Food();
	static int count = 0;
	static JLabel score;
	static ArrayList<Graphics> foodItems = new ArrayList<Graphics>();
	
	public Screen()
	{
		addKeyListener(snake);
		setFocusable(true);
		setBackground(Color.BLACK);
		setLayout(null);
	}
	
	public static JLabel addLabel()
	{
		score = new JLabel();
		
		score.setFont(new Font("Tahoma", Font.PLAIN, 15));
		score.setHorizontalAlignment(SwingConstants.CENTER);

		return score;
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		// Draws Food Object
		food.drawFood(g);

		// Draws Snake Object
		snake.drawSnake(g);
		
		// Moves the snake and determines if the snake touches the food
		try
		{
			snake.Move();
			collision();
			Thread.sleep(50);
			repaint();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
	public static int getScore()
	{
		return count;
	}
	
	public static void collision()
	{
		if(snake.getBounds().intersects(food.getBounds()))
		{
			count++;
		}
		
		score.setText("Score: " + getScore());
	}
}