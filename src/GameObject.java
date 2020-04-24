import java.awt.*;
import java.awt.image.BufferedImage;


/**
 * Holds a basic static object that might be part of the game
 * @author Jakob Birner
 */
public class GameObject {

    private int xPos;
    private int yPos;
    private BufferedImage[] animation;
    private String name;




    /**
     * initialize the GameObject with an animation
     * @param xPos the xPos the Object is placed at
     * @param yPos the yPos the Object is placed at
     * @param animation the images that make up the animation of this object
     */
    public GameObject(int xPos,int yPos,BufferedImage[] animation, String name){
        this.xPos = xPos;
        this.yPos = yPos;
        this.animation=animation;
        this.name=name;
    }

    /**
     * initialize the GameObject with a single image
     * @param xPos the xPos the Object is placed at
     * @param yPos the yPos the Object is placed at
     * @param image the image of this object
     */
    public GameObject(int xPos,int yPos,BufferedImage image,String name){
        this.xPos = xPos;
        this.yPos = yPos;
        this.animation=new BufferedImage[]{image};
        this.name=name;
    }


    public BufferedImage[] getAnimation() {
        return animation;
    }

    public String getName() {
        return name;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }
}
