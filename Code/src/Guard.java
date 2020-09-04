import helper.AABB;
import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.*;
import org.newdawn.slick.Animation;
import org.newdawn.slick.tiled.TiledMap;

import static helper.GameClock.*;
public class Guard {
    private TiledMap map;
    private Animation playerAnim, idleAnim, walkForward, walkHorizontal, walkLDiagonal, walkRDiagonal;
    private float x;
    private float y;
    private float speed;
    private boolean firstUpdate = true;
    private int mapIndex = 0;
    private int cnt = 0;

    public Guard(TiledMap map, float x, float y, float speed) throws SlickException{
        SpriteSheet guards = new SpriteSheet("art/guardss.png", 32, 32);

        Image[] horizontal = new Image[13];
        int cnt = 0;
        for (int i = 0; i < 13 ; i++) {
            horizontal[i] = guards.getSprite(cnt,0);
            cnt++;
        } 

        Image[] forward = new Image[13];
        for (int i = 0 ; i < 13 ; i++) {
            forward[i] = guards.getSprite(cnt, 0);
            cnt++;
        }

        Image[] Ldiagonal = new Image[13];
        for (int i = 0 ; i < 13 ; i++) {
            Ldiagonal[i] = guards.getSprite(cnt, 0);
            cnt++;
        }

        Image[] Rdiagonal = new Image[13];
        for (int i = 0 ; i < 13 ; i++) {
            Rdiagonal[i] = guards.getSprite(cnt, 0);
            cnt++;
        }

        Image[] idle = new Image[4];
        for (int i = 0 ; i < 4 ; i++) {
            idle[i] = guards.getSprite(cnt, 0);
            cnt++;
        }

        this.walkForward = new Animation(forward, 100);
        this.walkHorizontal = new Animation(horizontal, 100);
        this.walkLDiagonal = new Animation(Ldiagonal, 130);
        this.walkRDiagonal = new Animation(Rdiagonal, 100);
        this.idleAnim = new Animation(idle, 100);
        this.playerAnim = this.idleAnim;
        this.map = map;
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public boolean collide (float x, float y) {
        if (map.getTileId((int)x/32, (int)y/32, 1) != 0)
            return true;
        else
            return false;
    }

    public void update(int delta) {
        float tempx = 0, tempy = 0;
        if (this.firstUpdate)
            this.firstUpdate = false;
        else {
            if(cnt < 100){
                cnt+=1;
                tempx = this.x - (delta*speed);
                tempy = this.y;
                if (isInGrid(tempx, tempy).equals("x<=0")) {
                    this.x = 31*32;
                    this.y = tempy;
                    detNdChangeMapID("x<=0");
                    return;
                }
                if (!collide(tempx, tempy)) {
                    this.x -= delta * speed;
                    if (this.playerAnim != this.idleAnim) {
                        setPAnimFrame(this.walkHorizontal);
                    } else
                        this.playerAnim = this.walkHorizontal;
                }
            }
            else {
                cnt+=1;
                if(cnt > 200)
                    cnt = 0;
                tempx = this.x + (delta * speed);
                tempy = this.y;
                if (isInGrid(tempx, tempy).equals("x>=32")) {
                    this.x = 0;
                    this.y = tempy;
                    detNdChangeMapID("x>=32");
                    return;
                }
                if (!collide(tempx, tempy)) {
                    this.x += delta * speed;
                    if (this.playerAnim != this.idleAnim) {
                        setPAnimFrame(this.walkHorizontal);
                    } else
                        this.playerAnim = this.walkHorizontal;
                } else {
                    this.playerAnim = this.idleAnim;
                }
            }

        }

    }

    public void setPAnimFrame(Animation anim) {
        int framenum = this.playerAnim.getFrame();
        anim.setCurrentFrame(framenum);
        this.playerAnim = anim;
    }

    public String isInGrid(float x, float y) {
        if (x/32 >= 32)
            return "x>=32";
        else if (y/32 >= 32)
            return "y>=32";
        else if (x/32 <= 0)
            return "x<=0";
        else if (y/32 <= 0) {
            return "y<=0";
        }
        return "";
    }

    public void detNdChangeMapID(String dir) {
        if (dir.equals("x>=32")) { // out of bounds east x
            if (this.mapIndex != 2 && this.mapIndex != 5 && this.mapIndex != 8) {
                this.mapIndex++;
            }
        } else if (dir.equals("y>=32")) { // out of bounds south y
            if (this.mapIndex != 6 && this.mapIndex != 7 && this.mapIndex != 8) {
                this.mapIndex += 3;
            }
        } else if (dir.equals("y<=0")) { // out of bounds north y
            if (this.mapIndex != 0 && this.mapIndex != 1 && this.mapIndex != 2) {
                this.mapIndex -= 3;
            }
        } else if (dir.equals("x<=0")) { // out of bounds west x
            if (this.mapIndex != 0 && this.mapIndex != 3 && this.mapIndex != 6) {
                this.mapIndex--;
            }
        }
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public int getMapIndex() { return this.mapIndex; }

    public void setMap(TiledMap map) { this.map = map; }

    public Animation getAnim() {
        return this.playerAnim;
    }
}
