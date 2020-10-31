public class Armoury extends Building{

    public Armoury(int st) {
        name = "Armoury";
        BUILDTIME = 65;
        GASCOST = 100;
        MINERALCOST = 150;
        endTime = st + BUILDTIME;
        dependantOn = new Factory();
    }

    public Armoury() {
    }
}
