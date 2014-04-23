import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Food
{
	Random r = new Random();
	int foodX = 150;
	int foodY = 150;
	Color colorList[] = {Color.RED, Color.BLUE, Color.CYAN, Color.PINK, Color.YELLOW,
				     	 Color.GREEN, Color.WHITE, Color.MAGENTA, Color.ORANGE};
	Color color;
	private final static int FOOD_WIDTH = 6;
	private final static int FOOD_HEIGHT = 6;
	
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

	public void draw(Graphics g)
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