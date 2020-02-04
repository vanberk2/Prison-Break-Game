import java.util.*;

//may replace with gridLayout
public class Grid {
    public int x, y;  //size of grid
    public ArrayList list[][];  //list for holding individual block objects in grid

    public Grid(int X, int Y){
        x = X;
        y = Y;
        list = new ArrayList[x][y];
        list[0][0] = new ArrayList();
    }
}
