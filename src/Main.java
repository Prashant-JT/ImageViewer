import imageviewer.ui.swing.SwingImageDisplay;
import imageviewer.control.NextImageCommand;
import imageviewer.control.PrevImageCommand;
import imageviewer.control.ExitCommand;
import imageviewer.model.Image;
import imageviewer.persistence.files.FileImageLoader;

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
