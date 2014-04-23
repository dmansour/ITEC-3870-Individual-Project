import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MainGame extends Thread
{
	static Random r = new Random();
	static Snake snake = new Snake();
	static Food food = new Food();
	boolean collision = false;
	static JFrame frame;
	static JLabel label;
	static int count;
	
	public static void main(String[] args)
	{
		MainGame game = new MainGame();
		frame = new JFrame();
		label = new JLabel("Score: ");
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		
		frame.setTitle("Snake");
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

		frame.add(snake);
		frame.add(BorderLayout.SOUTH, label);
		frame.addKeyListener(snake);

		frame.setVisible(true);
		
		System.out.println(food.getBounds());
		System.out.println(snake.getBounds());
		moveSnake();
	}

	public static void moveSnake()
	{
		while (true)
		{
			try
			{
				snake.Move();
				collision();
				Thread.sleep(50);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
	public void start(){
		new Thread(this).start();
	}
	public static void collision()
	{
		if(snake.getBounds().contains(food.getBounds()))
		{
			count++;
		}

		label.setText("Score: " + count + "");
	}
}