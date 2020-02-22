import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Rectangle;

public class Camera {
    private float x;
    private float y;
    private Player player;
    private int mapW, mapH;
    private Rectangle view;

    public Camera(Grid grid, Player player) {
        this.player = player;
        this.x = player.getX();
        this.y = player.getY();
        this.view = new Rectangle(this.x, this.y, 64,64);
        this.mapW = grid.getX();
        this.mapH = grid.getY();
    }

    public void update(int gameWidth, int gameHeight) {
        this.x = player.getX() - (gameWidth/4);
        this.y = player.getY() - (gameHeight/4);
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }
}
