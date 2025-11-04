package org.emp.gl.core.launcher;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import org.emp.gl.clients.Horloge;
import org.emp.gl.time.service.impl.DummyTimeServiceImpl;
import org.emp.gl.timer.service.TimerService;

public class Gui {
    private JFrame frame;
    private JTextArea textArea;
    private TimerService timerService;

    public Gui() {
        frame = new JFrame("Horloge");
        frame.setSize(1200, 800);
        frame.setLocation(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textArea = new JTextArea();
        textArea.setFont(new Font("Monospaced", Font.BOLD, 84));
        textArea.setEditable(false);
        frame.add(textArea, BorderLayout.CENTER);

        timerService = new DummyTimeServiceImpl();
        Horloge horloge = new Horloge("Horloge", timerService, textArea);
    }

    public void display() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Gui app = new Gui();
        app.display();
    }
}