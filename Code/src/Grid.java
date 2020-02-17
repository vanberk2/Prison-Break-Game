//may replace with gridLayout
public class Grid {
    public int x, y;  //size of grid
    public Tile grid[][];  //list for holding individual tile objects in grid

    public Grid(int X, int Y){
        x = X;
        y = Y;
        grid = new Tile[x][y];
        for (int i = 0 ; i < grid.length ; i++) {
            for (int j = 0 ; j < grid[i].length ; j++) {
                grid[i][j] = new Tile(i * 32, j * 32, 32, "Concrete");
            }
        }
    }

    public void draw() {
        for (int i = 0 ; i < grid.length ; i++) {
            for (int j = 0 ; j < grid[i].length ; j++) {
                Tile tile = grid[i][j];
                tile.tDraw();
            }
        }
    }
}
