import org.newdawn.slick.*;
import org.newdawn.slick.Image;
import org.newdawn.slick.tiled.TiledMap;

public class Item
{
    private String name;
    private int value;
    private float x;
    private float y;
    private TiledMap map;
    Image items;

    public Item(TiledMap map, String name, int value, float x, float y) throws SlickException
    {
        items = new Image("art/playbutton.png");
        this.map = map;
        this.name = name;
        this.value = value;
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }
    
    public String getName() {
      return this.name;
    }
    
    public int getValue() {
      return this.value;
    }
}