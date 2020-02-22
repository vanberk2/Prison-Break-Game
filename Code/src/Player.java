import org.lwjgl.input.Keyboard;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import static helper.GameClock.*;
public class Player {
    private Grid grid;
    private Tile location;
    private Animation playerAnim, idleAnim, walkForward, walkHorizontal, walkLDiagonal, walkRDiagonal;
    private float x;
    private float y;
    private float speed;
    private String textureName;
    private boolean firstUpdate = true;

    public Player(Grid grid, float x, float y, float speed, String textureName) throws SlickException{
        // TODO: turn these into spritesheets
        Image[] idle = {new Image("art/PlayerI_1.png"), new Image("art/PlayerI_2.png"), new Image("art/PlayerI_3.png"), new Image("art/PlayerI_4.png")};
        Image[] forward = {new Image("art/PlayerW_1.png"), new Image("art/PlayerW_2.png"), new Image("art/PlayerW_3.png"),
                new Image("art/PlayerW_4.png"), new Image("art/PlayerW_5.png"), new Image("art/PlayerW_6.png"),
                new Image("art/PlayerW_7.png"), new Image("art/PlayerW_8.png"), new Image("art/PlayerW_9.png"),
                new Image("art/PlayerW_10.png"), new Image("art/PlayerW_11.png"), new Image("art/PlayerW_12.png")};
        Image[] horizontal = {new Image("art/PlayerH_1.png"), new Image("art/PlayerH_2.png"), new Image("art/PlayerH_3.png"),
                new Image("art/PlayerH_4.png"), new Image("art/PlayerH_5.png"), new Image("art/PlayerH_6.png"),
                new Image("art/PlayerH_7.png"), new Image("art/PlayerH_8.png"), new Image("art/PlayerH_9.png"),
                new Image("art/PlayerH_10.png"), new Image("art/PlayerH_11.png"), new Image("art/PlayerH_12.png")};
        Image[] Ldiagonal = {new Image("art/PlayerWLD_1.png"), new Image("art/PlayerWLD_2.png"), new Image("art/PlayerWLD_3.png"),
                new Image("art/PlayerWLD_4.png"), new Image("art/PlayerWLD_5.png"), new Image("art/PlayerWLD_6.png"),
                new Image("art/PlayerWLD_7.png"), new Image("art/PlayerWLD_8.png"), new Image("art/PlayerWLD_9.png"),
                new Image("art/PlayerWLD_10.png"), new Image("art/PlayerWLD_11.png"), new Image("art/PlayerWLD_12.png")};
        Image[] Rdiagonal = {new Image("art/PlayerWRD_1.png"), new Image("art/PlayerWRD_2.png"), new Image("art/PlayerWRD_3.png"),
                new Image("art/PlayerWRD_4.png"), new Image("art/PlayerWRD_5.png"), new Image("art/PlayerWRD_6.png"),
                new Image("art/PlayerWRD_7.png"), new Image("art/PlayerWRD_8.png"), new Image("art/PlayerWRD_9.png"),
                new Image("art/PlayerWRD_10.png"), new Image("art/PlayerWRD_11.png"), new Image("art/PlayerWRD_12.png")};
        this.walkForward = new Animation(forward, 100);
        this.walkHorizontal = new Animation(horizontal, 100);
        this.walkLDiagonal = new Animation(Ldiagonal, 100);
        this.walkRDiagonal = new Animation(Rdiagonal, 100);
        this.idleAnim = new Animation(idle, 100);
        this.playerAnim = this.idleAnim;
        this.grid = grid;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.textureName = textureName;
        this.location = new Tile(this.x, this.y, 32, this.textureName);
    }

    public void update() {
        if (this.firstUpdate)
            this.firstUpdate = false;
        else {
            if (Keyboard.isKeyDown(Input.KEY_W) && Keyboard.isKeyDown(Input.KEY_A)) {
                System.out.println("Player pressing W & A");
                this.y += getD_Time() * speed;
                this.x -= getD_Time() * speed;
                if (this.playerAnim != this.idleAnim) {
                    setPAnimFrame(this.walkLDiagonal);
                } else
                    this.playerAnim = this.walkLDiagonal;
            }
            else if (Keyboard.isKeyDown(Input.KEY_W) && Keyboard.isKeyDown(Input.KEY_D)) {
                System.out.println("Player pressing W & D");
                this.y += getD_Time() * speed;
                this.x += getD_Time() * speed;
                if (this.playerAnim != this.idleAnim) {
                    setPAnimFrame(this.walkRDiagonal);
                } else
                    this.playerAnim = this.walkRDiagonal;
            }
            else if (Keyboard.isKeyDown(Input.KEY_S) && Keyboard.isKeyDown(Input.KEY_A)) {
                System.out.println("Player pressing S & A");
                this.y -= getD_Time() * speed;
                this.x -= getD_Time() * speed;
                if (this.playerAnim != this.idleAnim) {
                    setPAnimFrame(this.walkRDiagonal);
                } else
                    this.playerAnim = this.walkRDiagonal;
            }
            else if (Keyboard.isKeyDown(Input.KEY_S) && Keyboard.isKeyDown(Input.KEY_D)) {
                System.out.println("Player pressing S & D");
                this.y -= getD_Time() * speed;
                this.x += getD_Time() * speed;
                if (this.playerAnim != this.idleAnim) {
                    setPAnimFrame(this.walkLDiagonal);
                } else
                    this.playerAnim = this.walkLDiagonal;
            }
            else if (Keyboard.isKeyDown(Input.KEY_W)) {
                System.out.println("Player pressing W");
                this.y += getD_Time() * speed;
                if (this.playerAnim != this.idleAnim) {
                    setPAnimFrame(this.walkForward);
                } else
                    this.playerAnim = this.walkForward;
                //this.playerAnim.update((long)getD_Time());
            }
            else if (Keyboard.isKeyDown(Input.KEY_A)) {
                System.out.println("Player pressing A");
                this.x -= getD_Time() * speed;
                if (this.playerAnim != this.idleAnim) {
                    setPAnimFrame(this.walkHorizontal);
                } else
                    this.playerAnim = this.walkHorizontal;
            }
            else if (Keyboard.isKeyDown(Input.KEY_S)) {
                System.out.println("Player pressing S");
                this.y -= getD_Time() * speed;
                if (this.playerAnim != this.idleAnim) {
                    setPAnimFrame(this.walkForward);
                } else
                    this.playerAnim = this.walkForward;
            }
            else if (Keyboard.isKeyDown(Input.KEY_D)) {
                System.out.println("Player pressing D");
                this.x += getD_Time() * speed;
                if (this.playerAnim != this.idleAnim) {
                    setPAnimFrame(this.walkHorizontal);
                } else
                    this.playerAnim = this.walkHorizontal;
            } else {
                this.playerAnim = this.idleAnim;
            }
        }
    }

    public void setPAnimFrame(Animation anim) {
        int framenum = this.playerAnim.getFrame();
        anim.setCurrentFrame(framenum);
        this.playerAnim = anim;
    }

    public void pDraw() {
        this.playerAnim.draw(this.x,this.y);
        //this.location.setX(this.x);
        //this.location.setY(this.y);
        //this.location.tDraw();
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }
}
