package imageviewer;

import model.Image;
import persistence.FileImageLoader;

public class Main {
    
    public static void main(String[] args) {
        Image image = new FileImageLoader("images").load();
        SwingImageDisplay imageDisplay = new SwingImageDisplay();
        imageDisplay.display(image);
        
        MainFrame frame = new MainFrame();
        frame.add(imageDisplay);        
        frame.add("N", new NextImageCommand(imageDisplay));
        frame.add("P", new PrevImageCommand(imageDisplay));
        frame.add("X", new ExitCommand());
    }
    
}
