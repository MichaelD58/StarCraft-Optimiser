public class Siege_Tank extends Unit {
    public Siege_Tank(int st) {
        name = "Siege Tank";
        SUPPLYCOST = 3;
        BUILDTIME = 45;
        MINERALCOST = 150;
        GASCOST = 125;
        dependantOn = null;
        builtFrom = new Factory();
        endTime = st + BUILDTIME;
        requiresTechLab = true;
    }

    public Siege_Tank() {
    }
}
