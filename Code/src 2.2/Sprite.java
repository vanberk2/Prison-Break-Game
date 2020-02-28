import java.util.*;

public class Sprite {
  private String name;
  private double health;
  
  public Sprite(double health) {
    super();
    this.health = health;
  }
  
  public Sprite(String name, double health) {
  super();
  this.name = name;
  this.health = health;
 }
  
  public double getHealth() {
    return health;
  }
  
  public void setHealth(double d) {
    this.health = d;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String n) {
    this.name = n;
  }
  
  public boolean isCaught() {
    return health <= 0;
  }
  
}