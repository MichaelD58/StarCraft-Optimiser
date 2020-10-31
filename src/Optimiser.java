import java.util.ArrayList;
import java.util.Random;

public class Optimiser {

    ArrayList<Construction> buildOrder = new ArrayList<>();
    Random rand = new Random();

    private StarCraft g;

    private int marines = 0;
    private int hellions = 0;
    private int medivacs = 0;
    private int vikings = 0;
    private int seigeTanks = 0;
    private int banshees = 0;
    private int thors = 0;
    private int marauders = 0;

    public Optimiser(int marines, int hellions, int medivacs, int vikings, int seigeTanks, int banshees, int thors, int marauders, StarCraft starCraft) {
        this.marines = marines;
        this.hellions = hellions;
        this.medivacs = medivacs;
        this.vikings = vikings;
        this.seigeTanks = seigeTanks;
        this.banshees = banshees;
        this.thors = thors;
        this.marauders = marauders;
        this.g = starCraft;
    }

    public void randomTurn(State s, StarCraft g, int t) {
        int n = rand.nextInt(18);
        int m = rand.nextInt(3);
        while (m > 0) {
            m--;
            randomMove(n, s, g, t);
            n = rand.nextInt(18);
        }
    }

    public void randomMove(int i, State s, StarCraft g, int t) {
        switch (i) {
            case 0: {
                if (g.constructionCount(new SCV(), g.units) < (s.NUMBEROFPOORPATCHSLOTSM + s.NUMBEROFGOODPATCHSLOTSM + (g.constructionCount(new Refinery(), g.buildings) * 3)) && s.getSpareSupply() > (marines + hellions * 2 + medivacs * 2 + vikings * 2 + seigeTanks * 3 + thors * 6 + banshees * 3 + marauders * 2) / 5 && g.constructionCount(new SCV(), g.units) + g.constructionCount(new SCV(), g.inBuilding) < (marines + hellions + medivacs + vikings + seigeTanks + thors + banshees + marauders) / 2) {
                    g.build(new SCV(t, s), s);
                }
                break;
            }
            case 1: {
                if (((g.constructionCount(new Supply_Depot(), g.buildings) + g.constructionCount(new Supply_Depot(), g.inBuilding)) * 8 + 10) < (marines + (hellions * 2 ) + (medivacs * 2 ) + (vikings * 2) + (seigeTanks * 3) + (thors * 6) + (banshees * 3) + (marauders * 2)) || g.constructionCount(new Supply_Depot(), g.buildings) + g.constructionCount(new Supply_Depot(), g.inBuilding) == 0 || thors > 0 && s.getSpareSupply() < 6 || thors == 0 && seigeTanks + banshees > 0 && s.getSpareSupply() < 3 || thors + seigeTanks + banshees == 0 && s.getSpareSupply() < 2 ) {
                        g.build(new Supply_Depot(t, s), s);
                }
                break;
            }
            case 2: {
                if (g.constructionCount(new Marine(), g.units) < marines) {
                    g.build(new Marine(t), s);
                }
                break;
            }
            case 3: {
                if (g.constructionCount(new Barracks(), g.buildings) + g.constructionCount(new Barracks(), g.inBuilding) == 0 || (g.constructionCount(new Barracks(), g.buildings) + g.constructionCount(new Barracks(), g.inBuilding)) < (marines + marauders) / 2) {
                if (marines + marauders != 0 && (g.constructionCount(new Marine(), g.inBuilding) + g.constructionCount(new Marauder(), g.inBuilding)) < g.constructionCount(new Barracks(), g.buildings)) {
                        if (marines > g.constructionCount(new Marine(), g.inBuilding) + g.constructionCount(new Marine(), g.units) && g.constructionCount(new Barracks(), g.buildings) != 0){
                            g.build(new Marine(t), s);
                        } else if (marauders > g.constructionCount(new Marauder(), g.inBuilding) + g.constructionCount(new Marauder(), g.units) && g.constructionCount(new Barracks(), g.buildings) != 0) {
                            g.build(new Marauder(t), s);
                        }
                   } else {
                        g.build(new Barracks(t), s);
                    }
                }
                break;
            }
            case 5: {
                if (vikings + medivacs + seigeTanks + thors + banshees + marauders + hellions != 0) {
                    g.build(new Refinery(t), s);
                }
                break;
            }
            case 6: {
               // if (hellions !=0 && (g.constructionCount(new Factory(), g.buildings) + g.constructionCount(new Factory(), g.inBuilding)) == 0) {
                    //|| (hellions == 0 && vikings + medivacs + seigeTanks + thors + banshees != 0 && g.constructionCount(new Factory(), g.buildings) + g.constructionCount(new Factory(), g.inBuilding) == 0) || g.constructionCount(new Factory(), g.buildings) + g.constructionCount(new Factory(), g.inBuilding) < (hellions + seigeTanks + thors) / 2
                    g.build(new Factory(t), s);
               // }
                break;
            }
            case 7: {
                if (g.constructionCount(new Hellion(), g.units) < hellions) {
                    g.build(new Hellion(t), s);
                }
                break;
            }
            case 8: {
                s.moveToVespene(g);
                break;
            }
            case 9: {
                s.moveToMinerals(g);
                break;
            }
            case 10: {
                if (vikings + medivacs + banshees != 0 && g.constructionCount(new Starport(), g.buildings) + g.constructionCount(new Starport(), g.inBuilding) < ((medivacs + vikings + banshees) / 2)) {
                    g.build(new Starport(t), s);
                }
                break;
            }
            case 11: {
                if (g.constructionCount(new Medivac(), g.units) < medivacs) {
                    g.build(new Medivac(t), s);
                }
                break;
            }
            case 12: {
                if (g.constructionCount(new Viking(), g.units) < vikings) {
                    g.build(new Viking(t), s);
                }
                break;
            }
            case 13: {
                if (g.constructionCount(new Armoury(), g.buildings) == 0 && thors > 0) {
                    g.build(new Armoury(t), s);
                }
            }
            case 14: {
                if (g.constructionCount(new Siege_Tank(), g.units) < seigeTanks) {
                    g.build(new Siege_Tank(t), s);
                }
            }
            case 15: {
                if (g.constructionCount(new Thor(), g.units) < thors) {
                    g.build(new Thor(t), s);
                }
            }
            case 16: {
                if (g.constructionCount(new Marauder(), g.units) < marauders) {
                    g.build(new Marauder(t), s);
                }
            }
            case 17: {
                if (g.constructionCount(new Banshee(), g.units) < banshees) {
                    g.build(new Banshee(t), s);
                }
            }
            case 18: {
                //if ((marauders + seigeTanks + thors + banshees) != 0){
                int w = rand.nextInt(3);
                g.build(new TechLab(t, w, g), s);
            //}
                break;
            }
        }
    }

    public boolean checkGoals() {
        if (marines <= g.constructionCount(new Marine(), g.units) && hellions <= g.constructionCount(new Hellion(), g.units) && medivacs <= g.constructionCount(new Medivac(), g.units) && vikings <= g.constructionCount(new Viking(), g.units) && seigeTanks <= g.constructionCount(new Siege_Tank(), g.units) && thors <= g.constructionCount(new Thor(), g.units) && banshees <= g.constructionCount(new Banshee(), g.units) && marauders <= g.constructionCount(new Marauder(), g.units)) {
            //System.out.println("Finished producing required units");
            return true;
        }
        return false;
    }
}
