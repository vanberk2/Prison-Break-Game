import java.util.*;

public class Player extends Sprite {
 private static final double defaultHealth = 200;
 private List<Item> inventory;
 
 public Player(double health) {
  super(health);
  inventory = new ArrayList<Item>();
 }
 
 public Player() {
  this(defaultHealth);
  inventory = new ArrayList<Item>();
 }
 
 public List<Item> getInventory() {
  return inventory;
 }
 public void setInventory(List<Item> inventory) {
  this.inventory = inventory;
 }
 
 public void addInventory(List<Item> inve) {
  for(Item i : inve) {
   inventory.add(i);
  }
 }
 
}