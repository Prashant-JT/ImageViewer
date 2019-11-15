package imageviewer;

import model.Image;

public class ImageViewer {

    public static void main(String[] args) {
        FileImageLoader file = new FileImageLoader("images");
        Image image_0 = file.load();
        Image image_1 = file.loadNext();
        Image image_2 = file.loadNext();
        Image image_3 = file.loadNext();
        Image image_4 = file.loadNext();
        Image image_5 = file.loadNext();
        Image image_6 = file.loadNext();
        Image image_7 = file.loadNext();
        Image image_8 = file.loadNext();
        Image image_9 = file.loadNext();
        Image image_10 = file.loadNext();
        Image image_11 = file.loadNext();
        Image image_12 = file.loadNext();
        
        System.out.println("Nombre image_0:" + image_0.getName());
        System.out.println("Nombre image_1:" + image_1.getName());
        System.out.println("Nombre image_2:" + image_2.getName());
        System.out.println("Nombre image_3:" + image_3.getName());
        System.out.println("Nombre image_4:" + image_4.getName());
        System.out.println("Nombre image_5:" + image_5.getName());
        System.out.println("Nombre image_6:" + image_6.getName());
        System.out.println("Nombre image_7:" + image_7.getName());
        System.out.println("Nombre image_8:" + image_8.getName());
        System.out.println("Nombre image_9:" + image_9.getName());
        System.out.println("Nombre image_10:" + image_10.getName());
        System.out.println("Nombre image_11:" + image_11.getName());
        System.out.println("Nombre image_12:" + image_12.getName());
    }
    
}
