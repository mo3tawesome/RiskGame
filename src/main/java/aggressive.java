import java.util.ArrayList;

public class aggressive extends Player {
    public aggressive() {
        this.ID=2;
    }

    @Override
    public Territory TerritoryForDeployment() {
        Territory TerritoryForDeployment = this.occupiedTerritories.values().iterator().next();
        for(Territory t : this.occupiedTerritories.values()){
            if(t.numberOfTroops>TerritoryForDeployment.numberOfTroops){TerritoryForDeployment=t;}
        }
        return TerritoryForDeployment;
    }

    @Override
    public Territory AttackToTerritory() {
        //get all territories he can attack
        ArrayList<Territory> territoriesToAttack = new ArrayList<>();
        for(Territory t : this.occupiedTerritories.values()){
            for(Territory j : t.adjacentTerritories.values()){
                if(!territoriesToAttack.contains(j)&&!occupiedTerritories.containsKey(j.name)&&t.numberOfTroops>1){
                    territoriesToAttack.add(j);
                }
            }
        }
        if(territoriesToAttack.isEmpty()){return null;}
        //choose the one with the most troops
        Territory territoryToAttack = territoriesToAttack.get(0);
        for(Territory t : territoriesToAttack){
            if(t.numberOfTroops>territoryToAttack.numberOfTroops){territoryToAttack=t;}
        }
        return territoryToAttack;
    }

    @Override
    public boolean attack() {
        while (AttackToTerritory()!=null){
            return super.attack();
        }
        return true;
    }
}
