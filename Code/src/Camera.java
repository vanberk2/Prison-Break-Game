import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.tiled.TiledMap;

import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glTranslatef;

public class Camera {
    private Vector2f pos;
    private Player p;
    private Rectangle view;
    private int x,y;
    private int mapW, mapH;

    public Camera(Player p, TiledMap map, int mapW, int mapH) {
        this.x = 0;
        this.y = 0;
        this.mapW = mapW;
        this.mapH = mapH;
        this.view = new Rectangle(0,0,512,512);
    }

    public void translate (Graphics g, Player p) {
        if (p.getX() -  512/2 + 32 < 0) {
            this.x = 0;
        } else if (p.getX() + 512 / 2 + 32 > mapW) {
            this.x = -mapW + 512;
        } else {
            this.x = (int)-p.getX() + 512/2 - 32;
        }

        if (p.getY() - 512/2 +32 < 0) {
            this.y = 0;
        } else if (p.getY() + 512 / 2 + 32 > mapH) {
            this.y = -mapH + 512;
        } else {
            this.y = (int)-p.getY() + 512/2 - 32;
        }

        g.translate(this.x, this.y);
        view.setX(-this.x);
        view.setY(-this.y);
    }

    public void create() {
        pos = new Vector2f(p.getX(), p.getY());
    }

    public void update() {
        glLoadIdentity();
        glTranslatef(-pos.x, -pos.y, 0);
    }



    //private float x;
    //private float y;
    //private Player player;
    //private int mapW, mapH;
    //private Rectangle view;


    //public Camera(Grid grid, Player player) {


        /* this.player = player;
        this.x = player.getX();
        this.y = player.getY();
        this.view = new Rectangle(this.x, this.y, 64,64);
        this.mapW = grid.getX();
        this.mapH = grid.getY(); */
    //}

}
