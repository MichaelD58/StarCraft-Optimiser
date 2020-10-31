
public class Hellion extends Unit{

    public Hellion(int st) {
        name = "Hellion";
        SUPPLYCOST = 2;
        BUILDTIME = 30;
        MINERALCOST = 100;
        GASCOST= 0;
        builtFrom = new Factory();
        endTime = st + BUILDTIME;
    }

    public Hellion() {
    }

}
