import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;
import org.newdawn.slick.state.BasicGameState;

public class Game extends BasicGameState {
    private TiledMap maps[] = new TiledMap[10];
    private Player player;
    private Camera camera;
    private Item item;
    private int currMapId = 0;

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
        item = new Item(maps[0], "Gold Coin", 100, 60, 60);
        item = new Item(maps[1], "a Cool looking Pen", 1, 60, 60);
        item = new Item(maps[2], "Makeshift Knife", 20, 60, 60);
        item = new Item(maps[3], "Running Shoes", 30, 60, 60);
        item = new Item(maps[4], "Bribe", 90, 60, 60);
        item = new Item(maps[5], "Stealth Potion", 1000, 60, 60);
        item = new Item(maps[6], "Gold Coin", 100, 60, 60);
        item = new Item(maps[7], "Gold Coin", 100, 60, 60);
        item = new Item(maps[8], "Gold Coin", 100, 60, 60);
        int mapW = maps[0].getWidth() * maps[0].getTileWidth();
        int mapH = maps[0].getHeight() * maps[0].getTileHeight();
        camera = new Camera(mapW, mapH);
    }

    public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException {
        player.update(delta);
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
        g.drawAnimation(player.getAnim(), player.getX(), player.getY());

        if(player.getX() == item.getX() && player.getY() == item.getY()) {
            player.addInventory(item);
        }

    }

    public int getID() {
        return 1;
    }
}
