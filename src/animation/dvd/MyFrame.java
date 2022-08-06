package animation.dvd;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    protected MyFrame() {
        super("DVD");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds(dm.width/2-640, dm.height/2-384, 1280, 768);
        DVDMove panel = new DVDMove();
        this.add(panel);
        this.setVisible(true);
    }
}
