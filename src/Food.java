import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

public class Food
{
	Random r = new Random();
	int foodX = 0;
	int foodY = 0;
	Color colorList[] = {Color.RED, Color.BLUE, Color.CYAN, Color.PINK, Color.YELLOW,
				     	 Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE};
	static Color color;
	final static int FOOD_WIDTH = 6;
	final static int FOOD_HEIGHT = 6;

	public Food()
	{
		foodX = r.nextInt(330) + 1;
		foodY = r.nextInt(330) + 1;
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

	public static Color getColor()
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