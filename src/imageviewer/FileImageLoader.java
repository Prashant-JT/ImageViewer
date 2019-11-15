package imageviewer;

import model.Image;
import persistence.ImageLoader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

class FileImageLoader implements ImageLoader{
    private final File[] files;
    private int index;
    
    FileImageLoader(String folder) {
       this.files = new File(folder).listFiles();
       this.index = 0;
    }

    @Override
    public Image load() {
        return imageAt();
    }

    @Override
    public Image loadNext() {
        this.index = (this.index < (files.length - 1)) ? (this.index + 1): 0;
        return load();
    }

    @Override
    public Image loadPrev() {
        this.index = (this.index > 0) ? (this.index - 1): (this.files.length - 1);
        return load();
    }

    private Image imageAt() {
       try {
           FileInputStream fis = new FileInputStream(files[this.index]);
           return read(fis);
       }catch (FileNotFoundException exception) {
           System.out.println("ERROR FileImageLoader::imageAt (File Not Found) " + exception.getMessage());
           return null;
       }catch (IOException exception) {
           System.out.println("ERROR FileImageLoader::imageAt (File Not Found) " + exception.getMessage());
           return null;
        }
    }

    private Image read(FileInputStream fis) throws IOException {
        byte[] buffer = new byte[4096];
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        while (true) {
            int length = fis.read(buffer);
            if (length < 0) break;
            baos.write(buffer, 0, length);
        }
        return new Image(buffer, this.files[this.index].getName());
    }
       
}