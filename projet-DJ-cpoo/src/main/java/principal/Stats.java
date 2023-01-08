package principal;

public class Stats {
    private int temps, precision, regularite = 0;//Initialiser à 0 par defaut

    public Stats(){} 

    public Stats(int t, int p, int r){
        this.temps = t;
        this.precision = p;
        this.regularite = r;
    }

    public Stats calcStats(ListeMots a, ListeMots b){
        return new Stats();
    }

    public int getTemps(){
        return temps;
    }

    public int getPrecision(){
        return precision;
    }

    public int getRegularite(){
        return regularite;
    }

    public void setTemps(int t){
        this.temps = t;
    }

    public void setPrecision(int p){
        this.precision = p;
    }

    public void setRegularite(int r){
        this.regularite = r;
    }
    
}
