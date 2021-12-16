import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller implements ActionListener {

    private View view;
    private Polinom polinom1=new Polinom();
    private Polinom polinom2=new Polinom();
    private Polinom polinom3=new Polinom();
    private Polinom rest=new Polinom();
    private Operatii operatii=new Operatii();

    public Controller(View v){
        this.view = v;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int selectedButton=0;
        if(view.getButton1().isSelected()) selectedButton=1;
        if(view.getButton2().isSelected()) selectedButton=2;
        if(view.getButton3().isSelected()) selectedButton=3;
        if(view.getButton4().isSelected()) selectedButton=4;
        if(view.getButton5().isSelected()) selectedButton=5;
        if(view.getButton6().isSelected()) selectedButton=6;
        if(view.getButton7().isSelected()) selectedButton=7;
        String primulPolinom=view.getTextField1().getText();
        String alDoileaPolinom=view.getTextField2().getText();
        Pattern p1=Pattern.compile("(-?\\b\\d+)[xX]\\^(-?\\d+\\b)");
        Matcher m1=p1.matcher(primulPolinom);
        while(m1.find()){
            int grad1=Integer.parseInt(m1.group(2));
            double coeficient1=Double.parseDouble(m1.group(1));
            Monom monom=new Monom(grad1,coeficient1);
            polinom1.addMonom(monom);
        }
        Pattern p2=Pattern.compile("(-?\\b\\d+)[xX]\\^(-?\\d+\\b)");
        Matcher m2=p2.matcher(alDoileaPolinom);
        while (m2.find()){
            int grad2=Integer.parseInt(m2.group(2));
            double coeficient2=Double.parseDouble(m2.group(1));
            Monom monom2=new Monom(grad2,coeficient2);
            polinom2.addMonom(monom2);
        }
        switch (selectedButton){
            case 1:
                polinom3=operatii.adunare(polinom1,polinom2);
                view.getButton1().setSelected(false);
                view.getTextField3().setText(polinom3.afisare());
                break;
            case 2:
                polinom3=operatii.scadere(polinom1,polinom2);
                view.getButton2().setSelected(false);
                view.getTextField3().setText(polinom3.afisare());
                break;
            case 3:
                polinom3=operatii.produs(polinom1,polinom2);
                view.getButton3().setSelected(false);
                view.getTextField3().setText(polinom3.afisare());
                break;
            case 4:
                polinom3=operatii.derivare(polinom1);
                view.getButton4().setSelected(false);
                view.getTextField3().setText(polinom3.afisare());
                break;
            case 5:
                polinom3=operatii.integrare(polinom1);
                view.getButton5().setSelected(false);
                view.getTextField3().setText(polinom3.afisare());
                break;
            case 6:
                polinom3=operatii.impartire(polinom1,polinom2,rest);
                view.getButton6().setSelected(false);
                view.getTextField3().setText(polinom3.afisare());
                view.getTextField4().setText(rest.afisare());
                break;
            case 7:
                view.getTextField1().setText(" ");
                view.getTextField2().setText(" ");
                view.getTextField3().setText(" ");
                view.getTextField4().setText(" ");
                view.getButton7().setSelected(false);
                break;
        }
        polinom1.removePolinom();
        polinom2.removePolinom();
        rest.removePolinom();
    }
}
