import java.util.Random;

public class Guard extends Sprite {
 
 private static final double defaultHealth = 200;
 private static final double defaultEscape = 0.20;
 
 private double escapeChance;
 
 public Guard(String name, double health, double escapeChance) {
  super(name, health);
  this.escapeChance = escapeChance;
 }
 
 public Guard(String name) {
  this(name, defaultHealth, defaultEscape);
 }

 public boolean isEscapable() {
  Random random = new Random();
  return random.nextDouble() < escapeChance;
 }
 
}