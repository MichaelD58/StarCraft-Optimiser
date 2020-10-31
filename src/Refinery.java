public class Refinery extends Building {

    public Refinery(int st) {
        name = "Refinery";
        BUILDTIME = 30;
        GASCOST = 0;
        MINERALCOST = 75;
        endTime = st + BUILDTIME;
    }

    public Refinery() {
    }

}
