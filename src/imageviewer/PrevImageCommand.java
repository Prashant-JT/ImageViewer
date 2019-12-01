package imageviewer;

public class PrevImageCommand implements Command {
    private final ImageDisplay imageDisplay;
    
    PrevImageCommand(ImageDisplay imageDisplay) {
        this.imageDisplay = imageDisplay;
    }

    @Override
    public void execute() {
        imageDisplay.display(imageDisplay.image().getPrev());
    }
    
}