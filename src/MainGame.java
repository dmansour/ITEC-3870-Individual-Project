import javax.swing.JFrame;

public class MainGame
{

	public static void main(String[] args)
	{
		MainGame game = new MainGame();
		DrawSnake snake = new DrawSnake();
		
		JFrame frame = new JFrame();
		
		frame.setTitle("Snake");
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);

		frame.add(snake);
		frame.addKeyListener(snake);
	}

}