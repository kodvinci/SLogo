package object;

import java.util.ArrayList;
import java.util.List;
import util.Location;

public class Trail {
   private List<Location> myTrails;
   
   
   public Trail(){
       myTrails = new ArrayList<Location>();
   }
   
   public void addTrail(Location newTrail){
       myTrails.add(newTrail);
   }
   public void removeTrail(Location removeTrail){
       myTrails.remove(removeTrail);
   }
   public void removeTrail(int index){
       myTrails.remove(index);
   }
   public void clearTrail(){
       myTrails.clear();
   }
}
