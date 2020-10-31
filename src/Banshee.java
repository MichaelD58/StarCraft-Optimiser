public class Banshee extends Unit{

    public Banshee(int st) {
        name = "Banshee";
        SUPPLYCOST = 3;
        BUILDTIME = 60;
        MINERALCOST = 150;
        GASCOST = 100;
        dependantOn = null;
        builtFrom = new Starport();
        endTime = st + BUILDTIME;
        requiresTechLab = true;
    }

    public Banshee() {
    }

}
