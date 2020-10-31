
public class SCV extends Unit{

    public SCV(int st, State s) {
        name = "SCV";
        SUPPLYCOST = 1;
        BUILDTIME = 17;
        GASCOST = 0;
        MINERALCOST = 50;
        endTime = st + BUILDTIME;
        dependantOn = null;
        builtFrom = new Command_Center();
    }

    public SCV() {

    }
}
