import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String args[]){



        BufferedImage[] img = new BufferedImage[3];
        try {
            img[0] = ImageIO.read(new File("sprites/testSprite1.png"));
            img[1] = ImageIO.read(new File("sprites/testSprite2.png"));
            img[2] = ImageIO.read(new File("sprites/testSprite3.png"));

            List<GameObject> objects = new ArrayList<>();
            objects.add(new GameObject(0,0,img[0],"player"));
            objects.add(new GameObject(10,10,img[1],"enemy"));
            objects.add(new GameObject(30,30,img[2],"rock"));


            Builder.setGameObjects(objects);
            Builder.buildFile();


        } catch (IOException e) {
        }



    }


}
