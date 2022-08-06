package animation.dvd;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DVDMove extends JPanel {

    private final int WIDTH = 1280;
    private final int HEIGHT = 768;
    private BufferedImage image;
    private int x = 0;
    private int y = 0;
    private int dx = 3;
    private int dy = 3;

    public DVDMove() {
        this.setBackground(Color.black);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        loadImage();
        start();
    }

    // load image
    private void loadImage() {
        try {
            image = ImageIO.read(new File("dvd.png"));
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
        g2D.drawImage(image, x, y, null);
    }

    public void start() {
        Timer timer = new Timer(10, e -> nextStep(image.getWidth(null), image.getHeight(null)));
        timer.start();
    }

    private void nextStep(int xImage, int yImage) {
        int rgb = new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255)).getRGB();

        if(x + dx > WIDTH - xImage || x + dx < 0) {
            dx = -dx;
            for(int i = 0; i < image.getWidth(); i++) {
                for(int j = 0; j < image.getHeight(); j++) {
                    if(image.getRGB(0, 0) != image.getRGB(i, j)) {
                        image.setRGB(i, j, rgb);
                    }
                }
            }
        }
        if(y + dy > HEIGHT - yImage || y + dy < 0) {
            dy = -dy;
            for(int i = 0; i < image.getWidth(); i++) {
                for(int j = 0; j < image.getHeight(); j++) {
                    if(image.getRGB(0, 0) != image.getRGB(i, j)) {
                        image.setRGB(i, j, rgb);
                    }
                }
            }
        }

        x += dx;
        y += dy;

        repaint();
    }
}
