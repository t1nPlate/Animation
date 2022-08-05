package animation.square;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SquareMovePath extends JPanel {

    public final int WIDTH = 800;
    public final int HEIGHT = 800;
    private int x = 0;
    private int y = 0;
    private Image image;

    public SquareMovePath() {
        this.setBackground(Color.CYAN);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        loadImage();
        start();
    }

    private void loadImage() {
        try {
            BufferedImage wPic = ImageIO.read(new File("plu.png"));
            image = wPic.getScaledInstance(wPic.getWidth() / 2, wPic.getHeight() / 2, Image.SCALE_DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2D.drawImage(image, x, y, null);
    }

    public void start() {
        Timer timer = new Timer(10, e -> nextStep(x + image.getWidth(null), y + image.getHeight(null)));
        timer.start();
    }

    private void nextStep(int xImage, int yImage) {
        if(yImage <= HEIGHT && xImage <= image.getWidth(null)) y += 3;
        if(yImage >= HEIGHT && xImage <= WIDTH) x += 3;
        if(xImage >= WIDTH && yImage >= image.getHeight(null)) y -= 3;
        if(xImage >= image.getWidth(null) && yImage <= image.getHeight(null)) x -= 3;
        repaint();
    }
}
