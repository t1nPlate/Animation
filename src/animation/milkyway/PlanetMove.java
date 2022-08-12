package animation.milkyway;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PlanetMove extends JPanel {

    protected final int WIDTH = 1280;
    protected final int HEIGHT = 800;
    private int earthX = 0;
    private int earthY = 0;
    private final int dx = 3;
    private final int dy = 3;
    int t = 0;
    private BufferedImage sun;
    private BufferedImage earth;

    public PlanetMove() {
        this.setBackground(Color.black);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        loadImage();
        start();
    }

    private void loadImage() {
        try {
            sun = ImageIO.read(new File("sun.png"));
            earth = ImageIO.read(new File("earth.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2D.setRenderingHint(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
        g2D.drawImage(sun, WIDTH/2-150, HEIGHT/2-150, null);
        g2D.drawImage(earth, earthX, earthY, null);
    }

    public void start() {
        Timer timer = new Timer(20, e -> nextStep());
        timer.start();
    }

    private void nextStep() {
        double radius = (sun.getWidth() + sun.getHeight()) / 1.5;
        earthX = (int) (radius * Math.cos(t*Math.PI/180) + dx) + WIDTH/2-120;
        earthY = (int) (radius * Math.sin(t*Math.PI/180) + dy) + HEIGHT/2-120;
        t = t == 359 ? 0 : t+1;
        repaint();
    }
}
