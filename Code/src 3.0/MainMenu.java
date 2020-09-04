import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MainMenu extends BasicGameState {
    Image playButton, exitButton, llButton;

    public MainMenu(int state) {

    }
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        playButton = new Image("art/playbutton.png");
        exitButton = new Image("art/exitbutton.png");
        llButton = new Image("art/loadlevelbutton.png");
    }
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        int x = Mouse.getX();
        int y = Mouse.getY();
        //System.out.println("x: " + x + "  y: " + y);
        // play button
        if ((x > 156 && x < 356) && (y > 306 && y < 356)) {
            if (Mouse.isButtonDown(0)) {
                sbg.enterState(1);
            }
        }

        // load level button
        if ((x > 156 && x < 356) && (y > 206 && y < 256)) {
            if (Mouse.isButtonDown(0)) {
                // TODO:: Open level screen
            }
        }

        // exit button
        if ((x > 156 && x < 356) && (y > 106 && y < 156)) {
            if (Mouse.isButtonDown(0)) {
                System.exit(0);
            }
        }
    }
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        playButton.draw(156,156);
        llButton.draw(156,256);
        exitButton.draw(156,356);
    }
    public int getID() {
        return 0;
    }
}
