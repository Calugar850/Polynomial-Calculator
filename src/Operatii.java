public class Operatii {

    public Polinom adunare(Polinom polinom1, Polinom polinom2){
        Polinom rezultat=new Polinom();
        for(Monom m1: polinom1.getPolinom())
            for(Monom m2: polinom2.getPolinom()){
                if(m1.getGrad()== m2.getGrad()){
                    m1.setUtilizat(1);
                    m2.setUtilizat(1);
                    Monom rezultatOperatie=new Monom(m1.getGrad(),m1.getCoeficient()+m2.getCoeficient());
                    rezultat.addMonom(rezultatOperatie);
                }
            }
        for(Monom m1: polinom1.getPolinom())
            if(m1.getUtilizat()==0)
                rezultat.addMonom(m1);
        for(Monom m2: polinom2.getPolinom())
            if(m2.getUtilizat()==0)
                rezultat.addMonom(m2);
        return rezultat;
    }

    public Polinom scadere(Polinom polinom1, Polinom polinom2){
        Polinom rezultat=new Polinom();
        for(Monom m1: polinom1.getPolinom())
            for(Monom m2: polinom2.getPolinom()){
                if(m1.getGrad()== m2.getGrad()){
                    m1.setUtilizat(1);
                    m2.setUtilizat(1);
                    Monom rezultatOperatie=new Monom(m1.getGrad(),m1.getCoeficient()-m2.getCoeficient());
                    rezultat.addMonom(rezultatOperatie);
                }
            }
        for(Monom m1: polinom1.getPolinom())
            if(m1.getUtilizat()==0)
                rezultat.addMonom(m1);
        for(Monom m2: polinom2.getPolinom())
            if(m2.getUtilizat()==0)
                rezultat.addMonom(m2);
        return rezultat;
    }

    public int cautareGrad(Polinom polinom){
        int gradMaxim=0;
        for(Monom m1: polinom.getPolinom())
            if(gradMaxim<m1.getGrad())
                gradMaxim=m1.getGrad();
        return gradMaxim;
    }

    public double cautareCoeficient(Polinom polinom, int gradMaxim){
        double coef=0;
        for(Monom m1: polinom.getPolinom())
            if(gradMaxim==m1.getGrad())
                coef=m1.getCoeficient();
        return coef;
    }

    public Polinom restrangereProdus(Polinom polinom1, Polinom polinom2){
        Polinom rezultat=new Polinom();
        for(Monom m1: polinom1.getPolinom())
            for(Monom m2: polinom2.getPolinom()){
                if(m1.getGrad()== m2.getGrad() && m1.getCoeficient()!= m2.getCoeficient()){
                    if(m1.getUtilizat()==0 && m2.getUtilizat()==0){
                        m1.setUtilizat(1);
                        m2.setUtilizat(1);
                        Monom rezultatOperatie=new Monom(m1.getGrad(),m1.getCoeficient()+m2.getCoeficient());
                        if(rezultatOperatie.getCoeficient()!=0)
                            rezultat.addMonom(rezultatOperatie);
                    }if(m1.getUtilizat()==1 && m2.getUtilizat()==0){
                        for(Monom m3: rezultat.getPolinom()){
                            if(m1.getGrad()==m3.getGrad()){
                                m3.setCoeficient(m3.getCoeficient()+m2.getCoeficient());
                                m2.setUtilizat(1);
                            }
                        }
                    }
                }
            }
        for(Monom m1: polinom1.getPolinom())
            if (m1.getUtilizat() == 0)
                rezultat.addMonom(m1);
        return rezultat;
    }

    public Polinom produs(Polinom polinom1, Polinom polinom2){
        Polinom rezultat=new Polinom();
        Polinom rezultatFinal=new Polinom();
        for(Monom m1: polinom1.getPolinom())
            for(Monom m2: polinom2.getPolinom()){
                Monom rezultatOperatie=new Monom(m1.getGrad()+m2.getGrad(),m1.getCoeficient()*m2.getCoeficient());
                rezultat.addMonom(rezultatOperatie);
            }
        rezultatFinal=restrangereProdus(rezultat,rezultat);
        return rezultatFinal;
    }

    public Polinom derivare(Polinom polinom1){
        Polinom rezultat=new Polinom();
        for(Monom m1 : polinom1.getPolinom()){
            if(m1.getGrad()!=0) {
                Monom rezultatOperatie=new Monom(m1.getGrad()-1,m1.getCoeficient()* m1.getGrad());
                rezultat.addMonom(rezultatOperatie);
            }
        }
        return rezultat;
    }

    public Polinom integrare(Polinom polinom1){
        Polinom rezultat=new Polinom();
        for(Monom m1 : polinom1.getPolinom()){
            if(m1.getGrad()>0){
                Monom rezultatOperatie=new Monom(m1.getGrad()+1,m1.getCoeficient()/(m1.getGrad()+1));
                rezultat.addMonom(rezultatOperatie);
            }
            if(m1.getGrad()==0) {
                Monom rezultatOperatie = new Monom(m1.getGrad() + 1, m1.getCoeficient());
                rezultat.addMonom(rezultatOperatie);
            }
        }
        return rezultat;
    }

    public Polinom impartire(Polinom polinom1, Polinom polinom2, Polinom rest){
        Polinom cat=new Polinom(); Polinom rezultatIntermediar=new Polinom();
        Polinom inmultire =new Polinom();
        int gradDeimpartit=cautareGrad(polinom1), gradImpartitor=cautareGrad(polinom2);
        double coefDeimpartit=cautareCoeficient(polinom1,gradDeimpartit), coefImpartitor=cautareCoeficient(polinom2,gradImpartitor);
        while(gradDeimpartit>=gradImpartitor){
            Monom m=new Monom(gradDeimpartit-gradImpartitor,coefDeimpartit/coefImpartitor);
            rezultatIntermediar.addMonom(m); cat.addMonom(m);
            inmultire=produs(rezultatIntermediar,polinom2);
            polinom1=scadere(polinom1,inmultire);
            rezultatIntermediar.removeMonom(m);
            gradDeimpartit--;
            coefDeimpartit=cautareCoeficient(polinom1,gradDeimpartit);
        }
        for(Monom m1: polinom1.getPolinom()){
            if(m1.getCoeficient()!=0)
                rest.addMonom(m1);
        }
        return cat;
    }
}

