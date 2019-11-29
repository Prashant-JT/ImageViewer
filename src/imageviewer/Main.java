package imageviewer;

import model.Image;
import persistence.FileImageLoader;

public class Main {
    
    public static void main(String[] args) {
        
        
        Image image = new FileImageLoader("c:/images").load();
        SwingImageDisplay imageDisplay = new SwingImageDisplay();
        imageDisplay.display(image);
    }
    
}
