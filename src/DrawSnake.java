import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class DrawSnake extends Canvas implements KeyListener
{
	int snakeX = 180;
	int snakeY = 190;
	boolean snakeUp = false;
	boolean snakeDown = false;
	boolean snakeLeft = false;
	boolean snakeRight = false;

	public int getSnakeX()
	{
		return snakeX;
	}
	
	public int getSnakeY()
	{
		return snakeY;
	}

	public boolean isSnakeUp()
	{
		return snakeUp;
	}
	
	public void setSnakeUp(boolean up)
	{
		snakeUp = up;
	}
	
	public boolean isSnakeDown()
	{
		return snakeDown;
	}
	
	public void setSnakeDown(boolean down)
	{
		snakeDown = down;
	}
	
	public boolean isSnakeLeft()
	{
		return snakeLeft;
	}
	
	public void setSnakeLeft(boolean left)
	{
		snakeLeft = left;
	}
	
	public boolean isSnakeRight()
	{
		return snakeRight;
	}
	
	public void setSnakeRight(boolean right)
	{
		snakeRight = right;
	}
	
	public void Move()
	{
		if (isSnakeUp() && snakeY > 0)
		{
			snakeY -= 5;
			repaint();
		}
		
		if (isSnakeDown() && snakeY < 350)
		{
			snakeY += 5;
			repaint();
		}
		
		if (isSnakeRight() && snakeX < 375)
		{
			snakeX += 5;
			repaint();
		}
		
		if (isSnakeLeft() && snakeX > 0)
		{
			snakeX -= 5;
			repaint();
		}
	}

	public void paint(Graphics g)
	{
		super.paint(g);
		
		g.setColor(Color.ORANGE);

		g.fillRect(getSnakeX(), getSnakeY(), 20, 20);
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == 38)
		{
			if (isSnakeDown() == false)
			{
				setSnakeDown(false);
				setSnakeLeft(false);
				setSnakeRight(false);
				setSnakeUp(true);
				Move();
			}
		}
		
		else if (e.getKeyCode() == 40)
		{
			if (isSnakeUp() == false)
			{
				setSnakeUp(false);
				setSnakeLeft(false);
				setSnakeRight(false);
				setSnakeDown(true);
				Move();
			}
		}
		
		else if (e.getKeyCode() == 39)
		{
			if (isSnakeLeft() == false)
			{
				setSnakeLeft(false);
				setSnakeUp(false);
				setSnakeDown(false);
				setSnakeRight(true);
				Move();
			}
		}
		
		else
		{
			if (isSnakeRight() == false)
			{
				setSnakeRight(false);
				setSnakeUp(false);
				setSnakeDown(false);
				setSnakeLeft(true);
				Move();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
		if (e.getKeyCode() == 38)
		{
			setSnakeDown(false);
		}
		else if (e.getKeyCode() == 40)
		{
			setSnakeUp(false);
		}
		else if (e.getKeyCode() == 39)
		{
			setSnakeLeft(false);
		}
		else
		{
			setSnakeRight(false);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) 
	{
		
	}
}