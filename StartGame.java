import helper.GameClock;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.*;

public class StartGame {
    private Player p;
    private Grid grid;
    private Camera pCam;
    /*public StartGame() {
        initGL();
    }*/
    public static void main (String args[]) throws Exception {
        AppGameContainer app = new AppGameContainer(new Game());
        app.setDisplayMode(512,512, false);
        app.start();
        /*// set up display
        Display.setDisplayMode(new DisplayMode(800, 800));
        Display.create();
        // init game
        StartGame game = new StartGame();
        // init game grid
        Grid gridtoDraw = new Grid(16,16);
        Grid grid = new Grid(16,16);
        Grid grid2 = new Grid(16, 16);

        gridtoDraw = grid;
        // init player
        Player p = new Player(gridtoDraw, 10, 10, 6, "Player");

        Tile test = new Tile(4*32, 4*32, 32, "Wall");
        grid2.setTile(test, 4, 4);
        grid.setTile(test,4,4);

        // while display is open, draw and update
        while (!Display.isCloseRequested()) {
            GameClock.update();
            p.update();
            //pCam.update();
            System.out.println("Player is in tile, x: " + p.getX()/32 + " y: " + p.getY()/32);

            // grid.draw draws our tiles
            if (p.getX()/32 > 15) {
                gridtoDraw = grid2;
            } else if (p.getX()/32 < 0) {
                gridtoDraw = grid;
            }
            p.setGrid(gridtoDraw);
            gridtoDraw.draw(p);
            p.pDraw();
            Display.update();
            Display.sync(60);
        }

        // if display is closed, close game
        game.close();*/
    }

/*    public void initGL() {
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0, 512, 0, 512, 1, -1);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
    }

    public void close() {
        Display.destroy();
        System.exit(0);
    }*/
}
