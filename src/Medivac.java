
public class Medivac extends Unit{

    public Medivac(int st) {
        name = "Medivac";
        SUPPLYCOST = 2;
        BUILDTIME = 42;
        MINERALCOST = 100;
        GASCOST= 100;
        builtFrom = new Starport();
        endTime = st + BUILDTIME;
    }

    public Medivac() {
    }
}
