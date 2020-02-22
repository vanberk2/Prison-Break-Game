import helper.GameClock;
import org.newdawn.slick.opengl.Texture;

public class Animation {
    private Texture[] frames;
    private long t_Time;
    private long curr_Time;
    private long prev_Time;
    private double fps;

    public Animation(int fps, int frameAmt, String filename) {
        this.t_Time = 0;
        this.curr_Time = 0;
        this.prev_Time = GameClock.getTime();
        this.fps = 1.0/(long)fps;
        this.frames = new Texture[frameAmt];

        for (int i = 0 ; i < frameAmt ; i++) {
            //this.frames[i] = new Texture("art/" + filename + "_" + i + ".png");
        }
    }

}
