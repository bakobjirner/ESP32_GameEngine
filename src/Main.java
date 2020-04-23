import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String args[]){



        BufferedImage[] img = new BufferedImage[1];
        try {
            img[0] = ImageIO.read(new File("sprites/testSprite3.png"));
        } catch (IOException e) {
        }
        SpriteHandler h = new SpriteHandler();

        h.createSpriteCode(img,"Player");
    }


}
