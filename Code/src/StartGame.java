import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class StartGame {
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

        // while display is open, draw and update
        while (!Display.isCloseRequested()) {
            // grid.draw draws our tiles
            grid.draw();
            Display.update();
            Display.sync(60);
        }

        // if display is closed, close game
        game.close();
    }

    public void initGL() {
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0, 512, 0, 512, 1, -1);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
    }

    public void resetGL() {
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
        GL11.glLoadIdentity();
    }

    public void update() {
        resetGL();
        Display.update();
    }

    public void close() {
        Display.destroy();
        System.exit(0);
    }
}
