
public class Viking extends Unit{

    public Viking() {
    }
    public Viking(int st) {
        name = "Viking";
        SUPPLYCOST = 2;
        BUILDTIME = 42;
        MINERALCOST = 150;
        GASCOST= 75;
        builtFrom = new Starport();
        endTime = st + BUILDTIME;

    }
}
