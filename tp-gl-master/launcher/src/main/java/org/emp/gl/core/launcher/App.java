package org.emp.gl.core.launcher;

import org.emp.gl.lookup.Lookup;

import org.emp.gl.clients.CompteARebours;
import org.emp.gl.clients.Horloge;
import org.emp.gl.time.service.impl.DummyTimeServiceImpl;
import org.emp.gl.timer.service.TimerService;

public class App {
    public static void main(String[] args) {
        TimerService ts = new DummyTimeServiceImpl();

     
        Lookup.getInstance().subscribeService("serv1", ts);

        Horloge h = new Horloge("name", ts, null);
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}