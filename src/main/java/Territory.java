import java.util.HashMap;

public class Territory {

    public String name;
    public Player ownedBy;
    public int numberOfTroops=0;
    public HashMap<String,Territory> adjacentTerritories;

}
