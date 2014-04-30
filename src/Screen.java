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
	static JLabel scoreLabel;
	static ArrayList<Food> foodItems = new ArrayList<Food>();
	
	public Screen()
	{
		addKeyListener(snake);
		setFocusable(true);
		setBackground(Color.BLACK);
		setLayout(null);
	}

	public static JLabel addLabel()
	{
		scoreLabel = new JLabel();
		
		scoreLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);

		return scoreLabel;
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
	
	public void collision()
	{
		if (snake.getBounds().contains(food.getBounds()))
		{
			count++;
		}
		
		scoreLabel.setText("Score: " + getScore());

	}
}