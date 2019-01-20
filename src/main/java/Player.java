import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

public abstract class Player {

    public int ID;
    public HashMap<String,Territory> occupiedTerritories;

    public int NumberOfTroopsToDeploy(){
        int num=0;
        if(occupiedTerritories.size()<3){num = 3;}
        else {num = occupiedTerritories.size()/3;}
        return num;
    }

    public Territory TerritoryForDeployment(){
        return null;
    }

    public Territory AttackFromTerritory(){
        //get the territory with the most number of troops adjacent to the territory to attack
        Territory territoryToAttack = AttackToTerritory();
        Territory territoryFromAttack = new Territory();
        for(Territory t : territoryToAttack.adjacentTerritories.values()){
            if(occupiedTerritories.containsKey(t.name)){
                if(t.numberOfTroops>territoryFromAttack.numberOfTroops){territoryFromAttack=t;}
            }
        }
        return territoryFromAttack;
    }
    public Territory AttackToTerritory(){
        return null;
    }
    public void deployTroops(){
        TerritoryForDeployment().numberOfTroops+=NumberOfTroopsToDeploy();

    }
    public boolean canAttack(Territory from, Territory to){
        if (from.numberOfTroops>1&&from.adjacentTerritories.containsKey(to.name)){
            return true;
        }
        return false;
    }
    public boolean attack(){
        Territory from = AttackFromTerritory();
        //display to ui
        Territory to = AttackToTerritory();
        if (!canAttack(from,to)){return false;}
        //roll the dice and return true if winner
        ArrayList <Integer> fromDice = new ArrayList<>();
        if (from.numberOfTroops>=3){
            fromDice.add(new Random().nextInt(6) + 1);
            fromDice.add(new Random().nextInt(6) + 1);
            fromDice.add(new Random().nextInt(6) + 1);
        }
        else if(from.numberOfTroops==2){
            fromDice.add(new Random().nextInt(6) + 1);
            fromDice.add(new Random().nextInt(6) + 1);
        }
        else if(from.numberOfTroops==1){
            fromDice.add(new Random().nextInt(6) + 1);
        }

        ArrayList <Integer> toDice = new ArrayList<>();
        if (from.numberOfTroops>=2){
            toDice.add(new Random().nextInt(6) + 1);
            toDice.add(new Random().nextInt(6) + 1);
        }
        else if(from.numberOfTroops==1){
            toDice.add(new Random().nextInt(6) + 1);
        }
        Collections.sort(fromDice);Collections.reverse(fromDice);
        Collections.sort(toDice);Collections.reverse(toDice);
        for (int i : toDice){
            if(i>=fromDice.get(toDice.indexOf(i)))//if the defense wins
            {from.numberOfTroops--;}//kill one of the offender
            else{to.numberOfTroops--;}
        }
        if(to.numberOfTroops==0){return true;}//if the offender killed all the defender's

        return false;
    }
    public void playTurn(){}
}
