package imageviewer.ui.swing;

import imageviewer.ui.ImageDisplay;
import java.awt.Graphics;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import imageviewer.model.Image;

public class SwingImageDisplay extends JPanel implements ImageDisplay {
    private Image image;

    @Override
    public void display(Image image) {
        this.image = image;
        this.repaint();
    }

    @Override
    public void paint(Graphics g) {
        g.clearRect(0, 0, this.getWidth(), this.getHeight());
        g.drawImage(awtImage(), 0, 0, this);
    }

    @Override
    public Image image() {
        return image;
    }

    private java.awt.Image awtImage() {
        try {
            return ImageIO.read(new ByteArrayInputStream(image.getData()));
        } catch (IOException e) {
            return null;
        }
    }
    
}