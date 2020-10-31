import java.util.ArrayList;

public abstract class Construction {

    public String name;
    public int endTime;
    public int GASCOST;
    public int BUILDTIME;
    public int MINERALCOST;
    public int SUPPLYCOST = 0;
    public Construction builtFrom;
    public Construction dependantOn = null;
    ArrayList<Unit> builds = new ArrayList<>();
    boolean hasTechLab = false;
    boolean buildingTechLab = false;
    boolean requiresTechLab = false;

/*    public Construction make(int t, State s) {
        return null;
    }*/
}
