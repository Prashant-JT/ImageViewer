package imageviewer.model.persistence;

import imageviewer.model.Image;

public interface ImageLoader {
    public Image load();
    public Image loadNext();
    public Image loadPrev();
    
}
