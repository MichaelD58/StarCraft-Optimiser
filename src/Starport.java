
public class Starport extends Building {

    boolean hasTechLab = false;

    public Starport(int st) {
        name = "Starport";
        BUILDTIME = 50;
        GASCOST = 100;
        MINERALCOST = 150;
        endTime = st + BUILDTIME;
        dependantOn = new Factory();
        builds.add(new Medivac());
        builds.add(new Viking());
        builds.add(new Banshee());
    }

    public Starport() {
        builds.add(new Medivac());
        builds.add(new Viking());
        builds.add(new Banshee());
    }


}
