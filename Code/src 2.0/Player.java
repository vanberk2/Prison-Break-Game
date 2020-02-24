import java.util.*;

public class Player extends Sprite {
 private static final double defaultHealth = 200;
 
 public Player(double health) {
  super(health);
 }
 
 public Player() {
  this(defaultHealth);
 }
 
}