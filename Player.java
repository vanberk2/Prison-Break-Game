import helper.AABB;
import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.*;
import org.newdawn.slick.Animation;
import org.newdawn.slick.tiled.TiledMap;

import static helper.GameClock.*;
public class Player {
    private Grid grid;
    private TiledMap map;
    private Tile location;
    private Animation playerAnim, idleAnim, walkForward, walkHorizontal, walkLDiagonal, walkRDiagonal;
    private float x;
    private float y;
    private float speed;
    private AABB hitbox;
    private String textureName;
    private boolean firstUpdate = true;

    public Player(TiledMap map, float x, float y, float speed, String textureName) throws SlickException{
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
        this.map = map;
        this.x = x;
        this.y = y;
        this.hitbox = new AABB(new Vector2f(this.x, this.y), new Vector2f(this.x+32,this.y+32));
        this.speed = speed;
        this.textureName = textureName;
        this.location = new Tile(this.x, this.y, 32, this.textureName);
    }

    public boolean collide (float x, float y) {
        int id = map.getTileId((int)x/32, (int)y/32, 1);
        System.out.println("Player is at x: " + (int)x/32 + "  y: " + (int)y/32 + "    tileID: " + map.getTileId((int)x/32, (int)y/32, 1));
        System.out.println("Tile property of collidable: " + map.getTileProperty(id, "collidable", "false"));
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
            if (Keyboard.isKeyDown(Input.KEY_S) && Keyboard.isKeyDown(Input.KEY_A)) {
                System.out.println("Player pressing S & A");
                tempx = this.x - (delta*speed);
                tempy = this.y + (delta*speed);
                if (!collide(tempx, tempy)) {
                    this.y += delta * speed;
                    this.x -= delta * speed;
                    if (this.playerAnim != this.idleAnim) {
                        setPAnimFrame(this.walkLDiagonal);
                    } else
                        this.playerAnim = this.walkLDiagonal;
                }
            }
            else if (Keyboard.isKeyDown(Input.KEY_S) && Keyboard.isKeyDown(Input.KEY_D)) {
                System.out.println("Player pressing S & D");
                tempx = this.x + (delta*speed);
                tempy = this.y + (delta*speed);
                if (!collide(tempx, tempy)) {
                    this.y += delta * speed;
                    this.x += delta * speed;
                    if (this.playerAnim != this.idleAnim) {
                        setPAnimFrame(this.walkRDiagonal);
                    } else
                        this.playerAnim = this.walkRDiagonal;
                }
            }
            else if (Keyboard.isKeyDown(Input.KEY_W) && Keyboard.isKeyDown(Input.KEY_A)) {
                System.out.println("Player pressing W & A");
                tempx = this.x - (delta*speed);
                tempy = this.y - (delta*speed);
                if (!collide(tempx,tempy)) {
                    this.y -= delta * speed;
                    this.x -= delta * speed;
                    if (this.playerAnim != this.idleAnim) {
                        setPAnimFrame(this.walkRDiagonal);
                    } else
                        this.playerAnim = this.walkRDiagonal;
                }
            }
            else if (Keyboard.isKeyDown(Input.KEY_W) && Keyboard.isKeyDown(Input.KEY_D)) {
                System.out.println("Player pressing W & D");
                tempx = this.x + (delta*speed);
                tempy = this.y - (delta*speed);
                if (!collide(tempx,tempy)) {
                    this.y -= delta * speed;
                    this.x += delta * speed;
                    if (this.playerAnim != this.idleAnim) {
                        setPAnimFrame(this.walkLDiagonal);
                    } else
                        this.playerAnim = this.walkLDiagonal;
                }
            }
            else if (Keyboard.isKeyDown(Input.KEY_S)) {
                System.out.println("Player pressing S");
                tempx = this.x;
                tempy = this.y + (delta*speed);
                if (!collide(tempx, tempy)) {
                    this.y += delta * speed;
                    if (this.playerAnim != this.idleAnim) {
                        setPAnimFrame(this.walkForward);
                    } else
                        this.playerAnim = this.walkForward;
                }
                //this.playerAnim.update((long)getD_Time());
            }
            else if (Keyboard.isKeyDown(Input.KEY_A)) {
                System.out.println("Player pressing A");
                tempx = this.x - (delta*speed);
                tempy = this.y;
                if (!collide(tempx, tempy)) {
                    this.x -= delta * speed;
                    if (this.playerAnim != this.idleAnim) {
                        setPAnimFrame(this.walkHorizontal);
                    } else
                        this.playerAnim = this.walkHorizontal;
                }
            }
            else if (Keyboard.isKeyDown(Input.KEY_W)) {
                System.out.println("Player pressing W");
                tempx = this.x;
                tempy = this.y - (delta*speed);
                if (!collide(tempx, tempy)) {
                    this.y -= delta * speed;
                    if (this.playerAnim != this.idleAnim) {
                        setPAnimFrame(this.walkForward);
                    } else
                        this.playerAnim = this.walkForward;
                }
            }
            else if (Keyboard.isKeyDown(Input.KEY_D)) {
                System.out.println("Player pressing D");
                tempx = this.x + (delta*speed);
                tempy = this.y;
                if (!collide(tempx,tempy)) {
                    this.x += delta * speed;
                    if (this.playerAnim != this.idleAnim) {
                        setPAnimFrame(this.walkHorizontal);
                    } else
                        this.playerAnim = this.walkHorizontal;
                }
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
        /* // if player goes off the map
        if (this.x/32 > 15) {
            this.x = 0;
        } else if (this.x/32 < 0) {
            this.x = 15*32;
        }


        int tempx = 0, tempy = 0;
        // if player attempts to walk into wall
        if (this.x % 1 >=0.5)
            tempx = (int)Math.ceil(this.x/32);
        else
            tempx = (int)Math.floor(this.x/32);

        if (this.y % 1 >= 0.5)
            tempy = (int)Math.ceil(this.y/32);
        else
            tempy = (int)Math.floor(this.y/32);

        int xory = grid.isWall(tempx, tempy);
        if (xory == 0) {
            this.x -= 16;
        } else if (xory == 1) {
            this.y -= 16;
        }
*/
        this.playerAnim.draw(this.x,this.y);
        //this.location.setX(this.x);
        //this.location.setY(this.y);
        //this.location.tDraw();
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public Animation getAnim() {
        return this.playerAnim;
    }
}
