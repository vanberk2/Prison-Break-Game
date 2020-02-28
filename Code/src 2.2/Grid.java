import java.util.List;

final public class Grid {
 public static Block initmap[][];
 public static Block currentBlock;
 
 public static boolean checkDirection(int blockX, int blockY) {
  return  ((blockX >= 0 && blockX < initmap.length) && 
    (blockY >= 0 && blockY < initmap.length) && 
    initmap[blockX][blockY] != null);
 }
 
 public static void moveDirection(int blockX, int blockY) {
  if(checkDirection(blockX, blockY)) {
   currentBlock = initmap[blockX][blockY];
  }
 }

 public static Block getBlock(int x, int y) {
  return initmap[x][y];
 }
 
 public static Block getBlock(Place place) {
  return initmap[place.getX()][place.getY()];
 }
 
}