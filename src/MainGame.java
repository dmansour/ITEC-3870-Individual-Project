import javax.swing.JFrame;

public class MainGame
{
	static DrawSnake snake = new DrawSnake();
	static Food f = new Food();
	
	public static void main(String[] args)
	{
		new MainGame();
		
		JFrame frame = new JFrame();
		
		frame.setTitle("Snake");
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		
		
		frame.add(snake);
		frame.addKeyListener(snake);
		

		System.out.println(checkCollision());
		System.out.println(f.getBounds());
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
				Thread.sleep(50);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public static boolean checkCollision()
	{
		return f.getBounds().intersects(snake.getBounds());
	}

}