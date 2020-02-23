package helper;

import org.lwjgl.util.vector.Vector2f;

public class AABB {
    protected Vector2f pos, size;

    public AABB(Vector2f pos, Vector2f size)
    {
        this.pos = pos;
        this.size = size;
    }

    public static boolean collides(AABB a, AABB b) {
        if (Math.abs(a.pos.x - b.pos.x) < a.size.x + b.size.x)
            if (Math.abs(a.pos.y - b.pos.y) < a.size.y + b.size.y)
                return true;

        return false;
    }
}
