public class State {
    private String region;
    private String statename;
    private String capital;

    public State(String region, String statename, String capital) {
        this.region = region;
        this.statename = statename;
        this.capital = capital;
    }
    
    public String getRegion() {
        return region;
    }
    
    public String getStatename() {
        return statename;
    }
    
    public String getCapital() {
        return capital;
    }
    
    public String toString() {
        return statename + ", " + capital;
    }
    
}
