import java.util.ArrayList;
import java.util.PriorityQueue;

public class Greedy extends Player {
    public Greedy(){this.ID=5;}
    public void Greedy(){
        int h=0;
         ArrayList<Territory> greedy= new ArrayList<>();
         for( Territory t: this.occupiedTerritories.values()){
             for (Territory s: t.adjacentTerritories.values()){
                 greedy.add(s);
                 h= heuristic(s);
             }
         }

         }

public int heuristic (Territory t){
    int sum=0;

        int h=t.numberOfTroops;
        for(Territory territory: t.adjacentTerritories.values()){
            if(t.adjacentTerritories!=occupiedTerritories ){
                sum=sum+territory.adjacentTerritories.values().hashCode();
            }
        }
        int BSR= sum/h;
        return BSR;
        }
}

