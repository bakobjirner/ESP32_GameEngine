import java.awt.*;


/**
 * Holds a basic static object that might be part of the game
 * @author Jakob Birner
 */
public class GameObject {

    private int xPos;
    private int yPos;
    private Image[] animation;




    /**
     * initialize the GameObject with an animation
     * @param xPos the xPos the Object is placed at
     * @param yPos the yPos the Object is placed at
     * @param animation the images that make up the animation of this object
     */
    public GameObject(int xPos,int yPos,Image[] animation){
        this.xPos = xPos;
        this.yPos = yPos;
        this.animation=animation;
    }

    /**
     * initialize the GameObject with a single image
     * @param xPos the xPos the Object is placed at
     * @param yPos the yPos the Object is placed at
     * @param image the image of this object
     */
    public GameObject(int xPos,int yPos,Image image){
        this.xPos = xPos;
        this.yPos = yPos;
        this.animation=new Image[]{image};
    }





}
