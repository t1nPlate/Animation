package animation.grass;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Grass {
    protected static final int WIDTH = 800;
    protected static final int HEIGHT = 600;
    protected static JPanel panel;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Grass");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds(dm.width/2-WIDTH/2, dm.height/2-HEIGHT/2, WIDTH, HEIGHT);

        Image image = null;

        panel = new JPanel(null);
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        panel.setBackground(Color.white);

        try {
            BufferedImage wPic = ImageIO.read(new File("grass.png"));
            image = wPic.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }

        frame.add(panel);
        frame.setVisible(true);

        for(int i = 0; i < WIDTH/ Objects.requireNonNull(image).getWidth(null); i++) {
            for(int j = 0; j < HEIGHT/image.getHeight(null); j++) {
                new GrassTexture(image, 50, i, j);
            }
        }
    }
}
