package imageviewer;

import javax.swing.JPanel;
import model.Image;

public class SwingImageDisplay extends JPanel implements ImageDisplay {
    private Image image;
    
    @Override
    public void display(Image image) {
        this.image = image;
        this.repaint();
    }

    @Override
    public Image image() {
        return image;
    }
    
}
