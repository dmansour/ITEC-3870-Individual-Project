import javax.swing.JFrame;

public class GameMain extends JFrame
{
	
	public GameMain()
	{
		setTitle("Pacman Game");
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) 
	{
		new GameMain();
	}

}
