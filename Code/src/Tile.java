import helper.AABB;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;
import java.io.IOException;
import java.lang.String;


public class Tile {
    private String textureName;  //specifies material of block object
    private Texture texture;    // texture of the tile
    private float x, y, hw;   //position and height/width of tile (height/width will always be the same for now)
    private AABB hitbox;

    public Tile (float x, float y, float hw, String textureName) {
        this.x = x;
        this.y = y;
        this.hitbox = new AABB(new Vector2f(this.x,this.y), new Vector2f(this.x+32, this.y+32));
        this.hw = hw;
        this.textureName = textureName;
        this.texture = null;
    }

    public void tDraw () {
        try {
            this.texture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("art/" + textureName + ".png"));
            this.texture.bind();
            GL11.glTranslatef(x, y, 0);
            GL11.glBegin(GL11.GL_QUADS);

            // set up coordinates of the tile square
            GL11.glVertex2f(0, 0);
            GL11.glTexCoord2f(0,0);

            GL11.glVertex2f(hw, 0);
            GL11.glTexCoord2f(1,0);

            GL11.glVertex2f(hw, hw);
            GL11.glTexCoord2f(1,1);

            GL11.glVertex2f(0, hw);
            GL11.glTexCoord2f(0,1);
            GL11.glEnd();
            GL11.glLoadIdentity();
        } catch (IOException error) {
            error.printStackTrace();
        }
    }

    public float getX() {
        return this.x;
    }

    public void setX(float x) {this.x = x;}

    public float getY() {
        return this.y;
    }

    public void setY(float y) {this.y = y;}

    public void setTexture(String textureName) {
        this.textureName = textureName;
    }

    public String getTextureName() { return this.textureName; }
}
