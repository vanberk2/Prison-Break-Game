package helper;

import org.lwjgl.Sys;

public class GameClock {
    private static long t_Time;
    private static long prevFrame;
    private static float d_Time = 0;

    public static void update() {
        d_Time = getDelta();
        t_Time += d_Time;
    }

    public static float getT_Time () {
        return t_Time;
    }

    public static float getD_Time() {
        return d_Time;
    }

    public static long getTime() {
        return Sys.getTime() * 1000 / Sys.getTimerResolution();
    }

    public static float getDelta() {
        long curr_Time = getTime();
        int delta = (int)(curr_Time - prevFrame);
        prevFrame = getTime();
        return delta * 0.01f;
    }
}
