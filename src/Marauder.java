public class Marauder extends Unit {


    public Marauder(int st) {
        name = "Marauder";
        SUPPLYCOST = 2;
        BUILDTIME = 30;
        MINERALCOST = 100;
        GASCOST = 25;
        dependantOn = null;
        builtFrom = new Barracks();
        endTime = st + BUILDTIME;
        requiresTechLab = true;
    }
    public Marauder() {
    }
}
