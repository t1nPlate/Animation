package animation.race;

import javax.swing.*;
import java.awt.*;

public class PlayerStart extends Thread {

    private static boolean flag = true; // Общий флаг для класса, останавливает другие объекты

    private final Player player;
    private int playerPosition; // текущее положение игрока

    public PlayerStart(Player player) {
        this.player = player;
        playerPosition = 0;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000); // Отсчет для старта
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (flag) {
            try {
                Thread.sleep(2);
                playerPosition += (int) ((Math.random() * 4) + 1);  // передвижение на 1-5 пикселей (рандомно)
                player.jl.setLocation(playerPosition, player.getImageY());
                if (playerPosition >= Race.WIDTH - player.jl.getWidth()) {
                    flag = false;
                    JLabel winText = new JLabel();
                    winText.setText(player.getName() + " побеждает!");
                    winText.setFont(new Font("Arial", Font.BOLD, 50));
                    winText.setBounds(Race.WIDTH / 2 - 250, Race.HEIGHT / 2 - 30, 500, 60);
                    Race.panel.add(winText);
                    winText.repaint(); // перерисовка, для того что-бы текст был виден на JPanel
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

}
