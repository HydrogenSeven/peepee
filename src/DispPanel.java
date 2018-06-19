import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class DispPanel extends JPanel {
    int count = 0;
    public BufferedImage image;

    public void paintComponent(Graphics g)
    {
        g.drawImage(image,10,10, image.getWidth(), this.getHeight(), Color.yellow, this);
    }
}
