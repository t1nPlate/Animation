package animation.milkyway;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Planet {
    private String fileName;
    private BufferedImage image;
    private int radius;
    public JLabel jl;
    private final int dx, dy;

    public Planet(String fileName, int radius) {
        this.fileName = fileName;
        this.radius = radius;
        try {
            image = ImageIO.read(new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        jl = new JLabel(new ImageIcon(image));
        if(radius == 0) {
            jl.setLocation(MilkyWay.WIDTH/2-image.getWidth()/2, MilkyWay.HEIGHT/2-image.getHeight()/2);
            jl.setSize(image.getWidth(), image.getHeight());
        }
        dx = MilkyWay.WIDTH/2-image.getWidth()/2;
        dy = MilkyWay.HEIGHT/2-image.getHeight()/2;
    }

    public BufferedImage getImage() {
        return image;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
