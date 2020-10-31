
public class Marine extends Unit{

    public Marine(int st) {
        name = "Marine";
        SUPPLYCOST = 1;
        BUILDTIME = 25;
        MINERALCOST = 50;
        GASCOST = 0;
        dependantOn = null;
        builtFrom = new Barracks();
        endTime = st + BUILDTIME;
    }

    public Marine() {
    }

}
