import org.emp.gl.lookup.Lookup;

import java.beans.PropertyChangeEvent;
import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;

public class CompteARebours implements TimerChangeListener {
    private String name;
    private TimerService timerService;
    private int secondsRest;

    public CompteARebours(String name, int vInitial, TimerService ts) {
        this.name = name;
        this.timerService = ts;
        this.secondsRest = vInitial;
        this.timerService.addTimeChangeListener(this);
        System.out.println("CompteARebours " + name + " initialized!");
        afficherHeure();
    }

    public String getName() {
        return name;
    }

    private void afficherHeure() {
        System.out.println(name + " -----> " + secondsRest);
    }

    @Override
    public void propertyChange(PropertyChangeEvent prop) {
        if (secondsRest == 0) {
            this.timerService.removeTimeChangeListener(this);
            System.out.println("Compte a rebours " + name + " est fini");
        } else if (prop.getPropertyName().equals(TimerChangeListener.SECONDE_PROP)) {
            secondsRest--;
            afficherHeure();
        }
    }
}
