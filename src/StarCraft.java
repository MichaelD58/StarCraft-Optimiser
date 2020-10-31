import java.util.ArrayList;
import java.util.TreeMap;

class StarCraft {

    ArrayList<Construction> inBuilding = new ArrayList<>();
    ArrayList<Construction> units = new ArrayList<>();
    ArrayList<Construction> buildings = new ArrayList<>();
    TreeMap<Integer, Construction> orderBuilding = new TreeMap<>();
    TreeMap<Integer, Integer> orderSupply = new TreeMap<>();

    int STARTINGMINERALS = 50;

    int STARTINGVESPENE = 0;

    private int buildProgress = 0;

    void Setup() {
        buildings.add(new Command_Center());
    }

    void Turn(int t, State s, Optimiser o) {

        s.updateMinerals();
        s.updateVespene((s.getVESPENEGATHERRATE() * s.getGasWorkers()));


        boolean failedToBuild = false;

        for (Construction construct : new ArrayList<>(inBuilding)) {

            if (construct.endTime == t) {
                String outputTime = "" + t;
                System.out.println(s.getSpareSupply() + " " + outputTime + " |Finished making a " + construct.getClass().getName() + "| ");
                if (construct instanceof Unit) {
                    units.add(construct);
                    if (construct instanceof SCV) {
                        s.updateWorkers(1);
                    }
                    inBuilding.remove(construct);
                } else {
                    if (construct instanceof Supply_Depot) {
                        s.updateSupply(8);
                    } else if ( construct instanceof TechLab) {
                        construct.dependantOn.hasTechLab = true;
                        construct.dependantOn.buildingTechLab = false;
                    }
                    buildings.add(construct);
                    inBuilding.remove(construct);
                }

                orderBuilding.put(Integer.parseInt(outputTime), construct);
                orderSupply.put(Integer.parseInt(outputTime), s.getSpareSupply());

            }
        }

        o.randomTurn(s, this, t);
    }

    boolean build(Construction c, State s) {

        int buildingCount = 0;
        int beingBuiltCount = 0;


        if (c instanceof Unit) {
            if (c.requiresTechLab){
                for (Construction b : buildings) {
                    if (c.builtFrom.getClass().equals(b.getClass()) && b.hasTechLab) {
                        buildingCount++;
                    }
                }
            }else {
            buildingCount = constructionCount(c.builtFrom, buildings);}

            for (Construction b : inBuilding) {

                for (Construction u : c.builtFrom.builds) {

                    if (b.getClass().equals(u.getClass())) {
                        beingBuiltCount++;
                    }
                }
            }
            for (Construction b : buildings) {
                if (b.getClass().equals(c.builtFrom.getClass()) && b.buildingTechLab) {
                    beingBuiltCount++;
                }
            }
        }

        if (s.getMinerals() >= c.MINERALCOST && s.getVespene() >= c.GASCOST && (c.dependantOn == null || buildCheck(c.dependantOn)) && (s.getSpareSupply() - c.SUPPLYCOST) >= 0) {

            if (c instanceof Unit) {
                if (beingBuiltCount < buildingCount) {
                    inBuilding.add(c);
                    s.updateMinerals(-c.MINERALCOST);
                    s.updateVespene(-c.GASCOST);
                    //System.out.print(" |added " + c.getClass().getName() + " to build| ");
                    buildProgress++;
                    s.updateSupply(-c.SUPPLYCOST);
                    return false;
                }
            } else {
                if (c instanceof Refinery) {
                    if (constructionCount(new Refinery(), buildings) + constructionCount(new Refinery(), inBuilding) < (2 * constructionCount(new Command_Center(), buildings))) {
                        inBuilding.add(c);
                        s.updateMinerals(-c.MINERALCOST);
                        s.updateVespene(-c.GASCOST);
                        //System.out.print(" |added " + c.getClass().getName(                    System.out.println(" |added " + c.getClass().getName() + " to build| " + c.dependantOn);) + " to build| ");
                        buildProgress++;
                        return false;
                    }

                    return true;
                } else if (c instanceof TechLab){
                    if(c.dependantOn != null && !c.dependantOn.hasTechLab){
                    c.dependantOn.buildingTechLab = true;
                    inBuilding.add(c);
                    s.updateMinerals(-c.MINERALCOST);
                    s.updateVespene(-c.GASCOST);
                    buildProgress++;
                    return false;
                    } else {
                        return true;
                    }
                }
                else {
                    inBuilding.add(c);
                    s.updateMinerals(-c.MINERALCOST);
                    s.updateVespene(-c.GASCOST);
                    //System.out.print(" |added " + c.getClass().getName() + " to build| ");
                    buildProgress++;
                    return false;
                }
            }
        }
        //System.out.print(" Insufficient Minerals or missing dependant building or building can make any more right now");
        return true;
    }

    int constructionCount(Construction c, ArrayList<Construction> l) {
        int buildingCount = 0;
        for (Construction b : l) {
            if (b.getClass().equals(c.getClass())) {
                buildingCount++;
            }
        }
        return buildingCount;
    }

    private boolean buildCheck(Construction b) {
        for (Construction c : buildings) {
            if (c.getClass().equals(b.getClass())) return true;
        }
        return false;
    }

    Construction getNoTech(int i) {
        switch (i){
            case 0: {
                Construction type = new Barracks();
                for (Construction b: buildings) {
                    if (b.getClass().equals(type.getClass())){
                        if(!b.hasTechLab && !b.buildingTechLab){
                            return b;
                        }
                    }
                }
            }
            case 1:{
                Construction type = new Factory();
                for (Construction b: buildings) {
                    if (b.getClass().equals(type.getClass())){
                        if(!b.hasTechLab && !b.buildingTechLab){
                            return b;
                        }
                    }
                }
            }
            case 2: {
                Construction type = new Starport();
                for (Construction b: buildings) {
                    if (b.getClass().equals(type.getClass())){
                        if(!b.hasTechLab && !b.buildingTechLab){
                            return b;
                        }
                    }
                }
            }
        }

        return null;
    }
}