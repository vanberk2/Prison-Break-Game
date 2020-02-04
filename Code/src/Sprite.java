public class Sprite {
    private int x, y;
    private Boolean guard;
    public Sprite(int X, int Y){
        x = X;
        y = Y;
    }
    public Boolean isGuard(){
        return guard;
    }
    public int getPosX(){
        return x;
    }
    public int getPosY(){
        return y;
    }
}
