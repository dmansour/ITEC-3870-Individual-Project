import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Food 
{
	int foodX = 0;
	int foodY = 0;
	Color colorList[] = {Color.RED, Color.BLUE, Color.CYAN, Color.PINK, Color.YELLOW,
				     	 Color.GREEN, Color.WHITE, Color.MAGENTA, Color.ORANGE};
	Color color;
	Random r = new Random();
	
	public Food()
	{
		foodY = r.nextInt(375) + 1;
		foodX = r.nextInt(375) + 1;
		color = colorList[r.nextInt(colorList.length)];
	}
	
	public int getFoodX()
	{
		return foodX;
	}

	public int getFoodY()
	{
		return foodY;
	}

	public void draw(Graphics g)
	{
		g.setColor(color);
		g.fillOval(foodX, foodY, 6, 6);
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle(getFoodX(), getFoodY(), 6, 6);
	}
	
}
