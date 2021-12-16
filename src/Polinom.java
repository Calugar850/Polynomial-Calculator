import java.util.ArrayList;

public class Polinom{
    private ArrayList<Monom> polinom;

    public Polinom() {
        polinom = new ArrayList<Monom>();
    }

    public void addMonom(Monom m){
        polinom.add(m);
    }

    public void removeMonom(Monom m) { polinom.remove(m); }

    public void removePolinom() { polinom.removeAll(polinom); }

    public ArrayList<Monom> getPolinom() {
        return polinom;
    }

    public void setPolinom(ArrayList<Monom> polinom) {
        this.polinom = polinom;
    }

    public String afisare() {
        String sir;
        String sirFinal=new String();
        for(Monom num : polinom){
            sir=num.toString();
            sirFinal=sirFinal+sir;
        }
        return sirFinal;
    }
}