package animation.milkyway;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    protected MyFrame() {
        super("MilkyWay");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds(dm.width/2-640, dm.height/2-400, 1280, 800);
        PlanetMove panel = new PlanetMove();
        this.add(panel);
        this.setVisible(true);
    }
}
