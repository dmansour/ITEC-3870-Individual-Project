import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Food
{
	Random r = new Random();
	int foodX = r.nextInt(330);
	int foodY = r.nextInt(330);
	Color colorList[] = {Color.RED, Color.BLUE, Color.CYAN, Color.PINK, Color.YELLOW,
				     	 Color.GREEN, Color.WHITE, Color.MAGENTA, Color.ORANGE};
	Color color;
	final static int FOOD_WIDTH = 6;
	final static int FOOD_HEIGHT = 6;

	public Food()
	{
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

	public Color getColor()
	{
		return color;
	}

	public void drawFood(Graphics g)
	{
		g.setColor(color);
		g.fillRect(getFoodX(), getFoodY(), FOOD_WIDTH, FOOD_HEIGHT);
	}

	public Rectangle getBounds()
	{
		Rectangle r = new Rectangle(getFoodX(), getFoodY(), FOOD_WIDTH, FOOD_HEIGHT);
		return r;
	}
}