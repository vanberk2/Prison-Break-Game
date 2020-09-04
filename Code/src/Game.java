import com.sun.javafx.css.StyleableProperty;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;
import org.newdawn.slick.state.BasicGameState;

import java.awt.*;

public class Game extends BasicGameState {
    private TiledMap maps[] = new TiledMap[10];
    private Player player;
    private Guard guard;
    private Camera camera;
    private int currMapId = 0;
    private int guardMapId = 0;
    private float xdiff, ydiff;

    public Game (int state) {

    }

    public void init(GameContainer container, StateBasedGame sbg) throws SlickException {
        // Level layout is 3x3 grid of TiledMaps
        maps[0] = new TiledMap("resources/levels/level_1_0.tmx");
        maps[1] = new TiledMap("resources/levels/level_1_1.tmx");
        maps[2] = new TiledMap("resources/levels/level_1_2.tmx");
        maps[3] = new TiledMap("resources/levels/level_1_3.tmx");
        maps[4] = new TiledMap("resources/levels/level_1_4.tmx");
        maps[5] = new TiledMap("resources/levels/level_1_5.tmx");
        maps[6] = new TiledMap("resources/levels/level_1_6.tmx");
        maps[7] = new TiledMap("resources/levels/level_1_7.tmx");
        maps[8] = new TiledMap("resources/levels/level_1_8.tmx");

        player = new Player(maps[0], 64, 64, (float)0.20, "Player");
        guard = new Guard(maps[0], 420, 300, (float)0.20);
        int mapW = maps[0].getWidth() * maps[0].getTileWidth();
        int mapH = maps[0].getHeight() * maps[0].getTileHeight();
        camera = new Camera(mapW, mapH);
    }

    public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException {
        player.update(delta);
        guard.update(delta);
    }

    public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException {
        camera.translate(g, player);
        if (currMapId != player.getMapIndex()) {
            currMapId = player.getMapIndex();
            maps[currMapId].render(0,0);
            player.setMap(maps[currMapId]);
        } else {
            maps[currMapId].render(0,0);
        }

        if (guardMapId != guard.getMapIndex()) {
            guardMapId = guard.getMapIndex();
            guard.setMap(maps[currMapId]);
        } else {
            maps[currMapId].render(0,0);
        }
        xdiff = player.getX() - guard.getX();
        ydiff = player.getY() - guard.getY();

        if (Math.abs(xdiff) < 32 && Math.abs(ydiff) < 32) {
            sbg.getState(1).init(container, sbg);
            sbg.enterState(2);
        }

        g.drawAnimation(player.getAnim(), player.getX(), player.getY());

        if (player.getMapIndex() == guard.getMapIndex())
            g.drawAnimation(guard.getAnim(), guard.getX(), guard.getY());

        // debug coords
        g.drawString("x: " + player.getX() + "   y: " + player.getY(), camera.getX() + 50, camera.getY() + 50);
    }

    public int getID() {
        return 1;
    }
}
