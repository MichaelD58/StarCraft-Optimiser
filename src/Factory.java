
public class Factory extends Building {

    boolean hasTechLab = false;

    public Factory(int st) {
        name = "Factory";
        BUILDTIME = 60;
        GASCOST = 100;
        MINERALCOST = 150;
        endTime = st + BUILDTIME;
        dependantOn = new Barracks();
        builds.add(new Hellion());
        builds.add(new Siege_Tank());
        builds.add(new Thor());
    }

    public Factory() {
        builds.add(new Hellion());
        builds.add(new Siege_Tank());
        builds.add(new Thor());
    }


}
