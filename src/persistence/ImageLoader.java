package persistence;

import model.Image;

public interface ImageLoader {
    public Image load();
    public Image loadNext();
    public Image loadPrev();
    
}
