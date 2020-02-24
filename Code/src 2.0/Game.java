import java.io.*;
import java.util.*;

public class Game {
  public static Scanner scan;
  public static String input = "";
  public static Player player = null;
  
  public static void main(String[] args) {
    init();
    scan = new Scanner(System.in);
  }
  
  public static void init() {
    boolean loop = true;
    player = new Player();
    
    System.out.println("Welcome to Prison Break! Escape Prison and become free!");
    System.out.println("Type help to show commands");
    
    loadBlocks();
    
    scan = new Scanner(System.in);
    while(!input.equals("quit")) {
      System.out.print("> ");
      input = scan.nextLine();
      command(player);
      
      if (player.isCaught()) {
        System.out.println("YOU GOT CAUGHT! GAME OVER!");
        System.exit(0);
      }
    }
    
    if(input.equals("quit")){
      System.out.println("Thanks for playing! See you next time!");
      System.exit(0);
    }
  }
  
  public static void command(Player player) {
    Block lastBlock = Grid.currentBlock;
    int currentBlockX = Grid.currentBlock.getBlockCoord().getX();
    int currentBlockY = Grid.currentBlock.getBlockCoord().getY();
    
    switch(input) {
      case "help":
        showHelp();
        break;
      case "north":
        Grid.moveDirection(currentBlockX - 1, currentBlockY);
        showBlock(Grid.currentBlock, lastBlock, "north");
        break;
      case "south":
        Grid.moveDirection(currentBlockX + 1, currentBlockY);
        showBlock(Grid.currentBlock, lastBlock, "south");
        break;
      case "east":
        Grid.moveDirection(currentBlockX, currentBlockY + 1);
        showBlock(Grid.currentBlock, lastBlock, "east");
        break;
      case "west":
        Grid.moveDirection(currentBlockX, currentBlockY - 1);
        showBlock(Grid.currentBlock, lastBlock, "west");
        break;
      case "room":
        showRoom(Grid.currentBlock);
        break;
      case "quit":
        System.out.println("GoodBye!");
        break;
      default: 
        System.out.println("Command not recognized. Type help.");
        break;
    }
  }
  
  public static void showHelp() {
    System.out.println("help - List of commands");
    System.out.println("north, south, east, west - movement");
    System.out.println("room - Shows neighboring rooms");
    System.out.println("quit - Quit game");
  }
  
  public static void showBlock(Block currentBlock, Block lastBlock, String direction) {
    if(currentBlock != lastBlock) {
      System.out.println("You move to " + currentBlock.getName() + "  in the " + direction);
      System.out.println(currentBlock.getDescription());
      
      if(currentBlock.getGuard() != null && !currentBlock.getGuard().isEmpty()) {
        System.out.println("\nThere was a prison guard here and you were caught you!");
        player.setHealth(0.0);
      }
    }
    else {
      Grid.currentBlock = lastBlock;
      System.out.println("No path " + direction + " from this room");
    }
  }
  
  public static void showRoom(Block currentBlock) {
    int currentBlockX = Grid.currentBlock.getBlockCoord().getX();
    int currentBlockY = Grid.currentBlock.getBlockCoord().getY();
    
    //north
    if(Grid.checkDirection(currentBlockX - 1, currentBlockY)) {
      System.out.println("At north " + Grid.initmap[currentBlockX - 1][currentBlockY].getName());
    }
    
    //south
    if(Grid.checkDirection(currentBlockX + 1, currentBlockY)) {
      System.out.println("At south " + Grid.initmap[currentBlockX + 1][currentBlockY].getName());
    }
    
    //east
    if(Grid.checkDirection(currentBlockX, currentBlockY + 1)) {    
      System.out.println("At east " + Grid.initmap[currentBlockX][currentBlockY + 1].getName());
    }
    
    //west
    if(Grid.checkDirection(currentBlockX, currentBlockY - 1)) {      
      System.out.println("At west " + Grid.initmap[currentBlockX][currentBlockY - 1].getName());
    }
  }
  
//hard coded placement of rooms and guards
  public static void loadBlocks() {
    Block[][] prison = new Block[3][3];
    
    prison[0][0] = new Block("Room1", "Start room", new Place(0,0));
    prison[0][1] = new Block("Room2", "empty room", new Place(0,1));
    prison[1][0] = new Block("Room3", "empty room", new Place(1,0));
    prison[1][1] = new Block("Room4", "empty room", new Place(1,1));
    prison[1][2] = new Block("Room5", "empty room", new Place(1,2));
    prison[0][2] = new Block("Room6", "empty room", new Place(0,2));
    
    Grid.initmap = prison;
    Grid.currentBlock = prison[0][0];
    
    Guard guard1 = new Guard("No.1", 200, 0.50);
    Guard guard2 = new Guard("No.2", 200, 0.50);
    
    Grid.getBlock(1,2).setGuard(guard1);
    Grid.getBlock(0,2).setGuard(guard2);
  }
  
}