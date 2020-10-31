

public class State {

    public final int NUMBEROFGOODPATCHSLOTSM = 16;
    public final int NUMBEROFPOORPATCHSLOTSM = 8;
    public final int MAXNUMBEROFGASWORKERSPREFINERY = 3;
    private int spareSupply = 10;

    public int getSpareSupply() {
        return spareSupply;
    }

    public void updateSupply(int amount) {

        if (spareSupply + amount > 200) {
            spareSupply = 200;
        } else {
            spareSupply = spareSupply + amount;
        }
    }

    public State(int vespene, int minerals, int minWorkers, int gasWorkers) {
        this.vespene = vespene;
        this.minerals = minerals;
        this.minWorkers = minWorkers;
        this.gasWorkers = gasWorkers;
    }

    private double MINERALGATHERRATE = 0.683;
    private double POORMINERALGATHERATE = 0.333;

    private double VESPENEGATHERRATE = 0.633;

    public double getVESPENEGATHERRATE() {
        return VESPENEGATHERRATE;
    }

    private double vespene;

    public double getVespene() {
        return vespene;
    }


    public boolean moveToVespene(StarCraft g) {
        int maxGasWorkers = g.constructionCount(new Refinery(), g.buildings) * MAXNUMBEROFGASWORKERSPREFINERY;
        if (gasWorkers < maxGasWorkers && minWorkers != 0) {
            minWorkers--;
            gasWorkers++;
            return true;
        }
        else return false;
    }

    public boolean moveToMinerals(StarCraft g) {
        if ( gasWorkers != 0) {
            minWorkers++;
            gasWorkers--;
            return true;
        }
        else return false;
    }

    public void updateVespene(double amount) {
        vespene = vespene + gasWorkers * VESPENEGATHERRATE;
    }

    private double minerals;

    public double getMinerals() {
        return minerals;
    }

    public void updateMinerals() {
        if (minWorkers <= NUMBEROFGOODPATCHSLOTSM) {
            updateMinerals(minWorkers * MINERALGATHERRATE);

        } else {
            updateMinerals(NUMBEROFGOODPATCHSLOTSM * MINERALGATHERRATE);
            if (minWorkers - NUMBEROFGOODPATCHSLOTSM <= NUMBEROFPOORPATCHSLOTSM) {
                updateMinerals((minWorkers - NUMBEROFGOODPATCHSLOTSM) * MINERALGATHERRATE);

            } else {
                updateMinerals(NUMBEROFPOORPATCHSLOTSM * POORMINERALGATHERATE);

            }
        }
    }

    public void updateMinerals(double a) {
        minerals = minerals + a;
    }

    public int getGasWorkers() {
        return gasWorkers;
    }

    public int getMinWorkers() {
        return minWorkers;
    }

    private int minWorkers;

    public void updateWorkers(int i) {
        if (i == 1) {
            minWorkers++;
        } else if (i == 2) {
            gasWorkers++;
        }
    }

    private int gasWorkers;


}
