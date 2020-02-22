import helper.GameClock;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.*;

public class StartGame {
    private Player p;
    private Grid grid;
    private Camera pCam;
    public StartGame() {
        initGL();
    }
    public static void main (String args[]) throws Exception {
        // set up display
        Display.setDisplayMode(new DisplayMode(800, 800));
        Display.create();
        // init game
        StartGame game = new StartGame();
        // init game grid
        Grid grid = new Grid(16,16);
        // init player
        Player p = new Player(grid, 10, 10, 6, "Player");
        Camera pCam = new Camera(grid, p);

        // while display is open, draw and update
        while (!Display.isCloseRequested()) {
            GameClock.update();
            p.update();
            pCam.update(800,800);
            System.out.println("t_time: " + GameClock.getT_Time() + "   d_time: " + GameClock.getD_Time());
            // grid.draw draws our tiles
            grid.draw();
            p.pDraw();
            Display.update();
            Display.sync(60);
        }

        // if display is closed, close game
        game.close();
    }

    public void initGL() {
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
    }
}
