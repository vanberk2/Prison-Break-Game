//may replace with gridLayout
public class Grid {
    public int x, y;  //size of grid
    public Tile grid[][];  //list for holding individual tile objects in grid

    public Grid(int x, int y){
        this.x = x;
        this.y = y;
        grid = new Tile[x][y];
        for (int i = 0 ; i < grid.length ; i++) {
            for (int j = 0 ; j < grid[i].length ; j++) {
                grid[i][j] = new Tile(i * 32, j * 32, 32, "Concrete");
            }
        }
    }

    public void draw(Player p) {
    /*    int tempx = ((int)p.getX()/32);
        int xedge = 0;
        int tempy = ((int)p.getY()/32);
        int yedge = 0;
        int x = 0,y = 0;
        if (tempx - 5 < 0) {
            x = 0;
        } else if (tempx + 5 > grid.length) {
            xedge = grid.length;
        } else {
            xedge = x + 5;
        }

        if (tempy - 5 < 0) {
            y = 0;
        } else if (tempy + 5 > grid.length) {
            yedge = grid[x].length;
        } else {
            yedge = y + 5;
        }

        for (int i = x ; i < xedge ; i++) {
            for (int j = y ; j < yedge ; j++) {
                Tile tile = grid[i][j];
                tile.tDraw();
            }
        }*/

        for (int i = 0 ; i < grid.length ; i++) {
            for (int j = 0 ; j < grid[i].length ; j++) {
                Tile tile = grid[i][j];
                tile.tDraw();
            }
        }
    }

    public void setTile(Tile tile, int x, int y) {
        grid[x][y] = tile;
    }

    public int isWall(int x, int y) {
        if (grid[x][y].getTextureName() == "Wall") {
            if (grid[x-1][y].getTextureName() != "Wall") {
                return 0;
            } else
                return 1;
        }
        return -1;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}
