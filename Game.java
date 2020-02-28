import org.lwjgl.opengl.Display;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class Game extends BasicGame {
    private TiledMap map;
    private Player player;
    private Camera camera;
    @Override
    public void init(GameContainer container) throws SlickException {
        map = new TiledMap("resources/testmap.tmx");
        player = new Player(map, 64, 64, (float)0.05, "Player");
        int mapW = map.getWidth() * map.getTileWidth();
        int mapH = map.getHeight() * map.getTileHeight();
        camera = new Camera(player, map, mapW, mapH);
    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {
        player.update(delta);
    }

    @Override
    public void render(GameContainer container, Graphics g) throws SlickException {
        camera.translate(g, player);
        map.render(0,0);
        g.drawAnimation(player.getAnim(), player.getX(), player.getY());
    }

    public Game () {
        super("");
    }
}
