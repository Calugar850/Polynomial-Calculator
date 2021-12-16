import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Testare {
    Operatii operatii=new Operatii();
    Monom m1=new Monom(3,1);
    Monom m2=new Monom(2,-2);
    Monom m3=new Monom(1,3);
    Monom m4=new Monom(0,-1);
    Monom m5=new Monom(1,1);
    Monom m6=new Monom(0,2);
    Polinom polinom1=new Polinom();
    Polinom polinom2=new Polinom();
    Polinom polinom3=new Polinom();

    @Test
    public void testAdunare(){
        polinom1.addMonom(m1);
        polinom1.addMonom(m2);
        polinom1.addMonom(m3);
        polinom1.addMonom(m4);
        polinom2.addMonom(m5);
        polinom2.addMonom(m6);
        polinom3=operatii.adunare(polinom1,polinom2);
        for(Monom m: polinom3.getPolinom()){
            switch (m.getGrad()){
                case 3:
                    assertEquals(1,m.getCoeficient(),0.01);
                    break;
                case 2:
                    assertEquals(-2,m.getCoeficient(),0.01);
                    break;
                case 1:
                    assertEquals(4,m.getCoeficient(),0.01);
                    break;
                case 0:
                    assertEquals(1,m.getCoeficient(),0.01);
                    break;
            }
        }
    }

    @Test
    public void testScadere(){
        polinom1.addMonom(m1);
        polinom1.addMonom(m2);
        polinom1.addMonom(m3);
        polinom1.addMonom(m4);
        polinom2.addMonom(m5);
        polinom2.addMonom(m6);
        polinom3=operatii.scadere(polinom1,polinom2);
        for(Monom m: polinom3.getPolinom()){
            switch (m.getGrad()){
                case 3:
                    assertEquals(1,m.getCoeficient(),0.01);
                    break;
                case 2:
                    assertEquals(-2,m.getCoeficient(),0.01);
                    break;
                case 1:
                    assertEquals(2,m.getCoeficient(),0.01);
                    break;
                case 0:
                    assertEquals(-3,m.getCoeficient(),0.01);
                    break;
            }
        }
    }

    @Test
    public void testDerivarePolinom1(){
        polinom1.addMonom(m1);
        polinom1.addMonom(m2);
        polinom1.addMonom(m3);
        polinom1.addMonom(m4);
        polinom3=operatii.derivare(polinom1);
        for(Monom m: polinom3.getPolinom()){
            switch (m.getGrad()){
                case 2:
                    assertEquals(3,m.getCoeficient(),0.01);
                    break;
                case 1:
                    assertEquals(-4,m.getCoeficient(),0.01);
                    break;
                case 0:
                    assertEquals(3,m.getCoeficient(),0.01);
                    break;
            }
        }
    }

    @Test
    public void testDerivarePolinom2(){
        polinom2.addMonom(m5);
        polinom2.addMonom(m6);
        polinom3=operatii.derivare(polinom2);
        for(Monom m: polinom3.getPolinom())
            if(m.getGrad()==0)
                assertEquals(1,m.getCoeficient(),0.01);
    }

    @Test
    public void testIntegrarePolinom1(){
        polinom1.addMonom(m1);
        polinom1.addMonom(m2);
        polinom1.addMonom(m3);
        polinom1.addMonom(m4);
        polinom3=operatii.integrare(polinom1);
        for(Monom m: polinom3.getPolinom()){
            switch (m.getGrad()){
                case 4:
                    assertEquals(0.25,m.getCoeficient(),0.01);
                    break;
                case 3:
                    assertEquals(-0.67,m.getCoeficient(),0.01);
                    break;
                case 2:
                    assertEquals(1.5,m.getCoeficient(),0.01);
                    break;
                case 1:
                    assertEquals(-1,m.getCoeficient(),0.01);
                    break;
            }
        }
    }

    @Test
    public void testIntegrarePolinom2(){
        polinom2.addMonom(m5);
        polinom2.addMonom(m6);
        polinom3=operatii.integrare(polinom2);
        for(Monom m: polinom3.getPolinom()){
            switch (m.getGrad()){
                case 2:
                    assertEquals(0.5,m.getCoeficient(),0.01);
                    break;
                case 1:
                    assertEquals(2,m.getCoeficient(),0.01);
                    break;
            }
        }
    }

    @Test
    public void testImpartire(){
        Polinom rest=new Polinom();
        polinom1.addMonom(m1);
        polinom1.addMonom(m2);
        polinom1.addMonom(m3);
        polinom1.addMonom(m4);
        polinom2.addMonom(m5);
        polinom2.addMonom(m6);
        polinom3=operatii.impartire(polinom1,polinom2,rest);
        for(Monom m: polinom3.getPolinom()){
            switch (m.getGrad()){
                case 2:
                    assertEquals(1,m.getCoeficient(),0.01);
                    break;
                case 1:
                    assertEquals(-4,m.getCoeficient(),0.01);
                    break;
                case 0:
                    assertEquals(11,m.getCoeficient(),0.01);
            }
        }
        for(Monom m: rest.getPolinom())
            if(m.getGrad()==0)
                assertEquals(-23,m.getCoeficient(),0.01);
    }

    @Test
    public void testProdus(){
        polinom1.addMonom(m1);
        polinom1.addMonom(m2);
        polinom1.addMonom(m3);
        polinom1.addMonom(m4);
        polinom2.addMonom(m5);
        polinom2.addMonom(m6);
        polinom3=operatii.produs(polinom1,polinom2);
        for(Monom m: polinom3.getPolinom()){
            switch (m.getGrad()){
                case 4:
                    assertEquals(1,m.getCoeficient(),0.01);
                    break;
                case 2:
                    assertEquals(-1,m.getCoeficient(),0.01);
                    break;
                case 1:
                    assertEquals(5,m.getCoeficient(),0.01);
                    break;
                case 0:
                    assertEquals(-2,m.getCoeficient(),0.01);
                    break;
            }
        }
    }
}
