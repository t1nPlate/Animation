package animation.milkyway;

import javax.swing.*;
import java.awt.*;

public class MilkyWay {
    protected static final int WIDTH = 1280;
    protected static final int HEIGHT = 800;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Milky Way");

        JPanel panel = new JPanel(null);
        panel.setBackground(Color.black);
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));

        Planet sun = new Planet("sun.png", 0);
        Planet mercury = new Planet("mercury.png", 200);
        Planet venus = new Planet("venus.png", 300);
        Planet earth = new Planet("earth.png", 400);
        System.out.println(venus.getImage().getWidth());
        System.out.println(venus.getImage().getHeight());
        panel.add(sun.jl);
        panel.add(mercury.jl);
        panel.add(venus.jl);
        panel.add(earth.jl);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds(dm.width/2-WIDTH/2, dm.height/2-HEIGHT/2, WIDTH, HEIGHT);
        frame.add(panel);
        frame.setVisible(true);

        new PlanetMove(mercury, 8).start();
        new PlanetMove(venus, 12).start();
        new PlanetMove(earth, 20).start();
    }
}
