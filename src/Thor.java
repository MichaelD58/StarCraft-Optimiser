public class Thor  extends Unit{

    public Thor(int st) {
        name = "Thor";
        SUPPLYCOST = 6;
        BUILDTIME = 60;
        MINERALCOST = 300;
        GASCOST = 200;
        dependantOn = new Armoury();
        builtFrom = new Factory();
        endTime = st + BUILDTIME;
        requiresTechLab = true;
    }
    public Thor() {
    }}
