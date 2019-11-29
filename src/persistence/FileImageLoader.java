package persistence;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import model.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileImageLoader implements ImageLoader{
    private final File[] files;
    
    public FileImageLoader(String root) {
        this(new File(root));
    }

    public FileImageLoader(File root) {
        this.files = root.listFiles();
    }
    
    @Override
    public Image load() {
        return imageAt(0);
    }

    private Image imageAt(int i) {
       return new Image() {
            @Override
            public String getName() {
                return file().getName();
            }

            @Override
            public byte[] getData() {
                try {
                    return dataOf(file());
                } catch (IOException ex) {
                    return new byte[0];
                }
            }

            @Override
            public Image getPrev() {
                return imageAt(i-1+n());
            }

            @Override
            public Image getNext() {
                return imageAt(i+1);
            }

            private File file() {
                return files[(i+n())%n()];
            }
            
            private int n() {
                return files.length;
            }

        };
    }

    private byte[] dataOf(File file) throws IOException {
        byte[] buffer = new byte[4096];
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        try (BufferedInputStream is = new BufferedInputStream(new FileInputStream(file));
             BufferedOutputStream os = new BufferedOutputStream(result)) {
            while (true) {
                int read = is.read(buffer);
                if (read < 0) break;
                os.write(buffer, 0, read);
            }
            os.flush();
            return result.toByteArray();
        }
    }
       
}