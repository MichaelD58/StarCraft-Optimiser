public class TechLab extends Building {
    public TechLab(int st, int w, StarCraft s) {
        name = "Tech lab attachment";
        BUILDTIME = 25;
        GASCOST = 25;
        MINERALCOST = 50;
        endTime = st + BUILDTIME;
        dependantOn = s.getNoTech(w);
    }

    public TechLab(){
    }

}
