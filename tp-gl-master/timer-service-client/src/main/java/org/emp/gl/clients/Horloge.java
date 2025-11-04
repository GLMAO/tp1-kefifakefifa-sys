import org.emp.gl.lookup.Lookup;
import java.beans.PropertyChangeEvent;
import org.emp.gl.lookup.Lookup;

import javax.swing.JTextArea;
import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;

public class Horloge implements TimerChangeListener {
    private String name;
    private TimerService timerService;
    private JTextArea textArea;

    public Horloge(String name) {
        this.name = name;
        this.timerService = (TimerService) Lookup.getInstance().getService("serv1");
        this.timerService.addTimeChangeListener(this);
        System.out.println("Horloge " + name + " initialized!");
        afficherHeure();
    }

    public Horloge(String name, TimerService ts) {
        this.name = name;
        this.timerService = ts;
        this.timerService.addTimeChangeListener(this);
        System.out.println("Horloge " + name + " initialized!");
        afficherHeure();
    }

    public Horloge(String name, TimerService ts, JTextArea textArea) {
        this.name = name;
        this.timerService = ts;
        this.textArea = textArea;
        this.timerService.addTimeChangeListener(this);
        System.out.println("Horloge " + name + " initialized!");
        afficherHeureGui();
    }

    public void afficherHeure() {
        if (timerService != null) {
            System.out.println(name + " affiche " + timerService.getHeures() + ":" + timerService.getMinutes() + ":" + timerService.getSecondes());
        }
    }

    public void afficherHeureGui() {
        if (timerService != null && textArea != null) {
            String timeDisplay = String.format("%02d:%02d:%02d", timerService.getHeures(), timerService.getMinutes(), timerService.getSecondes());
            textArea.setText(timeDisplay);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent prop) {
        if( prop.getPropertyName().equals(TimerChangeListener.SECONDE_PROP)){
            if (textArea != null) {
                afficherHeureGui();
            } else {
                afficherHeure();
            }
        }
        
    }
}
