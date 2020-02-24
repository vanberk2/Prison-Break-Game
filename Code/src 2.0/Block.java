import java.util.ArrayList;
import java.util.List;

public class Block {
  private String name;
  private String description;
  private Place blockCoord;
  private List<Guard> guards;
  
  public Block(String name, String description, Place blockCoord) {
  this(name, description, blockCoord, new ArrayList<Guard>());
 }

  public Block(String name, String description, Place blockCoord, List<Guard> guards) {
    super();
    this.name = name;
    this.description = description;
    this.blockCoord = blockCoord;
    this.guards = guards;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getDescription() {
    return description;
  }
  
  public void setDescription(String description) {
    this.description = description;
  }
  
  public Place getBlockCoord() {
    return blockCoord;
  }
  
  public void setBlockCoord(Place blockCoord) {
    this.blockCoord = blockCoord;
  }
  
  public void setGuard(List<Guard> guards) {
    this.guards = guards;
  }
  
  public void setGuard(Guard g) {
    guards.add(g);
  }
  
  public List<Guard> getGuard() {
    return guards;
  }
  
  @Override
  public String toString() {
    return ("Name: " + name + ", Description: " + description);
  }
  
}