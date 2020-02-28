public class EnemySprite extends Player{
    private boolean alert;
    public EnemySprite(TiledMap map, float x, float y, float speed, String textureName){
        super(map, x, y, speed, textureName);
        alert = 0;
    }
    public boolean startAlert(){
        //if(player is +/- x or y spot them)
            alert = 1;
            return alert;
        //else:
            //return alert;
    }
    public boolean cancelAlert(){
        //if(player is not +/- x or y don't spot them)
        alert = 0;
        return alert;
        //else:
        //return 1;
    }
    public void track(int delta) {
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
}