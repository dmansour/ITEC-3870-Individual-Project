import java.awt.BorderLayout;
import javax.swing.JFrame;

public class MainGame
{
	static Screen screen = new Screen();
	static JFrame frame;

	public static void main(String[] args)
	{
		MainGame game = new MainGame();
		frame = new JFrame();

		frame.setTitle("Snake");
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

		frame.add(screen);
		frame.add(BorderLayout.SOUTH, Screen.addLabel());

		frame.setVisible(true);
	}
}