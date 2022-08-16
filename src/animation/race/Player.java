package animation.race;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player {

    private BufferedImage image;
    private String fileName;
    private String name;
    public JLabel jl;
    private int imageY;

    public Player(String fileName, String name, int imageY) {
        this.name = name;
        this.imageY = imageY;
        this.fileName = fileName;
        try {
            image = ImageIO.read(new File(this.fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        createJL(imageY);
    }

    private void createJL(int imageY) {
        jl = new JLabel(new ImageIcon(image));
        jl.setBounds(0, imageY, image.getWidth(), image.getHeight());
    }

    public int getImageY() {
        return imageY;
    }

    public String getFileName() {
        return fileName;
    }

    public String getName() {
        return name;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageY(int imageY) {
        this.imageY = imageY;
    }
}
