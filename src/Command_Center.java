public class Command_Center extends Building{

    public Command_Center(int st) {
        name = "Command Center";
        BUILDTIME = 100;
        GASCOST = 0;
        MINERALCOST = 400;
        endTime = st + BUILDTIME;
        builds.add(new SCV());
    }

    public Command_Center() {
        builds.add(new SCV());
    }

}
