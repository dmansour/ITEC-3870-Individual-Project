import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JPanel;

public class DrawSnake extends JPanel implements KeyListener
{
	int x = 0;
	int y = 0;
	int dx = 0;
	int dy = 0;

	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public void moveDown()
	{
		dy += 5;
	}
	
	public void moveUp()
	{
		dy -= 5;
	}
	
	public void moveLeft()
	{
		dx -= 5;
	}
	
	public void moveRight()
	{
		dx += 5;
	}
	
	public void createDot(Graphics g)
	{
		Random r = new Random();
		
		g.setColor(Color.BLACK);
		
		g.fillOval(r.nextInt(10), r.nextInt(10), 8, 8);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		g.setColor(Color.ORANGE);
		
		g.fillRect(dx, dy, 20, 20);
	}

	@Override
	public void keyPressed(final KeyEvent e)
	{
		Runnable r = new Runnable()
		{
			int code = e.getKeyCode();
			
			@Override
			public void run() 
			{
				while (dy < 340)
				{
					try
					{
						if (code == KeyEvent.VK_DOWN)
						{
							moveDown();
							repaint();
							Thread.sleep(100);
							System.out.println(dy);
						}
					}
					catch (InterruptedException ie)
					{
						ie.printStackTrace();
					}
				}
			}

		};
		
		Thread t1 = new Thread(r);
		t1.start();
		
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
		
	}

	@Override
	public void keyTyped(KeyEvent e) 
	{
		
	}

}