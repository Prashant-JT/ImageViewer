package imageviewer.model;

public class Image {
    private byte[] data;
    private String name;

    public Image(byte[] data, String name) {
        this.data = data;
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
