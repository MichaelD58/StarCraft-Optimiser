public class Supply_Depot extends Building {

    public Supply_Depot(int st, State s) {
        name = "Supply Depot";
        BUILDTIME = 30;
        GASCOST = 0;
        MINERALCOST = 100;
        endTime = st + BUILDTIME;
    }

    public Supply_Depot(){ }
}
