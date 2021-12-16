public class Monom{
    private int grad;
    private double coeficient;
    private int utilizat;

    public Monom(int grad, double coeficient) {
        this.grad = grad;
        this.coeficient = coeficient;
        utilizat=0;
    }

    public int getGrad() {
        return grad;
    }

    public void setGrad(int grad) {
        this.grad = grad;
    }

    public double getCoeficient() {
        return coeficient;
    }

    public void setCoeficient(double coeficient) {
        this.coeficient = coeficient;
    }

    public int getUtilizat() { return utilizat; }

    public void setUtilizat(int utilizat) {
        this.utilizat = utilizat;
    }

    @Override
    public String toString() {
        String strDouble = String.format("%.2f", coeficient);
        if(coeficient>0 && grad>=2)
            return "+"+strDouble +"x^"+grad;
        if(coeficient>0 && grad==1)
            return "+" + strDouble +"x";
        if(coeficient>0 && grad==0)
            return "+" + strDouble+"";
        if(coeficient<0 && grad>=2)
            return strDouble +"x^"+grad;
        if(coeficient<0 && grad==1)
            return strDouble +"x";
        if(coeficient<0 && grad==0)
            return strDouble+"";
        return null;
    }
}
