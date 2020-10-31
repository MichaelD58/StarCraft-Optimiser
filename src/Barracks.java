
public class Barracks extends Building {

    boolean hasTechLab = false;

    public Barracks(int st) {
        name = "Barracks";
        BUILDTIME = 65;
        GASCOST = 0;
        MINERALCOST = 150;
        endTime = st + BUILDTIME;
        dependantOn = new Supply_Depot();
        builds.add(new Marine());
        builds.add(new Marauder());
    }

    public Barracks(){
        builds.add(new Marine());
        builds.add(new Marauder());
    }

}
