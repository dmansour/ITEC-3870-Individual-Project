import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Snake implements KeyListener
{
	int snakeX = 180;
	int snakeY = 190;
	final static int SNAKE_WIDTH = 20;
	final static int SNAKE_HEIGHT = 20;
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
		}

		if (isSnakeDown() && snakeY < 330)
		{
			snakeY += 5;
		}

		if (isSnakeRight() && snakeX < 375)
		{
			snakeX += 5;
		}

		if (isSnakeLeft() && snakeX > 0)
		{
			snakeX -= 5;
		}
	}
	
	public void drawSnake(Graphics g)
	{
		g.setColor(Color.ORANGE);
		
		g.fillRect(getSnakeX(), getSnakeY(), SNAKE_WIDTH, SNAKE_HEIGHT);
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		// Movement: UP
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

		// Movement: DOWN
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

		// Movement: RIGHT
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

		// Movement: LEFT
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
		// Movement: UP
		if (e.getKeyCode() == 38)
		{
			setSnakeDown(false);
			setSnakeLeft(false);
			setSnakeRight(false);
			setSnakeUp(true);
		}
		
		// Movement: DOWN
		if (e.getKeyCode() == 40)
		{
			setSnakeUp(false);
			setSnakeLeft(false);
			setSnakeRight(false);
			setSnakeDown(true);
		}
		
		// Movement: RIGHT
		if (e.getKeyCode() == 39)
		{
			setSnakeLeft(false);
			setSnakeUp(false);
			setSnakeDown(false);
			setSnakeRight(true);
		}
		
		// Movement: LEFT
		if (e.getKeyCode() == 37)
		{
			setSnakeRight(false);
			setSnakeUp(false);
			setSnakeDown(false);
			setSnakeLeft(true);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) 
	{

	}

	public Rectangle getBounds()
	{
		Rectangle r = new Rectangle(getSnakeX(), getSnakeY(), SNAKE_WIDTH, SNAKE_HEIGHT);
		return r;
	}
}