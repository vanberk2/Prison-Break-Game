import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

public class StartGame extends StateBasedGame {
    public StartGame () {
        super("Junior Burglar");
        this.addState(new MainMenu(0));
        this.addState(new Game(1));
    }

    public void initStatesList (GameContainer gc) throws SlickException {
        this.getState(0).init(gc, this);
        this.getState(1).init(gc,this);
        this.enterState(0);
    }
    public static void main(String args[]) throws Exception {
        AppGameContainer app = new AppGameContainer(new StartGame());
        app.setDisplayMode(512, 512, false);
        app.start();
    }
}
